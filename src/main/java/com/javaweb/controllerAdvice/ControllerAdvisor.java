package com.javaweb.controllerAdvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.Bean.ErrorResponeDTO;

import CostumException.CheckNullException;
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(CheckNullException.class)
    public ResponseEntity<Object> handleCheckNullException(
            CheckNullException e, WebRequest request) {
		ErrorResponeDTO errordto=new ErrorResponeDTO();
        errordto.setError(e.getMessage());
        List<String> detail1=new ArrayList<>();
        detail1.add("name va namsinh dang trong nen check lai");
        errordto.setDetail(detail1);
        return new ResponseEntity<>(errordto, HttpStatus.BAD_GATEWAY);
    }
}
