package com.setsail.common.mybatis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author by SUNS3T
 * @Classname SortAttribute
 * @Description TODO
 * @Date 2020/4/9 3:40
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SortAttribute {
}
