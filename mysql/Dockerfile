FROM --platform=linux/x86_64 mysql

ADD ./my.cnf /etc/mysql/my.cnf
ADD ./queries.sql /docker-entrypoint-initdb.d/schema.sql
