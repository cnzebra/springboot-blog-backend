package com.zhuxl.blog.constant;

import com.zhuxl.blog.modal.vo.OptionVo;
import com.zhuxl.blog.service.IOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhuxl
 * @date 2017/3/3
 */
@Component
public class WebConst {
    public static final String USER_IN_COOKIE = "S_L_ID";
    /**
     * 最大获取文章条数
     */
    public static final int MAX_POSTS = 9999;
    /**
     * 最大页码
     */
    public static final int MAX_PAGE = 100;
    /**
     * 文章最多可以输入的文字数
     */
    public static final int MAX_TEXT_COUNT = 200000;
    /**
     * 文章标题最多可以输入的文字个数
     */
    public static final int MAX_TITLE_COUNT = 200;
    /**
     * 点击次数超过多少更新到数据库
     */
    public static final int HIT_EXCEED = 10;
    public static Map<String, String> initConfig = new HashMap<>();
    public static String LOGIN_SESSION_KEY = "login_user";
    /**
     * aes加密加盐
     */
    public static String AES_SALT = "0123456789abcdef";
    /**
     * 上传文件最大1M
     */
    public static Integer MAX_FILE_SIZE = 1048576;

    /**
     * 成功返回
     */
    public static String SUCCESS_RESULT = "SUCCESS";

    @Autowired
    private IOptionService optionService;

    @PostConstruct
    public void initConfig() {
        List<OptionVo> optionVoList = optionService.getOptions();
        optionVoList.forEach(optionVo -> initConfig.put(optionVo.getName(),optionVo.getValue()));
    }
}
