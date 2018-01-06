package com.cnlm.blog.service;

import com.cnlm.blog.modal.vo.OptionVo;

import java.util.List;
import java.util.Map;

/**
 * options的接口
 *
 * @author BlueT
 * @date 2017/3/7
 */
public interface IOptionService {

    /**
     * @param optionVo
     */
    void insertOption(OptionVo optionVo);

    /**
     * @param name
     * @param value
     */
    void insertOption(String name, String value);

    /**
     * @return
     */
    List<OptionVo> getOptions();


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
    OptionVo getOptionByName(String name);
}
