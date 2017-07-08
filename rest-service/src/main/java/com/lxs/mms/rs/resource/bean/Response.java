package com.lxs.mms.rs.resource.bean;

import lombok.Data;

/**
 * 响应对象。<br/>
 * {@link #errMesg}和{@link #errDetail}仅在状态{@link #status}为{@link Status#ERROR}时出现。
 *
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@Data
public class Response<T> {
    /**
     * 业务数据
     */
    private T data;
    /**
     * 响应状态
     */
    private Status status;
    /**
     * 错误消息
     */
    private String errMesg;
    /**
     * 错误堆栈
     */
    private String errDetail;

    public enum Status {
        SUCCESS, ERROR;
    }
}
