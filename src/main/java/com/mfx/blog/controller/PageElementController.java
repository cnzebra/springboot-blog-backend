package com.mfx.blog.controller;

import com.github.pagehelper.PageInfo;
import com.mfx.blog.annotation.LogAnnotation;
import com.mfx.blog.constant.LogConstant;
import com.mfx.blog.dto.LogActions;
import com.mfx.blog.dto.LogLevelEnums;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.PageElementDO;
import com.mfx.blog.service.PageElementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class PageElementController extends BaseController {

    @Resource
    private PageElementService pageElementService;


    @LogAnnotation(action = LogActions.ADD_PAGE_ELEMENT, data = LogConstant.PREFIX + "1", level = LogLevelEnums.LEVEL10)
    @PostMapping("admin/pageElement.token")
    @ResponseBody
    public ResponseEntity addPageElement(@RequestBody PageElementDO pageElementDO, HttpServletRequest request) {
        try {
            pageElementService.insertPageElement(pageElementDO);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @LogAnnotation(action = LogActions.MOD_PAGE_ELEMENT, data = LogConstant.PREFIX + "1", level = LogLevelEnums.LEVEL10)
    @PutMapping("admin/pageElement.token")
    @ResponseBody
    public ResponseEntity modifyPageElement(@RequestBody PageElementDO pageElementDO, HttpServletRequest request) {
        try {
            pageElementService.modifyPageElement(pageElementDO);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @LogAnnotation(action = LogActions.DEL_PAGE_ELEMENT, data = LogConstant.PREFIX + "1", level = LogLevelEnums.LEVEL10)
    @DeleteMapping("admin/pageElement/{id}.token")
    @ResponseBody
    public ResponseEntity deletePageElement(@PathVariable("id") Long id, HttpServletRequest request) {
        try {
            pageElementService.deleteById(id);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }


    @GetMapping("admin/pageElement/list.token")
    @ResponseBody
    public ResponseEntity listPageElements(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                           @RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize,
                                           HttpServletRequest request) {
        try {
            PageInfo pageInfo = pageElementService.getPageElements(pageNum, pageSize);
            return new ResponseEntity(RestResponseBo.ok(pageInfo), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }


    @GetMapping("admin/pageElement/listByRoute.token")
    @ResponseBody
    public ResponseEntity listPageElementsByRoute(@RequestParam(value = "routeId") Long routeId,
                                                  HttpServletRequest request) {
        try {
            List list = pageElementService.listPageElementsByRoute(routeId);
            return new ResponseEntity(RestResponseBo.ok(list), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

}
