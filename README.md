# 키친포스

## 요구 사항

### 상품 (Product)

- 상품 생성
    - 이름과 가격을 입력받아 생성한다.
    - 가격은 음수일 수 없다.

- 상품 전체 조회
    - 전체 상품을 조회한다.

### 메뉴 그룹 (MenuGroup)

- 메뉴 그룹 생성
    - 이름을 입력받아 생성한다.

- 메뉴 그룹 전체 조회
    - 전체 메뉴 그룹을 조회한다.

### 메뉴 (Menu)

- 메뉴 생성
    - 이름, 가격, 메뉴 그룹id, 메뉴 상품들(상품id, 수량)을 입력받아 생성한다.
    - 메뉴의 가격은 음수일 수 없다.
    - 메뉴 그룹은 DB에 존재해야한다.
    - 메뉴 상품의 상품은 DB에 존재해야한다.
    - 가격은 (상품 가격 * 수량)의 총 합보다 작아야한다.

- 메뉴 전체 조회
    - 전체 메뉴를 조회한다.

### 주문 (Order)

- 주문 생성
    - 주문 테이블 id, 주문 항목(메뉴 id, 수량) 리스트를 입력받아 생성한다.
    - 주문 항목이 빈 리스트면 예외이다.
    - 주문 항목의 메뉴들은 전부 DB에 존재해야한다.
    - 주문 테이블은 DB에 존재해야한다.
    - 주문의 최초 상태를 조리중(COOKING)으로 설정한다.

- 주문 전체 조회
    - 전체 주문을 조회한다.
    - 주문 조회시 해당 주문의 주문 항목도 함께 조회된다.

- 주문 상태 변경
    - 주문 id와 주문 상태를 입력받아 변경한다.
    - 기존 주문의 상태가 계산 완료(COMPLETION)이면 예외가 발생한다.

### 테이블 (Table)

- 테이블 생성
    - 손님 수, 빈 테이블 여부를 입력받아 생성한다.

- 테이블 리스트 조회
    - 전체 테이블을 조회한다.

- 빈 테이블 여부 변경
    - 주문 테이블 id와 빈 테이블 여부를 입력받아 수정한다.
    - 주문 테이블은 DB에 존재해야한다.
    - 해당 주문 테이블의 테이블 그룹이 있으면 예외이다.
    - 조리중(COOKING)이거나 식사중(MEAL)인 주문이 있으면 예외이다.
    - 주문 테이블의 빈 테이블 여부를 수정한다.

- 손님 수 변경
    - 주문 테이블의 id와 손님 수를 입력받아 수정한다.
    - 손님 수는 음수일 수 없다.
    - 주문 테이블은 DB에 존재해야한다.
    - 주문 테이블의 손님 수를 수정한다.

### 테이블 그룹 (Table Group)

- 테이블 그룹 생성
    - 주문 테이블 id 리스트를 입력받아 생성한다.
    - 주문 테이블은 2개 이상이어야한다.
    - 모든 주문 테이블은 DB에 존재해야한다.
    - 이미 테이블 그룹에 속한 주문 테이블이면 예외가 발생한다.
    - 현재 시간을 테이블 그룹의 생성 시간으로 지정한다.
    - 주문 테이블의 정보를 수정한다.
        - 테이블 그룹 id를 생성한 테이블 그룹의 id로 설정한다.
        - 빈 테이블이 아니도록 설정한다.

- 테이블 그룹 해제
    - 테이블 그룹 id를 입력받아 해당 테이블 그룹을 해제한다.
    - 조리중(COOKING)이거나 식사중(MEAL)인 주문이 있으면 예외가 발생한다.
    - 주문 테이블의 정보를 수정한다.
        - 테이블 그룹 id를 null로 설정한다.
        - 빈 테이블이 아니도록 설정한다.

## 용어 사전

| 한글명      | 영문명              | 설명                            |
|----------|------------------|-------------------------------|
| 상품       | product          | 메뉴를 관리하는 기준이 되는 데이터           |
| 메뉴 그룹    | menu group       | 메뉴 묶음, 분류                     |
| 메뉴       | menu             | 메뉴 그룹에 속하는 실제 주문 가능 단위        |
| 메뉴 상품    | menu product     | 메뉴에 속하는 수량이 있는 상품             |
| 금액       | amount           | 가격 * 수량                       |
| 주문 테이블   | order table      | 매장에서 주문이 발생하는 영역              |
| 빈 테이블    | empty table      | 주문을 등록할 수 없는 주문 테이블           |
| 주문       | order            | 매장에서 발생하는 주문                  |
| 주문 상태    | order status     | 주문은 조리 ➜ 식사 ➜ 계산 완료 순서로 진행된다. |
| 방문한 손님 수 | number of guests | 필수 사항은 아니며 주문은 0명으로 등록할 수 있다. |
| 단체 지정    | table group      | 통합 계산을 위해 개별 주문 테이블을 그룹화하는 기능 |
| 주문 항목    | order line item  | 주문에 속하는 수량이 있는 메뉴             |
| 매장 식사    | eat in           | 포장하지 않고 매장에서 식사하는 것           |
