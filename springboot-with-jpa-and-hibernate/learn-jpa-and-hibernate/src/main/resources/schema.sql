create table course 
(
	id bigint not null, 
--	java long이랑 h2 db bingint형은 매칭된다.

	name varchar(255) not null,
	
	author varchar(255) not null,
	
	primary key (id)

);


