package com.mfx.blog.service.impl;

import com.mfx.blog.dao.OptionDao;
import com.mfx.blog.dao.OptionDao;
import com.mfx.blog.modal.entity.OptionDO;
import com.mfx.blog.modal.entity.OptionDOExample;
import com.mfx.blog.service.OptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * options表的service
 *
 * @author mfx
 * @date 2017/3/7
 */
@Service
public class OptionServiceImpl implements OptionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OptionServiceImpl.class);

    @Resource
    private OptionDao optionDao;

    @Override
    public void insertOption(OptionDO optionDO) {
        LOGGER.debug("Enter insertOption method:optionDO={}", optionDO);
        optionDao.insertSelective(optionDO);
        LOGGER.debug("Exit insertOption method.");
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void insertOption(String name, String value) {
        LOGGER.debug("Enter insertOption method:name={},value={}", name, value);
        OptionDO optionDO = new OptionDO();
        optionDO.setName(name);
        optionDO.setValue(value);
        if (optionDao.selectByPrimaryKey(name) == null) {
            optionDao.insertSelective(optionDO);
        } else {
            optionDao.updateByPrimaryKeySelective(optionDO);
        }
        LOGGER.debug("Exit insertOption method.");
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void saveOptions(Map<String, String> options) {
        if (null != options && !options.isEmpty()) {
            options.forEach(this::insertOption);
        }
    }

    @Override
    public OptionDO getOptionByName(String name) {
        return optionDao.selectByPrimaryKey(name);
    }

    @Override
    public List<OptionDO> getOptions() {
        return optionDao.selectByExample(new OptionDOExample());
    }
}
