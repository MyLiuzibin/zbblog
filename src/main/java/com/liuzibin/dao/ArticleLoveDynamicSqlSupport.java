package com.liuzibin.dao;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ArticleLoveDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ArticleLove articleLove = new ArticleLove();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> loveId = articleLove.loveId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> articleId = articleLove.articleId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userId = articleLove.userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> status = articleLove.status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> creator = articleLove.creator;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = articleLove.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> lastUpdator = articleLove.lastUpdator;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> lastUpdateTime = articleLove.lastUpdateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ArticleLove extends SqlTable {
        public final SqlColumn<String> loveId = column("love_id", JDBCType.CHAR);

        public final SqlColumn<String> articleId = column("article_id", JDBCType.CHAR);

        public final SqlColumn<String> userId = column("user_id", JDBCType.CHAR);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public final SqlColumn<String> creator = column("creator", JDBCType.CHAR);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> lastUpdator = column("last_updator", JDBCType.CHAR);

        public final SqlColumn<Date> lastUpdateTime = column("last_update_time", JDBCType.TIMESTAMP);

        public ArticleLove() {
            super("t_article_love");
        }
    }
}