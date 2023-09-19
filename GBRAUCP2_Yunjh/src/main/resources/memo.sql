-----게시판
create table gbraucp2y_sns(
	ys_no number(4) primary key,
	ys_writer varchar2(10 char) not null,
	ys_txt varchar2(500 char) not null,
	ys_date date not null,
	ys_color char(6 char) not null,
	constraint sns2_writer
		foreign key (ys_writer) references gbraucp2y_member(ym_id)
		on delete cascade
);
create sequence gbraucp2y_sns_seq;
----------------------------------------------