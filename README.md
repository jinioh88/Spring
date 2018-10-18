## 테스트환경
1. spring boot
2. mysql 5.6.41
3. Maven
4. JPA
5. Thymeleaf

## 폴더구조
main
  - java
    - contoller
        - api
    - domain
    - persistence
    - service
  - resources
    - templates
    - data.sql


test
  
----
1. data.sql로 goods, options, shipping 데이터를 미리 넣어놨습니다.
2. 스프링 MVC 방식으로 개발하였습니다.
3. 상품목록 조회, 장바구니, 장바구니 수정을 작업하였습니다.
  