
create table user(
id bigint auto_increment comment '用户主键ID',
name varchar(250) not null comment '用户名称',
primary key (id)
) engine=InnoDB auto_increment=1 default charset=utf8 ;