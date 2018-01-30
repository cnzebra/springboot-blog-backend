package com.zhuxl.blog.controller.admin;

import com.zhuxl.blog.component.constant.WebConst;
import com.zhuxl.blog.controller.BaseController;
import com.zhuxl.blog.dto.LogActions;
import com.zhuxl.blog.dto.Types;
import com.zhuxl.blog.modal.bo.RestResponseBo;
import com.zhuxl.blog.modal.entity.ArticleDO;
import com.zhuxl.blog.modal.entity.ArticleDOExample;
import com.zhuxl.blog.modal.entity.UserDO;
import com.zhuxl.blog.service.ArticleService;
import com.zhuxl.blog.service.LogService;
import com.github.pagehelper.PageInfo;
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
        articleDOExample.setOrderByClause("created desc");
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

    @GetMapping(value = "/{cid}")
    public String editPage(@PathVariable String cid, HttpServletRequest request) {
        ArticleDO contents = contentsService.getContents(cid);
        request.setAttribute("contents", contents);
        return "admin/page_edit";
    }

    @PostMapping(value = "publish")
    @ResponseBody
    public RestResponseBo publishPage(@RequestParam String title, @RequestParam String content,
                                      @RequestParam String status, @RequestParam String slug,
                                      @RequestParam(required = false) Integer allowComment, @RequestParam(required =
            false) Integer allowPing, HttpServletRequest request) {

        UserDO users = this.user(request);
        ArticleDO contents = new ArticleDO();
        contents.setTitle(title);
        contents.setCover("");
        contents.setContent(content);
        contents.setStatus(status);
        contents.setSlug(slug);
        contents.setType(Types.PAGE.getType());
        if (null != allowComment) {
            contents.setAllowComment(allowComment == 1);
        }
        if (null != allowPing) {
            contents.setAllowPing(allowPing == 1);
        }
        contents.setAuthorId(users.getUid());
        String result = contentsService.publish(contents);
        if (!WebConst.SUCCESS_RESULT.equals(result)) {
            return RestResponseBo.fail(result);
        }
        return RestResponseBo.ok();
    }

    @PostMapping(value = "modify")
    @ResponseBody
    public RestResponseBo modifyArticle(@RequestParam Integer cid, @RequestParam String title,
                                        @RequestParam String content,
                                        @RequestParam String status, @RequestParam String slug,
                                        @RequestParam(required = false) Integer allowComment, @RequestParam(required
            = false) Integer allowPing, HttpServletRequest request) {

        UserDO users = this.user(request);
        ArticleDO contents = new ArticleDO();
        contents.setCid(cid);
        contents.setTitle(title);
        contents.setContent(content);
        contents.setStatus(status);
        contents.setSlug(slug);
        contents.setType(Types.PAGE.getType());
        if (null != allowComment) {
            contents.setAllowComment(allowComment == 1);
        }
        if (null != allowPing) {
            contents.setAllowPing(allowPing == 1);
        }
        contents.setAuthorId(users.getUid());
        String result = contentsService.updateArticle(contents);
        if (!WebConst.SUCCESS_RESULT.equals(result)) {
            return RestResponseBo.fail(result);
        }
        return RestResponseBo.ok();
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public RestResponseBo delete(@RequestParam int cid, HttpServletRequest request) {
        String result = contentsService.deleteByCid(cid);
        logService.insertLog(LogActions.DEL_ARTICLE.getAction(), cid + "", request.getRemoteAddr(), this.getUid
                (request));
        if (!WebConst.SUCCESS_RESULT.equals(result)) {
            return RestResponseBo.fail(result);
        }
        return RestResponseBo.ok();
    }
}
