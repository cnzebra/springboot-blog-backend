package com.mfx.blog.controller;

import com.github.pagehelper.PageInfo;
import com.mfx.blog.annotation.LogAnnotation;
import com.mfx.blog.constant.LogConstant;
import com.mfx.blog.dto.LogActions;
import com.mfx.blog.dto.LogLevelEnums;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.RoleDO;
import com.mfx.blog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;


    @LogAnnotation(action = LogActions.ADD_ROLE, data = LogConstant.PREFIX + "1", level = LogLevelEnums.LEVEL10)
    @PostMapping("admin/role.token")
    @ResponseBody
    public ResponseEntity addRole(@RequestBody RoleDO roleDO, HttpServletRequest request) {
        try {
            roleService.insertRole(roleDO);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @LogAnnotation(action = LogActions.MOD_ROLE, data = LogConstant.PREFIX + "1", level = LogLevelEnums.LEVEL10)
    @PutMapping("admin/role.token")
    @ResponseBody
    public ResponseEntity modifyRole(@RequestBody RoleDO roleDO, HttpServletRequest request) {
        try {
            roleService.modifyRole(roleDO);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @LogAnnotation(action = LogActions.DEL_ROLE, data = LogConstant.PREFIX + "1", level = LogLevelEnums.LEVEL10)
    @DeleteMapping("admin/role/{id}.token")
    @ResponseBody
    public ResponseEntity deleteRole(@PathVariable("id") Long id, HttpServletRequest request) {
        try {
            roleService.deleteById(id);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }


    @GetMapping("admin/role/list.token")
    @ResponseBody
    public ResponseEntity listRoles(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize,
                                    HttpServletRequest request) {
        try {
            PageInfo pageInfo = roleService.getRoles(pageNum, pageSize);
            return new ResponseEntity(RestResponseBo.ok(pageInfo), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @GetMapping("admin/role/tree.token")
    @ResponseBody
    public ResponseEntity roleTree() {
        try {
            List tree = roleService.getRoleTree();
            return new ResponseEntity(RestResponseBo.ok(tree), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }


}
