package com.zhuxl.blog.component.common;


import com.zhuxl.blog.modal.vo.MetaVo;
import com.zhuxl.blog.utils.Tools;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 后台公共函数
 * <p>
 *
 * @author 13
 * @date 2017/2/21
 */
@Component
public final class AdminCommons {

    private static final String[] COLORS = {"default", "primary", "success", "info", "warning", "danger", "inverse",
            "purple", "pink"};

    /**
     * 判断category和cat的交集
     *
     * @param cats
     * @return
     */
    public static boolean existCat(MetaVo category, String cats) {
        String[] arr = StringUtils.split(cats, ",");
        if (null != arr && arr.length > 0) {
            for (String c : arr) {
                if (c.trim().equals(category.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String randColor() {
        int r = Tools.rand(0, COLORS.length - 1);
        return COLORS[r];
    }

}
