package com.mfx.blog.controller.admin;

import com.mfx.blog.dto.LogActions;
import com.mfx.blog.dto.Types;
import com.mfx.blog.controller.BaseController;
import com.mfx.blog.dto.Types;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.LogDO;
import com.mfx.blog.modal.entity.MetaDO;
import com.mfx.blog.service.LogService;
import com.mfx.blog.service.MetaService;
import com.mfx.blog.thread.UserThreadLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("admin/links")
public class LinksController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LinksController.class);

    @Resource
    private MetaService metasService;
    @Resource
    private LogService logService;

    @GetMapping(value = "")
    public String index(HttpServletRequest request) {
        List<MetaDO> metas = metasService.getMetas(Types.LINK.getType());
        request.setAttribute("links", metas);
        return "admin/links";
    }

    @PostMapping(value = "save")
    @ResponseBody
    public RestResponseBo saveLink(@RequestParam String title, @RequestParam String url,
                                   @RequestParam String logo, @RequestParam Long id,
                                   @RequestParam(value = "sort", defaultValue = "0") int sort,
                                   HttpServletRequest request) {
        try {
            MetaDO metas = new MetaDO();
            metas.setName(title);
            metas.setValue(url);
            metas.setDescription(logo);
            metas.setSort(sort);
            metas.setType(Types.LINK.getType());

            if (null != id) {
                metas.setId(id);
                metasService.update(metas);
            } else {
                metasService.saveMeta(metas);
            }
            LogDO logDO = new LogDO();
            logDO.setAction(LogActions.ADD_LINK.getAction());
            logDO.setLevel(1);
            logDO.setAuthorId(UserThreadLocal.get() == null ? null : UserThreadLocal.get().getId());
            logDO.setData("友链:" + id + "^" + title + "^" + url + "^");
            logService.insertLog(logDO, request);
        } catch (Exception e) {
            String msg = "友链保存失败";
            LOGGER.error(msg, e);
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public RestResponseBo delete(@RequestParam Long metaId,HttpServletRequest request) {
        try {
            metasService.delete(metaId);
            LogDO logDO = new LogDO();
            logDO.setAction(LogActions.DEL_LINK.getAction());
            logDO.setLevel(1);
            logDO.setAuthorId(UserThreadLocal.get() == null ? null : UserThreadLocal.get().getId());
            logDO.setData("友链:" + metaId);
            logService.insertLog(logDO, request);
        } catch (Exception e) {
            String msg = "友链删除失败";
            LOGGER.error(msg, e);
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }

}
