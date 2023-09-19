-- 혼자해보는 설계 테이블
create table yunjh_gallery(
	yd_no number(3) primary key,
	yd_uploader varchar2(10 char) not null,
	yd_title varchar2(50 char) not null,
	yd_file varchar2(100 char) not null,
	yd_category varchar2(10 char) not null,
	constraint gallery_uploader
		foreign key (yd_uploader) references gbraucp2_member(gm_id)
);


create sequence yunjh_gallery_seq;
-- 위에 두줄은 월요일에 업로드해서 직접 갤러리만들어보기

select * from YUNJH_GALLERY;
-- insert into yunjh_gallery 
-- values(yunjh_gallery_seq.nextval, 'kimm',
--	 	'firstfile', 'rock.png','photo',sysdate);
---------------------------------------------
--자료실
drop table gbraucp2_dataroom;

create table gbraucp2_dataroom(
	gd_no number(3) primary key,
	gd_uploader varchar2(10 char) not null,
	gd_title varchar2(50 char) not null,
	gd_file varchar2(100 char) not null,
	gd_category char(6 char) not null,
	gd_date date not null,
   constraint dataroom_uploader
      foreign key (gd_uploader) references gbraucp2_member(gm_id)
);

create sequence gbraucp2_dataroom_seq;
---------------------------------------------
select * from gbraucp2_dataroom;

---------------------------------------------
SELECT *
FROM (
    SELECT rownum AS rn, gd_no, gd_title, gd_file, gd_category, gd_date
    FROM (
        SELECT gd_no, gd_title, gd_file, gd_category, gd_date
        FROM gbraucp2_dataroom
        ORDER BY gd_date DESC
    )
)
WHERE rn >= 1 AND rn <= 5;
---------------------------------------------
select * 
from gbraucp2_dataroom 
where gd_category = 'E57373'
order by gd_date;



---------------------------------------------
-- 댓글 DB만들기
create table gbraucp2_sns_reply(
	gsr_no number(4) primary key,
	gsr_gs_no number(4) not null,
	gsr_writer varchar2(10 char) not null,
	gsr_txt varchar2(200 char) not null,
	gsr_date date not null,
   constraint sns2_reply_writer
      foreign key (gsr_writer) references gbraucp2_member(gm_id)
      on delete cascade,
	constraint sns2_reply
      foreign key (gsr_gs_no) references gbraucp2_sns(gs_no)
      on delete cascade
);

create sequence gbraucp2_sns_reply_seq;

select * from gbraucp2_sns_reply;
---------------------------------------------
-- 댓글 입력 - 미완성
insert into gbraucp2_sns_reply
values(gbraucp2_sns_reply_seq.nextval,)

---------------------------------------------
-- 날씨에 따른 빅데이터 : 1000만개
-- 64번 데이터를 수정, 삭제?? 빅데이터에서는 primary key가 중요하지 않다
create table gbraucp2_weather_color(
	gwc_temp number(4,2) not null,
	gwc_humidity number(4,2) not null,
	gwc_description varchar2(20 char) not null,
	gwc_color char(6 char) not null
);

select * from gbraucp2_weather_color;

---------------------------------------------
-- 말도 안되는 전체조회
-- 1단계
select gs_no,gs_writer,gs_txt,gs_date,gs_color,gm_photo
from gbraucp2_member,gbraucp2_sns
where gs_writer =gm_id
order by gs_date desc;
---------------------------------------------
-- 2단계
select *
		from(
			select rownum as rn, gs_no, gs_writer,gs_txt,gs_date,gs_color,gm_photo
			from (
				select gs_no,gs_writer,gs_txt,gs_date,gs_color,gm_photo 
				from gbraucp2_member,gbraucp2_sns
				where gs_writer =gm_id
				order by gs_date desc
			)
		)
		where rn >= 2 and rn <=5;
---------------------------------------------
-- 2.5단계
		select *
		from(
			select rownum as rn, gs_no, gs_writer,gs_txt,gs_date,gs_color,gm_photo
			from (
				select gs_no,gs_writer,gs_txt,gs_date,gs_color,gm_photo 
				from gbraucp2_member,gbraucp2_sns
				where gs_writer =gm_id
					and (gs_writer like '%'||#{search}||'%'
					or gs_txt like '%'||#{search}||'%')
				order by gs_date desc
			)
		)
		where rn &gt;= #{start} and rn &lt;=#{end}

---------------------------------------------
-- 날짜역순,2~5번까지 글
select *
from(
	select rownum as rn, gs_no, gs_writer,gs_txt,gs_date,gs_color
	from (
		select * 
		from gbraucp2_sns
		where gs_writer like '%%'or gs_txt like '%%'
		order by gs_date desc
	)
)
where rn >= 2 and rn <=5;
-- 날짜역순,2~5번까지 글을 쓴 사람
select gm_id, gm_photo
from gbraucp2_member
where gm_id in(
	select gs_writer
	from(
		select rownum as rn, gs_writer
		from (
			select gs_writer 
			from gbraucp2_sns
			where gs_writer like '%%'or gs_txt like '%%'
			order by gs_date desc
		)
	)
	where rn >= 2 and rn <=5
);
-- join
select gs_no, gs_writer,gs_txt,gs_date,gs_color,gm_photo
from (
	select *
	from(
		select rownum as rn, gs_no, gs_writer,gs_txt,gs_date,gs_color
		from (
			select * 
			from gbraucp2_sns
			where gs_writer like '%%'or gs_txt like '%%'
			order by gs_date desc
		)
	)
	where rn >= 2 and rn <=5
),(
	select gm_id, gm_photo
	from gbraucp2_member
	where gm_id in(
		select gs_writer
		from(
			select rownum as rn, gs_writer
			from (
				select gs_writer 
				from gbraucp2_sns
				where gs_writer like '%%'or gs_txt like '%%'
				order by gs_date desc
			)
		)
		where rn >= 2 and rn <=5
	)
)
where gs_writer = gm_id
order by gs_date desc;		
---------------------------------------------
-- 삭제 
delete from gbraucp2_sns where gs_no =1;	

-- 조회
select * from gbraucp2_sns;
		
---------------------------------------------
--3단계
select *
from (1)(2)
where gs_writer = gm_id
order by gs_date desc;
---------------------------------------------
--3단계 미완성
select gs_no,gm_id,gm_photo,gs_txt,gs_date,gs_color
from (
   select *
   from (
      select rownum as rn, gs_no,gs_writer,gs_txt,gs_date,gs_color
      from(
         select *
         from gbraucp2_sns
         order by gs_date desc
      )
   )
   where rn>= 2 and rn <=5
),(
   select gm_id, gm_photo
   from gbraucp2_member
   where gm_id in(
      select gs_writer
      from(
         select rownum as rn, gs_no, gs_writer,gs_txt,gs_date,gs_color
         from(
            select *
            from gbraucp2_sns
            order by gs_date desc
         )
      )
      where rn>=2 and rn <= 5   
   )
)
where gs_writer = gm_id
order by gs_date desc;

---------------------------------------------
--????
select gs_no,gm_id,gm_photo,gs_txt,gs_date,gs_color
		from (
			select *
			from (
	      		select rownum as rn, gs_no,gs_writer,gs_txt,gs_date,gs_color
	      		from(
	        		select *
	        		from gbraucp2_sns
	        		where (gs_writer like '%'||#{search}||'%'
					or gs_txt like '%'||#{search}||'%')
	         		order by gs_date desc
	      		)
	   		)
	   where rn &gt;= #{start} and rn &lt;=#{end}
	 ),(
	   select gm_id, gm_photo
	   from gbraucp2_member
	   where gm_id in(
	      select gs_writer
	      from(
	         select rownum as rn, gs_no, gs_writer,gs_txt,gs_date,gs_color
	         from(
	            select *
	            from gbraucp2_sns
	            where (gs_writer like '%'||#{search}||'%'
					or gs_txt like '%'||#{search}||'%')
	            order by gs_date desc
	         )
	      )
		  where rn &gt;= #{start} and rn &lt;=#{end} 
	   )
	)
	where gs_writer = gm_id
		and (gs_writer like '%'||#{search}||'%'
		or gs_txt like '%'||#{search}||'%')
	order by gs_date desc

---------------------------------------------


select *
		from(
			select rownum as rn, gs_no, gs_writer,gs_txt,gs_date,gs_color,gm_photo
			from (
				select gs_no,gs_writer,gs_txt,gs_date,gs_color,gm_photo 
				from gbraucp2_member,gbraucp2_sns
				where gs_writer =gm_id
				order by gs_date desc
			)
		)
		where rn >= 2 and rn <=5;


---------------------------------------------
-----게시판
create table gbraucp2_sns(
	gs_no number(4) primary key,
	gs_writer varchar2(10 char) not null,
	gs_txt varchar2(500 char) not null,
	gs_date date not null,
	gs_color char(6 char) not null,
	constraint sns2_writer
		foreign key (gs_writer) references gbraucp2_member(gm_id)
		on delete cascade
);
create sequence gbraucp2_sns_seq;

select * from gbraucp2_sns;


----------------------------------------------
-- 멤버
create table gbraucp2_member(
	gm_id varchar2(10 char) primary key,
	gm_pw varchar2(10 char) not null,
	gm_name varchar2(10 char) not null,
	gm_birthday date not null,
	gm_address varchar2(200 char) not null,
	gm_photo varchar2(100 char) not null
);

select * from gbraucp2_member;

----------------------------------------
-- 현재 날씨에 따라서 색깔 DB에 저장 -- openweatherDB를 이용
-- https://api.openweathermap.org/data/2.5/weather?q=seoul
-- &appid=baff8f3c6cbc28a4024e336599de28c4&units=metric&lang=kr