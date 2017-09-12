/*
SQLyog Community v12.4.1 (64 bit)
MySQL - 5.0.96-community-nt : Database - ds_slave_1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ds_slave_1` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `ds_slave_1`;

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
(1102,11,'INIT_SLAVE_1'),
(1104,11,'INIT_SLAVE_1'),
(1106,11,'INIT_SLAVE_1'),
(1108,11,'INIT_SLAVE_1');

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
(1101,11,'INIT_SLAVE_1'),
(1103,11,'INIT_SLAVE_1'),
(1105,11,'INIT_SLAVE_1'),
(1107,11,'INIT_SLAVE_1'),
(1109,11,'INIT_SLAVE_1');

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
(110001,1100,11),
(110201,1102,11),
(110401,1104,11),
(110601,1106,11),
(110801,1108,11);

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
(110101,1101,11),
(110301,1103,11),
(110501,1105,11),
(110701,1107,11),
(110901,1109,11);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
