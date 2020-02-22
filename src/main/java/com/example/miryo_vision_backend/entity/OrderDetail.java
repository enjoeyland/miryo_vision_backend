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
public class OrderDetail { // 신규 주문
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    String size;
    String 교환수량;
    String 회수수량;
    String date;

    String 입력직원; // 별도

    String 정산되야되는_날짜;
    String 포장예정일;
    String 송장일;
    String 송장번호;
    String 구매방법;
    String 품목구매단위;
    String 비고;
    String 신규메세지;


}
