package com.example.miryo_vision_backend.entity;

import com.example.miryo_vision_backend.service.employee.enums.Department;
import com.example.miryo_vision_backend.service.employee.enums.JobDuty;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(length = 13)
    private String residentRegistrationNum;

    // todo Address 개체 만들기??
    @Column(length = 13)
    private String address;

    private String phoneNum;

    private String email;

    private String 자격증;

    private String 특이사항;

    private Date 입사일;

    private Date 퇴사일;


    @Enumerated(EnumType.STRING)
    private Department department;

    private String jobTitle; //직급 :사원-대리~부장~사장

    @Enumerated(EnumType.STRING)
    private JobDuty jobDuty; // 직책: 팀장,지점장


    // todo: UI와 상관
    private String 등급;
    private String login_id;
    private String login_pw;


}
