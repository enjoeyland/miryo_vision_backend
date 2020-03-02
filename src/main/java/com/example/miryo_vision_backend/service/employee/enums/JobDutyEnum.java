package com.example.miryo_vision_backend.service.employee.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum JobDutyEnum {
    TEAM_MANAGER("팀장");

    private String name;

    JobDutyEnum(String name_ko) {
        this.name = name_ko;
    }

    private static final Map<String, JobDutyEnum> BY_NAME = new HashMap<>();

    static {
        for (JobDutyEnum e: values()) {
            BY_NAME.put(e.name, e);
        }
    }

    public static JobDutyEnum findByName(String name){
        return BY_NAME.get(name);
    }
}
