create table jun13_coffee(
	c_name varchar2(10 char) primary key,
	c_price number(4) not null
);
	
insert into jun13_coffee values('아메리카노', 5000);
insert into jun13_coffee values('카페라떼', 5500);

select * from jun13_coffee;

delete from jun13_coffee 
where c_name like '%'||#{c_name}||'%'

-- db작업은 위험
-- 작업 -> commit해야 실제 서버에 반영/rollback하면 취소
-- 이클립스/JDBC/Connection Pool이 자동 commit이었음