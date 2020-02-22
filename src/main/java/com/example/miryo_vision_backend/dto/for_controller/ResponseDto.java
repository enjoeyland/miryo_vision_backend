package com.example.miryo_vision_backend.dto.for_controller;

import lombok.Getter;


@Getter
public class ResponseDto {

    private String state;

    private Object data;

    public ResponseDto(Boolean isSuccess, Object data) {
        setState(isSuccess);
        this.data = data;
    }


    private void setState(Boolean isSuccess) {
        if (isSuccess) this.state = "success";
        else this.state = "error";
    }
}
