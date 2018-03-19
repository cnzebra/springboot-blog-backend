package com.mfx.blog.service;

import com.mfx.blog.annotation.MfxComponentAnnotation;
import com.mfx.blog.utils.SpringUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class MfxcomponentServiceImpl implements MfxcomponentService {


    @Override
    public List<String> listBeanNames() {
        String[] names = SpringUtils.listBeanIds(MfxComponentAnnotation.class);
        return Arrays.asList(names);
    }

    @Override
    public String getClassFullName(String beanId) {
        Object object = SpringUtils.getBean(beanId);
        if (object != null) {
            return object.getClass().getName();
        }
        return null;
    }

    @Override
    public List<String> methods(String beanId) {
        Object object = SpringUtils.getBean(beanId);
        if (object == null) {
            return null;
        }
        Method[] methods = object.getClass().getDeclaredMethods();
        List<String> methodNames = new ArrayList<String>();
        for (Method method : methods) {
            methodNames.add(method.getName());
        }
        return methodNames;
    }
}
