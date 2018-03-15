package com.sonnx.blog.controller;

import com.sonnx.blog.exception.TipException;
import com.sonnx.blog.modal.bo.RestResponseBo;
import com.sonnx.blog.modal.entity.UserDO;
import com.sonnx.blog.service.UserService;
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

    @PostMapping("user/register")
    @ResponseBody
    public ResponseEntity register(@RequestBody UserDO userDO, HttpServletRequest request) {
        try {
            UserDO user = userService.insertUser(userDO);
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
            return new ResponseEntity(RestResponseBo.ok(user), HttpStatus.OK);
        } catch (TipException e) {
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("异常:{}", e.getMessage(), e);
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @PutMapping("user/logout")
    @ResponseBody
    public ResponseEntity logout(@RequestParam(value = "token") String token, HttpServletRequest request) {
        try {
            userService.logout(token);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("异常:{}", e.getMessage(), e);
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }
}
