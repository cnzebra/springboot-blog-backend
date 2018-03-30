package com.mfx.blog.controller;

import com.github.pagehelper.PageInfo;
import com.mfx.blog.annotation.LogAnnotation;
import com.mfx.blog.constant.LogConstant;
import com.mfx.blog.dto.LogActions;
import com.mfx.blog.dto.LogLevelEnums;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.MilestoneDO;
import com.mfx.blog.service.LogService;
import com.mfx.blog.service.MilestoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class MilestoneController extends BaseController {

    private final static Logger LOGGER = LoggerFactory.getLogger(MilestoneController.class);

    @Autowired
    private MilestoneService milestoneService;
    @Resource
    private LogService logService;

    @LogAnnotation(action = LogActions.ADD_MILESTONE, data = "历程:" + LogConstant.PREFIX + "1", level = LogLevelEnums.LEVEL10)
    @PostMapping("milestone/record.token")
    @ResponseBody
    public ResponseEntity record(@RequestBody MilestoneDO milestoneDO, HttpServletRequest request) {
        try {
            milestoneService.insertMilestone(milestoneDO);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("异常:{}", e.getMessage(), e);
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @LogAnnotation(action = LogActions.MOD_MILESTONE, data = "历程:" + LogConstant.PREFIX + "1", level = LogLevelEnums.LEVEL10)
    @PutMapping("milestone/modify.token")
    @ResponseBody
    public ResponseEntity modify(@RequestBody MilestoneDO milestoneDO, HttpServletRequest request) {
        try {
            milestoneService.modify(milestoneDO);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("异常:{}", e.getMessage(), e);
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @LogAnnotation(action = LogActions.DEL_MILESTONE, data = "历程:" + LogConstant.PREFIX + "1", level = LogLevelEnums.LEVEL10)
    @DeleteMapping("milestone/{id}.token")
    @ResponseBody
    public ResponseEntity delete(@PathVariable("id") Long id, HttpServletRequest request) {
        try {
            milestoneService.delete(id);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("异常:{}", e.getMessage(), e);
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @GetMapping("milestone/list.open")
    @ResponseBody
    public ResponseEntity list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                               HttpServletRequest request) {
        try {
            PageInfo pageInfo = milestoneService.getMilestones(pageNum, pageSize);
            return new ResponseEntity(RestResponseBo.ok(pageInfo), HttpStatus.OK);
        } catch (TipException e) {
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("异常:{}", e.getMessage(), e);
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }
}
