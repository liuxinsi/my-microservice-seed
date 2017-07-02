package com.lxs.mms.rs.resource;

import lombok.Data;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
abstract public class ResourceSupport {


    @Data
    class Response<T>{
        T data;
        String code;
        String mesg;
        String detail;
    }
}
