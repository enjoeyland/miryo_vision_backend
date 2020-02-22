package com.example.miryo_vision_backend.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.List;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
    private Project project;

    @ToString.Exclude
    @OneToMany(targetEntity = Order.class, mappedBy = "item")
    List<Order> orderList;

    @ToString.Exclude
    @OneToMany(targetEntity = CustomerCompanyEmployee.class, mappedBy = "item")
    List<CustomerCompanyEmployee> customerCompanyEmployeeList;


    private String itemCode;
    private String itemLargeCategory;
    private String itemSmallCategory;
    private String 지급수량; // 번역
    private String unitCost;
    private Date registerDate;





}
