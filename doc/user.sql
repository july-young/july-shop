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

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'user_id',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机号',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `user_name` varchar(50) DEFAULT NULL COMMENT '用户名',
  `sex` tinyint(1) DEFAULT '1' COMMENT '性别 1 男 2 女',
  `age` tinyint(3) DEFAULT '0' COMMENT '年龄',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '注册时间',
  `is_avaliable` tinyint(1) DEFAULT '1' COMMENT '是否可用 1正常 2冻结',
  `pic_img` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `qq_openid` varchar(50) DEFAULT NULL COMMENT 'QQ联合登录id',
  `wx_openid` varchar(50) DEFAULT NULL COMMENT '微信公众号关注id',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户会员表';

/*Data for the table `t_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
