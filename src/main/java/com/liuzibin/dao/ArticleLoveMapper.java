package com.liuzibin.dao;

import static com.liuzibin.dao.ArticleLoveDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.liuzibin.entity.ArticleLove;
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
public interface ArticleLoveMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(loveId, articleId, userId, status, creator, createTime, lastUpdator, lastUpdateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ArticleLove> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ArticleLove> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ArticleLoveResult")
    Optional<ArticleLove> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ArticleLoveResult", value = {
        @Result(column="love_id", property="loveId", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="article_id", property="articleId", jdbcType=JdbcType.CHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.CHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="creator", property="creator", jdbcType=JdbcType.CHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_updator", property="lastUpdator", jdbcType=JdbcType.CHAR),
        @Result(column="last_update_time", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ArticleLove> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, articleLove, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, articleLove, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(String loveId_) {
        return delete(c -> 
            c.where(loveId, isEqualTo(loveId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(ArticleLove record) {
        return MyBatis3Utils.insert(this::insert, record, articleLove, c ->
            c.map(loveId).toProperty("loveId")
            .map(articleId).toProperty("articleId")
            .map(userId).toProperty("userId")
            .map(status).toProperty("status")
            .map(creator).toProperty("creator")
            .map(createTime).toProperty("createTime")
            .map(lastUpdator).toProperty("lastUpdator")
            .map(lastUpdateTime).toProperty("lastUpdateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<ArticleLove> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, articleLove, c ->
            c.map(loveId).toProperty("loveId")
            .map(articleId).toProperty("articleId")
            .map(userId).toProperty("userId")
            .map(status).toProperty("status")
            .map(creator).toProperty("creator")
            .map(createTime).toProperty("createTime")
            .map(lastUpdator).toProperty("lastUpdator")
            .map(lastUpdateTime).toProperty("lastUpdateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ArticleLove record) {
        return MyBatis3Utils.insert(this::insert, record, articleLove, c ->
            c.map(loveId).toPropertyWhenPresent("loveId", record::getLoveId)
            .map(articleId).toPropertyWhenPresent("articleId", record::getArticleId)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(creator).toPropertyWhenPresent("creator", record::getCreator)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(lastUpdator).toPropertyWhenPresent("lastUpdator", record::getLastUpdator)
            .map(lastUpdateTime).toPropertyWhenPresent("lastUpdateTime", record::getLastUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ArticleLove> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, articleLove, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ArticleLove> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, articleLove, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ArticleLove> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, articleLove, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ArticleLove> selectByPrimaryKey(String loveId_) {
        return selectOne(c ->
            c.where(loveId, isEqualTo(loveId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, articleLove, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(ArticleLove record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(loveId).equalTo(record::getLoveId)
                .set(articleId).equalTo(record::getArticleId)
                .set(userId).equalTo(record::getUserId)
                .set(status).equalTo(record::getStatus)
                .set(creator).equalTo(record::getCreator)
                .set(createTime).equalTo(record::getCreateTime)
                .set(lastUpdator).equalTo(record::getLastUpdator)
                .set(lastUpdateTime).equalTo(record::getLastUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ArticleLove record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(loveId).equalToWhenPresent(record::getLoveId)
                .set(articleId).equalToWhenPresent(record::getArticleId)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(creator).equalToWhenPresent(record::getCreator)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(lastUpdator).equalToWhenPresent(record::getLastUpdator)
                .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(ArticleLove record) {
        return update(c ->
            c.set(articleId).equalTo(record::getArticleId)
            .set(userId).equalTo(record::getUserId)
            .set(status).equalTo(record::getStatus)
            .set(creator).equalTo(record::getCreator)
            .set(createTime).equalTo(record::getCreateTime)
            .set(lastUpdator).equalTo(record::getLastUpdator)
            .set(lastUpdateTime).equalTo(record::getLastUpdateTime)
            .where(loveId, isEqualTo(record::getLoveId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(ArticleLove record) {
        return update(c ->
            c.set(articleId).equalToWhenPresent(record::getArticleId)
            .set(userId).equalToWhenPresent(record::getUserId)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(creator).equalToWhenPresent(record::getCreator)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(lastUpdator).equalToWhenPresent(record::getLastUpdator)
            .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime)
            .where(loveId, isEqualTo(record::getLoveId))
        );
    }
}