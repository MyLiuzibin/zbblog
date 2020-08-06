package com.liuzibin.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.liuzibin.pojo.UsersVo;
import com.liuzibin.pojo.dto.Pagination;
import com.liuzibin.service.UsersService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URLDecoder;

/**
 * @author liuzibin
 * @date 2020/7/13
 */

@RestController
@RequestMapping(value = "/api/port/v01")
public class UsersController {

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/usersList", method = RequestMethod.POST)
    public ResponseEntity<Pagination> listUsers(@RequestBody String body, HttpServletRequest request){
        ObjectMapper mapper = new ObjectMapper();
        Pagination page=null;
        UsersVo theVo = new UsersVo();
        try {
            String decodeStr = URLDecoder.decode(body, "UTF-8");
            theVo = mapper.readValue(decodeStr, UsersVo.class);
            page = usersService.listUser(theVo);
        }catch (JsonMappingException e){
            page=new Pagination();
            page.markErrorResultCode();
            page.setResultMessage("参数解析错误");
        }catch (IOException e) {
            page = new Pagination();
            page.markErrorResultCode();
            page.setResultMessage("参数错误!");
        } catch (Exception e) {
            page = new Pagination();
            page.markErrorResultCode();
            page.setResultMessage(e.getMessage());
        }
        return new ResponseEntity<Pagination>(page,HttpStatus.OK);
    }

    @RequestMapping(value = "/loginUsers", method = RequestMethod.POST)
    public ResponseEntity<UsersVo> getUsersInfo(@RequestBody String body,
                                                                  HttpServletRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        UsersVo theVo = new UsersVo();
        try {
            String decodeStr = URLDecoder.decode(body, "UTF-8");
            theVo = mapper.readValue(decodeStr, UsersVo.class);
            theVo = usersService.login(theVo);
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
        return new ResponseEntity<UsersVo>(theVo, HttpStatus.OK);
    }

    @RequestMapping(value = "/registerUsers", method = RequestMethod.POST)
    public ResponseEntity<UsersVo> insertUsers(@RequestBody String body,
                                                HttpServletRequest request) {
        ObjectMapper mapper = new ObjectMapper();
        UsersVo theVo = new UsersVo();
        try {
            String decodeStr = URLDecoder.decode(body, "UTF-8");
            theVo = mapper.readValue(decodeStr, UsersVo.class);
            theVo = usersService.register(theVo);
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
        return new ResponseEntity<UsersVo>(theVo, HttpStatus.OK);
    }

}
