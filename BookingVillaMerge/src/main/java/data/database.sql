create database `villa_booking`;
use `villa_booking`;
create table `accounts`(
	`account_code` int primary key auto_increment,
    `user_name` varchar(100) not null,
    `password_account` varchar(100) not null,
    `is_delete` bit(1) default 0
);
create table `positions`(
	`position_code` int primary key auto_increment,
    `position_name` varchar(50) not null,
	`is_delete` bit(1) default 0
);
create table `employees`(
	`employee_code` int primary key auto_increment,
    `name` varchar(50) not null,
    `identity_number` varchar(15) not null,
    `birthday` date not null,
    `gender` bit(1) not null,
    `phone_number` varchar(20),
    `email` varchar(50),
    `account_code` int,
    `position_code` int,
    foreign key (`position_code`) references `positions`(`position_code`),
    foreign key (`account_code`) references `accounts`(`account_code`),
	`is_delete` bit(1) default 0
);
create table `customers`(
	`customer_code` int primary key auto_increment,
    `name` varchar(50) not null,
    `identity_number` varchar(15) not null,
    `birthday` date not null,
    `gender` bit(1) not null,
    `phone_number` varchar(20) not null,
    `email` varchar(50) not null,
    `address` varchar(200),
    `account_code` int,
    foreign key (`account_code`) references `accounts`(`account_code`),
	`is_delete` bit(1) default 0
);
create table `villas` (
    `villa_id` int primary key auto_increment,
    `image_map` varchar(200) not null,
    `area` double not null,
    `level` int not null,
    `width` double not null,
    `deep` double not null,
    `garage` int not null,
    `gym_room` int not null,
    `relax_room` int not null,
    `toilet` int not null,
    `living_room` int not null,
    `kitchen_room` int not null,
    `bedroom` int not null,
    `price` int not null,
    `capacity` int not null,
	`is_delete` bit(1) default 0
);
create table `bookings` (
    `booking_id` int primary key auto_increment,
    `booking_time` datetime default current_timestamp,
    `check_in` date not null,
    `check_out` date not null,
    `price` int not null,
    `deposit` int default 0,
	`check_in_person_name` varchar(50),
	`check_in_person_phone_number` varchar(20),
    `villa_id` int,
    `customer_code` int,
    foreign key (`customer_code`) references `customers` (`customer_code`),
    foreign key (`villa_id`) references `villas`(`villa_id`),
    `is_pending` bit(1) default 1,
	`is_delete` bit(1) default 0
);
create table `image_detail_links` (
    `image_id` INT PRIMARY KEY AUTO_INCREMENT,
    `villa_id` INT,
    `image_detail` VARCHAR(200),
    foreign key (`villa_id`) references `villas`(`villa_id`),
	`is_delete` bit(1) default 0
);
create table `seen_time`(
	`role` int primary key,
    `time` datetime
);
insert into `seen_time`(`role`, `time`)
values
	(1, "2023-07-30 13:00:00");
insert into `accounts`(`user_name`, `password_account`)
values
	("nguyenvanan123", "1234ertyhb5"),
	("tranminhdat", "00001eqwrtr"),
	("levanbinh", "23456ertyu"),
	("nguyenngochan", "1111wertyuk2"),
	("admin", "123456abc"),
	("service 1", "123456abc"),
	("service 2", "123456abc"),
	("service 3", "123456abc"); 
insert into `positions`(`position_name`)
values
	("admin"),
    ("customer service");
insert into `customers`(`name`, `identity_number`, `birthday`, `gender`, `phone_number`, `address`, `email`, `account_code`)
values
	("Nguyễn Văn An", "362312342001", "1991-10-03", 0, "0704695457", "10, Đường Nguyễn Du, Thành phố Hà Nội, Tỉnh Hà Nội", "nguyenvana@gmail.com", 1),
	("Trần Minh Đạt", "491111411999", "1998-01-01", 0, "054893500","15, Đường Lê Lợi, Thành phố Đà Nẵng, Tỉnh Đà Nẵng", "bondat9999@gmail.com", 2),
	("Lê Văn Bình", "362300567801", "2000-03-19", 0, "0935578085", "30, Đường Nguyễn Huệ, Thành phố Hồ Chí Minh, Tỉnh Hồ Chí Minh", "levanbinh@gmail.com", 3),
	("Nguyễn Ngọc Hân", "398670012001", "1999-08-18", 1, "0123437963","9, Đường Trần Phú, Thành phố Hội An, Tỉnh Quảng Nam", "nguyenngochan1999@gmail.com", 4);
insert into `employees`(`name`, `identity_number`, `birthday`, `gender`, `phone_number`, `email`, `account_code`,`position_code`)
values
	("Đô Nan Chum", "545601362300", "1991-10-03", 1, "0456453161", "chum@gmail.com", 5, 1),
	("Lê Văn Đỗ Ki", "778921491999", "1998-01-01", 0, "089093134", "levando@gmail.com", 6, 2),
	("Qua Xin Tơn", "789000136230", "2000-03-19", 0, "0556706785", "waxin@gmail.com", 7, 2),
	("Xăm Thủng Coi Như Hỏng", "012001362300", "1999-08-18", 1, "0902356533", "xamthung@gmail.com", 8, 2);
insert into `villas` (`image_map`, `area`, `level`, `width`, `deep`, `garage`, `gym_room`, `relax_room`, `toilet`, `living_room`, `kitchen_room`, `bedroom`, `price`, `capacity`)
values
("https://drive.google.com/uc?id=1nc-sqvrPl7lxW4GggOJZQjyp0a5AC7yo", 540, 3, 15, 12, 0, 0 , 1, 3, 1, 1, 5, 2700000, 5),
("https://drive.google.com/uc?id=1lnQTdeFfqaiwTSDCDR8IRxBmVSQJe_97", 882, 4, 20, 14, 0, 1, 2, 5, 1, 1, 7, 4410000, 10),
("https://drive.google.com/uc?id=13FMm1rmxofoEkBhedjDP16skMh394NVc", 512, 3, 12.5, 20.5, 1, 1, 1, 4, 1, 1, 3, 2560000,5),
("https://drive.google.com/uc?id=1P5X9amlwKkUbMxYe8qstluKu_hmLVDQM", 278, 2, 13.2, 10.5, 0, 0, 0, 4, 1, 1, 4, 1390000, 4),
("https://drive.google.com/uc?id=1Q2N6rGUdt_DAW4JeiEsXdlVFOREW02EJ", 540, 3, 12.5, 20.5, 0, 1, 0, 6, 1, 1, 5, 2700000, 5),
("https://drive.google.com/uc?id=1rR5IICzPMgitkEx9i3OelWfjsIabRFxR", 374, 3, 12, 14, 1, 0, 0, 4, 1, 1, 4, 1870000, 4),
("https://drive.google.com/uc?id=15iuFjzJubATp_yzFWufnr5OTgLxVMiGn", 738, 4, 22.5, 16.3, 0, 1, 0, 5, 1, 1, 6, 3690000, 8),
("https://drive.google.com/uc?id=1IvGoqItZmiMmnkifriCvte_KK_m9-7Od", 465, 3, 8.5, 18, 0, 1, 2, 3, 1, 1, 3, 2325000, 6),
("https://drive.google.com/uc?id=1IvGoqItZmiMmnkifriCvte_KK_m9-7Od", 1142, 2, 19, 28, 1, 9, 0, 7, 1, 1, 8, 5710000, 12),
("https://drive.google.com/uc?id=1EEkZ-sZsolg7kQ2VT18ZUIe1aAHGOWDK", 746, 3, 17.2, 13.3, 1, 0, 0, 6, 1, 1, 6, 3730000, 8);    
insert into `image_detail_links`(`villa_id`, `image_detail`)
values
(1, "https://drive.google.com/uc?id=1NxHAgMfX2XX_eA34oiithxv97a6VopTF"),
(1, "https://drive.google.com/uc?id=1i0xsOs4WqAxVebKeQKwspQmXtlMuRo4M"),
(1, "https://drive.google.com/uc?id=1tkKXQbLsC7CxLsPkyGCqEqQ5Bf-NUyNa"),
(1, "https://drive.google.com/uc?id=1OGBoS97BiZafmRA102Imud62uLatx_RN"),
(1,"https://drive.google.com/uc?id=1Oor-TJD7-uo9e96xA3I_vKoNzcDndyES"),
(2, "https://drive.google.com/uc?id=1xe9Q-lGyPQbx8IObBKTb7D4hjdAG0WEF"),
(2, "https://drive.google.com/uc?id=1eBa5t2pUvcuchwwM2tWTzwEb8l4FBMTn"),
(2, "https://drive.google.com/uc?id=1PN-UTWQSb8LIluKaHXLfcIbHlCn_RRa1"),
(2, "https://drive.google.com/uc?id=1_7EjJ5GDC1v7w4v6JYURh8X6193l6zkL"),
(2, "https://drive.google.com/uc?id=1xEx3cNkDFngFh9oD24uY0UaEnDgNmApz"),
(2, "https://drive.google.com/uc?id=1iIms_wazyYYlJ06j3Y-cORgtKcki8iH3"),
(3, "https://drive.google.com/uc?id=1TKVJr4cn-SYWjac9crrcp7uiSiz1TwI1"),
(3, "https://drive.google.com/uc?id=1U-gyDldJMduxBv5_xQWGVJnsLG71jMCd"),
(3, "https://drive.google.com/uc?id=1jOI60Kk_1gw8GeObTsUxwT152AdeB0dT"),
(3, "https://drive.google.com/uc?id=1ZIu6KE_2dte4zaR0NHdTNGCZ2CyK3q8I"),
(3, "https://drive.google.com/uc?id=1DB2qafko4m78EGS_f6Dw3CVWNJyvjAG0"),
(4, "https://drive.google.com/uc?id=1xKSwa95gvCvhj4lF7UUL-DZHqzfYYL6i"),
(4, "https://drive.google.com/uc?id=1ZzYV5qZIdrZ1S2FwSSIIef6nPOb9wESJ"),
(4, "https://drive.google.com/uc?id=1TfW3cbQl99vpoMtyClwWJ0TA8EnstZhm"),
(4, "https://drive.google.com/uc?id=1sS6m1UQyt-_rfJ7rqyT389le7p0rT4bh"),
(4, "https://drive.google.com/uc?id=17ZGnoyO3Q81Z-DaFU1_4wz8cYEqkv-Op"),
(5, "https://drive.google.com/uc?id=1H8XRHhXZkxuxCjUJMyUzVXyzZjNxEkVE"),
(5, "https://drive.google.com/uc?id=1jGg_3Bnj_u3-1YuGgN_MhUClsIscdCJI"),
(5, "https://drive.google.com/uc?id=1M6cPBuLKeJobbrQENn3VL6DDAGjWdyaK"),
(5, "https://drive.google.com/uc?id=1Fb97M_DjXVNsRHaqaB48ldC0U2IxWi-t"),
(5, "https://drive.google.com/uc?id=1_q1a1vjO2C59yExnYHwCgUSHv1ClX_p0"),
(5, "https://drive.google.com/uc?id=1qNhiRbJGZdbqU2FtO_SXoIwPE389MZz_"),
(6, "https://drive.google.com/uc?id=1HSHCa3tgF8LncIjVTk0y7JxrLT1G3f6Z"),
(6, "https://drive.google.com/uc?id=1XRkKJtEm791L7sNJAbWJRkuBWVUc7RD3"),
(6, "https://drive.google.com/uc?id=1VOcum21hyQ7cguPyIaiNwLpySGv2AP5o"),
(6, "https://drive.google.com/uc?id=1iwqB8qrqyAUNVWY6Lp8aSiff4AV3-RPi"),
(6, "https://drive.google.com/uc?id=1ig_5jPgx0jDfxYe3_VDRnwX5ZgSEVJfS"),
(7, "https://drive.google.com/uc?id=11BoXW1litPYFnU3XFtiXHrdhzN6mJmZ8"),
(7, "https://drive.google.com/uc?id=1En7aWsz2zzkuqBPZM0X_ef1oR3egZxoQ"),
(7, "https://drive.google.com/uc?id=1_pm_cdsc_lfNw2IyPhCEcnuN10PCzf88"),
(7, "https://drive.google.com/uc?id=1BOINbgJMeTtPNlbEcsHe39muq1jZcM__"),
(7, "https://drive.google.com/uc?id=1APfnsd07iP_nnQSK8ww-xTvqacbNxZ6O"),
(7, "https://drive.google.com/uc?id=1g1thQafVhwBWtg1hMr8pceIyOC2X821H"),
(7, "https://drive.google.com/uc?id=1cHoFynG1KqxQWvYcf_BHkNtRUBGwtpIN"),
(8, "https://drive.google.com/uc?id=1I3JMgAGrwlRbMlrScB0kqR99s49RirV7"),
(8, "https://drive.google.com/uc?id=1VzP88vpqYR28QS1pmBU3CCjVsTY2Ben4"),
(8, "https://drive.google.com/uc?id=1DI8hC_k4cuml_HX_WkVfimnODkXQOxG-"),
(8, "https://drive.google.com/uc?id=1mbTogWKgiNnM2MtWPiNuyWLFAwtJ57bY"),
(9, "https://drive.google.com/uc?id=1cprUb-02yCtAv-tFPXlhOe-cEw_0FyTg"),
(9, "https://drive.google.com/uc?id=1ljYMcWznDMm_-v_OUrruKs6aNiAsl3AJ"),
(9, "https://drive.google.com/uc?id=1vMUQgFLOfi6ekA4tSD8UZY1dQMtDOYCk"),
(9, "https://drive.google.com/uc?id=1Au4dgCtFbiWu8-6QPDz7_9jhxfmLGCve"),
(9, "https://drive.google.com/uc?id=185YTYODuaBL7gDW3ZpkpfE_Se2I72P9p"), 
(9, "https://drive.google.com/uc?id=1T8KCfom9Yl8MJgeWPaVsUiyoDG254DKt"),
(9, "https://drive.google.com/uc?id=1nCeCUGPbgLlcKgygUZRz8QNqomGV4p1d"),
(10, "https://drive.google.com/uc?id=1ZjlEDHtdaS_TJrDm_Qk_0fPd1LDd30pG"),
(10, "https://drive.google.com/uc?id=1Rs5pyMK2eBAnMwVHd9iGLJthX-IMdqOi"), 
(10, "https://drive.google.com/uc?id=10fOZgpMlZyuo47xIDzUaX9S6gGWqmWGd"),
(10, "https://drive.google.com/uc?id=1Sik_S1SOIsUn4lbSeu4ZsZP9e1DtzFDj"),
(10, "https://drive.google.com/uc?id=17GbcuFOa4t_36Bo8cCmsQynE9xtsKgbe"),
(10, "https://drive.google.com/uc?id=1FyuARERKJcUjMmVC3m9Db40ctcyBhNSq"),
(10, "https://drive.google.com/uc?id=1jObNvjYuzlElEflfC7SFlaJQK-ENPO-i"),
(10, "https://drive.google.com/uc?id=1u2Q2Ki_GViZbU-OUDj_Udv4Rqd5dwy5i");
insert into `bookings`(`check_in`,`check_out`,`price`,`deposit`,`villa_id`,`customer_code`,`booking_time`)
values
("2023-09-10","2023-10-20", 44100000, 5000000, 2, 3, "2023-07-29 13:00:00"),
("2023-09-01","2023-10-02", 2560000, 500000, 1, 3, "2023-08-30 13:00:00"),
("2022-09-10","2022-10-11", 3730000, 400000, 10, 4, "2023-08-29 13:00:00");
insert into `bookings`(`check_in`,`check_out`,`price`,`deposit`,`villa_id`,`customer_code`,`check_in_person_name`,`check_in_person_phone_number`,`booking_time`)
values
("2022-09-10","2022-10-10", 3730000, 400000, 10, 4, "Lê Nin", "0989997564","2023-08-29 15:00:00");

-- Thắng
delimiter //
create procedure GetBookingCountAfterSeenTime()
begin
    declare `seen_time_value` datetime;
    declare `booking_count` int;
    select `time` into `seen_time_value` from `seen_time` where `role` = 1;
    select count(*) into `booking_count` from `bookings` where `booking_time` > `seen_time_value`;
    select `booking_count`;
end //
delimiter ;

delimiter //
create procedure get_detail_img()
begin
select `villa_id`, `image_detail`,`image_id` from `image_detail_links`
where `is_delete` = 0;
end //
delimiter ;

delimiter //
create procedure get_all_villa()
begin
select `villa_id`,`image_map`,`area`,`level`,`width`,`deep`,`garage`,`gym_room`,`relax_room`,`toilet`,`living_room`,`kitchen_room`,`bedroom`,`price`,`capacity` from `villas`
where `is_delete` = 0;
end //
delimiter ;

delimiter //
create procedure check_account(`acount_login` varchar(100), `password_login` varchar(100))
begin
select ifnull(`positions`.`position_name`,"customer"), `accounts`.`user_name`, `accounts`.`account_code` from `accounts`
	left join `employees` on `employees`.`account_code` = `accounts`.`account_code`
	left join `customers` on `customers`.`account_code` = `accounts`.`account_code`
	left join `positions` on `positions`.`position_code` = `employees`.`position_code`
    
    where `accounts`.`is_delete` = 0 
    and ifnull(`employees`.`phone_number`, `customers`.`phone_number`) = `acount_login` 
    and `accounts`.`password_account` = `password_login`;
end //
delimiter ;

delimiter //
create procedure create_employee(
	`new_user_name` varchar(100),
    `new_password_account` varchar(100),
    `new_name` varchar(50),
    `new_identity_number` varchar(15),
    `new_birthday` date,
    `new_gender` bit(1),
    `new_phone_number` varchar(20),
    `new_email` varchar(50)
    )
begin
    declare `new_account_code` int;
    set `new_account_code` = (select MAX(`employee_code`) + 1 from `employees`);
    insert into `accounts`(`user_name`, `password_account`)
    values
    (`new_user_name`, `new_password_account`);
    
    insert into `employees`(`name`, `identity_number`, `birthday`, `gender`, `phone_number`, `email`, `account_code`,`position_code`)
    values
    (`new_name`, `new_identity_number`, `new_birthday`, `new_gender`, `new_phone_number`, `new_email`, `new_account_code`, 2);
end //
delimiter ;


-- hạnh
-- duyệt booking
DELIMITER //
create procedure approved_booking(in booking_id_approved int)
begin
update bookings
set is_pending = 0
where booking_id = booking_id_approved;
end //
DELIMITER ;
-- xoá booking
DELIMITER //
create procedure delete_bookings(in delete_id int)
begin
update bookings
set is_delete = 1
where booking_id = delete_id;
end //
DELIMITER ;
-- xoá nhân viên
DELIMITER //
create procedure delete_employee(in delete_id int)
begin
update employees
set is_delete = 1
where employee_code = delete_id;
end //
DELIMITER ;

-- xoá khách hàng
DELIMITER //
create procedure delete_customer(in delete_id int)
begin
update customers
set is_delete = 1
where customer_code = delete_id;
end //
DELIMITER ;

-- Nhật
-- Chưa duyệt
delimiter //
create procedure show_list_pending(find_by_account_code int)
begin
-- select bookings.booking_id, check_in, check_out, price, deposit, villa_id
select bookings.*
from bookings
join customers on bookings.customer_code = customers.customer_code
join accounts on  customers.account_code = accounts.account_code
where bookings.is_delete = 0 and is_pending = 1 and accounts.account_code = find_by_account_code
group by bookings.booking_id
order by booking_time desc;
end //
delimiter ;
delimiter //
create procedure add_booking(`new_check_in` date,`new_check_out` date,`new_price` int,`new_deposit` int,
	`new_check_in_person_name` varchar(50),`new_check_in_person_phone_number` varchar(50),`new_villa_id` int,`new_customer_code` int)
begin
insert into `bookings`(`check_in`,`check_out`,`price`,`deposit`,`check_in_person_name`,`check_in_person_phone_number`,`villa_id`,`customer_code`)
values
(`new_check_in`,`new_check_out`,`new_price`,`new_deposit`,`new_check_in_person_name`,`new_check_in_person_phone_number`,`new_villa_id`,`new_customer_code`);
end //
delimiter ;
-- Đã duyệt
delimiter //
create procedure show_list_approved(find_by_account_code int)
begin
select bookings.*
from bookings
join customers on bookings.customer_code = customers.customer_code
join accounts on  customers.account_code = accounts.account_code
where bookings.is_delete = 0 and is_pending = 0 and accounts.account_code = find_by_account_code
group by bookings.booking_id
order by booking_time desc;
end //
delimiter ;
-- Đã hủy
delimiter //
create procedure show_list_delete(find_by_account_code int)
begin
select bookings.*
from bookings
join customers on bookings.customer_code = customers.customer_code
join accounts on  customers.account_code = accounts.account_code
where bookings.is_delete = 1 and accounts.account_code = find_by_account_code
group by bookings.booking_id
order by booking_time desc;
end //
delimiter ;
-- Update booking
delimiter //
create procedure update_booking(find_by_booking_id int, check_in_person_name_update varchar(50), check_in_person_phone_number_update varchar(50))
begin
update bookings
set check_in_person_name = check_in_person_name_update,
	check_in_person_phone_number = check_in_person_phone_number_update
where booking_id = find_by_booking_id;
end //
delimiter ;
-- Hủy booking
delimiter //
create procedure delete_booking(find_by_booking_id int)
begin
update bookings
set is_delete = 1
where booking_id = find_by_booking_id;
end //
delimiter ;
-- Lấy thông tin account
delimiter //
create procedure get_inform_account()
begin
select customers.account_code, name, phone_number, customer_code as id
from customers
union
select employees.account_code, name, phone_number, employee_code as id
from employees;
end //
delimiter ;

-- Lấy thông tin villa theo id 
delimiter //
create procedure get_inform_villa_by_id(find_by_villa_id int)
begin
select `villa_id`,`image_map`,`area`,`level`,`width`,`deep`,`garage`,`gym_room`,`relax_room`,`toilet`,`living_room`,`kitchen_room`,`bedroom`,`price`,`capacity` from `villas`
where villa_id = find_by_villa_id;
end //
delimiter ;
-- Đạt
-- 1. Xóa tài khoản
delimiter //
create procedure deleteAccountAndCustomer(account_code int)
begin
update accounts a
join customers c on a.account_code = c.account_code
set a.is_delete = 1, c.is_delete = 1
where a.account_code = account_code;
end //
delimiter ;
-- 2. Lấy lại mật khẩu
delimiter //
create procedure resetPasswordByIdentityNumberAndPhoneNumber (p_newPassword varchar(100), p_cmnd varchar(20),p_username varchar(20))
begin
UPDATE accounts AS a
    JOIN customers AS c ON a.account_code = c.account_code
    SET a.password_account = p_newPassword
    WHERE c.phone_number= p_username AND c.identity_number = p_cmnd;
END // 
delimiter ;
