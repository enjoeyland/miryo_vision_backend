package com.example.miryo_vision_backend.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;


@Getter
public class ServerResponse<T> {

    private String msg; //에러나 그냥 알리고 싶은 내용 보내기

    private String code = "20000"; //for intercept

    @JsonProperty(value = "status")
    private Boolean isSuccess;

    private T data; // 실패시: null

    public ServerResponse(Boolean isSuccess, T data, String msg) {
        this.isSuccess = isSuccess;
        this.data = data;
        this.msg = msg;
    }

    public ServerResponse(Boolean isSuccess, T data) {
        this.isSuccess = isSuccess;
        this.data = data;
        this.msg = "";

    }
}
