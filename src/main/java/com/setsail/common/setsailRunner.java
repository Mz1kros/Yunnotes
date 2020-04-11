package com.setsail.common;

import com.setsail.common.config.CommonConfig;
import com.setsail.common.util.RequestUtil;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sun.misc.Request;

import javax.annotation.Resource;

/**
 * @author by SUNS3T
 * @Classname setsailRunner
 * @Description TODO
 * @Date 2020/4/11 6:56
 * 继承Application接口后项目启动时会按照执行顺序执行run方法
 * 通过设置Order的value来指定执行的顺序
 */
@Component
@Order(value = 1)
public class setsailRunner implements ApplicationRunner {

    @Resource
    private CommonConfig commonConfig;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        RequestUtil.address = commonConfig.address;
        RequestUtil.port = commonConfig.port;
    }
}
