package com.mfx.blog.controller;

import com.github.pagehelper.PageInfo;
import com.mfx.blog.annotation.LogAnnotation;
import com.mfx.blog.constant.LogConstant;
import com.mfx.blog.enums.LogActions;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.ScheduleJobDO;
import com.mfx.blog.service.TaskService;
import com.mfx.blog.utils.SpringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;

/**
 * Created by cnlm.me@qq.com on 2017/7/22.
 */
@SuppressWarnings("ALL")
@RestController
public class TaskController extends BaseController {

    @Autowired
    private TaskService taskService;

    @GetMapping("admin/tasks.token")
    @ResponseBody
    public ResponseEntity taskList(@RequestParam(value = "name") String name,
                                   @RequestParam(value = "pageNum") int pageNum,
                                   @RequestParam(value = "pageSize") int pageSize) {
        PageInfo<ScheduleJobDO> pageInfo = null;
        try {
            if (StringUtils.isBlank(name)) {
                pageInfo = taskService.getAllTask(pageNum, pageSize);
            } else {
                //搜索任务
                pageInfo = taskService.getTasks(name, pageNum, pageSize);
            }
        } catch (TipException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(RestResponseBo.ok(pageInfo), HttpStatus.OK);
    }


    @LogAnnotation(action = LogActions.ADD_TASK, data = LogConstant.PREFIX + "1")
    @PostMapping("admin/task.token")
    @ResponseBody
    public ResponseEntity taskList(@RequestBody ScheduleJobDO scheduleJob) {
        Boolean verified = null;
        try {
            verified = taskService.verifyCronExpression(scheduleJob.getCronExpression());
        } catch (TipException e) {
            e.printStackTrace();
        }
        if (!verified) {
            return new ResponseEntity(RestResponseBo.fail("cron表达式有误，不能被解析！"), HttpStatus.OK);
        }
        Object obj = null;
        try {
            if (StringUtils.isNotBlank(scheduleJob.getSpringId())) {
                obj = SpringUtils.getBean(scheduleJob.getSpringId());
            } else {
                Class clazz = Class.forName(scheduleJob.getBeanClass());
                obj = clazz.newInstance();
            }

            if (obj == null) {
                return new ResponseEntity(RestResponseBo.fail("未找到目标类！"), HttpStatus.OK);
            } else {
                Class clazz = obj.getClass();
                Method method = null;

                method = clazz.getMethod(scheduleJob.getMethodName(), null);

                if (method == null) {
                    return new ResponseEntity(RestResponseBo.fail("未找到目标方法！"), HttpStatus.OK);
                }
                taskService.addTask(scheduleJob);
            }
        } catch (NoSuchBeanDefinitionException e) {
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("保存失败，检查 name group 组合是否有重复"), HttpStatus.OK);
        }
        return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
    }

    @LogAnnotation(action = LogActions.MOD_TASK, data = LogConstant.PREFIX + "1")
    @PutMapping("admin/task/edit")
    @ResponseBody
    public ResponseEntity taskEdit(@RequestBody ScheduleJobDO scheduleJob) {
        Boolean verified = null;
        if (scheduleJob.getId() == null) {
            return new ResponseEntity(RestResponseBo.fail("任务ID为空，请重新请求"), HttpStatus.OK);
        }
        try {
            verified = taskService.verifyCronExpression(scheduleJob.getCronExpression());
        } catch (TipException e) {
            e.printStackTrace();
        }
        if (!verified) {
            return new ResponseEntity(RestResponseBo.fail("cron表达式有误，不能被解析！"), HttpStatus.OK);
        }

        Object obj = null;
        try {
            if (StringUtils.isNotBlank(scheduleJob.getSpringId())) {
                obj = SpringUtils.getBean(scheduleJob.getSpringId());
            } else {
                Class clazz = Class.forName(scheduleJob.getBeanClass());
                obj = clazz.newInstance();
            }

            if (obj == null) {
                return new ResponseEntity(RestResponseBo.fail("未找到目标类！"), HttpStatus.OK);
            } else {
                Class clazz = obj.getClass();
                Method method = null;

                method = clazz.getMethod(scheduleJob.getMethodName(), null);

                if (method == null) {
                    return new ResponseEntity(RestResponseBo.fail("未找到目标方法！"), HttpStatus.OK);
                }
                // 修改任务需要任务处于停止状态
                if (ScheduleJobDO.STATUS_RUNNING.equals(scheduleJob.getJobStatus())) {
                    return new ResponseEntity(RestResponseBo.fail("任务处于运行状态,请停止后修改"), HttpStatus.OK);
                }
                taskService.editTask(scheduleJob);
            }
        } catch (NoSuchBeanDefinitionException e) {
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("保存失败，检查 name group 组合是否有重复！"), HttpStatus.OK);

        }
        return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
    }

    @LogAnnotation(action = LogActions.SWITCH_JOB, data = LogConstant.PREFIX + "1:" + LogConstant.PREFIX + "2")
    @PutMapping("admin/task/{id}/status.token")
    @ResponseBody
    public ResponseEntity changeJobStatus(@PathVariable("id") Long jobId, @RequestParam("cmd") String cmd) throws TipException {
        if (!"start".equals(cmd) && !"stop".equals(cmd)) {
            return new ResponseEntity(RestResponseBo.fail("任务状态改变失败！"), HttpStatus.OK);
        } else {
            taskService.changeStatus(jobId, cmd);
        }
        return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
    }

    @LogAnnotation(action = LogActions.DEL_TASK, data = LogConstant.PREFIX + "1")
    @DeleteMapping("admin/task/delete/{id}.token")
    @ResponseBody
    public ResponseEntity deleteJob(@PathVariable("id") Long jobId) throws TipException {
        ScheduleJobDO task = taskService.getTaskById(jobId);
        //如果任务处于运行状态，需要先停止任务
        if (task.getJobStatus() != null &&
                task.getJobStatus().equals(ScheduleJobDO.STATUS_RUNNING)) {
            taskService.changeStatus(jobId, "stop");
        }

        taskService.delTaskById(jobId);
        return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
    }
}
