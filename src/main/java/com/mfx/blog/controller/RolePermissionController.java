package com.mfx.blog.controller;

import com.mfx.blog.annotation.LogAnnotation;
import com.mfx.blog.constant.LogConstant;
import com.mfx.blog.enums.LogActions;
import com.mfx.blog.enums.LogLevelEnums;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.param.RolePermissionMap;
import com.mfx.blog.service.RolePermissionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class RolePermissionController extends BaseController {

    @Resource
    private RolePermissionService rolePermissionService;


    @LogAnnotation(action = LogActions.ADD_ROLE_PERMISSION, data = LogConstant.PREFIX + "1," + LogConstant.PREFIX + "2", level = LogLevelEnums.LEVEL10)
    @PostMapping("admin/role/permission.token")
    @ResponseBody
    public ResponseEntity settingRolePermission(@RequestBody RolePermissionMap permissionMap,
                                                HttpServletRequest request) {
        try {
            rolePermissionService.settingPermission(permissionMap.getRoleId(), permissionMap.getIdTypes());
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }


    @LogAnnotation(action = LogActions.DEL_ROLE_PERMISSION, data = LogConstant.PREFIX + "1", level = LogLevelEnums.LEVEL10)
    @DeleteMapping("admin/role/{roleId}/permission/{permissionId}.token")
    @ResponseBody
    public ResponseEntity deleteRolePermission(@PathVariable("roleId") Long roleId,
                                               @PathVariable("permissionId") Long permissionId,
                                               HttpServletRequest request) {
        try {
            rolePermissionService.deleteById(roleId, permissionId);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (TipException e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

}
