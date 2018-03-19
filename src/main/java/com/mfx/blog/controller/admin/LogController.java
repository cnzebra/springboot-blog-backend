package com.mfx.blog.controller.admin;


import com.github.pagehelper.PageInfo;
import com.mfx.blog.annotation.LogAnnotation;
import com.mfx.blog.controller.BaseController;
import com.mfx.blog.dto.LogActions;
import com.mfx.blog.dto.LogLevelEnums;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.LogDO;
import com.mfx.blog.modal.entity.LogDOExample;
import com.mfx.blog.service.LogService;
import com.mfx.blog.thread.UserThreadLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 13
 * @date 2017/2/21
 */
@Controller
@RequestMapping("/admin/log")
@Transactional(rollbackFor = TipException.class)
public class LogController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogController.class);

    @Resource
    private LogService logService;

    @GetMapping(value = "list.token")
    @ResponseBody
    public ResponseEntity list(@RequestParam(value = "action", defaultValue = "") String action,
                               @RequestParam(value = "data", defaultValue = "") String data,
                               @RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "15") int pageSize, HttpServletRequest request) {
        LogDOExample logDOExample = new LogDOExample();
        logDOExample.setOrderByClause("gmt_create desc");
        logDOExample.createCriteria().andActionLike("%" + action + "%").andDataLike("%" + data + "%");
        PageInfo<LogDO> logs = logService.getLogsForPage(pageNum, pageSize, logDOExample);
        return new ResponseEntity(RestResponseBo.ok(logs), HttpStatus.OK);
    }

    @LogAnnotation(action = LogActions.DELETE_LOG, data = "删除日志:#1", level = LogLevelEnums.LEVEL10)
    @DeleteMapping(value = "delete/{id}.token")
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") Long logId, HttpServletRequest request) {
        Integer result = logService.deleteById(logId);
        if (result != 1) {
            return new ResponseEntity(RestResponseBo.fail(result), HttpStatus.OK);
        }
        return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
    }


}
