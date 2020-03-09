package com.example.miryo_vision_backend.service.project;

import com.example.miryo_vision_backend.controller.dto.UiDto;
import com.example.miryo_vision_backend.service.project.enums.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

// fixme: MapStruct 1.3.1에서 lombok의 @Builder가 작동이 안된다.
//        현재 이 문제에 대해 버깅을 하고 있다. -> 1.4.0. 버전이 나올 것이다.
//        1.4.0. 버전이 나오면 "immutable" Dto 클래스를 만들기 위해 아래와 같이 annotation 바꾸기
//        @Value
//        @Builder
//        @AllArgsConstructor(access = AccessLevel.PRIVATE)



public enum ProjectDto {;

    private interface Id{
        Long getId();
    }

    private interface CustomerClassification{
        CustomerClassificationEnum getCustomerClassification();
    }
    private interface Year {
        YearEnum getYear();
    }
    private interface Gender{
        GenderEnum getGender();
    }
    private interface Season{
        SeasonEnum getSeason();
    }
    private interface ProductType{
        ProductTypeEnum getProductType();
    }

    private interface Barcode {
        String getBarcode();
    }
    private interface PlantCode{
        String getPlantCode();
    }
    private interface Name{
        String getName();
    }
    private interface StartDatetime{
        String getStartDatetime();
    }
    private interface FairStatus{
        FairStatusEnum getFairStatus();
    }
    private interface FairResultDatetime{
        String getFairResultDatetime();
    }

    private interface CustomerCompany {
        String getCustomerCompany();
    }
    private interface CustomerCompanyId {
        Long getCustomerCompanyId();
    }

    private interface SalesDepartEmployeeInCharge{
        String getSalesDepartEmployeeInCharge();
    }
    private interface SalesDepartEmployeeInChargeId{
        Long getSalesDepartEmployeeInChargeId();
    }
    private interface LogisticsDepartEmployeeInCharge{
        String getLogisticsDepartEmployeeInCharge();
    }
    private interface LogisticsDepartEmployeeInChargeId{
        Long getLogisticsDepartEmployeeInChargeId();
    }
    private interface ProductionDepartEmployeeInCharge{
        String getProductionDepartEmployeeInCharge();
    }
    private interface ProductionDepartEmployeeInChargeId{
        Long getProductionDepartEmployeeInChargeId();
    }
    private interface DesignDepartEmployeeInCharge{
        String getDesignDepartEmployeeInCharge();
    }
    private interface DesignDepartEmployeeInChargeId{
        Long getDesignDepartEmployeeInChargeId();
    }
    private interface AccountingDepartEmployeeInCharge{
        String getAccountingDepartEmployeeInCharge();
    }
    private interface AccountingDepartEmployeeInChargeId{
        Long getAccountingDepartEmployeeInChargeId();
    }

    public enum Request {;
        @Data
        public static class Create
                implements CustomerClassification,Year,Gender,Season,ProductType,
                CustomerCompanyId,SalesDepartEmployeeInChargeId,
                LogisticsDepartEmployeeInChargeId,ProductionDepartEmployeeInChargeId,
                DesignDepartEmployeeInChargeId,AccountingDepartEmployeeInChargeId {
            CustomerClassificationEnum customerClassification;
            YearEnum year;
            GenderEnum gender;
            SeasonEnum season;
            ProductTypeEnum productType;

            Long customerCompanyId;

            Long salesDepartEmployeeInChargeId;
            Long logisticsDepartEmployeeInChargeId;
            Long productionDepartEmployeeInChargeId;
            Long designDepartEmployeeInChargeId;
            Long accountingDepartEmployeeInChargeId;
        }
        @Data
        public static class Search
                implements CustomerClassification,Year,Gender,Season,ProductType,
                CustomerCompanyId,SalesDepartEmployeeInChargeId,LogisticsDepartEmployeeInChargeId,
                ProductionDepartEmployeeInChargeId,DesignDepartEmployeeInChargeId,
                AccountingDepartEmployeeInChargeId,FairStatus {
            CustomerClassificationEnum customerClassification;
            YearEnum year;
            GenderEnum gender;
            SeasonEnum season;
            ProductTypeEnum productType;

            Long customerCompanyId;

            Long salesDepartEmployeeInChargeId;
            Long logisticsDepartEmployeeInChargeId;
            Long productionDepartEmployeeInChargeId;
            Long designDepartEmployeeInChargeId;
            Long accountingDepartEmployeeInChargeId;

            FairStatusEnum fairStatus;
        }

        @Data
        public static class Update
                implements Id,
                SalesDepartEmployeeInChargeId,LogisticsDepartEmployeeInChargeId,
                ProductionDepartEmployeeInChargeId,DesignDepartEmployeeInChargeId,
                AccountingDepartEmployeeInChargeId,FairStatus {
            Long id;

            Long salesDepartEmployeeInChargeId;
            Long logisticsDepartEmployeeInChargeId;
            Long productionDepartEmployeeInChargeId;
            Long designDepartEmployeeInChargeId;
            Long accountingDepartEmployeeInChargeId;

            FairStatusEnum fairStatus;
        }

        @Data
        public static class Delete
                implements Id {
            Long id;
        }

    }
    @Data
    public static class Response
            implements UiDto.TableRow.ListIndex,
            CustomerClassification,Year,Gender,Season,ProductType,
            Barcode,PlantCode,Name,StartDatetime,FairStatus,FairResultDatetime,
            CustomerCompany,SalesDepartEmployeeInCharge,LogisticsDepartEmployeeInCharge,
            ProductionDepartEmployeeInCharge,DesignDepartEmployeeInCharge,AccountingDepartEmployeeInCharge {
        Integer listIndex;

        CustomerClassificationEnum customerClassification;
        YearEnum year;
        GenderEnum gender;
        SeasonEnum season;
        ProductTypeEnum productType;


        String barcode;
        String plantCode;
        String name;
        String startDatetime;
        FairStatusEnum fairStatus;
        String fairResultDatetime;

        String customerCompany;

        String salesDepartEmployeeInCharge;
        String logisticsDepartEmployeeInCharge;
        String productionDepartEmployeeInCharge;
        String designDepartEmployeeInCharge;
        String accountingDepartEmployeeInCharge;
    }


    public enum UiSelect{;
        private interface CustomerClassificationList{
            @JsonProperty(value = "customerClassification")
            List<UiDto.Option.WithCode> getCustomerClassificationList();
        }
        private interface YearList{
            @JsonProperty(value = "year")
            List<UiDto.Option.WithCode> getYearList();
        }
        private interface CustomerCompanyList{
            @JsonProperty(value = "customerCompany")
            List<UiDto.Option.WithIdAndCode> getCustomerCompanyList();
        }
        private interface GenderList{
            @JsonProperty(value = "gender")
            List<UiDto.Option.WithCode> getGenderList();
        }
        private interface SeasonList{
            @JsonProperty(value = "season")
            List<UiDto.Option.WithCode> getSeasonList();
        }
        private interface ProductTypeList{
            @JsonProperty(value = "productType")
            List<UiDto.Option.WithCode> getProductTypeList();
        }


        private interface SalesDepartEmployeeInChargeList{
            @JsonProperty(value = "salesDepartEmployeeInCharge")
            List<UiDto.Option.WithId> getSalesDepartEmployeeInChargeList();
        }
        private interface LogisticsDepartEmployeeInChargeList{
            @JsonProperty(value = "logisticsDepartEmployeeInCharge")
            List<UiDto.Option.WithId> getLogisticsDepartEmployeeInChargeList();
        }
        private interface ProductionDepartEmployeeInChargeList {
            @JsonProperty(value = "productionDepartEmployeeInCharge")
            List<UiDto.Option.WithId> getProductionDepartEmployeeInChargeList();
        }
        private interface DesignDepartEmployeeInChargeList{
            @JsonProperty(value = "designDepartEmployeeInCharge")
            List<UiDto.Option.WithId> getDesignDepartEmployeeInChargeList();
        }
        private interface AccountingDepartEmployeeInChargeList{
            @JsonProperty(value = "accountingDepartEmployeeInCharge")
            List<UiDto.Option.WithId> getAccountingDepartEmployeeInChargeList();
        }
        private interface FairStatusList{
            @JsonProperty(value = "fairStatus")
            List<UiDto.Option.KoreanSearchable> getFairStatusList();
        }

        @Data
        public static class All
                implements CustomerClassificationList,YearList,GenderList,SeasonList,ProductTypeList,
                CustomerCompanyList,SalesDepartEmployeeInChargeList,LogisticsDepartEmployeeInChargeList,
                ProductionDepartEmployeeInChargeList,DesignDepartEmployeeInChargeList,
                AccountingDepartEmployeeInChargeList, FairStatusList{
            List<UiDto.Option.WithCode> customerClassificationList;
            List<UiDto.Option.WithCode> yearList;
            List<UiDto.Option.WithCode> genderList;
            List<UiDto.Option.WithCode> seasonList;
            List<UiDto.Option.WithCode> productTypeList;
            List<UiDto.Option.WithIdAndCode> customerCompanyList;

            List<UiDto.Option.WithId> salesDepartEmployeeInChargeList;
            List<UiDto.Option.WithId> logisticsDepartEmployeeInChargeList;
            List<UiDto.Option.WithId> productionDepartEmployeeInChargeList;
            List<UiDto.Option.WithId> designDepartEmployeeInChargeList;
            List<UiDto.Option.WithId> accountingDepartEmployeeInChargeList;
            List<UiDto.Option.KoreanSearchable> fairStatusList;
        }

        @Data
        public static class Create
                implements CustomerClassificationList,YearList,GenderList,SeasonList,ProductTypeList,
                CustomerCompanyList,SalesDepartEmployeeInChargeList,LogisticsDepartEmployeeInChargeList,
                ProductionDepartEmployeeInChargeList,DesignDepartEmployeeInChargeList,AccountingDepartEmployeeInChargeList{
            List<UiDto.Option.WithCode> customerClassificationList;
            List<UiDto.Option.WithCode> yearList;
            List<UiDto.Option.WithCode> genderList;
            List<UiDto.Option.WithCode> seasonList;
            List<UiDto.Option.WithCode> productTypeList;
            List<UiDto.Option.WithIdAndCode> customerCompanyList;

            List<UiDto.Option.WithId> salesDepartEmployeeInChargeList;
            List<UiDto.Option.WithId> logisticsDepartEmployeeInChargeList;
            List<UiDto.Option.WithId> productionDepartEmployeeInChargeList;
            List<UiDto.Option.WithId> designDepartEmployeeInChargeList;
            List<UiDto.Option.WithId> accountingDepartEmployeeInChargeList;
        }
        @Data
        public static class Search
                implements CustomerClassificationList,YearList,GenderList,SeasonList,ProductTypeList,
                CustomerCompanyList,SalesDepartEmployeeInChargeList,LogisticsDepartEmployeeInChargeList,
                ProductionDepartEmployeeInChargeList,DesignDepartEmployeeInChargeList,
                AccountingDepartEmployeeInChargeList, FairStatusList{
            List<UiDto.Option.WithCode> customerClassificationList;
            List<UiDto.Option.WithCode> yearList;
            List<UiDto.Option.WithCode> genderList;
            List<UiDto.Option.WithCode> seasonList;
            List<UiDto.Option.WithCode> productTypeList;
            List<UiDto.Option.WithIdAndCode> customerCompanyList;

            List<UiDto.Option.WithId> salesDepartEmployeeInChargeList;
            List<UiDto.Option.WithId> logisticsDepartEmployeeInChargeList;
            List<UiDto.Option.WithId> productionDepartEmployeeInChargeList;
            List<UiDto.Option.WithId> designDepartEmployeeInChargeList;
            List<UiDto.Option.WithId> accountingDepartEmployeeInChargeList;
            List<UiDto.Option.KoreanSearchable> fairStatusList;
        }
        @Data
        public static class Update
                implements SalesDepartEmployeeInChargeList,LogisticsDepartEmployeeInChargeList,
                ProductionDepartEmployeeInChargeList,DesignDepartEmployeeInChargeList,
                AccountingDepartEmployeeInChargeList, FairStatusList{
            List<UiDto.Option.WithId> salesDepartEmployeeInChargeList;
            List<UiDto.Option.WithId> logisticsDepartEmployeeInChargeList;
            List<UiDto.Option.WithId> productionDepartEmployeeInChargeList;
            List<UiDto.Option.WithId> designDepartEmployeeInChargeList;
            List<UiDto.Option.WithId> accountingDepartEmployeeInChargeList;
            List<UiDto.Option.KoreanSearchable> fairStatusList;
        }
    }

}
