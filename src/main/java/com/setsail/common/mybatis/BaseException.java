package com.setsail.common.mybatis;

/**
 * @author by SUNS3T
 * @Classname BaseException
 * @Description TODO
 * 自定义异常，用来处理BaseMapper使用过程中抛出的异常
 * @Date 2020/4/9 20:59
 */
public class BaseException extends Exception{
    public BaseException(String msg){
        super(msg);
    }
}
