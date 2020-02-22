package com.example.miryo_vision_backend.utils;

import com.example.miryo_vision_backend.service.project.dto.ProjectCodeNameDto;
import com.example.miryo_vision_backend.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

class ObjectMapperTest {


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
        OrderDto orderDTO = ObjectMapper.map(order, OrderDto.class);

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

        ProjectCodeNameDto projectCodeNameDto = new ProjectCodeNameDto();
        projectCodeNameDto.setCustomerClassificationCodeName("금융권");
        projectCodeNameDto.setYearCodeName("2018");
        projectCodeNameDto.setCustomerCompanyName("한국가스공사");
        projectCodeNameDto.setGenderCodeName("공용");
        projectCodeNameDto.setProductTypeCodeName("근무복");
        projectCodeNameDto.setSeasonCodeName("하계");
        Project project = ObjectMapper.map(projectCodeNameDto, Project.class);

        assertThat(project.getCustomerClassificationCodeName(), is(projectCodeNameDto.getCustomerClassificationCodeName()));
        assertThat(project.getCustomerCompany().getName(), is(projectCodeNameDto.getCustomerCompanyName()));
        assertThat(project.getGenderCodeName(), is(projectCodeNameDto.getGenderCodeName()));
        assertThat(project.getSeasonCodeName(), is(projectCodeNameDto.getSeasonCodeName()));
        assertThat(project.getProductTypeCodeName(), is(projectCodeNameDto.getProductTypeCodeName()));
        assertThat(project.getYearCodeName(), is(projectCodeNameDto.getYearCodeName()));
    }
}
