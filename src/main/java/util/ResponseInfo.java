package util;

import com.alibaba.fastjson.JSON;

public class ResponseInfo<T> {

    private static final int CODE_SUCCESS = 200;

    private static final int CODE_FAIL = 400;

    private static final String MSG_SUCCESS="success";

    private static final String MSG_FAIL="failed";

    public ResponseInfo(){
    }
    public ResponseInfo(int code ){
        this.code=code;
    }
    public ResponseInfo(int code,T body ){
        this.code=code;
        this.body=body;
    }
    public ResponseInfo(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public ResponseInfo(int code, String msg,T body) {
        this.code = code;
        this.msg = msg;
        this.body=body;
    }
    public static ResponseInfo success(){
        return new ResponseInfo(CODE_SUCCESS,MSG_SUCCESS);
    }

    public static ResponseInfo success(Object data){
        return new ResponseInfo(CODE_SUCCESS,MSG_SUCCESS, data);
    }

    public static ResponseInfo fail(){
        return new ResponseInfo(CODE_FAIL, MSG_FAIL);
    }

    private int code;

    private String msg;

    public T body;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
