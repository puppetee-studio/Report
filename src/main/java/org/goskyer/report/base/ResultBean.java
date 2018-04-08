package org.goskyer.report.base;

public class ResultBean {

    public static final String OK_CODE = "0";
    public static final String OK_MSG = "ok";

    private String code = OK_CODE;
    private String msg = OK_MSG;
    private String result;

    public ResultBean() {
        //do nothing
    }

    public ResultBean(String result) {
        this.result = result;
    }

    public ResultBean(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultBean(String code, String msg, String result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
