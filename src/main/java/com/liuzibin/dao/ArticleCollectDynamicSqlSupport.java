package com.liuzibin.dao;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ArticleCollectDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final ArticleCollect articleCollect = new ArticleCollect();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> collectId = articleCollect.collectId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> articleId = articleCollect.articleId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> userId = articleCollect.userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> status = articleCollect.status;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> creator = articleCollect.creator;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = articleCollect.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> lastUpdator = articleCollect.lastUpdator;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> lastUpdateTime = articleCollect.lastUpdateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class ArticleCollect extends SqlTable {
        public final SqlColumn<String> collectId = column("collect_id", JDBCType.CHAR);

        public final SqlColumn<String> articleId = column("article_id", JDBCType.CHAR);

        public final SqlColumn<String> userId = column("user_id", JDBCType.CHAR);

        public final SqlColumn<Integer> status = column("status", JDBCType.INTEGER);

        public final SqlColumn<String> creator = column("creator", JDBCType.CHAR);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<String> lastUpdator = column("last_updator", JDBCType.CHAR);

        public final SqlColumn<Date> lastUpdateTime = column("last_update_time", JDBCType.TIMESTAMP);

        public ArticleCollect() {
            super("t_article_collect");
        }
    }
}