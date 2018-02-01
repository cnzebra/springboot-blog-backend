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

    private Integer articles;
    private Integer comments;
    private Integer links;
    private Integer attachs;

}
