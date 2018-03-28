package com.mfx.blog.controller;

import com.github.pagehelper.PageInfo;
import com.mfx.blog.annotation.LogAnnotation;
import com.mfx.blog.dto.LogActions;
import com.mfx.blog.dto.LogLevelEnums;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.RouteDO;
import com.mfx.blog.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RouteController extends BaseController {

    @Autowired
    private RouteService routeService;


    @LogAnnotation(action = LogActions.ADD_ROUTE, data = "#1", level = LogLevelEnums.LEVEL10)
    @PostMapping("admin/route.token")
    @ResponseBody
    public ResponseEntity addRoute(@RequestBody RouteDO routeDO, HttpServletRequest request) {
        try {
            routeService.insertRoute(routeDO);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @LogAnnotation(action = LogActions.MOD_ROUTE, data = "#1", level = LogLevelEnums.LEVEL10)
    @PutMapping("admin/route.token")
    @ResponseBody
    public ResponseEntity modifyRoute(@RequestBody RouteDO routeDO, HttpServletRequest request) {
        try {
            routeService.modifyRoute(routeDO);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @LogAnnotation(action = LogActions.DEL_ROUTE, data = "#1", level = LogLevelEnums.LEVEL10)
    @DeleteMapping("admin/route/{id}.token")
    @ResponseBody
    public ResponseEntity modifyRoute(@PathVariable("id") Long id, HttpServletRequest request) {
        try {
            routeService.deleteById(id);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }


    @GetMapping({"admin/route/list.token","route/list.open"})
    @ResponseBody
    public ResponseEntity modifyRoute(@RequestParam(value = "type", defaultValue = "") String type,
                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                      @RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize,
                                      HttpServletRequest request) {
        try {
            PageInfo pageInfo = routeService.getRoutes(type, pageNum, pageSize);
            return new ResponseEntity(RestResponseBo.ok(pageInfo), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @GetMapping("admin/route/tree.token")
    @ResponseBody
    public ResponseEntity listRoutesTree(@RequestParam(value = "type",defaultValue = "") String type, HttpServletRequest request) {
        try {
            List list = routeService.listRoutesTree(type);
            return new ResponseEntity(RestResponseBo.ok(list), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @GetMapping("admin/route/{id}.token")
    @ResponseBody
    public ResponseEntity listRoutesTree(@PathVariable("id") Long id, HttpServletRequest request) {
        try {
            RouteDO routeDO = routeService.getRouteById(id);
            return new ResponseEntity(RestResponseBo.ok(routeDO), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }
}
