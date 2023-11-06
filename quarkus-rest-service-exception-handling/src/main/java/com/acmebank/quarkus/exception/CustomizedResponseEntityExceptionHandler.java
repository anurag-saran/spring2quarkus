package com.acmebank.quarkus.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.time.LocalDateTime;

@Provider
public class CustomizedResponseEntityExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception e) {
        Response errorResponse = mapExceptionToResponse(e);
        return errorResponse;
    }

    private Response mapExceptionToResponse(Exception e) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), e.getMessage());
        if(e instanceof BankAccountNotFoundException){
            return Response.status(Response.Status.NOT_FOUND).entity(exceptionResponse).build();
        }else{
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exceptionResponse).build();
        }
    }
}