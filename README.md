# Currency Project

## 구현 레벨 
Lv 0. API 명세 및 ERD 작성 


Lv 1. 고객(User)과 통화(Currency) 복잡한 연관관계 


Lv 2. 환전 요청 CRUD 


Lv 3. 예외 처리 


## ERD
![image](https://github.com/user-attachments/assets/05b82dab-8ec2-4e6d-95e4-679186c5dc70)


## API명세

### 통화 관리 (Currency)

| 기능                  | URL                     | Method | 요청 예시                                                                 | 응답 예시                                                                 |
|---------------------|-------------------------|--------|-----------------------------------------------------------------------|-----------------------------------------------------------------------|
| 모든 통화 조회           | /currencies           | GET    |                                                                    | [{"id": 1, "currencyName": "USD", "exchangeRate": 1430.00, "symbol": "$"}, ...] |
| 특정 통화 조회           | /currencies/{id}      | GET    |                                                                   | {"id": 1, "currencyName": "USD", "exchangeRate": 1430.00, "symbol": "$"} |
| 통화 생성              | /currencies           | POST   | {"currencyName": "USD", "exchangeRate": 1430.00, "symbol": "$"}     | {"id": 3, "currencyName": "USD", "exchangeRate": 1430.00, "symbol": "$"} |

### 환전 요청 관리 (Exchange Request)

| 기능                            | URL                                 | Method | 요청 예시                                                                | 응답 예시                                                                 |
|-------------------------------|-------------------------------------|--------|-----------------------------------------------------------------------|-----------------------------------------------------------------------|
| 환전 요청 생성                     | /exchange-requests                | POST   | {"userId": 1, "toCurrencyId": 1, "amountInKrw": 10000}             | {"id": 1, "userId": 1, "toCurrencyId": 1, "amountInKrw": 10000, "amountAfterExchange": 6.99, "status": "normal"} |
| 특정 사용자에 대한 환전 요청 조회       | /exchange-requests/user/{userId}  | GET    |                                                                    | [{"id": 1, "userId": 1, "toCurrencyId": 1, "amountInKrw": 10000, "amountAfterExchange": 6.99, "status": "normal"}, ...] |
| 환전 요청 취소                     | /exchange-requests/{id}/cancel    | PUT    |                                                                    | {"id": 1, "userId": 1, "toCurrencyId": 1, "amountInKrw": 10000, "amountAfterExchange": 6.99, "status": "cancelled"} |
| 특정 사용자에 대한 모든 환전 요청 삭제 | /exchange-requests/user/{userId}  | DELETE |                                                                   | "Customer and their exchange requests deleted successfully."        |

### 사용자 관리 (User)

| 기능                  | URL                  | Method | 요청 예시                                               | 응답 예시                                                               |
|---------------------|----------------------|--------|-------------------------------------------------------|-----------------------------------------------------------------------|
| 모든 사용자 조회         | /users             | GET    |                                                    | [{"id": 1, "name": "John Doe", "email": "john.doe@example.com"}, ...] |
| 특정 사용자 조회         | /users/{id}        | GET    |                                                    | {"id": 1, "name": "John Doe", "email": "john.doe@example.com"}       |
| 사용자 생성            | /users            | POST   | {"name": "John Doe", "email": "john.doe@example.com"} | {"id": 2, "name": "John Doe", "email": "john.doe@example.com"}       |
| 사용자 삭제            | /users/{id}        | DELETE |                                                    | "정상적으로 삭제되었습니다."                                             |
