package com.sonnx.blog;

import com.sonnx.blog.exception.TipException;
import com.sonnx.blog.modal.entity.UserDO;
import com.sonnx.blog.service.OptionService;
import com.sonnx.blog.service.UserService;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 测试数据库事务
 * Created by sonnx on 2017/3/8.
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
