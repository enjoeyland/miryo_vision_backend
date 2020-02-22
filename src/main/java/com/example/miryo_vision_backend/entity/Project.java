package com.example.miryo_vision_backend.entity;

import com.example.miryo_vision_backend.SeasonAttributeConverter;
import com.example.miryo_vision_backend.SeasonEnum;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp; // hint: https://jistol.github.io/java/2017/02/03/jpa-datetype/
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

    private String plantCode;


    @ManyToOne
    @JoinColumn(name = "CUSTOMER_COMPANY_ID", referencedColumnName = "ID")
    private CustomerCompany customerCompany;

    @ToString.Exclude
    @OneToMany(targetEntity = Item.class, mappedBy = "project")
    private List<Item> itemList;

    @ToString.Exclude
    @OneToMany(targetEntity = Order.class, mappedBy = "project")
    private List<Order> orderList;

    @ToString.Exclude
    @OneToMany(targetEntity = CustomerCompanyEmployee.class, mappedBy = "project")
    private List<CustomerCompanyEmployee> customerCompanyEmployeeList;

    private String name;

    @Column(updatable = false)
    private Timestamp startDatetime;

    /** true : win
    *  false : lose
    *  null : waiting for result
    */
    private Boolean fairResult;

    @Column(updatable = false)
    private Timestamp fairResultDatetime;

//    private ProjectState(??) state;

//    private 직원 프로젝트_담당직원;
//    private CustomerCo 고객사; // note : 고객사를 참조 하는 것과 고객사의 코드번호를 어떻게 구분할지 생각하기 (일관성을 기준으로)
//    private 직원 영업부_담당직원;
//    private 직원 디자인부_담당직원;
//    private 직원 생산부_담당직원;
//    private 직원 물류부_담당직원;
//    private 직원 지원부_담당직원;



    private String customerClassificationCodeName;

    private String yearCodeName;



    private String genderCodeName;

    private String seasonCodeName;
//    @Convert(converter = SeasonAttributeConverter.class)
//    private SeasonEnum season;


    private String productTypeCodeName;


//    public Project(String customerClassificationCodeName,
//                   String yearCodeName,
//                   CustomerCompany customerCompanyCode,
//                   String genderCodeName,
//                   String seasonCodeName,
//                   String productTypeCodeName){
//        this.customerClassificationCodeName = customerClassificationCodeName;
//        this.yearCodeName = yearCodeName;
//        this.customerCompany = customerCompanyCode;
//        this.genderCodeName = genderCodeName;
//        this.seasonCodeName = seasonCodeName;
//        this.productTypeCodeName = productTypeCodeName;
//        this.barcode = this.generateProjectBarcode();
//    }

//    public String generateProjectBarcode() {
//        return this.customerClassificationCodeName +
//                this.yearCodeName +
//                this.customerCompany.code +
//                this.genderCodeName +
//                this.seasonCodeName +
//                this.productTypeCodeName +
//                String.format("%03d", this.id).substring(0, 3);
//    }
}
