
drop table qna;
drop table member;
drop table bbs;
drop table product;
drop table grade;
drop table orderdetails;
drop table reviewboard;
drop table cart;
drop table orders;

drop table member;
CREATE TABLE Member(
    memname VARCHAR2(20) NOT NULL, -- 회원명
    memid VARCHAR2(50) NOT NULL, -- id
    mempw VARCHAR2(40) NOT NULL, -- pw
    memtel VARCHAR2(20) NOT NULL, -- 전화번호
    mememail VARCHAR2(80) NOT NULL, -- 이메일
    address1 VARCHAR2(60) NOT NULL, -- 우편주소
    address2 VARCHAR2(60) NOT NULL, -- 주소
    address3 VARCHAR2(60) NOT NULL, -- 상세주소
    membirth VARCHAR2(20) NOT NULL, -- 생년월일
    grade_name VARCHAR2(20) DEFAULT 'ROOKIE', -- 회원등급
    mem_point NUMBER DEFAULT 0, -- 등급포인트
    CONSTRAINTS mem_memId_pk PRIMARY KEY(memid),
    CONSTRAINTS mem_memTel_ck CHECK(memtel LIKE '010-%-%'),
    CONSTRAINTS mem_gradeName_fk FOREIGN KEY(grade_name) REFERENCES Grade(gname) on delete cascade
); 

UPDATE member
SET mem_point=100000
WHERE memID='aa';

commit;

SELECT *
FROM member;


SELECT * 
FROM GRADE
WHERE gname = (SELECT grade_name FROM MEMBER WHERE memID='aa');

SELECT memid,mempw FROM member;

SELECT *
FROM member;

COMMIT;
drop table product;
select count(*) from product where prdName='asdnkjlsad';
select * from product;
CREATE TABLE PRODUCT (
    cateNum NUMBER NOT NULL, -- 대분류 번호
    cateSubName VARCHAR2(40) NOT NULL, -- 소분류 이름
    prdName VARCHAR2(80) NOT NULL, -- 상품이름
    prdDescription VARCHAR2(2000), -- 상품표현
    prdPrice NUMBER NOT NULL, -- 상품가격
    CONSTRAINT prd_prdName_pk PRIMARY KEY(prdName)
);

drop table cart;
CREATE TABLE Cart(
    memid VARCHAR2(40) NOT NULL, -- 회원아이디
    prdName VARCHAR2(80) NOT NULL, -- 상품이름
    cQuantity NUMBER NOT NULL, -- 상품수량
    product_price NUMBER, -- 상품가격
    CONSTRAINT cart_memId_fk FOREIGN KEY(memid) REFERENCES Member(memid) on delete cascade,
    CONSTRAINT cart_prdName_fk FOREIGN KEY(prdName) REFERENCES Product(prdName) on delete cascade
);

drop table GRADE;
CREATE TABLE GRADE ( -- 등급명, 등급할인, 시작점수, 끝점수
    gName VARCHAR2(20) NOT NULL,
    dcPercent NUMBER NOT NULL,
    startPoint NUMBER NOT NULL,
    endPoint NUMBER,
    CONSTRAINT grade_gName_pk PRIMARY KEY(gName)
);

insert into Grade
values('ROOKIE', 1, 0, 999);

insert into Grade
values('BRONZE', 3, 1000, 9999);

insert into Grade
values('SILVER', 5, 10000, 99999);

insert into Grade
values('GOLD', 8, 100000, 999999);

insert into Grade(gName, dcPercent, startPoint)
values('DIA', 10, 1000000);

select * from grade;

commit;
drop sequence order_num;

CREATE SEQUENCE order_num -- 주문번호 시퀀스
INCREMENT BY 1
START WITH 1
MINVALUE 1
NOMAXVALUE
NOCACHE;

drop table orders;

CREATE TABLE Orders (
    order_num NUMBER NOT NULL, -- 주문번호
    mem_id VARCHAR2(20) NOT NULL, -- 회원 아이디
    address1 VARCHAR2(60) NOT NULL, -- 우편번호
    address2 VARCHAR2(60) NOT NULL, -- 주소
    address3 VARCHAR2(60) NOT NULL, -- 상세주소
    tel VARCHAR2(20) NOT NULL, -- 전화번호
    total_price NUMBER NOT NULL, -- 총 결제금액
    delivery_state VARCHAR2(20) DEFAULT '주문요청', -- 주문상태
    order_date DATE DEFAULT SYSDATE, -- 주문날짜
    delivery_message VARCHAR2(100), -- 배송시 요청사항
    CONSTRAINT orders_orderNum_pk PRIMARY KEY(order_num),
    CONSTRAINT orders_memId_fk FOREIGN KEY(mem_id) REFERENCES Member(memid) on delete cascade
);

drop sequence order_details_num;
CREATE SEQUENCE order_details_num 
INCREMENT BY 1
START WITH 1
MINVALUE 1
NOMAXVALUE
NOCACHE;

drop table orderdetails;
CREATE TABLE OrderDetails (
    order_details_num NUMBER NOT NULL, -- 상세주문 번호
    order_num NUMBER NOT NULL, -- 주문번호
    product_name VARCHAR2(80) NOT NULL, -- 상품명
    product_qty NUMBER NOT NULL, -- 상품수량
    order_price NUMBER NOT NULL, -- 결제금액
    delivery_state VARCHAR2(20) DEFAULT '주문요청', -- 배송현황
    CONSTRAINT orderDetails_orderDetailsNum_pk PRIMARY KEY(order_details_num),
    CONSTRAINT orderDetails_orderNum_fk FOREIGN KEY(order_num) REFERENCES Orders(order_num) on delete cascade
);


select * from orderdetails;
drop table reviewboard;
CREATE TABLE reviewboard ( -- 멤버아이디,후기제품,후기내용,작성날짜
    rid VARCHAR2(20) NOT NULL,
    rproduct VARCHAR2(100),
    review VARCHAR2(4000) NOT NULL,
    rdate DATE DEFAULT SYSDATE,
    CONSTRAINT reviewid_pk FOREIGN KEY(rid) REFERENCES Member(memid) on delete cascade,
    CONSTRAINT rb_productName_fk FOREIGN KEY(rproduct) REFERENCES Product(prdName) on delete cascade
);

insert into orders (order_num, mem_id, address1, address2, address3, tel, total_price, delivery_state, order_date, delivery_message)
values (order_num.nextval, 'gggg', '9999', '서울시 동작구 노량진', 'kg빌딩 2층 201호', '010-1111-1111', 50300, '배송완료', '22/11/1', '부재시 문앞에 놓아주세요' );

insert into orderdetails(order_details_num, order_num, product_name, product_qty, order_price)
values(order_details_num.nextval, order_num.currval, '서해안 참바지락 600g', 1, 6500);

insert into orderdetails(order_details_num, order_num, product_name, product_qty, order_price)
values(order_details_num.nextval, order_num.currval, '자연산 돌멍게 1kg', 1, 17900);

insert into orderdetails(order_details_num, order_num, product_name, product_qty, order_price)
values(order_details_num.nextval, order_num.currval, '구이용 삼치 320g', 1, 7700);

update orderdetails set delivery_state='배송완료' where order_num = 5;

alter table reviewboard drop constraint reviewid_pk;

alter table reviewboard add constraint reviewid_pk FOREIGN KEY(rid) REFERENCES Member(memid) on delete cascade;

commit;
drop table bbs;
select * from bbs;
truncate table bbs;
select max(bbsId) from bbs;

CREATE TABLE BBS( -- 공지사항
bbsID NUMBER,
bbsTitle VARCHAR2(80),
bbsContent VARCHAR2(1000),
bbsDate DATE DEFAULT SYSDATE,
bbsHit NUMBER,
bbsCategory VARCHAR2(40),
memID VARCHAR2(20),
CONSTRAINT bbs_memId_fk FOREIGN KEY(memID) REFERENCES Member(memid) on delete cascade
);
select * from  qna;
drop table qna;
CREATE TABLE qna( -- 1대1 문의
qnaID NUMBER,
qnaTitle VARCHAR2(80),
qnaContent VARCHAR2(1000),
qnaAnswer VARCHAR2(1000),
qnaDate DATE,
qnaCategory VARCHAR2(40),
memID VARCHAR2(50),
CONSTRAINT qna_memId_fk FOREIGN KEY(memID) REFERENCES Member(memid) on delete cascade
);