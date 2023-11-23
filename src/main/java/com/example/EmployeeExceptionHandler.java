package com.example;

import static reactor.core.publisher.Mono.just;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

@ControllerAdvice
public class EmployeeExceptionHandler {

//    Exception Handler is Inbuilt Bind support of Spring Framework

  @ExceptionHandler(WebExchangeBindException.class)
  public Mono<ResponseEntity<Response>> webExchangeBindExceptionHandler(Exception exception){
    String errorMessage = "";
    if(exception instanceof WebExchangeBindException){
      errorMessage = ((WebExchangeBindException) exception).getAllErrors().get(0).getDefaultMessage();
    }
    Response response = new Response(errorMessage,null);
    return just(new ResponseEntity<>(response, HttpStatus.BAD_REQUEST));
  }


  @ExceptionHandler(RuntimeException.class)
  public Mono<ResponseEntity<Response>> runtimeExceptionHandler() {
    Response response = new Response("Something went wrong..!!",null);
    return just(new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR));
  }

  @ExceptionHandler(EmployeeException.class)
  public Mono<ResponseEntity<Response>> employeeExceptionHandler(RuntimeException exception){
    Response response = new Response(404, exception.getMessage(), null);
    return Mono.just(new ResponseEntity<>(response, HttpStatus.BAD_REQUEST));
  }

  @ExceptionHandler(EmployeeNotFoundException.class)
  public Mono<ResponseEntity<Response>> employeeNotFoundExceptionHandler(RuntimeException exception){
    Response response = new Response(404, exception.getMessage(),null);
    return Mono.just(new ResponseEntity<>(response, HttpStatus.NOT_FOUND));
  }

}