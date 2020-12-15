CREATE DATABASE dag;

USE dag;

CREATE TABLE dag_block(
    `id`   INT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `pre1` VARCHAR(100),
    `pre2` VARCHAR(100),
    `data` VARCHAR(100),
    `hash` VARCHAR(100),
    `num`  INT(20) NOT NULL DEFAULT 0,
    `timestamp` bigint(20) NOT NULL
)ENGINE=INNODB, DEFAULT CHARSET=utf8;