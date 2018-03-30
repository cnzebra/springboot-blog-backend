package com.mfx.blog.controller;

import com.mfx.blog.annotation.LogAnnotation;
import com.mfx.blog.constant.LogConstant;
import com.mfx.blog.dto.LogActions;
import com.mfx.blog.dto.LogLevelEnums;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.FeedbackDO;
import com.mfx.blog.service.FeedbackService;
import com.mfx.blog.service.LogService;
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
public class FeedbackController extends BaseController {

    @Autowired
    private FeedbackService feedbackService;
    @Resource
    private LogService logService;


    @LogAnnotation(action = LogActions.ADD_FEEDBACK, data = "内容:" + LogConstant.PREFIX + "1", level = LogLevelEnums.LEVEL10)
    @PostMapping("feedback")
    @ResponseBody
    public ResponseEntity addFeedback(@RequestBody FeedbackDO feedbackDO, HttpServletRequest request) {
        feedbackService.insertFeedback(feedbackDO);
        return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
    }
}
