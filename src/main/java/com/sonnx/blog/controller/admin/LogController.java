package com.sonnx.blog.controller.admin;


import com.github.pagehelper.PageInfo;
import com.sonnx.blog.controller.BaseController;
import com.sonnx.blog.exception.TipException;
import com.sonnx.blog.modal.entity.LogDO;
import com.sonnx.blog.modal.entity.LogDOExample;
import com.sonnx.blog.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String index(@RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "limit", defaultValue = "15") int limit, HttpServletRequest request) {
        LogDOExample logDOExample = new LogDOExample();
        logDOExample.setOrderByClause("gmt_create desc");
        logDOExample.createCriteria();
        PageInfo<LogDO> logs = logService.getLogsForPage(page, limit);
        request.setAttribute("logs", logs);
        return "admin/log_list";
    }


}
