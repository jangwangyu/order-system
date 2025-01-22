package com.study.ordersystem.controller;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class Response<T> {
    private final HttpStatus statusCode;
    private final String message;
    private final T data;


    public Response(HttpStatus statusCode, String message, T data) {
        this.statusCode = statusCode;
        this.message = message;
        this.data = data;
    }

    public static<T> Response<T> success(T data) { // 성공시
        return new Response<>(HttpStatus.OK, "SUCESS", data);
    }

    public static<T> Response<T> fail(String errorMessage) { // 실패시
        return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage,null);
    }

}
