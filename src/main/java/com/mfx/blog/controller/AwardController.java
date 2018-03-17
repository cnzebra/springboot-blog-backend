package com.mfx.blog.controller;

import com.mfx.blog.service.AwardService;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.AwardDO;
import com.mfx.blog.modal.entity.FeedbackDO;
import com.mfx.blog.service.AwardService;
import com.mfx.blog.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AwardController extends BaseController {

    @Autowired
    private AwardService awardService;


    @PostMapping("award")
    @ResponseBody
    public ResponseEntity addAward(@RequestBody AwardDO awardDO) {
        awardService.insertAward(awardDO);
        return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
    }
}
