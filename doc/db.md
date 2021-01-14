使用

lower_case_table_names=1
docker run --name mysq.db -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_DATABASE=ci  -d mysql  --lower-case-table-names=1

alter user 'root'@'%' identified with mysql_native_password by '123456';
flush privileges;