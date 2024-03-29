# Multimodule clean architecture

![architecture](./arch.PNG)

# 요구사항

## 설계

- 도메인별로 모듈 따로 구성
- 레이어별 모듈 구성
- 백오피스와, 프론트 모듈 나누기
- RequestDTO, ResponseDTO는 컨트롤러에서 도메인엔티티로 변경
    - 해당 변경로직은 엔티티에서?
- 도메인 접근은 도메인의 service에서 가능

## 개발

- 입력값 validation
- Auth로 접근제어
- stateless, JWT

## 테스트

- 테스트와 운영 DB 분리
- 로직 체크는 Mockito 이용
- 컨트롤러 테스트 작성
- 커버리지 100%

## 프론트

- 고객
    - 로그인
    - 회원가입, 수정 가능
    - 수정페이지는 로그인시 접근 가능
    - 포인트로 상품 주문 가능
    - 포인트 추가


- 상품
    - 조회
        - 조회시 현 재고 표현
        - 활성화된것만 조회
        - 조회시 label로 검색가능
        - 페이지네이션


- 주문
    - 주문가능
    - 주문 목록 조회


- 재고
    - 재고확인기능

## 백오피스

- 고객
    - 고객 등급별로 조회 가능, 이름 순 정렬
    - 고객 정보 변경


- 상품
    - 상품 등록, 수정, 활성화 상태


- 주문
    - 고객이 주문한 내역
    - 고객별로 주문 조회 가능,
    - 주문 날짜별 조회 가능
    - 상품별 주문 조회
    - 주문, 주문수정 가능
        - 백오피스에서는 재고에 구애받지 않음, but 재고가 감소


- 재고
    - 상품별 재고 구성
    - 주문시 재고가 감소하도록 구성
    - 주문시 해당 재고가 부족하면 주문 불가
    - 판매단위별로 재고 감소 정책 다르게
    - 재고가 설정값 이하일시 알림
    - 재고가 부족하더라도 주문 가능

## 도메인

- 고객(CUSTOMER)
    - 이름, 주소, 포인트, 등급, id, pw
    - ID, PW, LABEL, ADDRESS, POINT, GRADE,

- 주문(ORDER)
    - 고객, 주문상태, 주문 총 가격,
    - CUSTOMER_ID, STATUS, TOTAL_COST

- 주문 엔트리(ORDER_ENTRY)
    - 주문_ID, 상품_ID, 주문시 상품가격
    - ORDER_ID, PRODUCT_ID, PRICE

- 상품(PRODUCT)
    - 이름, 가격, 설명
    - LABEL, PRICE, DETAIL

- 재고(STOCK)
    - 상품_ID, 남은 수량
    - PRODUCT_ID, QANTITY
    - 상품 연관관계, 연결안될수도, 갯수

## 추후 작업

- 쿠폰기능 추가,
- Hibernate 6.0 spring Data 지원시 Filter사용해보기
- 데이터주도개발
- reactive로 전환
- MSA..??
- 판매단위가 KG인 상품과 수량인 상품 구분
- 가격 계산 방식이 다르도록 구성