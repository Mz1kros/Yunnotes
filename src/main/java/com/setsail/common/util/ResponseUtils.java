package com.setsail.common.util;

import com.setsail.common.response.Response;
import com.setsail.common.response.ResultData;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

/**
 * @author by SUNS3T
 * @Classname ResponseUtils
 * @Description TODO
 * @Date 2020/4/11 8:48
 */
public class ResponseUtils {
    /**
     * 根据组件返回的错误码重组应答报文
     * @param exception
     * @return
     */
    public static ResponseEntity getResponseFromException(Exception exception){
        ResponseEntity response;
        // 如果异常属于 HttpClientErrorException 则其状态码代表请求状态码，按照请求状态码返回相应的 ResponseEntity 即可
        if(exception instanceof HttpClientErrorException){
            HttpClientErrorException errorException = (HttpClientErrorException) exception;
            switch (errorException.getStatusCode()){
                case FORBIDDEN:  response = Response.forbidden(); break;
                case BAD_REQUEST: response = Response.badRequest();break;
                case UNAUTHORIZED: response = Response.unauthorized();break;
                case INTERNAL_SERVER_ERROR: response = Response.error();break;
                default:{
                    ResultData resultData = ResultData.error("ERROR");
                    response = ResponseEntity.status(errorException.getStatusCode()).contentType(MediaType.APPLICATION_JSON).body(resultData);
                }
            }
        }else {
            response = Response.badRequest();
        }
        return  response;
    }

    public static ResultData getResultDataFromException(HttpClientErrorException exception){
        return  (ResultData)getResponseFromException(exception).getBody();
    }
}
