package com.sonnx.blog.controller;

import com.github.pagehelper.PageInfo;
import com.sonnx.blog.component.constant.WebConst;
import com.sonnx.blog.dto.MetaDto;
import com.sonnx.blog.dto.Types;
import com.sonnx.blog.modal.bo.ArchiveBo;
import com.sonnx.blog.modal.bo.RestResponseBo;
import com.sonnx.blog.modal.entity.ArticleDO;
import com.sonnx.blog.modal.entity.CommentDO;
import com.sonnx.blog.modal.entity.MetaDO;
import com.sonnx.blog.modal.entity.UserDO;
import com.sonnx.blog.param.ArticleStatistics;
import com.sonnx.blog.service.*;
import com.sonnx.blog.utils.IPKit;
import com.sonnx.blog.utils.PatternKit;
import com.sonnx.blog.utils.TaleUtils;
import com.vdurmont.emoji.EmojiParser;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 首页
 *
 * @author Administrator
 * @date 2017/3/8 008
 */
@Controller
public class IndexController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Resource
    private ArticleService articleService;

    @Resource
    private CommentService commentService;

    @Resource
    private MetaService metaService;

    @Resource
    private SiteService siteService;

    @Resource
    private UserService usersService;

    /**
     * 首页分页
     *
     * @param request  request
     * @param pageNum  第几页
     * @param pageSize 每页大小
     * @return 主页
     */
    @GetMapping(value = "articles")
    @ResponseBody
    public ResponseEntity articles(HttpServletRequest request, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                   @RequestParam(value = "pageSize", defaultValue = "12") Integer pageSize) {
        PageInfo<ArticleDO> articles = articleService.getContents(pageNum, pageSize);
        return new ResponseEntity(RestResponseBo.ok(articles), HttpStatus.OK);
    }

    @GetMapping(value = "author")
    @ResponseBody
    public ResponseEntity authorInfo(@RequestParam(value = "authorId") Long authorId) {
        UserDO userDO = usersService.queryUserById(authorId);
        //将用户密码和token置为空
        userDO.setPassword(null);
        userDO.setToken(null);
        return new ResponseEntity(RestResponseBo.ok(userDO), HttpStatus.OK);
    }

    /**
     * 评论操作
     */
    @PostMapping(value = "article/{articleId}/comment")
    @ResponseBody
    public ResponseEntity comment(HttpServletRequest request, HttpServletResponse response,
                                  @PathVariable(value = "articleId") Long articleId,
                                  @RequestBody CommentDO commentDO) {

        if (null == articleId || StringUtils.isBlank(commentDO.getContent())) {
            return new ResponseEntity(RestResponseBo.fail("请输入完整后评论"), HttpStatus.OK);
        }

        if (StringUtils.isNotBlank(commentDO.getEmail()) && !TaleUtils.isEmail(commentDO.getEmail())) {
            return new ResponseEntity(RestResponseBo.fail("请输入正确的邮箱格式"), HttpStatus.OK);
        }

        if (StringUtils.isNotBlank(commentDO.getSiteUrl()) && !PatternKit.isURL(commentDO.getSiteUrl())) {
            return new ResponseEntity(RestResponseBo.fail("请输入正确的URL格式"), HttpStatus.OK);
        }

        if (commentDO.getContent().length() > 200) {
            return new ResponseEntity(RestResponseBo.fail("请输入200个字符以内的评论"), HttpStatus.OK);
        }

        String val = IPKit.getIpAddrByRequest(request) + ":" + articleId;
        Integer count = cache.hget(Types.COMMENTS_FREQUENCY.getType(), val);
        if (null != count && count > 0) {
            return new ResponseEntity(RestResponseBo.fail("您发表评论太快了，请过会再试"), HttpStatus.OK);
        }

        commentDO.setContent(EmojiParser.parseToAliases(commentDO.getContent()));

        commentDO.setIp(request.getRemoteAddr());
        try {
            String result = commentService.insertComment(commentDO);
            // 设置对每个文章1分钟可以评论一次
            cache.hset(Types.COMMENTS_FREQUENCY.getType(), val, 1, 5);
            if (!WebConst.SUCCESS_RESULT.equals(result)) {
                return new ResponseEntity(RestResponseBo.fail(result), HttpStatus.OK);
            }
            return new ResponseEntity(RestResponseBo.ok(), HttpStatus.OK);
        } catch (Exception e) {
            String msg = "评论发布失败";
            LOGGER.error(msg, e);
            return new ResponseEntity(RestResponseBo.fail(msg), HttpStatus.OK);
        }
    }

    @GetMapping(value = "categories")
    @ResponseBody
    public ResponseEntity categories() {
        List<MetaDto> categories = metaService.getMetaList(Types.CATEGORY.getType(), null, WebConst.MAX_POSTS);
        return new ResponseEntity(categories, HttpStatus.OK);
    }

    @GetMapping(value = "tags")
    @ResponseBody
    public ResponseEntity tags() {
        List<MetaDto> tags = metaService.getMetaList(Types.TAG.getType(), null, WebConst.MAX_POSTS);
        return new ResponseEntity(tags, HttpStatus.OK);
    }

    /**
     * 分类页
     *
     * @return
     */
    @GetMapping(value = "category/{keyword}")
    public String categories(HttpServletRequest request, @PathVariable String keyword, @RequestParam(value = "limit",
            defaultValue = "12") int limit) {
        return this.categories(request, keyword, 1, limit);
    }

    @GetMapping(value = "category/{keyword}/{page}")
    public String categories(HttpServletRequest request, @PathVariable String keyword,
                             @PathVariable int page, @RequestParam(value = "limit", defaultValue = "12") int limit) {
        page = page < 0 || page > WebConst.MAX_PAGE ? 1 : page;
        MetaDto metaDto = metaService.getMeta(Types.CATEGORY.getType(), keyword);
        if (null == metaDto) {
            return this.render404();
        }

        PageInfo<ArticleDO> contentsPaginator = articleService.getArticles(metaDto.getId(), page, limit);

        request.setAttribute("articles", contentsPaginator);
        request.setAttribute("meta", metaDto);
        request.setAttribute("type", "分类");
        request.setAttribute("keyword", keyword);

        return this.render("page-category");
    }


    /**
     * 归档页
     *
     * @return
     */
    @GetMapping(value = {"archives", "archives/{year}/{month}"})
    @ResponseBody
    public ResponseEntity archives(HttpServletRequest request,
                                   @PathVariable(value = "year", required = false) String year,
                                   @PathVariable(value = "month", required = false) String month,
                                   @RequestParam(value = "category", defaultValue = "") String category,
                                   @RequestParam(value = "tag", defaultValue = "") String tag) {
        List<ArchiveBo> archives = siteService.getArchives(year, month, category, tag);
        return new ResponseEntity(RestResponseBo.ok(archives), HttpStatus.OK);
    }

    /**
     * 友链页
     *
     * @return
     */
    @GetMapping(value = "links")
    @ResponseBody
    public ResponseEntity links(HttpServletRequest request) {
        List<MetaDO> links = metaService.getMetas(Types.LINK.getType());
        return new ResponseEntity(RestResponseBo.ok(links), HttpStatus.OK);
    }

    @GetMapping(value = "/article/{articleId}/comments")
    @ResponseBody
    public ResponseEntity page(@PathVariable(value = "articleId") Long articleId,
                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "6") Integer pageSize,
                               HttpServletRequest request) {
        ArticleDO contents = articleService.getContents(articleId);
        if (null == contents) {
            return new ResponseEntity(RestResponseBo.fail(), HttpStatus.OK);
        }
        PageInfo<CommentDO> commentsPaginator = commentService.getComments(articleId, pageNum, pageSize);
        return new ResponseEntity(RestResponseBo.ok(commentsPaginator), HttpStatus.OK);
    }



    /**
     * 更新文章的点击率
     *
     * @param articeId
     * @param chits
     */
    private void updateArticleHit(Long articeId, Integer chits) {
        Integer hits = cache.hget("article", "hits");
        if (chits == null) {
            chits = 0;
        }
        hits = null == hits ? 1 : hits + 1;
        if (hits >= WebConst.HIT_EXCEED) {
            ArticleDO temp = new ArticleDO();
            temp.setId(articeId);
            temp.setHits(chits + hits);
            articleService.updateContentByCid(temp);
            cache.hset("article", "hits", 1);
        } else {
            cache.hset("article", "hits", hits);
        }
    }

    /**
     * 标签页
     *
     * @param name
     * @return
     */
    @GetMapping(value = "tag/{name}")
    public String tags(HttpServletRequest request, @PathVariable String name, @RequestParam(value = "limit",
            defaultValue = "12") int limit) {
        return this.tags(request, name, 1, limit);
    }

    /**
     * 标签分页
     *
     * @param request
     * @param name
     * @param page
     * @param limit
     * @return
     */
    @GetMapping(value = "tag/{name}/{page}")
    public String tags(HttpServletRequest request, @PathVariable String name, @PathVariable int page, @RequestParam
            (value = "limit", defaultValue = "12") int limit) {

        page = page < 0 || page > WebConst.MAX_PAGE ? 1 : page;
//        对于空格的特殊处理
        name = name.replaceAll("\\+", " ");
        MetaDto metaDto = metaService.getMeta(Types.TAG.getType(), name);
        if (null == metaDto) {
            return this.render404();
        }

        PageInfo<ArticleDO> contentsPaginator = articleService.getArticles(metaDto.getId(), page, limit);
        request.setAttribute("articles", contentsPaginator);
        request.setAttribute("meta", metaDto);
        request.setAttribute("type", "标签");
        request.setAttribute("keyword", name);

        return this.render("page-category");
    }

    @PutMapping("article/statistics")
    @ResponseBody
    public ResponseEntity updateArticleStatistics(@RequestBody ArticleStatistics statistics) {
        int result = articleService.updateStatistics(statistics);

        return new ResponseEntity(RestResponseBo.ok(result), HttpStatus.OK);
    }

}
