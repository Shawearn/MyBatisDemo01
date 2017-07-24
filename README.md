# MyBatisDemo01
## 简介
一个 MyBatis 入门程序，用 Maven 构建，作为一个研究 MyBatis 原理的入门示例。

## 开始
运行项目之前需要根据下面的 SQL 语句生成相应的数据库并配置好数据库信息。
```sql
-- 创建数据库；
CREATE DATABASE `mybatis` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

-- 建表；
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) DEFAULT '',
  `descript` varchar(45) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

运行`MybatisT1`中的 main 方法插入数据到数据库并从数据库中查询插入的数据。