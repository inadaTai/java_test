FROM mysql:8.0

EXPOSE 3306

COPY ./my.cnf /etc/mysql/conf.d/my.cnf
RUN chmod 644 /etc/mysql/conf.d/my.cnf

COPY ./sql_init /docker-entrypoint-initdb.d