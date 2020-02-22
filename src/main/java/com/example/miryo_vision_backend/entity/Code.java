package com.example.miryo_vision_backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter // hint: setter를 쓰면 원래 Entity가 변하면 Dto나  setter를 사용하는 코드들이 영향을 받아서 문제인데
        //  어짜피 modelMapper를 사용해서 Dto로 변환하는 것이기 때문에 field를 직접적으로 사용하진 않는다.
@ToString
public abstract class Code {

    /*
     * 1. DB가 연결됨
     * 2. config에서 hibernate.ddl-auto=update 함.
     * 3. instance가 @Entity 임
     * 그러면 @Entity 마다 table 하나씩 만들어줌
     * 하지만 데이터는 직접 save 해야함
     */

    @Id
    @Column(name = "NAME",nullable = false)
    protected String name;

    @Column(name = "CODE",nullable = false)
    protected String code;

    @Column(name = "SORT",nullable = false)
    protected String sort;

    @Column(name = "NOTE")
    protected String note;

}
