package com.zhuxl.blog.modal.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 后台统计对象
 *
 * @author zhuxiaolong
 */
@Getter
@Setter
public class StatisticsBo implements Serializable {

    private Long articles;
    private Long comments;
    private Long links;
    private Long attachs;

}
