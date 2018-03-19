package com.mfx.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.service.MfxcomponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @author zhuxiaolong
 */
@RestController
public class MfxcomponentController extends BaseController {

    @Autowired
    private MfxcomponentService mfxcomponentService;

    @GetMapping("admin/mfxcomponent/list.token")
    @ResponseBody
    public ResponseEntity listMfxcomponent(HttpServletRequest request, HttpServletResponse response) {
        try {

            /*for (Map.Entry<Thread, StackTraceElement[]> stackTrace : Thread.getAllStackTraces().entrySet()) {
                Thread thread = stackTrace.getKey();
                StackTraceElement[] stes = stackTrace.getValue();
                if (thread.equals(Thread.currentThread())) {
                    continue;
                }
                PrintWriter printWriter = response.getWriter();
                printWriter.print("\n线程:" + thread.getName() + "\n");
                for (StackTraceElement ste : stes) {
                    printWriter.print("\t" + ste + "\n");
                }
            }*/


            List<String> names = mfxcomponentService.listBeanNames();
            return new ResponseEntity(RestResponseBo.ok(names), HttpStatus.OK);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @GetMapping("admin/mfxcomponent/fullname.token")
    @ResponseBody
    public ResponseEntity<JSONObject> getClassFullName(@RequestParam("beanName") String beanName) {
        try {
            String fullname = mfxcomponentService.getClassFullName(beanName);
            return new ResponseEntity(RestResponseBo.ok(fullname), HttpStatus.OK);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @GetMapping("admin/mfxcomponent/{beanName}/methods.token")
    @ResponseBody
    public ResponseEntity<JSONObject> listClassMethods(@PathVariable("beanName") String beanName) {
        try {
            List<String> names = mfxcomponentService.methods(beanName);
            return new ResponseEntity(RestResponseBo.ok(names), HttpStatus.OK);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }
}
