package com.liuzibin.service;

import com.liuzibin.dao.*;
import com.liuzibin.entity.*;
import com.liuzibin.pojo.ArticleCollectVo;
import com.liuzibin.pojo.ArticleCommentsVo;
import com.liuzibin.pojo.ArticleLoveVo;
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

import static com.liuzibin.dao.ArticlesDynamicSqlSupport.articleId;
import static com.liuzibin.dao.ArticlesDynamicSqlSupport.status;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

/**
 * @author liuzibin
 * @date 2020/8/3
 */
@Service
public class ArticleOperatingService {
    @Autowired
    private ArticleCommentsMapper articleCommentsMapper;
    @Autowired
    private ArticleLoveMapper articleLoveMapper;
    @Autowired
    private ArticleCollectMapper articleCollectMapper;

    public Pagination commentsList(ArticleCommentsVo theVo) {
        if (StringUtils.isEmpty(theVo.getStatus())) {
            theVo.setStatus(WebConstants.DATA_INSERT_STATUS);
        }

        List<ArticleComments> dataList = articleCommentsMapper.select(c ->
                c.where(status, isEqualTo(theVo.getStatus()))
                        .and(articleId, isEqualTo(theVo.getArticleId()))
                        .orderBy(ArticleCommentsDynamicSqlSupport.commentLikeCount)
                        .limit(theVo.getPageSize())
                        .offset(theVo.getPageSize() * (theVo.getPageNo() - 1)));

        long totalCount = articleCommentsMapper.count(c -> c.where(status, isEqualTo(WebConstants.DATA_INSERT_STATUS)).and(articleId, isEqualTo(theVo.getArticleId())));
        Pagination resultPr = new Pagination();
        resultPr.setTotalCount(totalCount);
        resultPr.setPageNo(theVo.getPageNo());
        resultPr.setPageSize(theVo.getPageSize());
        resultPr.setList(dataList);//当需要更多辅助数据时，可以轮询并转化为voList进行数据补充
        resultPr.markSuccessResultCode();
        return resultPr;
    }



    @Transactional
    public ArticleCommentsVo insertComments(ArticleCommentsVo theVo) {
        try {
            ArticleComments theArtT = new ArticleComments();
            int sqlResult = -1;
            Date curDate = new Date();

            BeanUtils.copyProperties(theVo, theArtT);
            theArtT.setCommentId(CommonUtil.buildUuid());

            theArtT.setCreateTime(curDate);
            theArtT.setLastUpdateTime(curDate);
            theArtT.setCreator(theArtT.getUserId() == null ? null : (String) theArtT.getUserId());
            theArtT.setLastUpdator(theArtT.getUserId() == null ? null : (String) theArtT.getUserId());
            theArtT.setStatus(WebConstants.DATA_INSERT_STATUS);

            sqlResult = articleCommentsMapper.insertSelective(theArtT);
            if (sqlResult <= 0) {
                theVo.markErrorResultCode();
                theVo.setResultMessage("发表评论失败!");
            }

            BeanUtils.copyProperties(theArtT,theVo);
            theVo.markSuccessResultCode();
        } catch (Exception e) {
            theVo.markErrorResultCode();
            theVo.setResultMessage("保存失败!");
        }
        return theVo;
    }



    @Transactional
    public ArticleLoveVo artLike(ArticleLoveVo theVo) {
        try {
            ArticleLove theLoveT = new ArticleLove();
            int sqlResult = -1;
            Date curDate = new Date();

            BeanUtils.copyProperties(theVo, theLoveT);
            theLoveT.setLoveId(CommonUtil.buildUuid());

            theLoveT.setCreateTime(curDate);
            theLoveT.setLastUpdateTime(curDate);
            theLoveT.setCreator(theVo.getUserId() == null ? null : (String) theVo.getUserId());
            theLoveT.setLastUpdator(theVo.getUserId() == null ? null : (String) theVo.getUserId());
            theLoveT.setStatus(WebConstants.DATA_INSERT_STATUS);

            sqlResult = articleLoveMapper.insertSelective(theLoveT);
            if (sqlResult <= 0) {
                theVo.markErrorResultCode();
                theVo.setResultMessage("发表评论失败!");
            }

            BeanUtils.copyProperties(theLoveT,theVo);
            theVo.markSuccessResultCode();
        } catch (Exception e) {
            theVo.markErrorResultCode();
            theVo.setResultMessage("保存失败!");
        }
        return theVo;
    }

    @Transactional
    public ArticleCollectVo artCollect(ArticleCollectVo theVo) {
        try {
            ArticleCollect theLoveT = new ArticleCollect();
            int sqlResult = -1;
            Date curDate = new Date();

            BeanUtils.copyProperties(theVo, theLoveT);
            theLoveT.setCollectId(CommonUtil.buildUuid());

            theLoveT.setCreateTime(curDate);
            theLoveT.setLastUpdateTime(curDate);
            theLoveT.setCreator(theVo.getUserId() == null ? null : (String) theVo.getUserId());
            theLoveT.setLastUpdator(theVo.getUserId() == null ? null : (String) theVo.getUserId());
            theLoveT.setStatus(WebConstants.DATA_INSERT_STATUS);

            sqlResult = articleCollectMapper.insertSelective(theLoveT);
            if (sqlResult <= 0) {
                theVo.markErrorResultCode();
                theVo.setResultMessage("发表评论失败!");
            }

            BeanUtils.copyProperties(theLoveT,theVo);
            theVo.markSuccessResultCode();
        } catch (Exception e) {
            theVo.markErrorResultCode();
            theVo.setResultMessage("保存失败!");
        }
        return theVo;
    }
}
