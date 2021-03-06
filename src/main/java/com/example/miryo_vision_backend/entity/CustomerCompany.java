package com.example.miryo_vision_backend.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMER_COMPANY")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerCompany)) return false;
        CustomerCompany that = (CustomerCompany) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
