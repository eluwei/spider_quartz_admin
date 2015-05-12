/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.38 : Database - 1000wcj
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`1000wcj` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `1000wcj`;

/*Table structure for table `apply_record` */

DROP TABLE IF EXISTS `apply_record`;

CREATE TABLE `apply_record` (
  `id` varchar(32) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `apply_money` int(11) DEFAULT NULL,
  `apply_name` varchar(100) DEFAULT NULL,
  `audit_status` int(11) DEFAULT NULL,
  `audit_time` datetime DEFAULT NULL,
  `auditor` varchar(50) DEFAULT NULL,
  `bank` int(11) DEFAULT NULL,
  `bank_name` varchar(100) DEFAULT NULL,
  `bank_no` varchar(32) DEFAULT NULL,
  `id_card_no` varchar(32) DEFAULT NULL,
  `member_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5jbprhmawbdmna4u0gnw656y7` (`member_id`),
  CONSTRAINT `FK_5jbprhmawbdmna4u0gnw656y7` FOREIGN KEY (`member_id`) REFERENCES `member_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `article` */

DROP TABLE IF EXISTS `article`;

CREATE TABLE `article` (
  `id` varchar(32) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `click_number` int(11) DEFAULT NULL,
  `content` longtext,
  `source` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `bet_date` */

DROP TABLE IF EXISTS `bet_date`;

CREATE TABLE `bet_date` (
  `bet_date_id` int(11) NOT NULL AUTO_INCREMENT,
  `day_date` varchar(16) DEFAULT NULL,
  `match_info` varchar(16) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `pdate` varchar(16) DEFAULT NULL COMMENT '比赛日期',
  `STATUS` int(11) DEFAULT NULL COMMENT '状态（0-历史期，1-当前期）',
  PRIMARY KEY (`bet_date_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*Table structure for table `constant_config` */

DROP TABLE IF EXISTS `constant_config`;

CREATE TABLE `constant_config` (
  `constant_config_id` int(11) NOT NULL AUTO_INCREMENT,
  `config_key` varchar(64) DEFAULT NULL,
  `config_value` longtext,
  `config_type` longtext,
  `update_date` datetime DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`constant_config_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Table structure for table `football_match` */

DROP TABLE IF EXISTS `football_match`;

CREATE TABLE `football_match` (
  `football_match_id` int(11) NOT NULL AUTO_INCREMENT,
  `type_code` varchar(16) DEFAULT NULL,
  `type_name` varchar(16) DEFAULT NULL,
  `pdate` varchar(16) DEFAULT NULL,
  `zid` varchar(16) DEFAULT NULL,
  `lottery_period_id` int(11) DEFAULT NULL COMMENT '排期主键',
  `expect` varchar(16) DEFAULT NULL,
  `game_num` varchar(8) DEFAULT NULL,
  `league` varchar(16) DEFAULT NULL,
  `end_time` varchar(16) DEFAULT NULL,
  `homesxname` varchar(16) DEFAULT NULL,
  `awaysxname` varchar(16) DEFAULT NULL,
  `concede_t_line_green` varchar(8) DEFAULT NULL,
  `nspf1` varchar(8) DEFAULT NULL,
  `nspf2` varchar(8) DEFAULT NULL,
  `nspf3` varchar(8) DEFAULT NULL,
  `nspf4` varchar(8) DEFAULT NULL,
  `nspf5` varchar(8) DEFAULT NULL,
  `nspf6` varchar(8) DEFAULT NULL,
  `spf1` varchar(8) DEFAULT NULL,
  `spf2` varchar(8) DEFAULT NULL,
  `spf3` varchar(8) DEFAULT NULL,
  `spf4` varchar(8) DEFAULT NULL,
  `spf5` varchar(8) DEFAULT NULL,
  `spf6` varchar(8) DEFAULT NULL,
  `spf7` varchar(8) DEFAULT NULL,
  `spf8` varchar(8) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`football_match_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3725 DEFAULT CHARSET=utf8;

/*Table structure for table `lottery_period` */

DROP TABLE IF EXISTS `lottery_period`;

CREATE TABLE `lottery_period` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `lottery_period` varchar(100) DEFAULT NULL COMMENT '比赛期数',
  `lottery_code` varchar(50) DEFAULT NULL COMMENT '彩票类型编码',
  `status` int(11) DEFAULT NULL COMMENT '状态（0-历史期，1-当前期，2-预售期）',
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `period_end_time` datetime DEFAULT NULL COMMENT '截止时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=205 DEFAULT CHARSET=utf8;

/*Table structure for table `member_user` */

DROP TABLE IF EXISTS `member_user`;

CREATE TABLE `member_user` (
  `id` varchar(32) NOT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `real_name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `birthday` varchar(32) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `state` varchar(64) DEFAULT NULL,
  `city` varchar(64) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `telephone` varchar(64) DEFAULT NULL,
  `bank_code` varchar(64) DEFAULT NULL,
  `identity_card` varchar(64) DEFAULT NULL,
  `sex` varchar(8) DEFAULT NULL,
  `bank_name` varchar(64) DEFAULT NULL,
  `activated` tinyint(1) DEFAULT NULL,
  `random_code` varchar(32) DEFAULT NULL,
  `total_score` int(11) DEFAULT '0',
  `available_score` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `order_detail` */

DROP TABLE IF EXISTS `order_detail`;

CREATE TABLE `order_detail` (
  `id` varchar(32) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `buy_cai_number` varchar(20) DEFAULT NULL,
  `detail_money` int(11) DEFAULT NULL,
  `detail_name` varchar(200) DEFAULT NULL,
  `order_id` varchar(32) DEFAULT NULL,
  `check_0` varchar(255) DEFAULT NULL,
  `check_1` varchar(255) DEFAULT NULL,
  `check_2` varchar(255) DEFAULT NULL,
  `check_3` varchar(255) DEFAULT NULL,
  `check_4` varchar(255) DEFAULT NULL,
  `check_5` varchar(255) DEFAULT NULL,
  `check_6` varchar(255) DEFAULT NULL,
  `check_7` varchar(255) DEFAULT NULL,
  `check_8` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_q6bwjb8y711vixrxinko7wmnw` (`order_id`),
  CONSTRAINT `FK_q6bwjb8y711vixrxinko7wmnw` FOREIGN KEY (`order_id`) REFERENCES `trade_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `state_city` */

DROP TABLE IF EXISTS `state_city`;

CREATE TABLE `state_city` (
  `id` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `class_parent_name` varchar(128) DEFAULT NULL,
  `class_parent_id` smallint(5) unsigned NOT NULL DEFAULT '0',
  `class_name` varchar(128) NOT NULL DEFAULT '',
  `class_type` tinyint(1) NOT NULL DEFAULT '2',
  PRIMARY KEY (`id`),
  KEY `class_parent_id` (`class_parent_id`),
  KEY `class_type` (`class_type`)
) ENGINE=MyISAM AUTO_INCREMENT=3409 DEFAULT CHARSET=utf8;

/*Table structure for table `sysman_resource` */

DROP TABLE IF EXISTS `sysman_resource`;

CREATE TABLE `sysman_resource` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `delete_flag` int(11) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `href` varchar(200) DEFAULT NULL,
  `icon_cls` varchar(200) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `order_no` int(11) DEFAULT NULL,
  `permission_str` varchar(200) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `p_menu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `FKA95124A0180B5AA9` (`p_menu_id`),
  CONSTRAINT `FKA95124A0180B5AA9` FOREIGN KEY (`p_menu_id`) REFERENCES `sysman_resource` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `sysman_role` */

DROP TABLE IF EXISTS `sysman_role`;

CREATE TABLE `sysman_role` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `delete_flag` int(11) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `creater_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `FK7D8902081B43F5BE` (`creater_id`),
  CONSTRAINT `FK7D8902081B43F5BE` FOREIGN KEY (`creater_id`) REFERENCES `sysman_user` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `sysman_role_resource` */

DROP TABLE IF EXISTS `sysman_role_resource`;

CREATE TABLE `sysman_role_resource` (
  `role_id` int(11) NOT NULL,
  `resource_id` int(11) NOT NULL,
  KEY `FK17BAC651BAA18E9` (`role_id`),
  KEY `FK17BAC65BE7B4269` (`resource_id`),
  CONSTRAINT `FK17BAC651BAA18E9` FOREIGN KEY (`role_id`) REFERENCES `sysman_role` (`pid`),
  CONSTRAINT `FK17BAC65BE7B4269` FOREIGN KEY (`resource_id`) REFERENCES `sysman_resource` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `sysman_user` */

DROP TABLE IF EXISTS `sysman_user`;

CREATE TABLE `sysman_user` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `delete_flag` int(11) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(32) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `position` varchar(20) DEFAULT NULL,
  `position_desc` varchar(100) DEFAULT NULL,
  `real_name` varchar(10) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `creater_id` int(11) DEFAULT NULL,
  `id` varchar(32) NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `FK7D8A6D5D1B43F5BE` (`creater_id`),
  CONSTRAINT `FK7D8A6D5D1B43F5BE` FOREIGN KEY (`creater_id`) REFERENCES `sysman_user` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Table structure for table `sysman_user_role` */

DROP TABLE IF EXISTS `sysman_user_role`;

CREATE TABLE `sysman_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FKD0596181BAA18E9` (`role_id`),
  KEY `FKD059618C0D4DCC9` (`user_id`),
  CONSTRAINT `FKD0596181BAA18E9` FOREIGN KEY (`role_id`) REFERENCES `sysman_role` (`pid`),
  CONSTRAINT `FKD059618C0D4DCC9` FOREIGN KEY (`user_id`) REFERENCES `sysman_user` (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `trade_order` */

DROP TABLE IF EXISTS `trade_order`;

CREATE TABLE `trade_order` (
  `id` varchar(32) NOT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `order_no` varchar(32) DEFAULT NULL,
  `order_status` int(11) DEFAULT NULL,
  `order_time` datetime DEFAULT NULL,
  `order_type` int(11) DEFAULT NULL,
  `pay_status` int(11) DEFAULT NULL,
  `total_money` int(11) DEFAULT NULL,
  `member_id` varchar(32) DEFAULT NULL,
  `lottery_period` int(11) DEFAULT NULL,
  `lottery_count` int(11) DEFAULT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  `lottery_type` varchar(255) DEFAULT NULL,
  `chuan_2_1` int(11) DEFAULT '0',
  `chuan_3_1` int(11) DEFAULT '0',
  `chuan_3_3` int(11) DEFAULT '0',
  `chuan_4_1` int(11) DEFAULT '0',
  `chaun_4_4` int(11) DEFAULT '0',
  `chaun_4_5` int(11) DEFAULT '0',
  `chaun_4_6` int(11) DEFAULT '0',
  `chuan_4_11` int(11) DEFAULT '0',
  `zhisheng_1` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_4g8b372xhhhd3bwlxd0g372d9` (`member_id`),
  KEY `FK_f1o3d5fxiaxh7v96h3wtl5m5k` (`lottery_period`),
  CONSTRAINT `FK_4g8b372xhhhd3bwlxd0g372d9` FOREIGN KEY (`member_id`) REFERENCES `member_user` (`id`),
  CONSTRAINT `FK_f1o3d5fxiaxh7v96h3wtl5m5k` FOREIGN KEY (`lottery_period`) REFERENCES `lottery_period` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `winning_number` */

DROP TABLE IF EXISTS `winning_number`;

CREATE TABLE `winning_number` (
  `winning_number_id` int(11) NOT NULL AUTO_INCREMENT,
  `expect` varchar(16) DEFAULT NULL,
  `open_code` varchar(32) DEFAULT NULL,
  `open_time` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `type_code` varchar(16) DEFAULT NULL,
  `type_name` varchar(16) DEFAULT NULL,
  `try_code` varchar(16) DEFAULT NULL,
  `ballsnum` varchar(16) DEFAULT NULL,
  `type_area` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`winning_number_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
