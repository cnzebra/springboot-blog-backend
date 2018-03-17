package com.mfx.blog.modal.entity;

import com.mfx.blog.modal.common.AbstractEntity;
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