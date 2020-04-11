package com.setsail.common.response;

/**
 * @author by SUNS3T
 * @Classname ResultData
 * @Description TODO
 * @Date 2020/4/10 20:01
 */
public class ResultData {

    /**
     * 业务状态 0：成功  1：失败
     */
    private int success ;
    /**
     * 返回数据
     */
    private Object data ;
    /**
     * 文字描述，一般放业务处理失败时返回的错误信息
     */
    private String message ;

    public final static int SUCCESS_CODE_SUCCESS = 0;
    public final static int SUCCESS_CODE_FAILED = 1;

    public ResultData() {
    }

    public static ResultData success() {
        ResultData resultData = new ResultData();
        resultData.setSuccess(SUCCESS_CODE_SUCCESS);
        return resultData;
    }
    public static ResultData success(Object data) {
        ResultData resultData = new ResultData();
        resultData.setSuccess(SUCCESS_CODE_SUCCESS);
        resultData.setData(data);
        return resultData;
    }
    public static ResultData error(String message) {
        ResultData resultData = new ResultData();
        resultData.setSuccess(SUCCESS_CODE_FAILED);
        resultData.setMessage(message);
        return resultData;
    }
    public boolean isSuccess(){
        return success == SUCCESS_CODE_SUCCESS;
    }


    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "success=" + success +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }
}
