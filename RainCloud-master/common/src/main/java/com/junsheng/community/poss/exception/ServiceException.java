package com.junsheng.community.poss.exception;

import com.junsheng.community.poss.domain.HeaderEnum;

/**
 * Created by leo on 16/8/4.
 */
public class ServiceException extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    /**
     * 构造新实例。
     */
    public ServiceException() {
        super();
    }

    /**
     * 用给定的异常信息构造新实例。
     * @param header 异常信息。
     */
    public ServiceException(HeaderEnum header) {
        super((String)null);
        this.errorMessage = header.getMsg();
        this.errorCode = header.getCode();
    }



    /**
     * 用表示异常原因的对象构造新实例。
     * @param cause 异常原因。
     */
    public ServiceException(Throwable cause) {
        super(null, cause);
        if (cause instanceof ServiceException){
            ServiceException serviceException = (ServiceException) cause;
            this.errorMessage = serviceException.getErrorMessage();
            this.errorCode = serviceException.getErrorCode();
        }
    }

    /**
     * 用异常消息和表示异常原因的对象构造新实例。
     * @param header 异常信息。
     * @param cause 异常原因。
     */
    public ServiceException(HeaderEnum header, Throwable cause) {
        super(null, cause);
        this.errorMessage = header.getMsg();
        this.errorCode = header.getCode();
    }



    /**
     * 用异常消息和表示异常原因及其他信息的对象构造新实例。
     * @param errorMessage 异常信息。
     * @param errorCode 错误代码。
     */
    public ServiceException(String errorCode , String errorMessage) {

        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    /**
     * 用异常消息和表示异常原因及其他信息的对象构造新实例。
     * @param errorMessage 异常信息。
     * @param errorCode 错误代码。
     * @param cause 异常原因。
     */
    public ServiceException(Throwable cause, String errorCode , String errorMessage) {
        super(cause);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }


    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return getErrorMessage()
                + "\n[errorCode]: " + getErrorCode()
                + "\n[errorMessage]: " + getErrorMessage();
    }
}
