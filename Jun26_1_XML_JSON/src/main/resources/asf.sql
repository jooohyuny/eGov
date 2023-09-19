create table jun261_snack(
	s_name varchar2(20 char) not null,
	s_price number(6) not null
);

insert into jun261_snack
values('초코파이',5000);
insert into jun261_snack
values('초코칩',3000);

select * from jun261_snack order by s_name;