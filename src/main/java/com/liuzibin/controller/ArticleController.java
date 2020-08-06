package com.liuzibin.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.liuzibin.pojo.ArticlesVo;
import com.liuzibin.pojo.dto.Pagination;

import com.liuzibin.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * @author liuzibin
 * @date 2020/7/21
 */

@RestController
@RequestMapping(value = "/api/port/v01")
public class ArticleController {
    @Autowired
    private ArticlesService articlesService;

    @RequestMapping(value = "/ArticleList", method = RequestMethod.POST)
    public ResponseEntity<Pagination> listArticle(@RequestBody String body, HttpServletRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        Pagination page = null;
        ArticlesVo theVo = new ArticlesVo();
        try {
            String decodeStr = URLDecoder.decode(body, "UTF-8");
            theVo = mapper.readValue(decodeStr, ArticlesVo.class);
            page = articlesService.listArticle(theVo);
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

    @RequestMapping(value = "/ArticleTop", method = RequestMethod.POST)
    public ResponseEntity<Pagination> topArticle(@RequestBody String body, HttpServletRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        Pagination page = null;
        ArticlesVo theVo = new ArticlesVo();
        try {
            String decodeStr = URLDecoder.decode(body, "UTF-8");
            theVo = mapper.readValue(decodeStr, ArticlesVo.class);
            page = articlesService.topArticle(theVo);
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

    @RequestMapping(value = "/ArticleInfo", method = RequestMethod.POST)
    public ResponseEntity<ArticlesVo> getArticleInfo(@RequestBody String body,
                                                     HttpServletRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        ArticlesVo theVo = new ArticlesVo();
        try {
            String decodeStr = URLDecoder.decode(body, "UTF-8");
            theVo = mapper.readValue(decodeStr, ArticlesVo.class);
            theVo = articlesService.getById(theVo);
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
        return new ResponseEntity<ArticlesVo>(theVo, HttpStatus.OK);
    }

    @RequestMapping(value = "/insertArticle.do", method = RequestMethod.POST)
    public ResponseEntity<ArticlesVo> insertArticle(@RequestBody String body, HttpServletRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        ArticlesVo theVo = new ArticlesVo();
        try {
            String decodeStr = URLDecoder.decode(body, "UTF-8");
            theVo = mapper.readValue(decodeStr, ArticlesVo.class);
            theVo = articlesService.insertArticle(theVo);
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
        return new ResponseEntity<ArticlesVo>(theVo, HttpStatus.OK);
    }

}
