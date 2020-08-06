package com.liuzibin.dao;

import static com.liuzibin.dao.ArticlesDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.liuzibin.entity.Articles;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface ArticlesMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(articleId, articleTitle, articleContent, articleViews, commentsNu, loveNu, collectNu, lable, status, creator, createTime, lastUpdator, lastUpdateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Articles> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Articles> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ArticlesResult")
    Optional<Articles> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ArticlesResult", value = {
        @Result(column="article_id", property="articleId", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="article_title", property="articleTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_content", property="articleContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="article_views", property="articleViews", jdbcType=JdbcType.BIGINT),
        @Result(column="comments_nu", property="commentsNu", jdbcType=JdbcType.BIGINT),
        @Result(column="love_nu", property="loveNu", jdbcType=JdbcType.BIGINT),
        @Result(column="collect_nu", property="collectNu", jdbcType=JdbcType.BIGINT),
        @Result(column="lable", property="lable", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="creator", property="creator", jdbcType=JdbcType.CHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_updator", property="lastUpdator", jdbcType=JdbcType.CHAR),
        @Result(column="last_update_time", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Articles> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, articles, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, articles, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(String articleId_) {
        return delete(c -> 
            c.where(articleId, isEqualTo(articleId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Articles record) {
        return MyBatis3Utils.insert(this::insert, record, articles, c ->
            c.map(articleId).toProperty("articleId")
            .map(articleTitle).toProperty("articleTitle")
            .map(articleContent).toProperty("articleContent")
            .map(articleViews).toProperty("articleViews")
            .map(commentsNu).toProperty("commentsNu")
            .map(loveNu).toProperty("loveNu")
            .map(collectNu).toProperty("collectNu")
            .map(lable).toProperty("lable")
            .map(status).toProperty("status")
            .map(creator).toProperty("creator")
            .map(createTime).toProperty("createTime")
            .map(lastUpdator).toProperty("lastUpdator")
            .map(lastUpdateTime).toProperty("lastUpdateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Articles> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, articles, c ->
            c.map(articleId).toProperty("articleId")
            .map(articleTitle).toProperty("articleTitle")
            .map(articleContent).toProperty("articleContent")
            .map(articleViews).toProperty("articleViews")
            .map(commentsNu).toProperty("commentsNu")
            .map(loveNu).toProperty("loveNu")
            .map(collectNu).toProperty("collectNu")
            .map(lable).toProperty("lable")
            .map(status).toProperty("status")
            .map(creator).toProperty("creator")
            .map(createTime).toProperty("createTime")
            .map(lastUpdator).toProperty("lastUpdator")
            .map(lastUpdateTime).toProperty("lastUpdateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Articles record) {
        return MyBatis3Utils.insert(this::insert, record, articles, c ->
            c.map(articleId).toPropertyWhenPresent("articleId", record::getArticleId)
            .map(articleTitle).toPropertyWhenPresent("articleTitle", record::getArticleTitle)
            .map(articleContent).toPropertyWhenPresent("articleContent", record::getArticleContent)
            .map(articleViews).toPropertyWhenPresent("articleViews", record::getArticleViews)
            .map(commentsNu).toPropertyWhenPresent("commentsNu", record::getCommentsNu)
            .map(loveNu).toPropertyWhenPresent("loveNu", record::getLoveNu)
            .map(collectNu).toPropertyWhenPresent("collectNu", record::getCollectNu)
            .map(lable).toPropertyWhenPresent("lable", record::getLable)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(creator).toPropertyWhenPresent("creator", record::getCreator)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(lastUpdator).toPropertyWhenPresent("lastUpdator", record::getLastUpdator)
            .map(lastUpdateTime).toPropertyWhenPresent("lastUpdateTime", record::getLastUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Articles> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, articles, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Articles> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, articles, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Articles> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, articles, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Articles> selectByPrimaryKey(String articleId_) {
        return selectOne(c ->
            c.where(articleId, isEqualTo(articleId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, articles, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Articles record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(articleId).equalTo(record::getArticleId)
                .set(articleTitle).equalTo(record::getArticleTitle)
                .set(articleContent).equalTo(record::getArticleContent)
                .set(articleViews).equalTo(record::getArticleViews)
                .set(commentsNu).equalTo(record::getCommentsNu)
                .set(loveNu).equalTo(record::getLoveNu)
                .set(collectNu).equalTo(record::getCollectNu)
                .set(lable).equalTo(record::getLable)
                .set(status).equalTo(record::getStatus)
                .set(creator).equalTo(record::getCreator)
                .set(createTime).equalTo(record::getCreateTime)
                .set(lastUpdator).equalTo(record::getLastUpdator)
                .set(lastUpdateTime).equalTo(record::getLastUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Articles record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(articleId).equalToWhenPresent(record::getArticleId)
                .set(articleTitle).equalToWhenPresent(record::getArticleTitle)
                .set(articleContent).equalToWhenPresent(record::getArticleContent)
                .set(articleViews).equalToWhenPresent(record::getArticleViews)
                .set(commentsNu).equalToWhenPresent(record::getCommentsNu)
                .set(loveNu).equalToWhenPresent(record::getLoveNu)
                .set(collectNu).equalToWhenPresent(record::getCollectNu)
                .set(lable).equalToWhenPresent(record::getLable)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(creator).equalToWhenPresent(record::getCreator)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(lastUpdator).equalToWhenPresent(record::getLastUpdator)
                .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Articles record) {
        return update(c ->
            c.set(articleTitle).equalTo(record::getArticleTitle)
            .set(articleContent).equalTo(record::getArticleContent)
            .set(articleViews).equalTo(record::getArticleViews)
            .set(commentsNu).equalTo(record::getCommentsNu)
            .set(loveNu).equalTo(record::getLoveNu)
            .set(collectNu).equalTo(record::getCollectNu)
            .set(lable).equalTo(record::getLable)
            .set(status).equalTo(record::getStatus)
            .set(creator).equalTo(record::getCreator)
            .set(createTime).equalTo(record::getCreateTime)
            .set(lastUpdator).equalTo(record::getLastUpdator)
            .set(lastUpdateTime).equalTo(record::getLastUpdateTime)
            .where(articleId, isEqualTo(record::getArticleId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Articles record) {
        return update(c ->
            c.set(articleTitle).equalToWhenPresent(record::getArticleTitle)
            .set(articleContent).equalToWhenPresent(record::getArticleContent)
            .set(articleViews).equalToWhenPresent(record::getArticleViews)
            .set(commentsNu).equalToWhenPresent(record::getCommentsNu)
            .set(loveNu).equalToWhenPresent(record::getLoveNu)
            .set(collectNu).equalToWhenPresent(record::getCollectNu)
            .set(lable).equalToWhenPresent(record::getLable)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(creator).equalToWhenPresent(record::getCreator)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(lastUpdator).equalToWhenPresent(record::getLastUpdator)
            .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime)
            .where(articleId, isEqualTo(record::getArticleId))
        );
    }
}