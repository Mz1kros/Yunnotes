package com.setsail.common.mybatis.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author SUNS3T
 * @Classname TableAttribute
 * @Description 表注解，用在entity的类声明之前
 * value赋值为表名
 * @Date 2020/4/9 2:25
 * @Created by SUNS3T
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TableAttribute {
    /**
     * 表名
     * @return
     */
    String name();
    /**
     * 描述
     * 注解的参数类似无参数方法，可以用default设定一个默认值
     */
    String comment() default "";
}
