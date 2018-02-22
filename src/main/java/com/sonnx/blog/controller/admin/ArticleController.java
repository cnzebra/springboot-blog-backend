package com.sonnx.blog.controller.admin;


import com.github.pagehelper.PageInfo;
import com.sonnx.blog.component.constant.WebConst;
import com.sonnx.blog.controller.BaseController;
import com.sonnx.blog.dto.LogActions;
import com.sonnx.blog.dto.Types;
import com.sonnx.blog.exception.TipException;
import com.sonnx.blog.modal.bo.RestResponseBo;
import com.sonnx.blog.modal.entity.*;
import com.sonnx.blog.service.ArticleService;
import com.sonnx.blog.service.AttachFileService;
import com.sonnx.blog.service.LogService;
import com.sonnx.blog.service.MetaService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 13
 * @date 2017/2/21
 */
@Controller
@RequestMapping("/admin/article")
@Transactional(rollbackFor = TipException.class)
public class ArticleController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);

    @Resource
    private ArticleService contentsService;

    @Resource
    private MetaService metasService;
    @Autowired
    private AttachFileService attachService;

    @Resource
    private LogService logService;

    @GetMapping(value = "")
    public String index(@RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "limit", defaultValue = "15") int limit, HttpServletRequest request) {
        ArticleDOExample articleDOExample = new ArticleDOExample();
        articleDOExample.setOrderByClause("gmt_create desc");
        articleDOExample.createCriteria().andTypeEqualTo(Types.ARTICLE.getType());
        PageInfo<ArticleDO> contentsPaginator = contentsService.getArticlesWithpage(articleDOExample, page, limit);
        request.setAttribute("articles", contentsPaginator);
        return "admin/article_list";
    }

    @GetMapping(value = "list")
    @ResponseBody
    public ResponseEntity articleList(@RequestParam(value = "page", defaultValue = "1") int page,
                                      @RequestParam(value = "limit", defaultValue = "15") int limit, HttpServletRequest request) {
        ArticleDOExample articleDOExample = new ArticleDOExample();
        articleDOExample.setOrderByClause("gmt_create desc");
        articleDOExample.createCriteria().andTypeEqualTo(Types.ARTICLE.getType());
        PageInfo<ArticleDO> contentsPaginator = contentsService.getArticlesWithpage(articleDOExample, page, limit);
        return new ResponseEntity(contentsPaginator, HttpStatus.OK);
    }

    @GetMapping(value = {"preview/{id}", "preview/{id}.html"})
    public ResponseEntity articlePreview(HttpServletRequest request, @PathVariable Long id) {
        ArticleDO contents = contentsService.getContents(id);
        if (null == contents) {
            return new ResponseEntity(null, HttpStatus.OK);
        }
        return new ResponseEntity(contents, HttpStatus.OK);


    }


    @GetMapping(value = "/publish")
    public String newArticle(HttpServletRequest request) {
        List<MetaDO> categories = metasService.getMetas(Types.CATEGORY.getType());
        request.setAttribute("categories", categories);
        PageInfo<AttachFileDO> attachPaginator = attachService.getAttachs(1, 12);
        request.setAttribute("attachs", attachPaginator);
        return "admin/article_edit";
    }

    @GetMapping(value = "/{articleId}")
    public String editArticle(@PathVariable Long articleId, HttpServletRequest request) {
        ArticleDO contents = contentsService.getContents(articleId);
        request.setAttribute("contents", contents);
        List<MetaDO> categories = metasService.getMetas(Types.CATEGORY.getType());
        request.setAttribute("categories", categories);
        request.setAttribute("active", "article");

        PageInfo<AttachFileDO> attachPaginator = attachService.getAttachs(1, 12);
        request.setAttribute("attachs", attachPaginator);

        return "admin/article_edit";
    }

    @PostMapping(value = "/publish")
    @ResponseBody
    public RestResponseBo publishArticle(ArticleDO contents, HttpServletRequest request) {
        UserDO users = this.user(request);
        contents.setAuthorId(users.getId());
        contents.setType(Types.ARTICLE.getType());
        if (StringUtils.isBlank(contents.getCategories())) {
            contents.setCategories("默认分类");
        }
        String result = contentsService.publish(contents);
        if (!WebConst.SUCCESS_RESULT.equals(result)) {
            return RestResponseBo.fail(result);
        }
        return RestResponseBo.ok();
    }

    @PostMapping(value = "/modify")
    @ResponseBody
    public RestResponseBo modifyArticle(ArticleDO contents, HttpServletRequest request) {
        UserDO users = this.user(request);
        contents.setAuthorId(users.getId());
        contents.setType(Types.ARTICLE.getType());
        String result = contentsService.updateArticle(contents);
        if (!WebConst.SUCCESS_RESULT.equals(result)) {
            return RestResponseBo.fail(result);
        }
        return RestResponseBo.ok();
    }

    @RequestMapping(value = "/delete")
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
