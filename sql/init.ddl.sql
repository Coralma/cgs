USE cgs;

CREATE TABLE `t_person` (
 `id` int(12) unsigned NOT NULL AUTO_INCREMENT,
 `username` varchar(6) NOT NULL COMMENT '用户名',
 `password` varchar(6) NOT NULL COMMENT '密码',
 `job` varchar(6) NOT NULL COMMENT '工作信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;