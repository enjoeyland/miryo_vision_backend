# 1. 기본 UI 수신 형식

## 1.1. Response Data 형식:
Data Format: controller.dto.ResponseDto
```json
{
    "msg":"",
    "code":"",
    "status":true, //boolen type
    "data": {}
}
```





# 2. Project Search Page
## 2.1. Get search page data

URL: /project/search/initData

Method: GET

Data Format: service.project.dto.ProjectSearchInitDataDto

```json
{
    "msg":"",
    "code":"",
    "status":true,
    "data":{
        "year": [
            {
                "value": "2018",
                "key": "3",
                "text": "Y2018",
                "code": "D"
            }
        ],
        "season": [],
        "customerCompany": [],
        "fairStatus": [],
        "designDepartEmployeeInCharge":[]

    }
}
```

## 2.2. Get search result data
###2.2.1 Request From UI 
URL:/project/search

Method: GET //논의을 해봐야함

Data Format: service.project.dto.ProjectSearchRequestDto

```json
{
    "designDepartEmployeeInCharge": "",
    "year": "",
    "season": "",
    "customerCompany": "",
    "fairStatus": ""
}
```

###2.2.2 Repense From Server 

Data Format: 
* controller.dto.TableWithFilterDto
* controller.dto.FilterDto
* service.project.dto.ProjectResponseDto

```json
{
    ...

    "data":{
        "dataSource":{
             "dataSource": [
                 {
                     "key": "5", //중요
                     
                     "customerClassification": "일반사",
                     "year": "2019",
                     "gender": "공용",
                     "season": "사계절",
                     "productType": "복지품",
                     "barcode": "GE02U4B031",
                     "plantCode": null,
                     "name": null,
                     "startDatetime": null,
                     "fairStatus": "LOSE",
                     "fairResultDatetime": null,
                     "customerCompany": "한국가스공사",
                     "logisticsDepartEmployeeInCharge": "물류팀장3",
                     "productionDepartEmployeeInCharge": "생산팀장3",
                     "designDepartEmployeeInCharge": "디자인팀장1",
                     "accountingDepartEmployeeInCharge": "경리팀장3",
                     "businessDepartTeam": "영업팀장1"
                 }
        ],
        "filtersData":{
            "customerClassificationFilter": [
                {
                    "disassemble": "ㄱㅡㅁㅇㅠㅇㄱㅝㄴ",
                    "value": "금융권",
                    "text": "금융권"
                }
            ]
        }
     }
}
```
