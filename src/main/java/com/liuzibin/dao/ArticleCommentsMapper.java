package com.liuzibin.dao;

import static com.liuzibin.dao.ArticleCommentsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.liuzibin.entity.ArticleComments;
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
public interface ArticleCommentsMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(commentId, articleId, userId, userName, commentLikeCount, commentContent, status, creator, createTime, lastUpdator, lastUpdateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<ArticleComments> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<ArticleComments> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ArticleCommentsResult")
    Optional<ArticleComments> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ArticleCommentsResult", value = {
        @Result(column="comment_id", property="commentId", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="article_id", property="articleId", jdbcType=JdbcType.CHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.CHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="comment_like_count", property="commentLikeCount", jdbcType=JdbcType.BIGINT),
        @Result(column="comment_content", property="commentContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="creator", property="creator", jdbcType=JdbcType.CHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_updator", property="lastUpdator", jdbcType=JdbcType.CHAR),
        @Result(column="last_update_time", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ArticleComments> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, articleComments, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, articleComments, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(String commentId_) {
        return delete(c -> 
            c.where(commentId, isEqualTo(commentId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(ArticleComments record) {
        return MyBatis3Utils.insert(this::insert, record, articleComments, c ->
            c.map(commentId).toProperty("commentId")
            .map(articleId).toProperty("articleId")
            .map(userId).toProperty("userId")
            .map(userName).toProperty("userName")
            .map(commentLikeCount).toProperty("commentLikeCount")
            .map(commentContent).toProperty("commentContent")
            .map(status).toProperty("status")
            .map(creator).toProperty("creator")
            .map(createTime).toProperty("createTime")
            .map(lastUpdator).toProperty("lastUpdator")
            .map(lastUpdateTime).toProperty("lastUpdateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<ArticleComments> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, articleComments, c ->
            c.map(commentId).toProperty("commentId")
            .map(articleId).toProperty("articleId")
            .map(userId).toProperty("userId")
            .map(userName).toProperty("userName")
            .map(commentLikeCount).toProperty("commentLikeCount")
            .map(commentContent).toProperty("commentContent")
            .map(status).toProperty("status")
            .map(creator).toProperty("creator")
            .map(createTime).toProperty("createTime")
            .map(lastUpdator).toProperty("lastUpdator")
            .map(lastUpdateTime).toProperty("lastUpdateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(ArticleComments record) {
        return MyBatis3Utils.insert(this::insert, record, articleComments, c ->
            c.map(commentId).toPropertyWhenPresent("commentId", record::getCommentId)
            .map(articleId).toPropertyWhenPresent("articleId", record::getArticleId)
            .map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(userName).toPropertyWhenPresent("userName", record::getUserName)
            .map(commentLikeCount).toPropertyWhenPresent("commentLikeCount", record::getCommentLikeCount)
            .map(commentContent).toPropertyWhenPresent("commentContent", record::getCommentContent)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(creator).toPropertyWhenPresent("creator", record::getCreator)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(lastUpdator).toPropertyWhenPresent("lastUpdator", record::getLastUpdator)
            .map(lastUpdateTime).toPropertyWhenPresent("lastUpdateTime", record::getLastUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ArticleComments> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, articleComments, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ArticleComments> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, articleComments, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<ArticleComments> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, articleComments, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<ArticleComments> selectByPrimaryKey(String commentId_) {
        return selectOne(c ->
            c.where(commentId, isEqualTo(commentId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, articleComments, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(ArticleComments record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(commentId).equalTo(record::getCommentId)
                .set(articleId).equalTo(record::getArticleId)
                .set(userId).equalTo(record::getUserId)
                .set(userName).equalTo(record::getUserName)
                .set(commentLikeCount).equalTo(record::getCommentLikeCount)
                .set(commentContent).equalTo(record::getCommentContent)
                .set(status).equalTo(record::getStatus)
                .set(creator).equalTo(record::getCreator)
                .set(createTime).equalTo(record::getCreateTime)
                .set(lastUpdator).equalTo(record::getLastUpdator)
                .set(lastUpdateTime).equalTo(record::getLastUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(ArticleComments record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(commentId).equalToWhenPresent(record::getCommentId)
                .set(articleId).equalToWhenPresent(record::getArticleId)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(userName).equalToWhenPresent(record::getUserName)
                .set(commentLikeCount).equalToWhenPresent(record::getCommentLikeCount)
                .set(commentContent).equalToWhenPresent(record::getCommentContent)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(creator).equalToWhenPresent(record::getCreator)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(lastUpdator).equalToWhenPresent(record::getLastUpdator)
                .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(ArticleComments record) {
        return update(c ->
            c.set(articleId).equalTo(record::getArticleId)
            .set(userId).equalTo(record::getUserId)
            .set(userName).equalTo(record::getUserName)
            .set(commentLikeCount).equalTo(record::getCommentLikeCount)
            .set(commentContent).equalTo(record::getCommentContent)
            .set(status).equalTo(record::getStatus)
            .set(creator).equalTo(record::getCreator)
            .set(createTime).equalTo(record::getCreateTime)
            .set(lastUpdator).equalTo(record::getLastUpdator)
            .set(lastUpdateTime).equalTo(record::getLastUpdateTime)
            .where(commentId, isEqualTo(record::getCommentId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(ArticleComments record) {
        return update(c ->
            c.set(articleId).equalToWhenPresent(record::getArticleId)
            .set(userId).equalToWhenPresent(record::getUserId)
            .set(userName).equalToWhenPresent(record::getUserName)
            .set(commentLikeCount).equalToWhenPresent(record::getCommentLikeCount)
            .set(commentContent).equalToWhenPresent(record::getCommentContent)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(creator).equalToWhenPresent(record::getCreator)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(lastUpdator).equalToWhenPresent(record::getLastUpdator)
            .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime)
            .where(commentId, isEqualTo(record::getCommentId))
        );
    }
}