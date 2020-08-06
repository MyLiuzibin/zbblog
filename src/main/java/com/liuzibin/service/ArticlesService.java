package com.liuzibin.service;


import com.liuzibin.dao.ArticleContentMapper;
import com.liuzibin.dao.ArticlesDynamicSqlSupport;
import com.liuzibin.dao.ArticlesMapper;
import com.liuzibin.dao.UsersMapper;
import com.liuzibin.entity.ArticleContent;
import com.liuzibin.entity.Articles;
import com.liuzibin.entity.Users;
import com.liuzibin.pojo.ArticlesVo;
import com.liuzibin.pojo.dto.Pagination;
import com.liuzibin.util.CommonUtil;
import com.liuzibin.util.WebConstants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.liuzibin.dao.ArticlesDynamicSqlSupport.status;
import static org.mybatis.dynamic.sql.SqlBuilder.*;


/**
 * @author liuzibin
 * @date 2020/7/21
 */
@Service
public class ArticlesService {
    @Autowired
    private ArticlesMapper articlesMapper;
    @Autowired
    private ArticleContentMapper articleContentMapper;
    @Autowired
    private UsersMapper usersMapper;

    public Pagination listArticle(ArticlesVo theVo) {
        if (StringUtils.isEmpty(theVo.getStatus())) {
            theVo.setStatus(WebConstants.DATA_INSERT_STATUS);
        }

        List<Articles> dataList = articlesMapper.select(c ->
                c.where(status, isEqualTo(theVo.getStatus()))
                        .orderBy(ArticlesDynamicSqlSupport.createTime.descending())
                        .limit(theVo.getPageSize())
                        .offset(theVo.getPageSize() * (theVo.getPageNo() - 1)));

        long totalCount = articlesMapper.count(c -> c.where(status, isEqualTo(WebConstants.DATA_INSERT_STATUS)));
        Pagination resultPr = new Pagination();
        resultPr.setTotalCount(totalCount);
        resultPr.setPageNo(theVo.getPageNo());
        resultPr.setPageSize(theVo.getPageSize());
        resultPr.setList(dataList);//当需要更多辅助数据时，可以轮询并转化为voList进行数据补充
        resultPr.markSuccessResultCode();
        return resultPr;
    }


    public Pagination topArticle(ArticlesVo theVo) {
        if (StringUtils.isEmpty(theVo.getStatus())) {
            theVo.setStatus(WebConstants.DATA_INSERT_STATUS);
        }

        List<Articles> dataList = articlesMapper.select(c ->
                c.where(status, isEqualTo(theVo.getStatus()))
                        .orderBy(ArticlesDynamicSqlSupport.articleViews.descending())
                        .limit(theVo.getPageSize())
                        .offset(theVo.getPageSize() * (theVo.getPageNo() - 1)));


        Pagination resultPr = new Pagination();
        resultPr.setPageNo(theVo.getPageNo());
        resultPr.setPageSize(theVo.getPageSize());
        resultPr.setList(dataList);//当需要更多辅助数据时，可以轮询并转化为voList进行数据补充
        resultPr.markSuccessResultCode();
        return resultPr;
    }


    public ArticlesVo getById(ArticlesVo theVo) {
        if (StringUtils.isEmpty(theVo.getArticleId())) {
            theVo.markErrorResultCode();
            theVo.setResultMessage("必须属性不能为空");
            return theVo;
        }

        Optional<Articles> theArtT = articlesMapper.selectByPrimaryKey(theVo.getArticleId());
        Optional<ArticleContent> theConT = articleContentMapper.selectByPrimaryKey(theVo.getArticleId());

        BeanUtils.copyProperties(theArtT.get(), theVo);
        theVo.setContent(theConT.get().getContent());
        theVo.markSuccessResultCode();
        return theVo;
    }

    @Transactional
    public ArticlesVo insertArticle(ArticlesVo theVo) {
        try {
            Optional<Users> theUserT=usersMapper.selectByPrimaryKey(theVo.getUserId());
            if (theUserT.isPresent()){
                if (!WebConstants.USER_GROUP_ADMINISTRATOR.equals(theUserT.get().getUgroup())){
                    theVo.markErrorResultCode();
                    theVo.setResultMessage("没有权限");
                    return theVo;
                }
            }else {
                theVo.markErrorResultCode();
                theVo.setResultMessage("没有权限");
                return theVo;
            }

            Articles theArtT = new Articles();
            int sqlResult = -1;
            Date curDate = new Date();

            BeanUtils.copyProperties(theVo, theArtT, new String[]{"content"});
            theArtT.setArticleId(CommonUtil.buildUuid());
            theArtT.setCreateTime(curDate);
            theArtT.setLastUpdateTime(curDate);
            theArtT.setCreator(theArtT.getArticleId() == null ? null : (String) theArtT.getArticleId());
            theArtT.setLastUpdator(theArtT.getArticleId() == null ? null : (String) theArtT.getArticleId());
            theArtT.setStatus(WebConstants.DATA_INSERT_STATUS);
            sqlResult = articlesMapper.insertSelective(theArtT);
            if (sqlResult >= 0) {
                ArticleContent theConT = new ArticleContent();
                theConT.setContent(theVo.getContent());
                theConT.setCreateTime(curDate);
                theConT.setLastUpdateTime(curDate);
                theConT.setCreator(theVo.getCurOperator() == null ? null : (String) theVo.getCurOperator().get("id"));
                theConT.setLastUpdator(theVo.getCurOperator() == null ? null : (String) theVo.getCurOperator().get("id"));
                theConT.setStatus(WebConstants.DATA_INSERT_STATUS);
                theConT.setArticleId(theArtT.getArticleId());

                int contSqlResult = articleContentMapper.insertSelective(theConT);
                if (contSqlResult >= 0) {
                    theVo.markSuccessResultCode();
                }
            }
        } catch (Exception e) {
            theVo.markErrorResultCode();
            theVo.setResultMessage("保存失败!");
        }
        return theVo;
    }


}
