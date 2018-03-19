package com.mfx.blog.service;


import java.util.List;


public interface MfxcomponentService {

    List<String> listBeanNames();

    String getClassFullName(String beanId);

    List<String> methods(String beanId);

}
