package com.sonnx.blog.controller.admin;


import com.github.pagehelper.PageInfo;
import com.sonnx.blog.controller.BaseController;
import com.sonnx.blog.dto.LogActions;
import com.sonnx.blog.exception.TipException;
import com.sonnx.blog.modal.bo.RestResponseBo;
import com.sonnx.blog.modal.entity.LogDO;
import com.sonnx.blog.modal.entity.LogDOExample;
import com.sonnx.blog.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    @GetMapping(value = "")
    public String index(@RequestParam(value = "action", defaultValue = "") String action,
                        @RequestParam(value = "data", defaultValue = "") String data,
                        @RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "limit", defaultValue = "15") int limit, HttpServletRequest request) {
        LogDOExample logDOExample = new LogDOExample();
        logDOExample.setOrderByClause("gmt_create desc");
        logDOExample.createCriteria().andActionLike("%" + action + "%").andDataLike("%" + data + "%");
        PageInfo<LogDO> logs = logService.getLogsForPage(page, limit, logDOExample);
        request.setAttribute("logs", logs);
        return "admin/log_list";
    }

    @GetMapping(value = "query")
    public String index(@RequestParam Integer page,
                        @RequestParam Integer pageSize,
                        @RequestParam String action,
                        @RequestParam String data,
                        HttpServletRequest request) {
        LogDOExample logDOExample = new LogDOExample();
        logDOExample.setOrderByClause("gmt_create desc");
        logDOExample.createCriteria().andActionLike("%" + action + "%").andDataLike("%" + data + "%");
        PageInfo<LogDO> logs = logService.getLogsForPage(page, pageSize, logDOExample);
        request.setAttribute("logs", logs);
        return "admin/log_list";
    }

    @PostMapping(value = "delete")
    @ResponseBody
    public RestResponseBo delete(@RequestParam Long logId, HttpServletRequest request) {
        Integer result = logService.deleteById(logId);
        logService.insertLog(LogActions.DELETE_LOG.getAction(), logId + ":" + (result == 1 ? "删除成功" : "删除失败"), 2, request.getRemoteAddr(), this.getUid
                (request));
        if (result != 1) {
            return RestResponseBo.fail(result);
        }
        return RestResponseBo.ok();
    }


}
