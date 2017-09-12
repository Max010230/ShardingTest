/*
SQLyog Community v12.4.1 (64 bit)
MySQL - 5.0.96-community-nt : Database - ds_master
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ds_master` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ds_master`;

/*Table structure for table `t_order_0` */

DROP TABLE IF EXISTS `t_order_0`;

CREATE TABLE `t_order_0` (
  `order_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `status` varchar(50) default NULL,
  PRIMARY KEY  (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `t_order_0` */

insert  into `t_order_0`(`order_id`,`user_id`,`status`) values 
(10,10,'10'),
(1000,10,'INIT_MASTER'),
(1002,10,'INIT_MASTER'),
(1004,10,'INIT_MASTER'),
(1006,10,'INIT_MASTER'),
(1008,10,'INIT_MASTER');

/*Table structure for table `t_order_1` */

DROP TABLE IF EXISTS `t_order_1`;

CREATE TABLE `t_order_1` (
  `order_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `status` varchar(50) default NULL,
  PRIMARY KEY  (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `t_order_1` */

insert  into `t_order_1`(`order_id`,`user_id`,`status`) values 
(1001,10,'INIT_MASTER'),
(1003,10,'INIT_MASTER'),
(1005,10,'INIT_MASTER'),
(1007,10,'INIT_MASTER');

/*Table structure for table `t_order_item_0` */

DROP TABLE IF EXISTS `t_order_item_0`;

CREATE TABLE `t_order_item_0` (
  `item_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY  (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `t_order_item_0` */

insert  into `t_order_item_0`(`item_id`,`order_id`,`user_id`) values 
(100001,1000,10),
(100201,1002,10),
(100401,1004,10),
(100601,1006,10),
(100801,1008,10);

/*Table structure for table `t_order_item_1` */

DROP TABLE IF EXISTS `t_order_item_1`;

CREATE TABLE `t_order_item_1` (
  `item_id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY  (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `t_order_item_1` */

insert  into `t_order_item_1`(`item_id`,`order_id`,`user_id`) values 
(100101,1001,10),
(100301,1003,10),
(100501,1005,10),
(100701,1007,10),
(100901,1009,10);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
