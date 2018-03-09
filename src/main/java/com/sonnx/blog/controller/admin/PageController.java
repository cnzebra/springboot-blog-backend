package com.sonnx.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.sonnx.blog.dto.LogActions;
import com.sonnx.blog.dto.Types;
import com.sonnx.blog.component.constant.WebConst;
import com.sonnx.blog.controller.BaseController;
import com.sonnx.blog.dto.LogActions;
import com.sonnx.blog.dto.Types;
import com.sonnx.blog.modal.bo.RestResponseBo;
import com.sonnx.blog.modal.entity.ArticleDO;
import com.sonnx.blog.modal.entity.ArticleDOExample;
import com.sonnx.blog.modal.entity.UserDO;
import com.sonnx.blog.service.ArticleService;
import com.sonnx.blog.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 13
 * @date 2017/2/21
 */
@Controller()
@RequestMapping("admin/page")
public class PageController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PageController.class);

    @Resource
    private ArticleService contentsService;

    @Resource
    private LogService logService;

    @GetMapping(value = "")
    public String index(HttpServletRequest request) {
        ArticleDOExample articleDOExample = new ArticleDOExample();
        articleDOExample.setOrderByClause("gmt_create desc");
        articleDOExample.createCriteria().andTypeEqualTo(Types.PAGE.getType());
        PageInfo<ArticleDO> contentsPaginator = contentsService.getArticlesWithpage(articleDOExample, 1, WebConst
                .MAX_POSTS);
        request.setAttribute("articles", contentsPaginator);
        return "admin/page_list";
    }

    @GetMapping(value = "new")
    public String newPage(HttpServletRequest request) {
        return "admin/page_edit";
    }

    @GetMapping(value = "/{id}")
    public String editPage(@PathVariable Long id, HttpServletRequest request) {
        ArticleDO contents = contentsService.getContents(id);
        request.setAttribute("contents", contents);
        return "admin/page_edit";
    }

    @PostMapping(value = "publish")
    @ResponseBody
    public RestResponseBo publishPage(@RequestParam String title, @RequestParam String content,
                                      @RequestParam String status, @RequestParam String path,
                                      @RequestParam(required = false) Integer allowComment, @RequestParam(required =
            false) Integer allowPing, HttpServletRequest request) {

        UserDO users = this.user(request);
        ArticleDO contents = new ArticleDO();
        contents.setTitle(title);
        contents.setCover("");
        contents.setContent(content);
        contents.setStatus(status);
        contents.setPath(path);
        contents.setType(Types.PAGE.getType());
        if (null != allowComment) {
            contents.setAllowComment(allowComment == 1);
        }
        if (null != allowPing) {
            contents.setAllowPing(allowPing == 1);
        }
        contents.setAuthorId(users.getId());
        String result = contentsService.publish(contents);
        if (!WebConst.SUCCESS_RESULT.equals(result)) {
            return RestResponseBo.fail(result);
        }
        return RestResponseBo.ok();
    }

    @PostMapping(value = "modify")
    @ResponseBody
    public RestResponseBo modifyArticle(@RequestParam Long articleId, @RequestParam String title,
                                        @RequestParam String content,
                                        @RequestParam String status, @RequestParam String path,
                                        @RequestParam(required = false) Integer allowComment, @RequestParam(required
            = false) Integer allowPing, HttpServletRequest request) {

        UserDO users = this.user(request);
        ArticleDO contents = new ArticleDO();
        contents.setId(articleId);
        contents.setTitle(title);
        contents.setContent(content);
        contents.setStatus(status);
        contents.setPath(path);
        contents.setType(Types.PAGE.getType());
        if (null != allowComment) {
            contents.setAllowComment(allowComment == 1);
        }
        if (null != allowPing) {
            contents.setAllowPing(allowPing == 1);
        }
        contents.setAuthorId(users.getId());
        String result = contentsService.updateArticle(contents);
        if (!WebConst.SUCCESS_RESULT.equals(result)) {
            return RestResponseBo.fail(result);
        }
        return RestResponseBo.ok();
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public RestResponseBo delete(@RequestParam Long articleId, HttpServletRequest request) {
        String result = contentsService.deleteByCid(articleId);
        logService.insertLog(LogActions.DEL_ARTICLE.getAction(), articleId + "", null, request.getRemoteAddr(), this.getUid
                (request));
        if (!WebConst.SUCCESS_RESULT.equals(result)) {
            return RestResponseBo.fail(result);
        }
        return RestResponseBo.ok();
    }
}
