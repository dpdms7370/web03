create table board1 (bno number primary key, bobe varchar(300), bsub varchar(700) , bw varchar(50), bdate date);

insert into board1 values (1, '게시글 1 입니다.','게시글1의 상세내용 입니다.','admin','2022-5-23');


insert into board1 values ((select nvl(max(bno), 0)+1 from board1), '게시글 2 입니다.','게시글2의 상세내용 입니다.','admin',sysdate);

insert into board1 values ((select nvl(max(bno), 0)+1 from board1), '게시글 3 입니다.','게시글3의 상세내용 입니다.','admin',sysdate);
insert into board1 values ((select nvl(max(bno), 0)+1 from board1), '게시글 4 입니다.','게시글4의 상세내용 입니다.','admin',sysdate);
insert into board1 values ((select nvl(max(bno), 0)+1 from board1), '게시글 5 입니다.','게시글5의 상세내용 입니다.','admin',sysdate);


select * from board1;
commit;
--------------------------------------------------
create table member1 (mno number , mid varchar(50) primary key,mpw varchar(200),mname varchar(30),mcall varchar(50),madd varchar(100),mdate date);



insert into member1 values ((select nvl(max(mno), 0)+1 from member1),'aaa','aaa','회원1','010-0000-0000','미국',sysdate);

insert into member1 values ((select nvl(max(mno), 0)+1 from member1),'bbb','bbb','회원2','010-1111-1111','미국',sysdate);
insert into member1 values ((select nvl(max(mno), 0)+1 from member1),'ccc','ccc','회원3','010-2222-2222','미국',sysdate);
insert into member1 values ((select nvl(max(mno), 0)+1 from member1),'ddd','ddd','회원4','010-3333-3333','미국',sysdate);
insert into member1 values ((select nvl(max(mno), 0)+1 from member1),'eee','eee','회원5','010-4444-4444','미국',sysdate);

select * from member1;
commit;

------------------------------------------------------


create table product (pno number, pname varchar(50) primary key, psub varchar(300), pcost varchar(200));

insert into product values((select nvl(max(pno), 0)+1 from product), '상품1','상품1설명','상품1가격: 1000원');

insert into product values((select nvl(max(pno), 0)+1 from product), '상품2','상품2설명','상품2가격: 2000원');
insert into product values((select nvl(max(pno), 0)+1 from product), '상품3','상품3설명','상품3가격: 3000원');
insert into product values((select nvl(max(pno), 0)+1 from product), '상품4','상품4설명','상품4가격: 4000원');
insert into product values((select nvl(max(pno), 0)+1 from product), '상품5','상품5설명','상품5가격: 5000원');

select * from product;

commit;
