package com.setsail.common.proxy;

import com.setsail.common.response.Response;
import com.setsail.common.util.RequestUtil;
import com.setsail.common.util.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author by SUNS3T
 * @Classname ApiController
 * @Description TODO
 * @Date 2020/4/11 7:12
 * 接口转发,处理 JSON 格式的请求
 * @RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
 * 如果只是使用@RestController注解Controller，则Controller中的方法无法返回jsp页面，或者html，
 * 配置的视图解析器 InternalResourceViewResolver不起作用，返回的内容就是Return 里的内容。
 * 如果需要返回到指定页面，则需要用 @Controller配合视图解析器InternalResourceViewResolver才行。
 * 如果需要返回JSON，XML或自定义mediaType内容到页面，则需要在对应的方法上加上@ResponseBody注解
 *
 *  @CrossOrigin 注解，避免因为服务端导致的跨域问题
 *  可以通过注入 HttpServletRequest 的方式读取请求
 */
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*",allowedHeaders="*", maxAge = 3600)
public class ApiController {
    @Resource
    HttpServletRequest request;

    @Autowired
    RestTemplate restTemplate;

    // TODO 转发前校验JWT和用户权限
    /**
     * json 格式的GET请求
     * @param params
     * @return
     */
    @GetMapping
    public ResponseEntity get(@RequestParam Map<String,String> params){
        //定义应答
        ResponseEntity responseEntity;
        try {
            //String类型响应体封装到body
            responseEntity = restTemplate.getForEntity(RequestUtil.getUrl(params,request), String.class,params);
            //记录请求处理成功的日志
            RequestUtil.successLog(request,params,responseEntity);
        }catch (Exception e){
            //解析请求失败的应答
            responseEntity = ResponseUtils.getResponseFromException(e);
            //记录请求处理失败的日志
            RequestUtil.errorLog(request,params,responseEntity);
        }
        return responseEntity;
    }

    /**
     * JSON  形式的 POST 请求
     * @param params
     * @return
     */
    @PostMapping
    public ResponseEntity post(@RequestBody Map<String,String> params){
        ResponseEntity responseEntity;
        try {
            responseEntity = restTemplate.postForEntity(RequestUtil.getUrl(params,request),null,String.class,params);
            RequestUtil.successLog(request,params,responseEntity);
        }catch (Exception e){
            responseEntity = ResponseUtils.getResponseFromException(e);
            RequestUtil.errorLog(request,params,responseEntity);
        }
        return responseEntity;
    }

    /**
     * JSON 格式的 PUT 请求
     * @param params
     * @return
     */
    @PutMapping
    public ResponseEntity put(@RequestBody Map<String,String> params){
        ResponseEntity responseEntity = Response.ok();
        try {
            restTemplate.put(RequestUtil.getUrl(params,request),null,params);
            RequestUtil.successLog(request,params,responseEntity);
        }catch (Exception e){
            responseEntity = ResponseUtils.getResponseFromException(e);
            RequestUtil.errorLog(request,params,responseEntity);
        }
        return responseEntity;
    }

    /**
     * JSON 形式的 DELETE 请求
     * @param params
     * @return
     */
    @DeleteMapping
    public ResponseEntity delete(@RequestBody Map<String,String> params){
        ResponseEntity responseEntity = Response.ok();
        try {
            restTemplate.delete(RequestUtil.getUrl(params,request),params);
            RequestUtil.successLog(request,params,responseEntity);
        }catch (Exception e){
            responseEntity = ResponseUtils.getResponseFromException(e);
            RequestUtil.errorLog(request,params,responseEntity);
        }
        return responseEntity;
    }


}
