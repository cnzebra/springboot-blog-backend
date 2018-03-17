package com.mfx.blog.modal.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class AbstractEntity extends AbstractIdSerializable {
    private Date gmtCreate;

    private Date gmtModified;
}
