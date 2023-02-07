create table course (course_id bigserial not null, description varchar(255), name varchar(255), primary key (course_id))

create table student (student_id bigserial not null, bday varchar(255), email varchar(255), first_name varchar(255), last_name varchar(255), level integer, primary key (student_id))

create table student_course (student_id bigint not null, course_id bigint not null, primary key (student_id, course_id))

alter table if exists student_course add constraint FKejrkh4gv8iqgmspsanaji90ws foreign key (course_id) references course

alter table if exists student_course add constraint FKq7yw2wg9wlt2cnj480hcdn6dq foreign key (student_id) references student