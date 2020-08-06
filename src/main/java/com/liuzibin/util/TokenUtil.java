package com.liuzibin.util;

import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author liuzibin
 * @date 2020/8/1
 */
public class TokenUtil {
    /**
     * 获取请求的token
     */

    public static String getRequestToken(HttpServletRequest httpRequest) {

        //从header中获取token
        String token = httpRequest.getHeader("token");
        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isEmpty(token)) {
            token = httpRequest.getParameter("token");
        }
        return token;
    }
}