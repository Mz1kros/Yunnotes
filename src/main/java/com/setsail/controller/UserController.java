package com.setsail.controller;

import com.setsail.common.response.Response;
import com.setsail.common.response.ResultData;
import com.setsail.common.util.StringUtils;
import com.setsail.entity.UserInfo;
import com.setsail.mapper.UserMapper;
import com.setsail.service.UserService;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping
    public ResponseEntity getAll(){
        List<UserInfo> list = userService.getAll();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(list);
    }
    @GetMapping("/getByEmail")
    public ResponseEntity getByEmail(String email){
        if (StringUtils.isEmpty(email)){
            return Response.badRequest();
        }
        ResultData resultData = userService.getByEmail(email);
        return Response.ok(resultData);
    }
}
