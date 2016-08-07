create user traveloperator identified by test;
grant connect, resource to traveloperator; 

create table role (
	id number(19,0) not null, 
    version number(19,0) not null,
    rolename varchar2(50) not null,
    creation_date timestamp default sysdate, 
    modification_date timestamp default sysdate,
    primary key (id)
);

create table app_user (
	id number(19,0) not null, 
	role_id number(19,0) not null,
    version number(19,0) not null,    
    username varchar2(20 char) not null unique, 
    password varchar2(255 char) not null,
    firstname varchar(50) NOT NULL,
    middlename varchar(50) DEFAULT '',
    lastname varchar(50) DEFAULT '',
    isactive char(1 char) not null,  
    email varchar2(255 char) not null,
    last_login_time timestamp ,   
    creation_date timestamp default sysdate, 
    modification_date timestamp default sysdate,
    primary key (id),
    foreign key(role_id) references role(id)   
);


create table hotel_master(
	id number(19,0) not null,
	hotel_name varchar2(100) not null,
	hotel_description varchar2(2000) not null,
	star_rating varchar2(10),
	hotel_type varchar2(20) not null,
	main_image varchar2(50) not null,
	conditions varchar2(1000),
	other_information varchar2(2000),
	creation_date timestamp default sysdate, 
    modification_date timestamp default sysdate,
    version number(19,0) not null,
    primary key (id)   
);

create table hotel_address(
	id number(19,0) not null,
	hotel_master_id number(19,0) not null,
	address_line_1 varchar2(100) not null,
	address_line_2 varchar2(100),
	city varchar2(50) not null,
	state varchar2(15) not null,
	postal_code varchar2(15) not null,
	country varchar2(15) not null,
	other_information varchar2(500),
	creation_date timestamp default sysdate, 
    modification_date timestamp default sysdate,
    version number(19,0) not null,
    primary key (id),
    foreign key(hotel_master_id) references hotel_master(id)
);

create table hotel_images(
	id number(19,0) not null,
	hotel_master_id number(19,0) not null,
	image_file varchar2(200) not null,
	image_description varchar2(100),
	creation_date timestamp default sysdate, 
    modification_date timestamp default sysdate,
    version number(19,0) not null,
	primary key (id),
	foreign key(hotel_master_id) references hotel_master(id)
);

create table hotel_facility(
	id number(19,0) not null,
	hotel_master_id number(19,0) not null,
	facility_name varchar2(200) not null,
	facility_description varchar2(500),
	creation_date timestamp default sysdate, 
    modification_date timestamp default sysdate,
    version number(19,0) not null,
	primary key (id),
	foreign key(hotel_master_id) references hotel_master(id)
);

create table hotel_policy(
	id number(19,0) not null,
	hotel_master_id number(19,0) not null,
	policy_name varchar2(200) not null,
	policy_description varchar2(500),
	creation_date timestamp default sysdate, 
    modification_date timestamp default sysdate,
    version number(19,0) not null,
	primary key (id),
	foreign key(hotel_master_id) references hotel_master(id)
);

create table tour_destination(
    id number(19,0) not null,
    destination_name varchar2(100) not null,
    destination_description varchar2(500) not null,
    creation_date timestamp default sysdate, 
    modification_date timestamp default sysdate,
    version number(19,0) not null,
    primary key (id)   
);

create table tour_master(
    id number(19,0) not null,
    tour_name varchar2(50) not null,
    tour_destination_id number(19,0) not null,
    tour_description varchar2(500) not null,
    tour_price varchar2(100) not null,
    tour_dates varchar2(100) not null,
    main_image varchar2(25),
    creation_date timestamp default sysdate, 
    modification_date timestamp default sysdate,
    version number(19,0) not null,
    primary key (id), 
    foreign key (tour_destination_id) references tour_destination(id)
);


create table tour_itinerary(
    id number(19,0) not null,
    tour_master_id number(19,0) not null,
    itinerary_day varchar2(10) not null,
    itinerary_title varchar2(50) not null,
    itinerary_description varchar2(500) not null,
    creation_date timestamp default sysdate, 
    modification_date timestamp default sysdate,
    version number(19,0) not null,
    primary key (id), 
    foreign key (tour_master_id) references tour_master(id)
);

create table tour_images(
    id number(19,0) not null,
    tour_master_id number(19,0) not null,
    image_source varchar2(100) not null,
    image_description varchar2(500) not null,
    creation_date timestamp default sysdate, 
    modification_date timestamp default sysdate,
    version number(19,0) not null,
    primary key (id), 
    foreign key (tour_master_id) references tour_master(id)
);

create table tour_booking_request(
    id number(19,0) not null,
    tour_master_id number(19,0) not null,
    user_id number(19,0) not null,
    creation_date timestamp default sysdate, 
    modification_date timestamp default sysdate,
    version number(19,0) not null,
    primary key (id), 
    foreign key (tour_master_id) references tour_master(id),
    foreign key (user_id) references app_user(id)    
);

create table hotel_booking_request(
    id number(19,0) not null,
    hotel_master_id number(19,0) not null,
    user_id number(19,0) not null,
    creation_date timestamp default sysdate, 
    modification_date timestamp default sysdate,
    version number(19,0) not null,
    primary key (id), 
    foreign key (hotel_master_id) references hotel_master(id),
    foreign key (user_id) references app_user(id)    
);


commit;