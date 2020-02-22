package com.example.miryo_vision_backend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUSTOMER_COMPANY")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CustomerCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ToString.Exclude
    @OneToMany(targetEntity = Project.class, mappedBy= "customerCompany")
    private List<Project> projectList = new ArrayList<Project>();


    @Column(name = "NAME",nullable = false)
    protected String name;

    @Column(name = "CODE",nullable = false)
    protected String code;

    @Column(name = "SORT",nullable = false)
    protected String sort;

    String 이름;

    String 고객사구분;
    String 업태;
    String 종목;

    String 사업자등록번호;
    String 대표전화;
    String 주소;


    String 대표자명;
    String 이메일;


    String 은행명;
    String 계좌번호;


    String 특이사항;


    @Column(name = "NOTE")
    protected String note;


}
