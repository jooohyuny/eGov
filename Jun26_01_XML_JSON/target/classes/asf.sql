create table jun261_snack(
	s_name varchar2(20 char) not null,
	s_price number(6) not null
);

insert into jun261_snack
values('초코파이',5000);
insert into jun261_snack
values('초코칩',3000);

select * from jun261_snack order by s_name;

create table jun27_menu(
	m_name varchar2(10 char) primary key,
	m_price number(5) not null
);

insert into jun27_menu
values('제육덮밥', 7000);
insert into jun27_menu
values('돈까스덮밥', 7000);
insert into jun27_menu
values('불고기덮밥', 7000);
insert into jun27_menu
values('치킨마요덮밥', 7000);
insert into jun27_menu
values('야채김밥', 4000);
insert into jun27_menu
values('참치김밥', 4500);
insert into jun27_menu
values('멸치김밥', 5000);
insert into jun27_menu
values('우동', 5500);
insert into jun27_menu
values('어묵우동', 6000);
insert into jun27_menu
values('유부우동', 6500);
insert into jun27_menu
values('회덮밥', 9900);
insert into jun27_menu
values('알탕', 8900);
insert into jun27_menu
values('알밥', 8500);
insert into jun27_menu
values('닭갈비', 12000);
insert into jun27_menu
values('부대찌개', 11000);
insert into jun27_menu
values('김치찌개', 10000);
insert into jun27_menu
values('된장찌개', 9000);
insert into jun27_menu
values('된장찌개', 9000);
insert into jun27_menu
values('비빔밥', 7800);
insert into jun27_menu
values('참치비빔밥', 8600);
insert into jun27_menu
values('소고기비빔밥', 9700);
insert into jun27_menu
values('김치볶음밥', 7400);



select * from jun27_menu;

select * from jun27_menu
where m_price<=6000
order by m_name;
