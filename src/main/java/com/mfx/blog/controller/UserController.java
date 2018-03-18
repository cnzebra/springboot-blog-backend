package com.mfx.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.mfx.blog.dto.LogActions;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.LogDO;
import com.mfx.blog.modal.entity.UserDO;
import com.mfx.blog.param.ModifyPassParam;
import com.mfx.blog.service.LogService;
import com.mfx.blog.service.UserService;
import com.mfx.blog.thread.UserThreadLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController extends BaseController {

    private final static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private LogService logService;

    @PostMapping("user/register")
    @ResponseBody
    public ResponseEntity register(@RequestBody UserDO userDO, HttpServletRequest request) {
        try {
            UserDO user = userService.insertUser(userDO);
            LogDO logDO = new LogDO();
            logDO.setAction(LogActions.USER_REGISTER.getAction());
            logDO.setLevel(1);
            logDO.setAuthorId(UserThreadLocal.get() == null ? null : UserThreadLocal.get().getId());
            logDO.setData("用户:" + JSONObject.toJSONString(user));
            logService.insertLog(logDO, request);
            return new ResponseEntity(RestResponseBo.ok(user), HttpStatus.OK);
        } catch (TipException e) {
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("异常:{}", e.getMessage(), e);
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }


    @PutMapping("user/login")
    @ResponseBody
    public ResponseEntity login(@RequestBody UserDO userDO, HttpServletRequest request) {
        try {
            UserDO user = userService.login(userDO);
            LogDO logDO = new LogDO();
            logDO.setAction(LogActions.BACK_LOGIN.getAction());
            logDO.setLevel(1);
            logDO.setAuthorId(UserThreadLocal.get() == null ? null : UserThreadLocal.get().getId());
            logDO.setData("登录用户:" + JSONObject.toJSONString(user));
            logService.insertLog(logDO, request);

            return new ResponseEntity(RestResponseBo.ok(user), HttpStatus.OK);
        } catch (TipException e) {
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("异常:{}", e.getMessage(), e);
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @PutMapping("user/modify.token")
    @ResponseBody
    public ResponseEntity modifyUser(@RequestBody UserDO userDO, HttpServletRequest request) {
        try {
            UserDO user = userService.update(userDO);
            LogDO logDO = new LogDO();
            logDO.setAction(LogActions.MOD_INFO.getAction());
            logDO.setLevel(1);
            logDO.setAuthorId(UserThreadLocal.get() == null ? null : UserThreadLocal.get().getId());
            logDO.setData("用户信息:" + JSONObject.toJSONString(user));
            logService.insertLog(logDO, request);
            return new ResponseEntity(RestResponseBo.ok(user), HttpStatus.OK);
        } catch (TipException e) {
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("异常:{}", e.getMessage(), e);
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @PutMapping("user/password/modify.token")
    @ResponseBody
    public ResponseEntity modifyPassword(@RequestBody ModifyPassParam modifyPassParam, HttpServletRequest request) {
        try {
            userService.modifyPassword(modifyPassParam);
            LogDO logDO = new LogDO();
            logDO.setAction(LogActions.MOD_PWD.getAction());
            logDO.setLevel(1);
            logDO.setAuthorId(UserThreadLocal.get() == null ? null : UserThreadLocal.get().getId());
            logDO.setData("密码信息:" + JSONObject.toJSONString(modifyPassParam));
            logService.insertLog(logDO, request);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("异常:{}", e.getMessage(), e);
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @PutMapping("user/logout.token")
    @ResponseBody
    public ResponseEntity logout(HttpServletRequest request) {
        try {
            userService.logout();
            LogDO logDO = new LogDO();
            logDO.setAction(LogActions.LOGOUT.getAction());
            logDO.setLevel(1);
            logDO.setAuthorId(UserThreadLocal.get() == null ? null : UserThreadLocal.get().getId());
            logDO.setData("退出用户:" + UserThreadLocal.get().getLoginName());
            logService.insertLog(logDO, request);

            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("异常:{}", e.getMessage(), e);
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }
}
