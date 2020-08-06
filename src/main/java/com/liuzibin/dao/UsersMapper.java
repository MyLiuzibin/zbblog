package com.liuzibin.dao;

import static com.liuzibin.dao.UsersDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.liuzibin.entity.Users;
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
public interface UsersMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    BasicColumn[] selectList = BasicColumn.columnList(userId, userName, password, email, ugroup, accessToken, expireTime, loginTime, status, creator, createTime, lastUpdator, lastUpdateTime);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Users> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Users> multipleInsertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UsersResult")
    Optional<Users> selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UsersResult", value = {
        @Result(column="user_id", property="userId", jdbcType=JdbcType.CHAR, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="ugroup", property="ugroup", jdbcType=JdbcType.VARCHAR),
        @Result(column="access_token", property="accessToken", jdbcType=JdbcType.VARCHAR),
        @Result(column="expire_time", property="expireTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="login_time", property="loginTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="creator", property="creator", jdbcType=JdbcType.CHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_updator", property="lastUpdator", jdbcType=JdbcType.CHAR),
        @Result(column="last_update_time", property="lastUpdateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Users> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, users, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, users, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(String userId_) {
        return delete(c -> 
            c.where(userId, isEqualTo(userId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Users record) {
        return MyBatis3Utils.insert(this::insert, record, users, c ->
            c.map(userId).toProperty("userId")
            .map(userName).toProperty("userName")
            .map(password).toProperty("password")
            .map(email).toProperty("email")
            .map(ugroup).toProperty("ugroup")
            .map(accessToken).toProperty("accessToken")
            .map(expireTime).toProperty("expireTime")
            .map(loginTime).toProperty("loginTime")
            .map(status).toProperty("status")
            .map(creator).toProperty("creator")
            .map(createTime).toProperty("createTime")
            .map(lastUpdator).toProperty("lastUpdator")
            .map(lastUpdateTime).toProperty("lastUpdateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertMultiple(Collection<Users> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, users, c ->
            c.map(userId).toProperty("userId")
            .map(userName).toProperty("userName")
            .map(password).toProperty("password")
            .map(email).toProperty("email")
            .map(ugroup).toProperty("ugroup")
            .map(accessToken).toProperty("accessToken")
            .map(expireTime).toProperty("expireTime")
            .map(loginTime).toProperty("loginTime")
            .map(status).toProperty("status")
            .map(creator).toProperty("creator")
            .map(createTime).toProperty("createTime")
            .map(lastUpdator).toProperty("lastUpdator")
            .map(lastUpdateTime).toProperty("lastUpdateTime")
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Users record) {
        return MyBatis3Utils.insert(this::insert, record, users, c ->
            c.map(userId).toPropertyWhenPresent("userId", record::getUserId)
            .map(userName).toPropertyWhenPresent("userName", record::getUserName)
            .map(password).toPropertyWhenPresent("password", record::getPassword)
            .map(email).toPropertyWhenPresent("email", record::getEmail)
            .map(ugroup).toPropertyWhenPresent("ugroup", record::getUgroup)
            .map(accessToken).toPropertyWhenPresent("accessToken", record::getAccessToken)
            .map(expireTime).toPropertyWhenPresent("expireTime", record::getExpireTime)
            .map(loginTime).toPropertyWhenPresent("loginTime", record::getLoginTime)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(creator).toPropertyWhenPresent("creator", record::getCreator)
            .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
            .map(lastUpdator).toPropertyWhenPresent("lastUpdator", record::getLastUpdator)
            .map(lastUpdateTime).toPropertyWhenPresent("lastUpdateTime", record::getLastUpdateTime)
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Users> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, users, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Users> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, users, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default List<Users> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, users, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Optional<Users> selectByPrimaryKey(String userId_) {
        return selectOne(c ->
            c.where(userId, isEqualTo(userId_))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, users, completer);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateAllColumns(Users record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalTo(record::getUserId)
                .set(userName).equalTo(record::getUserName)
                .set(password).equalTo(record::getPassword)
                .set(email).equalTo(record::getEmail)
                .set(ugroup).equalTo(record::getUgroup)
                .set(accessToken).equalTo(record::getAccessToken)
                .set(expireTime).equalTo(record::getExpireTime)
                .set(loginTime).equalTo(record::getLoginTime)
                .set(status).equalTo(record::getStatus)
                .set(creator).equalTo(record::getCreator)
                .set(createTime).equalTo(record::getCreateTime)
                .set(lastUpdator).equalTo(record::getLastUpdator)
                .set(lastUpdateTime).equalTo(record::getLastUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Users record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(userId).equalToWhenPresent(record::getUserId)
                .set(userName).equalToWhenPresent(record::getUserName)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(ugroup).equalToWhenPresent(record::getUgroup)
                .set(accessToken).equalToWhenPresent(record::getAccessToken)
                .set(expireTime).equalToWhenPresent(record::getExpireTime)
                .set(loginTime).equalToWhenPresent(record::getLoginTime)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(creator).equalToWhenPresent(record::getCreator)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(lastUpdator).equalToWhenPresent(record::getLastUpdator)
                .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Users record) {
        return update(c ->
            c.set(userName).equalTo(record::getUserName)
            .set(password).equalTo(record::getPassword)
            .set(email).equalTo(record::getEmail)
            .set(ugroup).equalTo(record::getUgroup)
            .set(accessToken).equalTo(record::getAccessToken)
            .set(expireTime).equalTo(record::getExpireTime)
            .set(loginTime).equalTo(record::getLoginTime)
            .set(status).equalTo(record::getStatus)
            .set(creator).equalTo(record::getCreator)
            .set(createTime).equalTo(record::getCreateTime)
            .set(lastUpdator).equalTo(record::getLastUpdator)
            .set(lastUpdateTime).equalTo(record::getLastUpdateTime)
            .where(userId, isEqualTo(record::getUserId))
        );
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Users record) {
        return update(c ->
            c.set(userName).equalToWhenPresent(record::getUserName)
            .set(password).equalToWhenPresent(record::getPassword)
            .set(email).equalToWhenPresent(record::getEmail)
            .set(ugroup).equalToWhenPresent(record::getUgroup)
            .set(accessToken).equalToWhenPresent(record::getAccessToken)
            .set(expireTime).equalToWhenPresent(record::getExpireTime)
            .set(loginTime).equalToWhenPresent(record::getLoginTime)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(creator).equalToWhenPresent(record::getCreator)
            .set(createTime).equalToWhenPresent(record::getCreateTime)
            .set(lastUpdator).equalToWhenPresent(record::getLastUpdator)
            .set(lastUpdateTime).equalToWhenPresent(record::getLastUpdateTime)
            .where(userId, isEqualTo(record::getUserId))
        );
    }
}