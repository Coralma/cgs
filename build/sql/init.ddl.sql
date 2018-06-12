USE cgs;

CREATE TABLE `t_person` (
 `id` int(12) unsigned NOT NULL AUTO_INCREMENT,
 `username` varchar(6) NOT NULL COMMENT '用户名',
 `password` varchar(6) NOT NULL COMMENT '密码',
 `job` varchar(6) NOT NULL COMMENT '工作信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


drop table if exists sequence;
create table sequence (
seq_name        VARCHAR(50) NOT NULL, -- 序列名称
current_val     INT         NOT NULL, -- 当前值
increment_val   INT         NOT NULL    DEFAULT 1, -- 步长(跨度)
PRIMARY KEY (seq_name)   );

drop table if exists t_vehicle_policy;
CREATE TABLE `t_vehicle_policy` (
 `policyId` int(12) unsigned NOT NULL AUTO_INCREMENT,
 `policyNo` varchar(50)  COMMENT 'policyNo',
 `effectiveDate` date,
 `expiryDate` date,
 `status` varchar(50),
 `policyHolderName` varchar(50),
 `gender` varchar(50),
 `birthday` date,
 `idType` varchar(50),
 `idNo` varchar(50),
 `postNo` varchar(50),
 `mobilePhone` varchar(50),
 `companyPhone` varchar(50),
 `homePhone` varchar(50),
 `si` decimal(18,2),
 `premium` decimal(18,2),
  PRIMARY KEY (`policyId`),
  UNIQUE KEY `policyNo_UNIQUE` (`policyNo`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

drop table if exists t_vehicle_insured;
CREATE TABLE `t_vehicle_insured` (
 `insuredId` int(12) unsigned NOT NULL AUTO_INCREMENT,
 `policyId` int(12),
 `newCar` varchar(10),
 `vehicleNo` varchar(50),
 `vehicleBand` varchar(50),
 `vehicleModel` varchar(50),
 `engineNo` varchar(50),
 `carFrameNo` varchar(50),
 `usageType` varchar(50),
 `belongType` varchar(50),
 `registerDate` date,
 `bodyType` varchar(50),
 `premium` decimal(18,2),
 `price` decimal(18,2),
 `si` decimal(18,2),
  PRIMARY KEY (`insuredId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


drop table if exists t_user;
CREATE TABLE `t_user` (
 `userId` int(12) unsigned NOT NULL AUTO_INCREMENT,
 `username` varchar(50),
 PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

drop table if exists t_user_address;
CREATE TABLE `t_user_address` (
 `addressId` int(12) unsigned NOT NULL AUTO_INCREMENT,
 `userId` int(12),
 `address` varchar(50),
 `postNo` varchar(50),
 PRIMARY KEY (`addressId`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
