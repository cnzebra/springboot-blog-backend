package com.mfx.blog.controller;

import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.FeedbackDO;
import com.mfx.blog.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FeedbackController extends BaseController {

    @Autowired
    private FeedbackService feedbackService;


    @PostMapping("feedback")
    @ResponseBody
    public ResponseEntity addFeedback(@RequestBody FeedbackDO feedbackDO) {
        feedbackService.insertFeedback(feedbackDO);
        return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
    }
}
