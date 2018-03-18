package com.mfx.blog.param;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ModifyPassParam {
    private String password;

    private String newPassword;

    private String confirmPassword;
}
