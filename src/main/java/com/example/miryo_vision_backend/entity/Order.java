package com.example.miryo_vision_backend.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "`ORDER`")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long OrderNum;


    @ManyToOne
    @JoinColumn(name = "PROJECT_ID", referencedColumnName = "ID")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID")
    private Item item;


//    @OneToMany(targetEntity = CustomerCompanyEmployee.class, mappedBy = "order")
//    private List<CustomerCompanyEmployee> customerCompanyEmployeeList;


    private Integer quantity;
    private Date requestDate;
    private Date estimatedDeliveryDate;

    private Integer totalPrice;   // ??
    private Boolean isFirstOrder;
}
