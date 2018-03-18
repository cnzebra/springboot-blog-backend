package com.mfx.blog.controller.admin;

import com.mfx.blog.dto.*;
import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.controller.BaseController;
import com.mfx.blog.dto.MetaDto;
import com.mfx.blog.dto.Types;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.LogDO;
import com.mfx.blog.modal.entity.MetaDO;
import com.mfx.blog.service.LogService;
import com.mfx.blog.service.MetaService;
import com.mfx.blog.thread.UserThreadLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 13
 * @date 2017/2/21
 */
@Controller
@RequestMapping("admin/category")
public class CategoryController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CategoryController.class);

    @Resource
    private MetaService metasService;
    @Resource
    private LogService logService;


    @GetMapping(value = "list.token")
    @ResponseBody
    public ResponseEntity categories() {
        List<MetaDto> categories = metasService.getMetaList(Types.CATEGORY.getType(), null, WebConst.MAX_POSTS);
        return new ResponseEntity(RestResponseBo.ok(categories), HttpStatus.OK);
    }

    @PostMapping(value = "save")
    @ResponseBody
    public RestResponseBo saveCategory(@RequestBody MetaDO meta,HttpServletRequest request) {
        try {
            metasService.saveMeta(Types.CATEGORY.getType(), meta.getName(), meta.getId());
            LogDO logDO = new LogDO();
            logDO.setAction(LogActions.ADD_ARTICLE_CATEGORY.getAction());
            logDO.setLevel(1);
            logDO.setAuthorId(UserThreadLocal.get() == null ? null : UserThreadLocal.get().getId());
            logDO.setData("增加文章分类成功:" + meta.getName());
            logService.insertLog(logDO, request);
        } catch (Exception e) {
            String msg = "分类保存失败";
            LOGGER.error(msg, e);
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public RestResponseBo delete(@RequestParam Long metaId) {
        try {
            metasService.delete(metaId);
        } catch (Exception e) {
            String msg = "删除失败";
            LOGGER.error(msg, e);
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }

}
