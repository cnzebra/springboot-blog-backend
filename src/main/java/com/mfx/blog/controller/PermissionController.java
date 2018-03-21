package com.mfx.blog.controller;

import com.github.pagehelper.PageInfo;
import com.mfx.blog.annotation.LogAnnotation;
import com.mfx.blog.dto.LogActions;
import com.mfx.blog.dto.LogLevelEnums;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.PermissionDO;
import com.mfx.blog.modal.vo.PermissionTreeVO;
import com.mfx.blog.service.PermissionService;
import com.mfx.blog.utils.ConvertUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.TreeSet;

@Controller
public class PermissionController extends BaseController {

    @Resource
    private PermissionService permissionService;


    @LogAnnotation(action = LogActions.ADD_PERMISSION, data = "#1", level = LogLevelEnums.LEVEL10)
    @PostMapping("admin/permission.token")
    @ResponseBody
    public ResponseEntity addPermission(@RequestBody PermissionDO permissionDO, HttpServletRequest request) {
        try {
            permissionService.insertPermission(permissionDO);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @LogAnnotation(action = LogActions.MOD_PERMISSION, data = "#1", level = LogLevelEnums.LEVEL10)
    @PutMapping("admin/permission.token")
    @ResponseBody
    public ResponseEntity modifyPermission(@RequestBody PermissionDO permissionDO, HttpServletRequest request) {
        try {
            permissionService.modifyPermission(permissionDO);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @LogAnnotation(action = LogActions.DEL_PERMISSION, data = "#1", level = LogLevelEnums.LEVEL10)
    @DeleteMapping("admin/permission/{id}.token")
    @ResponseBody
    public ResponseEntity deletePermission(@PathVariable("id") Long id, HttpServletRequest request) {
        try {
            permissionService.deleteById(id);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }


    @GetMapping("admin/permission/list.token")
    @ResponseBody
    public ResponseEntity listPermissions(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                          @RequestParam(value = "pageSize", defaultValue = "1") Integer pageSize,
                                          HttpServletRequest request) {
        try {
            PageInfo pageInfo = permissionService.getPermissions(pageNum, pageSize);
            return new ResponseEntity(RestResponseBo.ok(pageInfo), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @GetMapping("admin/permission/tree.token")
    @ResponseBody
    public ResponseEntity listPermissionTree(HttpServletRequest request) {
        try {
            TreeSet tree = permissionService.getPermissionTree();
            List<PermissionTreeVO> vos = ConvertUtils.mapToIviewTree(tree);

            return new ResponseEntity(RestResponseBo.ok(vos), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }
}
