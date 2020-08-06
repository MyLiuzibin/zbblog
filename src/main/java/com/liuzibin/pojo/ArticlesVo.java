package com.liuzibin.pojo;

import com.liuzibin.pojo.dto.BaseVo;
import lombok.Data;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.Date;

@Data
public class ArticlesVo extends BaseVo implements Serializable {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String articleId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String articleTitle;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String articleContent;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long articleViews;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long commentsNu;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long loveNu;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long collectNu;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer lable;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String creator;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String lastUpdator;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date lastUpdateTime;

//    文章内容
    private String Content;
//
    private String userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private static final long serialVersionUID = 1L;

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ArticlesVo other = (ArticlesVo) that;
        return (this.getArticleId() == null ? other.getArticleId() == null : this.getArticleId().equals(other.getArticleId()))
            && (this.getArticleTitle() == null ? other.getArticleTitle() == null : this.getArticleTitle().equals(other.getArticleTitle()))
            && (this.getArticleContent() == null ? other.getArticleContent() == null : this.getArticleContent().equals(other.getArticleContent()))
            && (this.getArticleViews() == null ? other.getArticleViews() == null : this.getArticleViews().equals(other.getArticleViews()))
            && (this.getCommentsNu() == null ? other.getCommentsNu() == null : this.getCommentsNu().equals(other.getCommentsNu()))
            && (this.getLoveNu() == null ? other.getLoveNu() == null : this.getLoveNu().equals(other.getLoveNu()))
            && (this.getCollectNu() == null ? other.getCollectNu() == null : this.getCollectNu().equals(other.getCollectNu()))
            && (this.getLable() == null ? other.getLable() == null : this.getLable().equals(other.getLable()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastUpdator() == null ? other.getLastUpdator() == null : this.getLastUpdator().equals(other.getLastUpdator()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()));
    }

    @Override
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getArticleId() == null) ? 0 : getArticleId().hashCode());
        result = prime * result + ((getArticleTitle() == null) ? 0 : getArticleTitle().hashCode());
        result = prime * result + ((getArticleContent() == null) ? 0 : getArticleContent().hashCode());
        result = prime * result + ((getArticleViews() == null) ? 0 : getArticleViews().hashCode());
        result = prime * result + ((getCommentsNu() == null) ? 0 : getCommentsNu().hashCode());
        result = prime * result + ((getLoveNu() == null) ? 0 : getLoveNu().hashCode());
        result = prime * result + ((getCollectNu() == null) ? 0 : getCollectNu().hashCode());
        result = prime * result + ((getLable() == null) ? 0 : getLable().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastUpdator() == null) ? 0 : getLastUpdator().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        return result;
    }
}