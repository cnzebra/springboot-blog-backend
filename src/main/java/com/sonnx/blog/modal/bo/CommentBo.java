package com.sonnx.blog.modal.bo;

import com.sonnx.blog.modal.entity.CommentDO;
import com.sonnx.blog.modal.entity.CommentDO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 返回页面的评论，包含父子评论内容
 *
 * @author 13
 * @date 2017/2/24
 */
@Getter
@Setter
public class CommentBo extends CommentDO {

    private int levels;
    private List<CommentDO> children;

    public CommentBo(CommentDO comments) {
        setAuthor(comments.getAuthor());
        setEmail(comments.getEmail());
        setId(comments.getId());
        setAuthorId(comments.getAuthorId());
        setSiteUrl(comments.getSiteUrl());
        setGmtCreate(comments.getGmtCreate());
        setAgent(comments.getAgent());
        setIp(comments.getIp());
        setContent(comments.getContent());
        setOwnerId(comments.getOwnerId());
        setArticleId(comments.getArticleId());
    }

}
