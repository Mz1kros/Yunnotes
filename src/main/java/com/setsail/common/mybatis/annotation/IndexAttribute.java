package com.setsail.common.mybatis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author SUNS3T
 * @Classname IndexAttribute
 * @Description 索引字段注解，可以根据索引字段进行查找、删除操作
 *  * 注意：索引字段尽量使用包装类，如：Integer，避免使用 int long等基本类型
 *  *  因为条件查询会将有值的索引字段作为查询条件，
 *  *  此时，如果字段类型为int，初始值为0，0 将作为查询条件。
 * @Date 2020/4/9 2:56
 * @Created by SUNS3T
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IndexAttribute {
}
