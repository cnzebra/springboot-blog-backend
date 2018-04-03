package com.mfx.blog.handler;

import com.mfx.blog.exception.TipException;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.bo.RestResponseBo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mfx
 * @date 2017/3/4
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = TipException.class)
    @ResponseBody
    public ResponseEntity tipException(Exception e) {
        LOGGER.error("find exception:e={}", e.getMessage());
        return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
    }


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity exception(Exception e) {
        LOGGER.error("find exception:e={}", e.getMessage(), e);
        return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
    }
}
