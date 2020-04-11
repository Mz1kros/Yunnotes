package com.setsail.service;
import com.setsail.common.response.ResultData;
import com.setsail.entity.UserInfo;
import com.setsail.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 */
@Service
public class UserService {

    /**
     *
     */
    @Resource
    private UserMapper userMapper;

    /**
     *
     * @return
     */
    public List<UserInfo> getAll(){
        return userMapper.baseSelectAll(new UserInfo());
    }

    public ResultData getByEmail(String email){
        UserInfo userInfo = new UserInfo();
        userInfo.setEmail(email);
        List<UserInfo> list = userMapper.baseSelectByCondition(userInfo);
        if (list != null && list.size() > 0){
            return ResultData.success(list.get(0));
        }
        return ResultData.error("该邮箱未注册");
    }
}
