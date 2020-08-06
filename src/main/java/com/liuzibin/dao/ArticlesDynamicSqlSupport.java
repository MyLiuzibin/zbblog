package com.liuzibin.dao;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ArticlesDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final Articles articles = new Articles();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> articleId = articles.articleId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> articleTitle = articles.articleTitle;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> articleContent = articles.articleContent;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> articleViews = articles.articleViews;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> commentsNu = articles.commentsNu;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> loveNu = articles.loveNu;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> collectNu = articles.collectNu;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> lable = articles.lable;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> status = articles.status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> creator = articles.creator;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = articles.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> lastUpdator = articles.lastUpdator;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> lastUpdateTime = articles.lastUpdateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class Articles extends SqlTable {
        public final SqlColumn<String> articleId = column("article_id", JDBCType.CHAR);

        public final SqlColumn<String> articleTitle = column("article_title", JDBCType.VARCHAR);

        public final SqlColumn<String> articleContent = column("article_content", JDBCType.VARCHAR);

        public final SqlColumn<Long> articleViews = column("article_views", JDBCType.BIGINT);

        public final SqlColumn<Long> commentsNu = column("comments_nu", JDBCType.BIGINT);

        public final SqlColumn<Long> loveNu = column("love_nu", JDBCType.BIGINT);

        public final SqlColumn<Long> collectNu = column("collect_nu", JDBCType.BIGINT);

        public final SqlColumn<Integer> lable = column("lable", JDBCType.INTEGER);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public final SqlColumn<String> creator = column("creator", JDBCType.CHAR);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> lastUpdator = column("last_updator", JDBCType.CHAR);

        public final SqlColumn<Date> lastUpdateTime = column("last_update_time", JDBCType.TIMESTAMP);

        public Articles() {
            super("t_articles");
        }
    }
}