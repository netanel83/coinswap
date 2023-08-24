package com.coinswap.util;

import com.alibaba.fastjson2.JSONObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResult {
    private Object data;
    private  int code;
    private String message;
    private String totalPage;
    private String totalElement;

    public MessageResult(int code,String message){
        this.code = code;
        this.message = message;
    }
    public MessageResult(int code,String message,Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public MessageResult(){}
    public static MessageResult success(){
        return new MessageResult(0,"SUCCESS");
    }
    public static MessageResult success(String message){
        return new MessageResult(0,message);
    }
    public static MessageResult success(String message,Object data){
        return new MessageResult(0,message,data);
    }
    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }

    public static MessageResult getSuccessInstance(String message,Object data){
        MessageResult result = success(message);
        result.setData(data);
        return result;
    }
}
