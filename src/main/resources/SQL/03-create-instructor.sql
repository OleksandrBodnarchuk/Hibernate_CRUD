create table instructor
(
    id                   int auto_increment
        primary key,
    first_name           varchar(45) null,
    last_name            varchar(45) null,
    email                varchar(45) null,
    instructor_detail_id int         null,
    constraint FK_DETAIL
        foreign key (instructor_detail_id) references instructor_detail (id)
);
