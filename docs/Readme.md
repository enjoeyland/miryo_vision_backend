# miryo_vision_backend

## 1.전반적 구조


    (WebClient - frontend) - Controller - Service - Repository - DB



### 1.1. Controller

### 1.2. for each Service package
#### 1.2.1. Structure
예를 들어 Project Package 이면
1. Project-Service
2. Project-Predicate
3. Project-EntityConverter
4. Project-InfoCreator
5. DTO들

#### 1.2.2. Service가 하는 일:
기본적으로 DDD에서 제시하는  Business Logic 을 갖는다. 
이 외의 기능을 하기위해 위임을 한다. 
1. Business Logic 을 갖는다.
2. CrudService 를 상속 받는다.
3. to Entity 나 to DTO 에 관련된 일은 ProjectEntityConverter에게 위임한다.
4. Predicate를 만들기 위해 ProjectPredicate에게 위임한다.

#### 1.2.3. ProjectEntityConverter의 주요 기능:
1. toSearchEntity()   - DTO에 있는 데이터를 Entity에게 ModelMapper를 이용하여서 넣어준다.
2. toCompleteEntity() - Repository에서 save 할 수 있도록 데이터를 다 채운다.
                      - 데이터는 ProjectInfoCreator에게서 받아온다.
## 2. 활용기술
1. ModelMapper : Entity 와 DTO 사이 데이터 이동을 자동으로 함
2. QueryDSL : select 관련 query를 쉽게 보낼수 있음. Predicate를 사용하여 2^n만큼의 combination의 경우의 수를 n만큼의 코드로 변환가능
