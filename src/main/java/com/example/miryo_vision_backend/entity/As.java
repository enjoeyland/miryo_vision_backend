package com.example.miryo_vision_backend.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "`AS`") // hint: https://stackoverflow.com/questions/57506605/caused-by-java-sql-sqlsyntaxerrorexception-version-for-the-right-syntax
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class As {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String size;
    String quantity;
    String date;

    String 입력Employee; // 별도

    String retrievedDate;
    String asKind;
    String estimatedDeliveryDate;
    String invoiceDate;
    String invoiceNum;
    String retrievedStatus;
    String 교환Message;
    String callDate;
    String callerName;
    String callDetails;

    String note;

}
