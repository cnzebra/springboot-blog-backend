package com.mfx.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.mfx.blog.controller.BaseController;
import com.mfx.blog.dto.LogActions;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.CommentDO;
import com.mfx.blog.modal.entity.CommentDOExample;
import com.mfx.blog.modal.entity.LogDO;
import com.mfx.blog.modal.entity.UserDO;
import com.mfx.blog.service.CommentService;
import com.mfx.blog.service.LogService;
import com.mfx.blog.thread.UserThreadLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    @Resource
    private LogService logService;


    /**
     * 删除一条评论
     *
     * @param commentId
     * @return
     */
    @PostMapping(value = "delete.token")
    @ResponseBody
    public ResponseEntity delete(@RequestParam Long commentId,HttpServletRequest request) {
        try {
            CommentDO comments = commentsService.getCommentById(commentId);
            if (null == comments) {
                return new ResponseEntity(RestResponseBo.fail("不存在该评论"), HttpStatus.OK);
            }
            commentsService.delete(commentId, comments.getArticleId());
        } catch (Exception e) {
            String msg = "评论删除失败";
            LOGGER.error(msg, e);
            return new ResponseEntity(RestResponseBo.fail(msg), HttpStatus.OK);
        }
        return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
    }

    @PostMapping(value = "status")
    @ResponseBody
    public ResponseEntity delete(@RequestParam Long commentId, @RequestParam String status) {
        try {
            CommentDO comments = commentsService.getCommentById(commentId);
            if (comments != null) {
                comments.setId(commentId);
                comments.setStatus(status);
                commentsService.update(comments);
            } else {
                return new ResponseEntity(RestResponseBo.fail("操作失败"), HttpStatus.OK);
            }
        } catch (Exception e) {
            String msg = "操作失败";
            return new ResponseEntity(RestResponseBo.fail(msg), HttpStatus.OK);
        }
        return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);

    }

}
