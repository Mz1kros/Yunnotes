package com.setsail.server;

import com.setsail.common.util.Console;
import com.setsail.common.util.StringUtils;
import com.setsail.entity.UserInfo;
import com.setsail.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author by SUNS3T
 * @Classname UserMapperTest
 * @Description TODO
 * @Date 2020/4/10 7:17
 */
@SpringBootTest
public class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    void contextLoads() {
    }

    @Test
    public void initTestData(){
        for(int i = 0 ; i < 10 ; i++){
            UserInfo userInfo = new UserInfo();
            userInfo.setType(1);
            userInfo.setEmail(StringUtils.getAllCharString(10));
            userInfo.setPassword("123456");
//            userMapper.baseInsertAndReturnKey(userInfo);
            Console.println(userInfo.getId() + "",userInfo);
        }
    }

    @Test
    public void getAll(){
        List<UserInfo> list = (List<UserInfo>) userMapper.baseSelectAll(new UserInfo());
        for(UserInfo userInfo : list){
            Console.println(userInfo.getId() + "",userInfo);
        }
    }

    @Test
    public void createUserInfoTable(){
        userMapper.baseCreate(new UserInfo());
    }
}
