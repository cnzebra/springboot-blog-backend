package com.mfx.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.mfx.blog.component.common.Commons;
import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.controller.BaseController;
import com.mfx.blog.dto.LogActions;
import com.mfx.blog.dto.Types;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.AttachFileDO;
import com.mfx.blog.modal.entity.UserDO;
import com.mfx.blog.service.AttachFileService;
import com.mfx.blog.service.LogService;
import com.mfx.blog.utils.TaleUtils;
import com.mfx.blog.component.common.Commons;
import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.controller.BaseController;
import com.mfx.blog.dto.LogActions;
import com.mfx.blog.dto.Types;
import com.mfx.blog.modal.entity.AttachFileDO;
import com.mfx.blog.modal.entity.UserDO;
import com.mfx.blog.service.AttachFileService;
import com.mfx.blog.service.LogService;
import com.mfx.blog.utils.TaleUtils;
import com.mfx.blog.component.common.Commons;
import com.mfx.blog.component.constant.WebConst;
import com.mfx.blog.controller.BaseController;
import com.mfx.blog.dto.LogActions;
import com.mfx.blog.dto.Types;
import com.mfx.blog.modal.bo.RestResponseBo;
import com.mfx.blog.modal.entity.AttachFileDO;
import com.mfx.blog.modal.entity.UserDO;
import com.mfx.blog.service.AttachFileService;
import com.mfx.blog.service.LogService;
import com.mfx.blog.utils.TaleUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 附件管理
 * <p>
 *
 * @author 13
 * @date 2017/2/21
 */
@Controller
@RequestMapping("admin/attach")
public class AttachController extends BaseController {

    public static final String CLASSPATH = TaleUtils.getUplodFilePath();
    private static final Logger LOGGER = LoggerFactory.getLogger(AttachController.class);
    @Resource
    private AttachFileService attachService;

    @Resource
    private LogService logService;

    /**
     * 附件页面
     *
     * @param request
     * @param page
     * @param limit
     * @return
     */
    @GetMapping(value = "")
    public String index(HttpServletRequest request, @RequestParam(value = "page", defaultValue = "1") int page,
                        @RequestParam(value = "limit", defaultValue = "12") int limit) {
        PageInfo<AttachFileDO> attachPaginator = attachService.getAttachs(page, limit);
        request.setAttribute("attachs", attachPaginator);
        request.setAttribute(Types.ATTACH_URL.getType(), Commons.siteOption(Types.ATTACH_URL.getType(), Commons
                .siteUrl()));
        request.setAttribute("max_file_size", WebConst.MAX_FILE_SIZE / 1024);
        return "admin/attach";
    }

    /**
     * 上传文件接口
     *
     * @param request
     * @return
     */
    @PostMapping(value = "upload")
    @ResponseBody
    public RestResponseBo upload(HttpServletRequest request, @RequestParam("file") MultipartFile[] multipartFiles)
            throws IOException {
        UserDO users = this.user(request);
        Long id = users.getId();
        List<String> errorFiles = new ArrayList<>();
        try {
            for (MultipartFile multipartFile : multipartFiles) {
                String fname = multipartFile.getOriginalFilename();
                if (multipartFile.getSize() <= WebConst.MAX_FILE_SIZE) {
                    String fkey = TaleUtils.getFileKey(fname);
                    String ftype = TaleUtils.isImage(multipartFile.getInputStream()) ? Types.IMAGE.getType() : Types
                            .FILE.getType();
                    File file = new File(CLASSPATH + fkey);
                    try {
                        FileCopyUtils.copy(multipartFile.getInputStream(), new FileOutputStream(file));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    attachService.save(fname, fkey, ftype, id);
                } else {
                    errorFiles.add(fname);
                }
            }
        } catch (Exception e) {
            return RestResponseBo.fail();
        }
        return RestResponseBo.ok(errorFiles);
    }

    /**
     * 上传多文件接口
     *
     * @param request
     * @return
     */
    @PostMapping(value = "upload/multiple")
    @ResponseBody
    public RestResponseBo upload(HttpServletRequest request)
            throws IOException {
        UserDO users = this.user(request);
        Long id = users.getId();
        List<String> errorFiles = new ArrayList<>();
        try {
            CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession()
                    .getServletContext());
            if (commonsMultipartResolver.isMultipart(request)) {
                MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
                MultiValueMap<String, MultipartFile> multiValueMap = multipartRequest.getMultiFileMap();//图片集合
                Iterator<String> iterator = multipartRequest.getFileNames();
                while (iterator.hasNext()) {
                    //取得上传文件
                    String fieldName = iterator.next();
                    List<MultipartFile> multipartFiles = multiValueMap.get(fieldName);

                    for (MultipartFile multipartFile : multipartFiles) {
                        String fname = multipartFile.getOriginalFilename();
                        if (multipartFile.getSize() <= WebConst.MAX_FILE_SIZE) {
                            String fkey = TaleUtils.getFileKey(fname);
                            String ftype = TaleUtils.isImage(multipartFile.getInputStream()) ? Types.IMAGE.getType()
                                    : Types.FILE.getType();
                            File file = new File(CLASSPATH + fkey);
                            try {
                                FileCopyUtils.copy(multipartFile.getInputStream(), new FileOutputStream(file));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            attachService.save(fname, fkey, ftype, id);
                        } else {
                            errorFiles.add(fname);
                        }
                    }
                }

            }

        } catch (Exception e) {
            LOGGER.error("上传附件报错:{}", e.getMessage(), e);
            return RestResponseBo.fail();
        }
        return RestResponseBo.ok(errorFiles);
    }

    @RequestMapping(value = "delete")
    @ResponseBody
    public RestResponseBo delete(@RequestParam Long id, HttpServletRequest request) {
        try {
            AttachFileDO attach = attachService.selectById(id);
            if (null == attach) {
                return RestResponseBo.fail("不存在该附件");
            }
            attachService.deleteById(id);
            new File(CLASSPATH + attach.getFileKey()).delete();
            logService.insertLog(LogActions.DEL_ARTICLE.getAction(), attach.getFileKey(), null, request.getRemoteAddr(), this
                    .getUid(request));
        } catch (Exception e) {
            String msg = "附件删除失败";
            LOGGER.error(msg, e);
            return RestResponseBo.fail(msg);
        }
        return RestResponseBo.ok();
    }

}
