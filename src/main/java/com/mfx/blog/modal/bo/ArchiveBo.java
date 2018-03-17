package com.mfx.blog.modal.bo;

import com.mfx.blog.modal.entity.ArticleDO;
import com.mfx.blog.modal.entity.ArticleDO;
import com.mfx.blog.modal.entity.ArticleDO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @author 13
 * @date 2017/2/23
 */
@Getter
@Setter
@ToString
public class ArchiveBo implements Serializable {

    private String year;
    private String month;
    private String date;
    private String count;
    private List<ArticleDO> articles;

}
