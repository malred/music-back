create database if not exists music;
use music;
create table if not exists blogs
(
	id int auto_increment,
	uid varchar(50) not null comment '作者id',
	content longtext not null comment '存富文本(LONGTEXT: 极大文本数据)',
	title varchar(50) not null comment '文章标题',
	cover varchar(255) null comment '文章封面',
	createday date null comment '创建时间',
	constraint blogs_id_uindex
		unique (id)
);

alter table blogs
	add primary key (id);

create table if not exists friends
(
	id int auto_increment,
	uid varchar(50) not null,
	fid varchar(50) not null,
	`group` varchar(25) default '默认' not null,
	constraint friends_id_uindex
		unique (id)
);

alter table friends
	add primary key (id);

create table if not exists muser
(
	id varchar(25) not null,
	uname varchar(20) not null,
	upass varchar(20) not null,
	constraint muser_id_uindex
		unique (id),
	constraint muser_uname_uindex
		unique (uname)
);

alter table muser
	add primary key (id);

create table if not exists muser_info
(
	id varchar(25) not null,
	name varchar(20) null comment '真实姓名',
	age int null,
	birth date null,
	createday date null comment '账户创建时间,在注册时自动生成',
	location varchar(20) null,
	img varchar(255) null,
	sex char default '无' not null,
	constraint muser_info_id_uindex
		unique (id)
);

alter table muser_info
	add primary key (id);

create table if not exists muser_like
(
	id varchar(255) not null,
	mid varchar(255) not null,
	uid varchar(255) not null,
	constraint user_like_id_uindex
		unique (id)
);

alter table muser_like
	add primary key (id);

create table if not exists music_info
(
	mid varchar(255) not null,
	mname varchar(255) not null,
	pic_url varchar(255) null comment '歌曲封面',
	arname varchar(255) not null comment '歌手名字',
	constraint music_info_mid_uindex
		unique (mid)
);

