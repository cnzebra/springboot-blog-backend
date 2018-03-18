package com.mfx.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.mfx.blog.dto.LogActions;
import com.mfx.blog.modal.entity.LogDO;
import com.mfx.blog.service.AwardService;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.AwardDO;
import com.mfx.blog.modal.entity.FeedbackDO;
import com.mfx.blog.service.AwardService;
import com.mfx.blog.service.FeedbackService;
import com.mfx.blog.service.LogService;
import com.mfx.blog.thread.UserThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class AwardController extends BaseController {

    @Autowired
    private AwardService awardService;
    @Resource
    private LogService logService;


    @PostMapping("award")
    @ResponseBody
    public ResponseEntity addAward(@RequestBody AwardDO awardDO, HttpServletRequest request) {
        awardService.insertAward(awardDO);
        LogDO logDO = new LogDO();
        logDO.setAction(LogActions.ADD_AWARD.getAction());
        logDO.setLevel(1);
        logDO.setAuthorId(UserThreadLocal.get() == null ? null : UserThreadLocal.get().getId());
        logDO.setData("赞赏记录:" + JSONObject.toJSONString(awardDO));
        logService.insertLog(logDO, request);
        return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
    }
}
