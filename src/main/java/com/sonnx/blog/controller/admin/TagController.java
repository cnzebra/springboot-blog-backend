package com.sonnx.blog.controller.admin;

import com.sonnx.blog.component.constant.WebConst;
import com.sonnx.blog.controller.BaseController;
import com.sonnx.blog.dto.MetaDto;
import com.sonnx.blog.dto.Types;
import com.sonnx.blog.modal.bo.RestResponseBo;
import com.sonnx.blog.service.MetaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 13
 * @date 2017/2/21
 */
@Controller
@RequestMapping("admin/tag")
public class TagController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TagController.class);

    @Resource
    private MetaService metasService;

    @GetMapping(value = "list")
    @ResponseBody
    public ResponseEntity tags() {
        List<MetaDto> tags = metasService.getMetaList(Types.TAG.getType(), null, WebConst.MAX_POSTS);
        return new ResponseEntity(tags, HttpStatus.OK);
    }
}
