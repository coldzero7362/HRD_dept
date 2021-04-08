CREATE TABLE personnel(
	id char(2)NOT NULL PRIMARY KEY,
	name varchar2(30) NOT NULL,
	dept varchar2(20) NOT NULL,
	position char(1),
	duty varchar2(20),
	phone varchar2(14)
)
select * from personnel;
insert into personnel values(95,'박민우','인사부',1,'상무','010-1234-5678');
insert into personnel values(96,'홍길동','경리부',2,'과장','010-3333-4444');
select * from propS$ where NAME LIKE 'NLS_%';
ㄴ
update PERSONNEL set id=?,name=?,dept=?,position=?,duty=?,phone=? where id = ?;

delete PERSONNEL where id=?;
