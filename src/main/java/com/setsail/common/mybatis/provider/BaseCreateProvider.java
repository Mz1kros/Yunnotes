package com.setsail.common.mybatis.provider;

import com.setsail.common.mybatis.BaseEntity;
import com.setsail.common.mybatis.BaseException;
import com.setsail.common.mybatis.SqlFieldReader;

/**
 * @author by SUNS3T
 * @Classname BaseCreateProvider
 * @Description TODO
 * @Date 2020/4/10 18:15
 */
public class BaseCreateProvider {
    /**
     *
     * 创建表的同时要创建索引，会执行多条语句，在application.properties中要设置 allowMultiQueries=true
     * spring.datasource.url = jdbc:mysql://localhost:3306/my_core
     * ?useUnicode=true&characterEncoding=utf-8&useSSL=false&allowMultiQueries=true
     * @param entity
     * @param <T>
     * @return
     */
    public static <T extends BaseEntity> String create(T entity) throws BaseException {
        return SqlFieldReader.getCreateTableSql(entity);
    }
}
