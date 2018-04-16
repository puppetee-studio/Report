package org.goskyer.report.base;

public class ResultBean {

    public static final int OK_CODE = 0;
    public static final String OK_MSG = "ok";

    private int code = OK_CODE;
    private String msg = OK_MSG;
    private Object result;

    public ResultBean() {
        //do nothing
    }

    public ResultBean(Object result) {
        this.result = result;
    }

    public ResultBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultBean(int code, String msg, String result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

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

    public Object getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
