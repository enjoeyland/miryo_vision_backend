package com.example.miryo_vision_backend.entity;

import com.example.miryo_vision_backend.service.project.enums.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@NamedEntityGraphs({
    @NamedEntityGraph(name = "joinCustomerCompany",attributeNodes = {
        @NamedAttributeNode("customerCompany")
    })
})

public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 10)
    private String barcode;

    @Column(length = 5)
    private String plantCode;


    @ManyToOne
    @JoinColumn(name = "CUSTOMER_COMPANY_ID", referencedColumnName = "ID")
    private CustomerCompany customerCompany;

    @ManyToOne
    @JoinColumn(name = "SALES_DEPART_EMPLOYEE_INCHARGE_ID", referencedColumnName = "ID")
    private Employee salesDepartEmployeeInCharge;

    @ManyToOne
    @JoinColumn(name = "LOGISTICS_DEPART_EMPLOYEE_INCHARGE_ID", referencedColumnName = "ID")
    private Employee logisticsDepartEmployeeInCharge;

    @ManyToOne
    @JoinColumn(name = "PRODUCTION_DEPART_EMPLOYEE_INCHARGE_ID", referencedColumnName = "ID")
    private Employee productionDepartEmployeeInCharge;

    @ManyToOne
    @JoinColumn(name = "DESIGN_DEPART_EMPLOYEE_INCHARGE_ID", referencedColumnName = "ID")
    private Employee designDepartEmployeeInCharge;

    @ManyToOne
    @JoinColumn(name = "ACCOUNTING_DEPART_EMPLOYEE_INCHARGE_ID", referencedColumnName = "ID")
    private Employee accountingDepartEmployeeInCharge;



    @ToString.Exclude
    @OneToMany(targetEntity = Item.class, mappedBy = "project")
    private List<Item> itemList;

    @ToString.Exclude
    @OneToMany(targetEntity = Order.class, mappedBy = "project")
    private List<Order> orderList;

    @ToString.Exclude
    @OneToMany(targetEntity = CustomerCompanyEmployee.class, mappedBy = "project")
    private List<CustomerCompanyEmployee> customerCompanyEmployeeList;

    @Column(length = 20)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDatetime;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private FairStatusEnum fairStatus;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fairResultDatetime;

//    private ProjectState(??) state;



    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private CustomerClassificationEnum customerClassification;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private YearEnum year;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private SeasonEnum season;

    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private ProductTypeEnum productType;
}
