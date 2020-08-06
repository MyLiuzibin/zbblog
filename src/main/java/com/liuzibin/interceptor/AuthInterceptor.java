package com.liuzibin.interceptor;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liuzibin.entity.Users;
import com.liuzibin.pojo.dto.BaseVo;
import com.liuzibin.service.UsersService;
import com.liuzibin.util.HttpContextUtil;
import com.liuzibin.util.Result;
import com.liuzibin.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author liuzibin
 * @date 2020/8/1
 */
public class AuthInterceptor implements HandlerInterceptor {
    @Autowired
    private UsersService usersService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        if (request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        Users userEntity=new Users();
        userEntity.setAccessToken(TokenUtil.getRequestToken(request));
        //如果token为空
        if (StringUtils.isEmpty(userEntity.getAccessToken())) {
            setReturn(response,"用户未登录，请先登录");
            return false;
        }
        //1. 根据token，查询用户信息
        userEntity = usersService.findByToken(userEntity);
        //2. 若用户不存在,
        if (userEntity == null) {
            setReturn(response,"用户不存在");
            return false;
        }
        //3. token失效
        if (userEntity.getExpireTime().before(new Date())) {
            setReturn(response,"用户登录凭证已失效，请重新登录");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }

    //返回错误信息
    private static void setReturn(HttpServletResponse response, String resultMessage) throws IOException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Allow-Origin", HttpContextUtil.getOrigin());

        //UTF-8编码
        BaseVo baseVo=new BaseVo();
        ObjectMapper mapper = new ObjectMapper();

        httpResponse.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");

        baseVo.markTokenErrorResultCode();
        baseVo.setResultMessage(resultMessage);
        response.getWriter().print(mapper.writeValueAsString(baseVo));
//        Result build = Result.build(status, resultMessage);
//        String json = JSON.toJSONString(build);
//        httpResponse.getWriter().print(json);
    }

}
