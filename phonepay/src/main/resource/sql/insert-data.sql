--user accounts
insert into tbl_user_account (username, email_addr, password, user_role, first_name, last_name)
select 'tom', 'tommy@email.com', 'tom001', 'admin', 'thomas', 'spencer'
where not exists (select * from tbl_user_account where user_id = 1);

insert into tbl_user_account (username, email_addr, password, user_role, first_name, last_name)
select 'jerry', 'jerry@email.com', 'jerry001', 'guest', 'Jaremiah', 'Smith'
where not exists (select * from tbl_user_account where user_id = 2);

--categories
insert into tbl_category (category_name)
select 'Uncategorized'
where not exists (select * from tbl_category where category_id = 1);

insert into tbl_category (category_name)
select 'Fiction'
where not exists (select * from tbl_category where category_id = 2);

--media files
insert into tbl_media (media_name, media_url, media_type, media_size)
select 'image1', '/media/profile/image1.png', '.png', 245
where not exists (select * from tbl_media where media_id = 1);

insert into tbl_media (media_name, media_url, media_type, media_size)
select 'image2', '/media/profile/image2.jpeg', '.jpeg', 60
where not exists (select * from tbl_media where media_id = 2);

--subscribers
insert into tbl_subscriber (subscr_email, release_updates)
select 'tommy@email.com', 1
where not exists (select * from tbl_subscriber where subscr_email = 'tommy@email.com');

insert into tbl_subscriber (subscr_email, release_updates)
select 'jerry@email.com', 0
where not exists (select * from tbl_subscriber where subscr_email = 'jerry@email.com');
