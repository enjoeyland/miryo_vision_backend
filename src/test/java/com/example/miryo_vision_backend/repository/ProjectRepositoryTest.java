package com.example.miryo_vision_backend.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProjectRepositoryTest {
    @Autowired
    ProjectRepository projectRepository;

//    @Test
//    void findByYearCodeAndCustomerCo() {
//        CodeDto yearCodeDto = new CodeDto();
//        yearCodeDto.setCode("D");
////        yearCodeDto.setName("2018");
//        CodeDto customerCoDto = new CodeDto();
//        customerCoDto.setCode("2");
////        customerCoDto.setName("한국가스공사"); // hint : @id에 데이터 없이는 안됨
//
//        YearCode yearCode = yearCodeService.mapWithEntity(yearCodeDto);
//        CustomerCo customerCo = ObjectMapper.map(customerCoDto, CustomerCo.class);
//

//        List<Project> testingProject = projectRepository.findByYearCodeAndCustomerCo(yearCode, customerCo);
//        Project verifingProject = projectRepository.findById(1L).orElseThrow(() -> new EntityNotFoundException("1L"));
//        assertThat(testingProject.get(0).toString(), is(verifingProject.toString()));
//
//
//    }

//    @Test
//    void findByCustomerCoName() {
//        List<Project> testingProject = projectRepository.findByCustomerCoName("한국가스공사");
//        Project verifingProject = projectRepository.findById(1L).orElseThrow(() -> new EntityNotFoundException("1L"));
//        assertThat(testingProject.get(0).toString(), is(verifingProject.toString()));
//
//    }

//    @Test
//    void findByYearCodeNameAndCustomerCompanyName() {
//        List<Project> testingProject = projectRepository.findByYearCodeNameAndCustomerCompanyName("2018", "한국가스공사");
//        Project verifingProject = projectRepository.findById(1L).orElseThrow(() -> new EntityNotFoundException("1L"));
//        assertThat(testingProject.get(0).toString(), is(verifingProject.toString()));
//    }

    @Test
    void save() {
        //hint: 문제상황: save 할때, (foreign key로 갖고 있는) Entity에 PK값(@Id값)이 null일 때 에러
        //               org.hibernate.TransientPropertyValueException: object references an unsaved transient instance - save the transient instance before flushing
        //      해결방안: Entity에 PK값를 채우기
    }
}
