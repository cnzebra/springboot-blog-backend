package com.mfx.blog.service;

import com.mfx.blog.modal.entity.OptionDO;

import java.util.List;
import java.util.Map;

/**
 * options的接口
 *
 * @author mfx
 * @date 2017/3/7
 */
public interface OptionService {

    /**
     * @param optionDO
     */
    void insertOption(OptionDO optionDO);

    /**
     * @param name
     * @param value
     */
    void insertOption(String name, String value);

    /**
     * @return
     */
    List<OptionDO> getOptions();


    /**
     * 保存一组配置
     *
     * @param options
     */
    void saveOptions(Map<String, String> options);

    /**
     * @param name
     * @return
     */
    OptionDO getOptionByName(String name);
}
