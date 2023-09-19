create table yunwebproject_member(
	ym_id varchar2(20 char) primary key,
	ym_pw varchar2(20 char) not null,
	ym_name varchar2(10 char) not null,
	ym_birthday date not null,
	ym_addr varchar2(100 char) not null,
	ym_photo varchar2(100 char) not null
);
-------------------------------------------------------
select * from yunwebproject_member;

-- 로그인
-- 입력한 id/pw랑
-- db에 있는 id/pw랑 비교

-- 1)모든 계정 다 가져와서
-- DAO에서 for + if로 비교
-- 계정이 많으면.. -> 탈
-- 2) id/pw 맞는 계정만 가져와서
-- DAO에서 로그인 성공처리하자
-- SQL injection공격에 취약
select *
from yunwebproject_member
where ym_id = 'test' abd ym_pw = 'a1111';

-- 3) id맞는 계정만 가져와서
-- DAO에서 비번검사
select *
from yunwebproject_member
where ym_id = 'test';

-- 탈퇴했을때 글 삭제? - 이거는 알아서 하기
-- 삭제를 할거면 외래키 constraint 를 주면 편하다
create table yunwebproject_sns(
	ys_no number(3) primary key,
	ys_writer varchar2(10 char) not null,
	ys_txt varchar2(300 char) not null,
	ys_date date not null,
	constraint sns_writer2
		foreign key (ys_writer) references yunwebproject_member(ym_id)
		on delete cascade
);
create sequence yunwebproject_sns_seq;
-------------------------------------------------------
insert into yunwebproject_sns
values(yunwebproject_sns_seq.nextval, ?, ?, sysdate)
-------------------------------------------------------
select * from yunwebproject_sns;

	
-------------------------------------------------------


select ys_no, ys_writer, ys_txt, ys_date, ym_photo
from yunwebproject_sns, yunwebproject_member
where ys_writer = ym_id
order by ys_date desc;



select ys_no, ys_txt, ys_date, ym_id, ym_photo
from yunwebproject_sns, yunwebproject_member
where ys_writer = ym_id
order by ys_date desc;

select * 
from(
	select rownum as rn, ys_no, ys_txt, ys_date, ym_id, ym_photo 
	from ( 
		select *  
		from yunwebproject_sns, yunwebproject_member
		where ys_writer = ym_id
		order by ys_date desc 
		) 
	) 
where rn >=2 and rn<=5;

--1)



--2) 날짜순역순으로 3~5번 글 쓴 사람 id,프사
select ym_id, ym_photo
from yunwebproject


--3) 1,2 join
select *
from (1)(2)
where ys_writer = ym_id
order by ys_date desc;


--3) 1,2 join  --- 최종 sql문
select ys_no,ym_id,ym_photo,ys_txt,ys_date
from (
   select *
   from (
      select rownum as rn, ys_no,ys_writer,ys_txt,ys_date
      from(
         select *
         from yunwebproject_sns
         order by ys_date desc
      )
   )
   where rn>= 2 and rn <=5
),(
   select ym_id, ym_photo
   from yunwebproject_member
   where ym_id in(
      select ys_writer
      from(
         select rownum as rn, ys_no, ys_writer,ys_txt,ys_date
         from(
            select *
            from yunwebproject_sns
            order by ys_date desc
         )
      )
      where rn>=2 and rn <= 5   
   )
)
where ys_writer = ym_id
order by ys_date desc;

-----------------------------------------------------------------

create table yunwebproject_sns_reply(
   ysr_no number(4) primary key,
   ysr_ys_no number(3) not null,         -- 소속 글 번호
   ysr_writer varchar2(10 char) not null,   -- 댓글쓴 사람 id
   ysr_txt varchar2(100 char) not null,
   ysr_date date not null,
   constraint sns_reply
      foreign key (ysr_ys_no) references yunwebproject_sns(ys_no)
      on delete cascade,
   constraint sns_reply_writer
      foreign key (ysr_writer) references yunwebproject_member(ym_id)
      on delete cascade
);

create sequence yunwebproject_sns_reply_seq;
----------------------------------------------------------------
-- sql
insert into yunwebproject_sns_reply
value(yunwebproject_sns_reply_seq.nextval,?,?,?, sysdate);

select * from yunwebproject_sns_reply;
----------------------------------------------------------------
create table yunwebproject_cw(
	ycw_no number(3) primary key,
	ycw_writer varchar2(10 char) not null,
	ycw_txt varchar2(300 char) not null,
	ycw_date date not null,
	constraint cw_writer2
		foreign key (ycw_writer) references yunwebproject_member(ym_id)
		on delete cascade
);
create sequence yunwebproject_cw_seq;
----------------------------------------------------------------
insert into yunwebproject_cw
values(yunwebproject_cw_seq.nextval,'kimm','싸이월드', sysdate);

select * from yunwebproject_cw;
----------------------------------------------------------------

select ycw_no,ym_id,ym_photo,ycw_txt,ycw_date
from (
   select *
   from (
      select rownum as rn, ycw_no,ycw_writer,ycw_txt,ycw_date
      from(
         select *
         from yunwebproject_cw
         order by ycw_date desc
      )
   )
   where rn>= 2 and rn <=5
),(
   select ym_id, ym_photo
   from yunwebproject_member
   where ym_id in(
      select ycw_writer
      from(
         select rownum as rn, ycw_no, ycw_writer,ycw_txt,ycw_date
         from(
            select *
            from yunwebproject_cw
            order by ycw_date desc
         )
      )
      where rn>=2 and rn <= 5   
   )
)
where ycw_writer = ym_id
order ycw_date desc;
-------------------------------------------------------------------------------------------
--230615 페이지 나누기 첫번째 페이지만 보이도록
-- 1) 먼저 냅다 전체조회(실제로는 이렇게 하지 않음)
select *
from (
	select rownum as rn, ys_no,ys_writer,ys_txt,ys_date,ym_photo
    from(
    	select ys_no, ys_writer, ys_txt, ys_date, ym_photo
    	from yunwebproject_sns, yunwebproject_member
    	where ys_writer = ym_id
    	order by ys_date desc
    )
)
where rn>= 2 and rn <=5;
-------------------------------------------------------------------------------------------
-- 실제 SQL문
select ys_no,ym_id,ym_photo,ys_txt,ys_date
from (
   select *
   from (
      select rownum as rn, ys_no,ys_writer,ys_txt,ys_date
      from(
         select *
         from yunwebproject_sns
         where ys_txt like '%%'
         order by ys_date desc
      )
   )
   where rn>= 2 and rn <=5
),(
   select ym_id, ym_photo
   from yunwebproject_member
   where ym_id in(
      select ys_writer
      from(
         select rownum as rn, ys_no, ys_writer,ys_txt,ys_date
         from(
            select *
            from yunwebproject_sns
            where ys_txt like '%%'
            order by ys_date desc
         )
      )
      where rn>=2 and rn <= 5   
   )
)
where ys_writer = ym_id
order by ys_date desc;
------------------------------------------------------------------
-- 오류 수정본
SELECT ys_no, ym_id, ym_photo, ys_txt, ys_date
FROM (
   SELECT *
   FROM (
      SELECT rownum AS rn, ys_no, ys_writer, ys_txt, ys_date
      FROM (
         SELECT *
         FROM yunwebproject_sns
         WHERE ys_txt LIKE '%%'
         ORDER BY ys_date DESC
      )
   )
   WHERE rn >= 2 AND rn <= 5
), (
   SELECT ym_id, ym_photo
   FROM yunwebproject_member
   WHERE ym_id IN (
      SELECT ys_writer
      FROM (
         SELECT rownum AS rn, ys_no, ys_writer, ys_txt, ys_date
         FROM (
            SELECT *
            FROM yunwebproject_sns
            WHERE ys_txt LIKE '%%'
            ORDER BY ys_date DESC
         )
      )
      WHERE rn >= 2 AND rn <= 5   
   )
)
WHERE ys_writer = ym_id
ORDER BY ys_date DESC;



