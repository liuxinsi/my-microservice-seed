package com.lxs.mms.rest.service.core.jersey;

import com.google.common.base.Joiner;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 封装所有Bean Validation产生的异常。
 *
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
public class ValidationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        Set<String> exMesgs = exception.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .collect(Collectors.toSet());

        com.lxs.mms.rest.service.core.bean.Response<Object> resp =
                new com.lxs.mms.rest.service.core.bean.Response<>();
        resp.setStatus(com.lxs.mms.rest.service.core.bean.Response.Status.ERROR);
        resp.setErrMesg(Joiner.on("、").join(exMesgs));
        return Response.status(Response.Status.BAD_REQUEST).entity(resp).build();
    }
}
