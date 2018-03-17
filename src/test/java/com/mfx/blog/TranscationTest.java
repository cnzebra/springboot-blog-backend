package com.mfx.blog;

import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.entity.UserDO;
import com.mfx.blog.service.OptionService;
import com.mfx.blog.service.UserService;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.entity.UserDO;
import com.mfx.blog.service.OptionService;
import com.mfx.blog.service.UserService;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 测试数据库事务
 * Created by mfx on 2017/3/8.
 */
@MapperScan("com.my.blog.website.dao")
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional(rollbackFor = TipException.class)
public class TranscationTest {

    @Resource
    private UserService userService;

    @Resource
    private OptionService optionService;

    @org.junit.Test
    @Ignore
    public void test() {
        UserDO user = new UserDO();
        user.setLoginName("wangqiang111");
        user.setPassword("123456");
        user.setEmail("8888");
        userService.insertUser(user);
        optionService.insertOption("site_keywords", "qwqwq");
    }
}
