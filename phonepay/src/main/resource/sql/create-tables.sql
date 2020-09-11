create table if not exists tbl_user_account
(
user_id INTEGER not null primary key AUTOINCREMENT ,
username VARCHAR(30) UNIQUE not null,
email_addr    VARCHAR(50) UNIQUE not null,
password  VARCHAR(50) not null,
user_role VARCHAR(10) not null default 'guest',
user_status VARCHAR(25) not null default 'pending-verification',
phone_num VARCHAR(10),
user_title VARCHAR(50),
first_name VARCHAR(20),
last_name VARCHAR(20),
photo_url VARCHAR(127),
fb_link VARCHAR(50),
tw_link VARCHAR(50),
lk_link VARCHAR(50),
blog_url VARCHAR(127),
user_bio VARCHAR(512),
user_created_ts text not null default(datetime('now'))
);

create table if not exists tbl_category
(
category_id INTEGER not null primary key AUTOINCREMENT ,
category_name VARCHAR(15) not null unique,
category_created_ts text not null default(datetime('now'))
) ;

create table if not exists tbl_media
(
media_id INTEGER not null primary key AUTOINCREMENT ,
media_name text not null,
media_url text not null,
media_type text not null,
media_size integer not null,
media_tags text,
media_created_ts text not null default(datetime('now'))
) ;

create table if not exists tbl_subscriber
(
subscr_email VARCHAR(50) not null unique primary key ,
release_updates boolean not null default 0,
subscr_created_ts text not null default(datetime('now'))
) ;