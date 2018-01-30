package com.zhuxl.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.zhuxl.blog.controller.BaseController;
import com.zhuxl.blog.modal.bo.RestResponseBo;
import com.zhuxl.blog.modal.entity.CommentDO;
import com.zhuxl.blog.modal.entity.CommentDOExample;
import com.zhuxl.blog.modal.entity.UserDO;
import com.zhuxl.blog.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 13
 * @date 2017/2/26
 */
@Controller
@RequestMapping("admin/comments")
public class CommentController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

    @Resource
    private CommentService commentsService;

    @GetMapping(value = "")
    public String index(@RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "limit", defaultValue = "15") int limit, HttpServletRequest request) {
        UserDO users = this.user(request);
        CommentDOExample commentDOExample = new CommentDOExample();
        commentDOExample.setOrderByClause("id desc");
        commentDOExample.createCriteria().andAuthorIdNotEqualTo(users.getId());
        PageInfo<CommentDO> commentsPaginator = commentsService.getCommentsWithPage(commentDOExample, page, limit);
        request.setAttribute("comments", commentsPaginator);
        return "admin/comment_list";
    }

    /**
     * 删除一条评论
     *
     * @param coid
     * @return
     */
    @PostMapping(value = "delete")
    @ResponseBody
    public RestResponseBo delete(@RequestParam Long commentId) {
        try {
            CommentDO comments = commentsService.getCommentById(commentId);
            if (null == comments) {
                return RestResponseBo.fail("不存在该评论");
            }
            commentsService.delete(commentId, comments.getArticleId());
        } catch (Exception e) {
            String msg = "评论删除失败";
            LOGGER.error(msg, e);
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }

    @PostMapping(value = "status")
    @ResponseBody
    public RestResponseBo delete(@RequestParam Long commentId, @RequestParam String status) {
        try {
            CommentDO comments = commentsService.getCommentById(commentId);
            if (comments != null) {
                comments.setId(commentId);
                comments.setStatus(status);
                commentsService.update(comments);
            } else {
                return RestResponseBo.fail("操作失败");
            }
        } catch (Exception e) {
            String msg = "操作失败";
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }

}
