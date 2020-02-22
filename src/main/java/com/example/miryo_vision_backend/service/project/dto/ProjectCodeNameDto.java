package com.example.miryo_vision_backend.service.project.dto;

import com.example.miryo_vision_backend.entity.Project;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectCodeNameDto {

    private String customerClassificationCodeName;

    private String yearCodeName;

    private String customerCompanyName;

    private String genderCodeName;

    private String seasonCodeName;

    private String productTypeCodeName;

//   fixme: 타입이 다른데 어떻게 해야할지 모르겠다.
//    고려1: 한정된 데이터
//    고려2: service 쪽에서 하는 게 좋은지
//    고려3: modelmapper가 알아서 해줄지 확인(즉 기존 방식 유지가능??)
   public Project toEntity() {
//       return new Project(customerClassificationCode,
//               yearCode,
//               customerCo,
//               genderCode,
//               seasonCode,
//               productTypeCode);
       return new Project();
   }
}
