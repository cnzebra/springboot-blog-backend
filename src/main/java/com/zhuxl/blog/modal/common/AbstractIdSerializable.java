package com.zhuxl.blog.modal.common;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhuxiaolong
 * @date 2018年1月30日11:07:39
 */
@Getter
@Setter
public abstract class AbstractIdSerializable implements Serializable {

    private Long id;
}
