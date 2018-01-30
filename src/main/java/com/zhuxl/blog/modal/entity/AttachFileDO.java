package com.zhuxl.blog.modal.entity;

import com.zhuxl.blog.modal.common.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

/**
 * @author
 */
@Getter
@Setter
public class AttachFileDO extends AbstractEntity {
    private static final long serialVersionUID = 1L;

    private String fileName;
    private String fileType;
    private String fileKey;
    private Long authorId;

}