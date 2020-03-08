package com.example.miryo_vision_backend.service.employee.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum JobDuty {
    // todo:  직책은 팀장과 팀원으로 나누면 될거같고

    // todo: 팀장은 : 상무, 이사, 부장, 차장
    //       팀원은 : 과장, 대리, 사원
    TEAM_MANAGER("팀장");

    @JsonValue
    private String name;

    JobDuty(String name_ko) {
        this.name = name_ko;
    }

    private static final Map<String, JobDuty> BY_NAME = new HashMap<>();

    static {
        for (JobDuty e: values()) {
            BY_NAME.put(e.name, e);
        }
    }

    @JsonCreator
    public static JobDuty findByName(String name){
        return BY_NAME.get(name);
    }
}
