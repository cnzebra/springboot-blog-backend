package com.mfx.blog.controller.admin;


import com.github.pagehelper.PageInfo;
import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.constant.ParamsConstant;
import com.mfx.blog.controller.BaseController;
import com.mfx.blog.dto.LogActions;
import com.mfx.blog.dto.Types;
import com.mfx.blog.exception.TipException;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.*;
import com.mfx.blog.param.ArticleQueryParam;
import com.mfx.blog.service.*;
import com.mfx.blog.thread.UserThreadLocal;
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
import java.util.ArrayList;
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
    @Autowired
    private UserService userService;

    @Resource
    private LogService logService;


    @PostMapping(value = "list.token")
    @ResponseBody
    public ResponseEntity articleList(@RequestBody ArticleQueryParam queryParam,
                                      HttpServletRequest request) {
        try {
            String token = request.getHeader(ParamsConstant.HEADER_TOKEN);
            UserDOExample userDOExample = new UserDOExample();
            userDOExample.createCriteria().andTokenEqualTo(token);

            ArticleDOExample articleDOExample = new ArticleDOExample();

            // 排序
            if (StringUtils.isNotBlank(queryParam.getSort())) {
                articleDOExample.setOrderByClause(queryParam.getSort());
            } else {
                articleDOExample.setOrderByClause("gmt_create desc");
            }

            ArticleDOExample.CriteriaAbstract criteriaAbstract = articleDOExample.createCriteria();

            criteriaAbstract.andTypeEqualTo(Types.ARTICLE.getType());


            // 状态筛选
            String status = queryParam.getQueryParam().getStatus();
            if (StringUtils.isNotBlank(status)) {
                criteriaAbstract.andStatusEqualTo(status);
            }

            // 表单查询
            String title = queryParam.getQueryParam().getTitle();
            title = StringUtils.isBlank(title) ? "" : title;
            criteriaAbstract.andTitleLike("%" + title + "%");

            String tagsList = queryParam.getQueryParam().getTags();
            String categoriesList = queryParam.getQueryParam().getCategories();
            criteriaAbstract.andTagsLike("%" + tagsList + "%");
            criteriaAbstract.andCategoriesLike("%" + categoriesList + "%");

            List<ArticleDOExample.CriteriaAbstract> criteriaAbstracts = new ArrayList();
            criteriaAbstracts.add(criteriaAbstract);

            articleDOExample.setOredCriteria(criteriaAbstracts);

            PageInfo<ArticleDO> contentsPaginator = contentsService.getArticlesWithpage(articleDOExample, userDOExample, queryParam.getPageNum(), queryParam.getPageSize());
            return new ResponseEntity(RestResponseBo.ok(contentsPaginator), HttpStatus.OK);
        } catch (TipException e) {
            LOGGER.error("异常:{}", e.getMessage(), e);
            return new ResponseEntity(RestResponseBo.fail(e.getMessage()), HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("异常:{}", e.getMessage(), e);
            return new ResponseEntity(RestResponseBo.fail("内部错误"), HttpStatus.OK);
        }
    }

    @PutMapping(value = "audit.token")
    @ResponseBody
    public RestResponseBo auditArticle(@RequestParam(value = "articleId") Long articleId,
                                       @RequestParam(value = "status") String status, HttpServletRequest request) {
        int result = contentsService.audit(articleId, status);
        LogDO logDO = new LogDO();
        logDO.setAction(LogActions.AUDIT_ARTICLE.getAction());
        logDO.setLevel(1);
        logDO.setAuthorId(UserThreadLocal.get() == null ? null : UserThreadLocal.get().getId());
        if (result == 1) {
            logDO.setData("文章:" + articleId + ",审核成功:" + status == "audit" ? "待审" : (status == "draft") ? "草稿" : "发布");
            logService.insertLog(logDO, request);
            return RestResponseBo.ok();
        }
        logDO.setData("文章:" + articleId + ",审核失败:" + status == "audit" ? "待审" : (status == "draft") ? "草稿" : "发布");
        logService.insertLog(logDO, request);
        return RestResponseBo.fail();
    }

    @GetMapping(value = {"preview/{id}.token"})
    public ResponseEntity articlePreview(HttpServletRequest request, @PathVariable Long id) {
        ArticleDO contents = contentsService.getContents(id);
        if (null == contents) {
            return new ResponseEntity(RestResponseBo.fail(), HttpStatus.OK);
        }
        return new ResponseEntity(RestResponseBo.ok(contents), HttpStatus.OK);
    }

    @GetMapping(value = {"detail/{path}.open"})
    public ResponseEntity articleDetail(HttpServletRequest request, @PathVariable String path) {
        ArticleDO contents = contentsService.getDetail(path);
        if (null == contents) {
            return new ResponseEntity(RestResponseBo.fail(), HttpStatus.OK);
        }
        return new ResponseEntity(RestResponseBo.ok(contents), HttpStatus.OK);
    }


    @PostMapping(value = "/publish.token")
    @ResponseBody
    public ResponseEntity publishArticle(@RequestBody ArticleDO contents, HttpServletRequest request) {
        contents.setType(Types.ARTICLE.getType());
        if (StringUtils.isBlank(contents.getCategories())) {
            contents.setCategories("默认分类");
        }
        String result = contentsService.publish(contents);

        LogDO logDO = new LogDO();
        logDO.setAction(LogActions.PUBLISH_ARTICLE.getAction());
        logDO.setLevel(1);
        logDO.setAuthorId(UserThreadLocal.get() == null ? null : UserThreadLocal.get().getId());

        if (WebConst.SUCCESS_RESULT.equals(result)) {
            logDO.setData("发表文章成功:" + contents.getTitle() + "【" + contents.getStatus() + "】");
            logService.insertLog(logDO, request);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        }
        logDO.setData("发表文章失败:" + contents.getTitle() + "【" + contents.getStatus() + "】");
        logService.insertLog(logDO, request);
        return new ResponseEntity(RestResponseBo.fail(result), HttpStatus.OK);
    }

    @PutMapping(value = "/modify.token")
    @ResponseBody
    public ResponseEntity modifyArticle(@RequestBody ArticleDO contents, HttpServletRequest request) {
        contents.setType(Types.ARTICLE.getType());
        String result = contentsService.updateArticle(contents);

        LogDO logDO = new LogDO();
        logDO.setAction(LogActions.PUBLISH_ARTICLE.getAction());
        logDO.setLevel(1);
        logDO.setAuthorId(UserThreadLocal.get() == null ? null : UserThreadLocal.get().getId());

        if (WebConst.SUCCESS_RESULT.equals(result)) {
            logDO.setData("修改文章成功:" + contents.getTitle() + "【" + contents.getStatus() + "】");
            logService.insertLog(logDO, request);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        }
        logDO.setData("修改文章失败:" + contents.getTitle() + "【" + contents.getStatus() + "】");
        logService.insertLog(logDO, request);
        return new ResponseEntity(RestResponseBo.fail(result), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete.token")
    @ResponseBody
    public ResponseEntity delete(@RequestParam Long id, HttpServletRequest request) {
        String result = contentsService.deleteByCid(id);
        LogDO logDO = new LogDO();
        logDO.setAction(LogActions.PUBLISH_ARTICLE.getAction());
        logDO.setLevel(1);
        logDO.setAuthorId(UserThreadLocal.get() == null ? null : UserThreadLocal.get().getId());

        if (WebConst.SUCCESS_RESULT.equals(result)) {
            logDO.setData("删除文章成功:" + id);
            logService.insertLog(logDO, request);
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        }
        logDO.setData("删除文章失败:" + id);
        logService.insertLog(logDO, request);
        return new ResponseEntity(RestResponseBo.fail(result), HttpStatus.OK);
    }
}
