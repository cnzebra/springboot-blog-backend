package com.cnlm.blog.modal.bo;

import java.io.Serializable;

/**
 * @author 13
 * @date 2017/2/25
 */
public class BackResponseBo implements Serializable {

    private String attachPath;
    private String themePath;
    private String sqlPath;

    public String getAttachPath() {
        return attachPath;
    }

    public void setAttachPath(String attachPath) {
        this.attachPath = attachPath;
    }

    public String getThemePath() {
        return themePath;
    }

    public void setThemePath(String themePath) {
        this.themePath = themePath;
    }

    public String getSqlPath() {
        return sqlPath;
    }

    public void setSqlPath(String sqlPath) {
        this.sqlPath = sqlPath;
    }
}
