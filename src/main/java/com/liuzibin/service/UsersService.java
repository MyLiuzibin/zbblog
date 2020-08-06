package com.liuzibin.service;

import com.liuzibin.dao.UsersMapper;
import com.liuzibin.entity.Users;
import com.liuzibin.pojo.UsersVo;
import com.liuzibin.pojo.dto.Pagination;
import com.liuzibin.util.CommonUtil;
import com.liuzibin.util.WebConstants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.liuzibin.dao.UsersDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;



/**
 * @author liuzibin
 * @date 2020/7/13
 */
@Service
public class UsersService {

    @Autowired
    private UsersMapper usersMapper;

    public Pagination listUser(UsersVo theVo){




        return null;
    }

    /**
     * 用户登录
     *
     * @return
     */
    @Transactional
    public UsersVo login(UsersVo theVo){
        if (StringUtils.isEmpty(theVo.getEmail()) || StringUtils.isEmpty(theVo.getPassword())){
            theVo.markErrorResultCode();
            theVo.setResultMessage("邮箱密码不能为空");
            return theVo;
        }
        Optional<Users> theT=usersMapper.selectOne(c->
                c.where(email,isEqualTo(theVo.getEmail()))
                .and(password, isEqualTo(theVo.getPassword()))
                .and(status, isEqualTo(WebConstants.DATA_INSERT_STATUS)));

        if (!theT.isPresent()){
            theVo.markErrorResultCode();
            theVo.setResultMessage("账号密码错误");
            return theVo;
        }

        Date curDate = new Date();
        theT.get().setLoginTime(curDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(curDate);
        calendar.add(Calendar.HOUR_OF_DAY, +12);
        curDate = calendar.getTime();
        theT.get().setExpireTime(curDate);

        int sqlup=usersMapper.updateByPrimaryKeySelective(theT.get());

        if (sqlup<=0){
            theVo.markErrorResultCode();
            theVo.setResultMessage("登录失败！");
        }
        BeanUtils.copyProperties(theT.get(), theVo);
        theVo.markSuccessResultCode();
        return theVo;
    }

    @Transactional
    public UsersVo register(UsersVo theVo){
        if (theVo.getUserName()==null|| theVo.getPassword()==null ||theVo.getEmail()==null){
            theVo.markErrorResultCode();
            theVo.setResultMessage("必须条件未填写");
            return theVo;
        }

        Users theUserT = new Users();
        int sqlResult = -1;
        Date curDate = new Date();
        BeanUtils.copyProperties(theVo, theUserT);
        theUserT.setUserId(CommonUtil.buildUuid());
        theUserT.setAccessToken(CommonUtil.buildUuid());
        theUserT.setUgroup(WebConstants.USER_GROUP_ORDINARY);
        theUserT.setCreateTime(curDate);
        theUserT.setLastUpdateTime(curDate);
        theUserT.setLoginTime(curDate);
        theUserT.setCreator(theUserT.getUserId() == null ? null : (String) theUserT.getUserId());
        theUserT.setLastUpdator(theUserT.getUserId() == null ? null : (String) theUserT.getUserId());
        theUserT.setStatus(WebConstants.DATA_INSERT_STATUS);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(curDate);
        calendar.add(Calendar.HOUR_OF_DAY, +12);
        curDate = calendar.getTime();
        theUserT.setExpireTime(curDate);

        sqlResult=usersMapper.insertSelective(theUserT);
        if (sqlResult<=0){
            theVo.markErrorResultCode();
            theVo.setResultMessage("注册失败");
            return theVo;
        }
        BeanUtils.copyProperties(theUserT,theVo);
        theVo.markSuccessResultCode();
        return theVo;
    }

    /**    检查用户的Token
     *
     * @param theVo
     * @return
     */
    public Users findByToken(Users theVo){
        List<Users> theT=usersMapper.select(c->
                c.where(accessToken,isEqualTo(theVo.getAccessToken())));

        BeanUtils.copyProperties(theT.get(0), theVo);
        return theVo;
    }

}
