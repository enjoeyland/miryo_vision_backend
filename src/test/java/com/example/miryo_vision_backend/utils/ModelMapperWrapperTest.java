package com.example.miryo_vision_backend.utils;

import com.example.miryo_vision_backend.entity.CustomerCompany;
import com.example.miryo_vision_backend.entity.Project;
import com.example.miryo_vision_backend.service.project.enums.*;
import lombok.*;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
class OrderDto {
    String customerFirstName;
    String customerLastName;
    String billingStreet;
    String billingCity;
}

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
class ProjectBarcode {

    private String customerClassificationCode;

    private String yearCode;

    private String customerCompanyCode;

    private String genderCode;

    private String seasonCode;

    private String productTypeCode;
}

class ModelMapperWrapperTest {


    @Test
    void mapTestingFlexibility() {

        // hint: 문제상황: modelMapper 홈페이지에 제시하는 modelMapper의 장점인 유연성을 테스트
        //                modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        //       해결방안: 엄격하면 안됨
        //

        @AllArgsConstructor
        @Getter
        class Address {
            String street;
            String city;
        }
        @AllArgsConstructor
        @Getter
        class Name {
            String firstName;
            String lastName;
        }
        @AllArgsConstructor
        @Getter
        class Customer {
            Name name;
        }
        @AllArgsConstructor
        @Getter
        class Order {
            Customer customer;
            Address billingAddress;
        }

        Order order = new Order(new Customer(new Name("Min", "KyungHyun")), new Address("역삼로 74길","대치동"));


        ModelMapper modelMapper = new ModelMapper();
//        OrderDto orderDTO = modelMapper.map(order, OrderDto.class); // 됨
        OrderDto orderDTO = ModelMapperWrapper.map(order, OrderDto.class);

        assertEquals(order.getCustomer().getName().getFirstName(), orderDTO.getCustomerFirstName());
        assertEquals(order.getCustomer().getName().getLastName(), orderDTO.getCustomerLastName());
        assertEquals(order.getBillingAddress().getStreet(), orderDTO.getBillingStreet());
        assertEquals(order.getBillingAddress().getCity(), orderDTO.getBillingCity());
    }
    @Test
    void mapTestingMultipleSourcePropertyHierarchiesError() {

        // hint: 문제상황: Project 에 name이 존재한다.근데 modelMapper가 이것을 추상적으로 여겨서
        //                The destination property entity.Project.setName() matches multiple source property hierarchies
        //                이러한 에러가 난다.
        //       해결방안: modelMapper.getConfiguration().setAmbiguityIgnored(true);


        // hint: 문제상황: "2018"->Y2018 -> enum 첫번째 화살표가 자동으로 안된다.
        //                아마 되게 하려면 하나하나 연결시켜야 할것이다.
        //                근데 modelmapper는 연결시키기 어렵다.
        //       해결방안: mapstruct을 사용한다.

        // hint: 1.modelmapper는 이름으로 mapping하는 strategy에 강점이 있다.
        //       2.enum->Y2018->"2018"로는 자동으로 할수 있다.



        Project project = new Project();
        project.setCustomerClassification(CustomerClassificationEnum.GENERAL);
        project.setYear(YearEnum.Y2018);

        CustomerCompany customerCompany = new CustomerCompany();
        customerCompany.setId(2L);
        customerCompany.setCode("02");

        project.setCustomerCompany(customerCompany);
        project.setGender(GenderEnum.UNISEX);
        project.setProductType(ProductTypeEnum.WORK);
        project.setSeason(SeasonEnum.SUMMER);
        ProjectBarcode projectBarcode = ModelMapperWrapper.map(project, ProjectBarcode.class);

        assertThat(projectBarcode.getCustomerClassificationCode(), is(String.valueOf(project.getCustomerClassification().getCode())));
        assertThat(projectBarcode.getCustomerCompanyCode(), is(String.valueOf(project.getCustomerCompany().getCode())));
        assertThat(projectBarcode.getGenderCode(), is(String.valueOf(project.getGender().getCode())));
        assertThat(projectBarcode.getSeasonCode(), is(String.valueOf(project.getSeason().getCode())));
        assertThat(projectBarcode.getProductTypeCode(), is(String.valueOf(project.getProductType().getCode())));
        assertThat(projectBarcode.getYearCode(), is(String.valueOf(project.getYear().getCode())));
    }
}
