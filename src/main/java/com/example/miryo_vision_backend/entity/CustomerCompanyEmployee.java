package com.example.miryo_vision_backend.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CustomerCompanyEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID")
    private Item item;

//    @ManyToOne
//    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID")
//    private Order order;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_COMPANY_BRANCH_ID", referencedColumnName = "ID")
    CustomerCompanyBranch customerCompanyBranch;


    String name;
    String employeeNum;
    String position;
    String gender;
    Integer height;
    String personalPhoneNum;
    String note;


}
