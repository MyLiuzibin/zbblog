package com.liuzibin.dao;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ArticleCommentsDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ArticleComments articleComments = new ArticleComments();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> commentId = articleComments.commentId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> articleId = articleComments.articleId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userId = articleComments.userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userName = articleComments.userName;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> commentLikeCount = articleComments.commentLikeCount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> commentContent = articleComments.commentContent;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> status = articleComments.status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> creator = articleComments.creator;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = articleComments.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> lastUpdator = articleComments.lastUpdator;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> lastUpdateTime = articleComments.lastUpdateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ArticleComments extends SqlTable {
        public final SqlColumn<String> commentId = column("comment_id", JDBCType.CHAR);

        public final SqlColumn<String> articleId = column("article_id", JDBCType.CHAR);

        public final SqlColumn<String> userId = column("user_id", JDBCType.CHAR);

        public final SqlColumn<String> userName = column("user_name", JDBCType.VARCHAR);

        public final SqlColumn<Long> commentLikeCount = column("comment_like_count", JDBCType.BIGINT);

        public final SqlColumn<String> commentContent = column("comment_content", JDBCType.VARCHAR);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public final SqlColumn<String> creator = column("creator", JDBCType.CHAR);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> lastUpdator = column("last_updator", JDBCType.CHAR);

        public final SqlColumn<Date> lastUpdateTime = column("last_update_time", JDBCType.TIMESTAMP);

        public ArticleComments() {
            super("t_article_comments");
        }
    }
}