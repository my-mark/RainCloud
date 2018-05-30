package com.junsheng.community.poss.domain;

public enum HeaderEnum {
    /**
     * 系统级错误
     */
    SUC_MSG("0000", "success"),// 不可更改
    SYS_MSG("0001", "系统错误"),// 不可更改
    PARAM_MSG("0002", "参数错误"),
    DAO_MSG("0003", "数据异常"),
    SERVICE_MSG("0004", "服务异常"),
    WEB_MSG("0005", "网络异常,请重试"),
    WEB_REPEAT_SUBMIT("0006", "重复提交"),
    INVALID_REQUEST("0007", "非法请求"),
    NET_NOT_STABLE("0008", "网络不稳定，请稍后再试"),

    /**
     * 用户相关
     */
    INVALID_SESSION("1001", "你已经退出登录!"), // 不可更改
    INVALID_USER_PASSWORD("1002","用户名或密码错误!"),//不可更改
    USER_NOT_EXIST("1003","用户名不存在!"),
    USER_IS_LOGIN("1004" ,"当前用户已经登录"),


    /**
     * 文件上传相关
     */
    FILE_INPUSTREAM_IO_EXCEPTION("2001","上传失败！"),
    /**
     * 文件上传相关
     */
    FILE_EXPORTPDF_IO_EXCEPTION("2002","文件下载异常！");


    private String code;

    private String msg;


    HeaderEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
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

}
