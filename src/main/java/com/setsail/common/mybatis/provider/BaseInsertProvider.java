package com.setsail.common.mybatis.provider;



import com.setsail.common.mybatis.BaseEntity;
import com.setsail.common.mybatis.SqlFieldReader;
import com.setsail.common.util.Console;
import com.setsail.common.util.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author by SUNS3T
 * @Classname BaseInsertProvider
 * @Description TODO
 * @Date 2020/4/10 7:07
 */
public class BaseInsertProvider {
    /**
     * 缓存insert语句
     * insert into 表名 values(name = #{},...)
     */
    public static Map<String,String> insertMap = new ConcurrentHashMap<>(16);
    public static Map<String,String> insertAndReturnKeyMap = new ConcurrentHashMap<>(16);

    /**
     * 基础的添加语句
     * 读取对象的所有字段属性，生成insert语句
     * @param entity
     * @param <T>
     * @return
     */
    public static <T extends BaseEntity> String insert(T entity){
        Class clazz = entity.getClass();
        String className = clazz.getName();
        String sql = insertMap.get(className);
        if (StringUtils.isEmpty(sql)){
            String fieldStr = SqlFieldReader.getFieldStr(entity);
            StringBuilder builder = new StringBuilder();
            builder.append("INSERT INTO ")
                    .append(SqlFieldReader.getTableName(entity)).append(" ")
                    .append("(").append(fieldStr).append(")")
                    .append("VALUES(");

            StringBuilder valuesBuilder = new StringBuilder();
            String[] arr = fieldStr.split(",");
            for (String s : arr) {
                valuesBuilder.append("#{").append(s).append("}").append(",");
            }
            builder.append(valuesBuilder.substring(0,valuesBuilder.length()-1))
                    .append(")");
            sql = builder.toString();
            insertMap.put(className, sql);
        }
        Console.info("insert",sql,entity);
        return sql;
    }

    public static <T extends BaseEntity> String insertAndReturnKey(T entity) {
        Class cls = entity.getClass();
        String className = cls.getName();
        String sql = insertAndReturnKeyMap.get(className);
        if(StringUtils.isEmpty(sql)){
            String fieldStr = SqlFieldReader.getFieldStr(entity);
            String[] arrays = fieldStr.split(",");

            StringBuilder builder = new StringBuilder();

            StringBuilder valuesStr = new StringBuilder();

            builder.append("INSERT INTO ")
                    .append(SqlFieldReader.getTableName(entity)).append(" ")
                    .append("(");
            for(String str:arrays){
                if("id".equals(str)){
                    continue;
                }
                valuesStr.append(str).append(",");
            }
            builder.append(valuesStr.substring(0,valuesStr.length() - 1));

            builder.append(") ").append("VALUES(");

            valuesStr = new StringBuilder();
            for(String str:arrays){
                if("id".equals(str)){
                    continue;
                }
                valuesStr.append("#{").append(str).append("}").append(",");
            }
            builder.append(valuesStr.substring(0,valuesStr.length() - 1))
                    .append(") ");
            sql = builder.toString();
            insertAndReturnKeyMap.put(className,sql);
        }
        Console.info("insertAndReturnKey",sql,entity);
        return sql;
    }
}
