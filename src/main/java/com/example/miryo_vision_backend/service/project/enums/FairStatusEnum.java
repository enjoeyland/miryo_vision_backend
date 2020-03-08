package com.example.miryo_vision_backend.service.project.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum FairStatusEnum {

    WAITING(null),
    WIN(true),
    LOSE(false);

    private Boolean isFairWin;

    FairStatusEnum(Boolean isFairWin) {
        this.isFairWin = isFairWin;
    }


    private static final Map<Boolean, FairStatusEnum> BY_BOOL = new HashMap<>();

    static {
        for (FairStatusEnum e: values()) {
            BY_BOOL.put(e.isFairWin, e);
        }
    }

    public static FairStatusEnum findByBool(Boolean isFairWin){
        return BY_BOOL.get(isFairWin);
    }


}
