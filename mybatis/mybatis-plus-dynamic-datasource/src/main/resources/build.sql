drop table if exists user_test;
create table user_test(
  id bigint primary key,
  username varchar(32) unique not null,
  create_time timestamp default localtimestamp(0),
  update_time timestamp
);