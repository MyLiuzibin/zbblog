package com.liuzibin.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liuzibin.entity.ArticleComments;
import com.liuzibin.pojo.*;
import com.liuzibin.pojo.ArticleCommentsVo;
import com.liuzibin.pojo.ArticleCommentsVo;
import com.liuzibin.pojo.dto.Pagination;
import com.liuzibin.service.ArticleOperatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * @author liuzibin
 * @date 2020/8/3
 */

@RestController
@RequestMapping(value = "/api/port/v01")
public class ArticleOperatingController {
    @Autowired
    private ArticleOperatingService articleOperatingService;

    @RequestMapping(value = "/commentsList", method = RequestMethod.POST)
    public ResponseEntity<Pagination> listArticle(@RequestBody String body, HttpServletRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        Pagination page = null;
        ArticleCommentsVo theVo = new ArticleCommentsVo();
        try {
            String decodeStr = URLDecoder.decode(body, "UTF-8");
            theVo = mapper.readValue(decodeStr, ArticleCommentsVo.class);
            page = articleOperatingService.commentsList(theVo);
        } catch (JsonMappingException e) {
            page = new Pagination();
            page.markErrorResultCode();
            page.setResultMessage("参数解析错误");
        } catch (IOException e) {
            page = new Pagination();
            page.markErrorResultCode();
            page.setResultMessage("参数错误!");
        } catch (Exception e) {
            page = new Pagination();
            page.markErrorResultCode();
            page.setResultMessage(e.getMessage());
        }
        return new ResponseEntity<Pagination>(page, HttpStatus.OK);
    }

    @RequestMapping(value = "/insertComments.do", method = RequestMethod.POST)
    public ResponseEntity<ArticleCommentsVo> insertComments(@RequestBody String body, HttpServletRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        ArticleCommentsVo theVo = new ArticleCommentsVo();
        try {
            String decodeStr = URLDecoder.decode(body, "UTF-8");
            theVo = mapper.readValue(decodeStr, ArticleCommentsVo.class);
            theVo = articleOperatingService.insertComments(theVo);
        } catch (JsonMappingException e) {
            theVo.markErrorResultCode();
            theVo.setResultMessage("参数解析错误!");
        } catch (IOException e) {
            theVo.markErrorResultCode();
            theVo.setResultMessage("参数错误!");
        } catch (Exception e) {
            theVo.markErrorResultCode();
            theVo.setResultMessage(e.getMessage());
        }
        return new ResponseEntity<ArticleCommentsVo>(theVo, HttpStatus.OK);
    }

    @RequestMapping(value = "/ArtLike.do", method = RequestMethod.POST)
    public ResponseEntity<ArticleLoveVo> artLike(@RequestBody String body, HttpServletRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        ArticleLoveVo theVo = new ArticleLoveVo();
        try {
            String decodeStr = URLDecoder.decode(body, "UTF-8");
            theVo = mapper.readValue(decodeStr, ArticleLoveVo.class);
            theVo = articleOperatingService.artLike(theVo);
        } catch (JsonMappingException e) {
            theVo.markErrorResultCode();
            theVo.setResultMessage("参数解析错误!");
        } catch (IOException e) {
            theVo.markErrorResultCode();
            theVo.setResultMessage("参数错误!");
        } catch (Exception e) {
            theVo.markErrorResultCode();
            theVo.setResultMessage(e.getMessage());
        }
        return new ResponseEntity<ArticleLoveVo>(theVo, HttpStatus.OK);
    }

    @RequestMapping(value = "/ArtCollect.do", method = RequestMethod.POST)
    public ResponseEntity<ArticleCollectVo> artCollect(@RequestBody String body, HttpServletRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        ArticleCollectVo theVo = new ArticleCollectVo();
        try {
            String decodeStr = URLDecoder.decode(body, "UTF-8");
            theVo = mapper.readValue(decodeStr, ArticleCollectVo.class);
            theVo = articleOperatingService.artCollect(theVo);
        } catch (JsonMappingException e) {
            theVo.markErrorResultCode();
            theVo.setResultMessage("参数解析错误!");
        } catch (IOException e) {
            theVo.markErrorResultCode();
            theVo.setResultMessage("参数错误!");
        } catch (Exception e) {
            theVo.markErrorResultCode();
            theVo.setResultMessage(e.getMessage());
        }
        return new ResponseEntity<ArticleCollectVo>(theVo, HttpStatus.OK);
    }
}
