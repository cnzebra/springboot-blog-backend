package com.mfx.blog.controller.admin;

import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.controller.BaseController;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.OptionDO;
import com.mfx.blog.service.LogService;
import com.mfx.blog.service.OptionService;
import com.mfx.blog.service.SiteService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangq
 * @date 2017/3/20
 */
@Controller
@RequestMapping("/admin/setting")
public class SettingController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SettingController.class);

    @Resource
    private OptionService optionService;

    @Resource
    private LogService logService;

    @Resource
    private SiteService siteService;

    /**
     * 系统设置
     */
    @GetMapping(value = "")
    public String setting(HttpServletRequest request) {
        List<OptionDO> voList = optionService.getOptions();
        Map<String, String> options = new HashMap<>(16);
        voList.forEach((option) -> {
            options.put(option.getName(), option.getValue());
        });
        if (options.get("site_record") == null) {
            options.put("site_record", "");
        }
        request.setAttribute("options", options);
        return "admin/setting";
    }

    /**
     * 保存系统设置
     */
    @PostMapping(value = "")
    @ResponseBody
    public RestResponseBo saveSetting(@RequestParam(required = false) String siteTheme, HttpServletRequest request) {
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Map<String, String> querys = new HashMap<>(16);
            parameterMap.forEach((key, value) -> {
                querys.put(key, join(value));
            });
            optionService.saveOptions(querys);
            WebConst.initConfig = querys;
            if (StringUtils.isNotBlank(siteTheme)) {
                BaseController.THEME = "themes/" + siteTheme;
            }
//            logService.insertLog(LogActions.SYS_SETTING.getAction(), GsonUtils.toJsonString(querys), null, request
//                    .getRemoteAddr(), this.getUid(request));
            return RestResponseBo.ok();
        } catch (Exception e) {
            String msg = "保存设置失败";
            return RestResponseBo.fail(msg);
        }
    }

    /**
     * 数组转字符串
     *
     * @param arr
     * @return
     */
    private String join(String[] arr) {
        StringBuilder ret = new StringBuilder();
        String[] var3 = arr;
        int var4 = arr.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            String item = var3[var5];
            ret.append(',').append(item);
        }

        return ret.length() > 0 ? ret.substring(1) : ret.toString();
    }

}
