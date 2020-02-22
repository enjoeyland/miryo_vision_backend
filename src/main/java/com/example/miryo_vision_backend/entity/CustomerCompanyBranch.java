package com.example.miryo_vision_backend.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CustomerCompanyBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ToString.Exclude
    @OneToMany(targetEntity = CustomerCompanyEmployee.class, mappedBy = "customerCompanyBranch")
    List<CustomerCompanyEmployee> customerCompanyEmployeeList;


    String branchName;
    String 소속부서; // affiliated division / department
    String 점Num;
    Integer 발송순서; // deliveryOrder order 혼용
    String address;
    String zipNum;
    String generalDirectoryNumber; // 대표번호
    String 소속명; // ?? Affiliation Name

}
