/*
SQLyog Ultimate v12.4.1 (64 bit)
MySQL - 5.7.29 : Database - july_shop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`july_shop` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `july_shop`;

/*Table structure for table `t_attribute_key` */

DROP TABLE IF EXISTS `t_attribute_key`;

CREATE TABLE `t_attribute_key` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `CATEGORY_ID` int(11) DEFAULT NULL COMMENT '分类ID',
  `ATTRIBUTE_NAME` varchar(32) DEFAULT NULL COMMENT '属性名称',
  `NAME_SORT` varchar(32) DEFAULT NULL COMMENT '名称排序',
  `REVISION` int(11) DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='商品规格Key表 ';

/*Data for the table `t_attribute_key` */

insert  into `t_attribute_key`(`ID`,`CATEGORY_ID`,`ATTRIBUTE_NAME`,`NAME_SORT`,`REVISION`,`CREATED_BY`,`CREATED_TIME`,`UPDATED_BY`,`UPDATED_TIME`) values
(1,11,'内存','0',1,NULL,'2019-03-02 15:34:35','2019-03-02 15:34:35','2019-03-02 15:34:35'),
(2,11,'颜色','0',1,NULL,'2019-03-02 15:34:35','2019-03-02 15:34:35','2019-03-02 15:34:35'),
(3,11,'年份','0',1,NULL,'2019-03-02 15:34:35','2019-03-02 15:34:35','2019-03-02 15:34:35'),
(4,11,'尺寸','0',1,NULL,'2019-03-02 15:34:35','2019-03-02 15:34:35','2019-03-02 15:34:35');

/*Table structure for table `t_attribute_value` */

DROP TABLE IF EXISTS `t_attribute_value`;

CREATE TABLE `t_attribute_value` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `ATTRIBUTE_ID` varchar(32) DEFAULT NULL COMMENT '属性ID',
  `ATTRIBUTE_VALUE` varchar(32) DEFAULT NULL COMMENT '属性值',
  `VALUE_SORT` varchar(32) DEFAULT NULL COMMENT '值排序',
  `REVISION` int(11) DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='商品规格值表 ';

/*Data for the table `t_attribute_value` */

insert  into `t_attribute_value`(`ID`,`ATTRIBUTE_ID`,`ATTRIBUTE_VALUE`,`VALUE_SORT`,`REVISION`,`CREATED_BY`,`CREATED_TIME`,`UPDATED_BY`,`UPDATED_TIME`) values
(1,'1','4G','0',1,NULL,'2019-03-02 15:36:27','2019-03-02 15:36:27','2019-03-02 15:36:27'),
(2,'1','8G','0',1,NULL,'2019-03-02 15:36:42','2019-03-02 15:36:42','2019-03-02 15:36:42'),
(3,'1','16G','0',1,NULL,'2019-03-02 15:36:43','2019-03-02 15:36:43','2019-03-02 15:36:43'),
(4,'1','32G','0',1,NULL,'2019-03-02 15:36:43','2019-03-02 15:36:43','2019-03-02 15:36:43'),
(5,'2','白色','0',1,NULL,'2019-03-02 15:38:55','2019-03-02 15:38:55','2019-03-02 15:38:55'),
(6,'2','红色','0',1,NULL,'2019-03-02 15:38:55','2019-03-02 15:38:55','2019-03-02 15:38:55'),
(7,'2','紫色','0',1,NULL,'2019-03-02 15:38:55','2019-03-02 15:38:55','2019-03-02 15:38:55'),
(8,'3','2017','0',1,NULL,'2019-03-02 15:38:57','2019-03-02 15:38:57','2019-03-02 15:38:57'),
(9,'3','2018','0',1,NULL,'2019-03-02 15:38:57','2019-03-02 15:38:57','2019-03-02 15:38:57'),
(10,'3','2019','0',1,NULL,'2019-03-02 15:38:57','2019-03-02 15:38:57','2019-03-02 15:38:57'),
(11,'3','16寸','0',1,NULL,'2019-03-02 15:38:59','2019-03-02 15:38:59','2019-03-02 15:38:59'),
(12,'3','20寸','0',1,NULL,'2019-03-02 15:38:59','2019-03-02 15:38:59','2019-03-02 15:38:59'),
(13,'3','24寸','0',1,NULL,'2019-03-02 15:38:59','2019-03-02 15:38:59','2019-03-02 15:38:59'),
(14,'3','32寸','0',1,NULL,'2019-03-02 15:38:59','2019-03-02 15:38:59','2019-03-02 15:38:59');

/*Table structure for table `t_category` */

DROP TABLE IF EXISTS `t_category`;

CREATE TABLE `t_category` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `PARENT_ID` int(11) DEFAULT NULL COMMENT '父ID',
  `NAME` varchar(128) DEFAULT NULL COMMENT '名称',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `SORT_ORDER` int(11) DEFAULT NULL COMMENT '分类顺序',
  `REVISION` int(11) DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='商品分类 商品分类信息表';

/*Data for the table `t_category` */

insert  into `t_category`(`ID`,`PARENT_ID`,`NAME`,`STATUS`,`SORT_ORDER`,`REVISION`,`CREATED_BY`,`CREATED_TIME`,`UPDATED_BY`,`UPDATED_TIME`) values
(1,0,'家用电器',0,0,NULL,NULL,'2019-03-02 15:00:57','2019-03-02 15:00:57','2019-03-02 15:00:57'),
(2,1,'空调',0,0,NULL,NULL,'2019-03-02 15:02:08','2019-03-02 15:02:08','2019-03-02 15:02:08'),
(3,1,'冰箱',0,0,NULL,NULL,'2019-03-02 15:02:08','2019-03-02 15:02:08','2019-03-02 15:02:08'),
(4,1,'洗衣机',0,0,NULL,NULL,'2019-03-02 15:02:08','2019-03-02 15:02:08','2019-03-02 15:02:08'),
(5,1,'生活电器',0,0,NULL,NULL,'2019-03-02 15:02:08','2019-03-02 15:02:08','2019-03-02 15:02:08'),
(6,2,'中央空调',0,0,NULL,NULL,'2019-03-02 15:03:19','2019-03-02 15:03:19','2019-03-02 15:03:19'),
(7,2,'柜式空调',0,0,NULL,NULL,'2019-03-02 15:03:19','2019-03-02 15:03:19','2019-03-02 15:03:19'),
(8,0,'电脑办公',0,0,NULL,NULL,'2019-03-02 15:28:39','2019-03-02 15:28:39','2019-03-02 15:28:39'),
(9,8,'电脑整机',0,0,NULL,NULL,'2019-03-02 15:28:49','2019-03-02 15:28:49','2019-03-02 15:28:49'),
(10,8,'电脑配件',0,0,NULL,NULL,'2019-03-02 15:28:49','2019-03-02 15:28:49','2019-03-02 15:28:49'),
(11,9,'平板电脑',0,0,NULL,NULL,'2019-03-02 15:30:10','2019-03-02 15:30:10','2019-03-02 15:30:10'),
(12,9,'笔记本',0,0,NULL,NULL,'2019-03-02 15:30:10','2019-03-02 15:30:10','2019-03-02 15:30:10');

/*Table structure for table `t_product` */

DROP TABLE IF EXISTS `t_product`;

CREATE TABLE `t_product` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `CATEGORY_ID` int(11) DEFAULT NULL COMMENT '类型ID',
  `NAME` varchar(128) DEFAULT NULL COMMENT '名称',
  `SUBTITLE` varchar(128) DEFAULT NULL COMMENT '小标题',
  `MAIN_IMAGE` varchar(128) DEFAULT NULL COMMENT '主图像',
  `SUB_IMAGES` text COMMENT '小标题图像',
  `DETAIL` text COMMENT '描述',
  `ATTRIBUTE_LIST` varchar(128) DEFAULT NULL COMMENT '商品规格',
  `PRICE` decimal(32,8) DEFAULT NULL COMMENT '价格',
  `STOCK` int(11) DEFAULT NULL COMMENT '库存',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态',
  `REVISION` int(11) DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='商品信息表';

/*Data for the table `t_product` */

insert  into `t_product`(`ID`,`CATEGORY_ID`,`NAME`,`SUBTITLE`,`MAIN_IMAGE`,`SUB_IMAGES`,`DETAIL`,`ATTRIBUTE_LIST`,`PRICE`,`STOCK`,`STATUS`,`REVISION`,`CREATED_BY`,`CREATED_TIME`,`UPDATED_BY`,`UPDATED_TIME`) values
(1,11,'Pad平板电脑无线局域网','Pad平板电脑','http://img.iblimg.com/photo-42/3020/1135120490_200x200.jpg','{\"imgages\":[{\"http://img.iblimg.com/photo-42/3020/1135120490_200x200.jpg\"},{\"http://img.iblimg.com/photo-42/3020/1135120490_200x200.jpg\"}]}','官方授权Pad苹果电脑','1,2,3',NULL,NULL,0,1,NULL,'2019-03-02 16:02:40',NULL,'2020-07-10 16:02:40'),
(2,11,'Pad平板电脑无线局域网2','Pad平板电脑','http://img.iblimg.com/photo-42/3020/1135120490_200x200.jpg','{\"imgages\":[{\"http://img.iblimg.com/photo-42/3020/1135120490_200x200.jpg\"},{\"http://img.iblimg.com/photo-42/3020/1135120490_200x200.jpg\"}]}','官方授权Pad苹果电脑','1,2,3',NULL,NULL,0,1,NULL,'2019-03-02 16:02:40',NULL,'2020-07-10 16:02:40');

/*Table structure for table `t_product_specs` */

DROP TABLE IF EXISTS `t_product_specs`;

CREATE TABLE `t_product_specs` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `PRODUCT_ID` int(11) DEFAULT NULL COMMENT '商品ID',
  `PRODUCT_SPECS` text COMMENT '商品规格',
  `SPECS_SEQ` int(11) DEFAULT NULL COMMENT '规格顺序',
  `PRODUCT_STOCK` int(11) DEFAULT NULL COMMENT '商品库存',
  `PRODUCT_PRICE` decimal(32,8) DEFAULT NULL COMMENT '商品价格',
  `REVISION` int(11) DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='商品规格表 ';

/*Data for the table `t_product_specs` */

insert  into `t_product_specs`(`ID`,`PRODUCT_ID`,`PRODUCT_SPECS`,`SPECS_SEQ`,`PRODUCT_STOCK`,`PRODUCT_PRICE`,`REVISION`,`CREATED_BY`,`CREATED_TIME`,`UPDATED_BY`,`UPDATED_TIME`) values
(1,1,'{\"内存\":\"4G\",\"颜色\":\"红色\",\"年份\":\"2019\",\"尺寸\":\"16寸\"}',0,30,3699.00000000,1,NULL,'2019-03-02 15:50:04','2019-03-02 15:50:04','2019-03-02 15:50:04'),
(2,1,'{\"内存\":\"8G\",\"颜色\":\"白色\",\"年份\":\"2019\",\"尺寸\":\"16寸\"}',0,30,3899.00000000,1,NULL,'2019-03-02 15:50:04','2019-03-02 15:50:04','2019-03-02 15:50:04'),
(3,1,'{\"内存\":\"16G\",\"颜色\":\"白色\",\"年份\":\"2019\",\"尺寸\":\"16寸\"}',0,30,4199.00000000,1,NULL,'2019-03-02 15:50:04','2019-03-02 15:50:04','2019-03-02 15:50:04');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT 'user_id',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号',
  `email` varchar(31) DEFAULT NULL COMMENT '邮箱',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `sex` tinyint(1) DEFAULT '1' COMMENT '性别 1 男 2 女',
  `age` tinyint(3) DEFAULT '0' COMMENT '年龄',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '注册时间',
  `is_avalible` tinyint(1) DEFAULT '1' COMMENT '是否可用 1正常 2冻结',
  `pic_img` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `qq_openid` varchar(50) DEFAULT NULL COMMENT 'QQ联合登录id',
  `wx_openid` varchar(50) DEFAULT NULL COMMENT '微信公众号关注id',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='用户会员表';

/*Data for the table `t_user` */

insert  into `t_user`(`user_id`,`mobile`,`email`,`password`,`user_name`,`sex`,`age`,`create_time`,`is_avalible`,`pic_img`,`qq_openid`,`wx_openid`,`update_time`) values
(2,'18268732124','string','E10ADC3949BA59ABBE56E057F20F883E','user',1,0,NULL,1,NULL,NULL,NULL,'2020-02-29 23:27:40');

/*Table structure for table `t_user_token` */

DROP TABLE IF EXISTS `t_user_token`;

CREATE TABLE `t_user_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(255) DEFAULT NULL,
  `login_type` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `device_infor` varchar(255) DEFAULT NULL,
  `is_availability` int(2) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4;

/*Data for the table `t_user_token` */

insert  into `t_user_token`(`id`,`token`,`login_type`,`device_infor`,`is_availability`,`user_id`,`create_time`,`update_time`) values
(8,'july.mb.loginIOSa79afcf8a7a74869a4c12686f68b8a35','IOS','ap',1,1,'2020-02-26 14:01:16','2020-02-26 14:06:52'),
(11,'july.mb.loginIOS21f3483664dd456195bf2beaf809b90f','IOS','ap',1,1,'2020-02-26 14:06:52','2020-02-26 14:07:08'),
(12,'july.mb.loginIOS005dddbc84d44134ae47e6f0dcd678b1','IOS','ap',0,1,'2020-02-26 14:07:08',NULL),
(13,'july.mb.loginPC16dbd8cbe66846959b7cdd9b861bda4c','PC','Chrome/79.0.3945.88',1,3,'2020-02-26 17:03:42','2020-02-26 17:03:53'),
(14,'july.mb.loginPC19d4541fbbe443b6a80e50db23deea75','PC','Chrome/79.0.3945.88',1,3,'2020-02-26 17:03:53','2020-02-26 17:29:38'),
(15,'july.mb.loginPCcc613fec25464c2fae1246ffaa9db440','PC','Chrome/79.0.3945.88',1,3,'2020-02-26 17:29:38','2020-02-26 17:38:01'),
(16,'july.mb.loginPCfa7a07f75ca341d09490fa4863d8faa2','PC','Chrome/79.0.3945.88',0,3,'2020-02-26 17:38:01',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
