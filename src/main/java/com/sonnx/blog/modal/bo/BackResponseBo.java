package com.sonnx.blog.modal.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author zhuxiaolong
 * @date 2018年1月30日15:34:41
 */
@Getter
@Setter
public class BackResponseBo implements Serializable {

    private String attachPath;
    private String themePath;
    private String sqlPath;
}
