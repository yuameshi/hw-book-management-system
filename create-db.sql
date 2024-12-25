-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.11.5-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  12.8.0.6908
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 导出 bookdb 的数据库结构
CREATE DATABASE IF NOT EXISTS `bookdb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `bookdb`;

-- 导出  表 bookdb.book 结构
CREATE TABLE IF NOT EXISTS `book` (
  `id` varchar(8) NOT NULL COMMENT '图书编号',
  `bookname` varchar(100) DEFAULT NULL COMMENT '图书名称',
  `booktype` varchar(50) DEFAULT '科技' COMMENT '图书类别',
  `author` varchar(50) DEFAULT NULL COMMENT '图书作者',
  `translator` varchar(50) DEFAULT NULL COMMENT '译者',
  `publisher` varchar(100) DEFAULT NULL COMMENT '出版社',
  `publish_time` datetime DEFAULT NULL COMMENT '出版时间',
  `price` float DEFAULT 28 COMMENT '定价',
  `stock` int(11) DEFAULT 1 COMMENT '库存数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 正在导出表  bookdb.book 的数据：~0 rows (大约)

-- 导出  表 bookdb.borrow 结构
CREATE TABLE IF NOT EXISTS `borrow` (
  `int` int(11) NOT NULL AUTO_INCREMENT COMMENT '借阅流水号',
  `book_id` varchar(50) DEFAULT NULL COMMENT '图书编号',
  `reader_id` varchar(50) DEFAULT NULL COMMENT '读者编号',
  `borrow_date` datetime DEFAULT NULL COMMENT '借阅时间',
  `back_date` datetime DEFAULT NULL COMMENT '还书时间',
  `if_back` varchar(2) DEFAULT NULL COMMENT '是否归还',
  PRIMARY KEY (`int`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 正在导出表  bookdb.borrow 的数据：~0 rows (大约)

-- 导出  表 bookdb.reader 结构
CREATE TABLE IF NOT EXISTS `reader` (
  `id` varchar(8) NOT NULL COMMENT '读者编号',
  `readername` varchar(50) DEFAULT NULL COMMENT '读者姓名',
  `readertype` varchar(50) DEFAULT NULL COMMENT '读者类别',
  `sex` varchar(2) DEFAULT NULL COMMENT '读者性别',
  `max_num` int(11) DEFAULT NULL COMMENT '最大可借数',
  `days_num` int(11) DEFAULT NULL COMMENT '可借天数',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 正在导出表  bookdb.reader 的数据：~0 rows (大约)

-- 导出  表 bookdb.users 结构
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户流水号',
  `username` varchar(50) DEFAULT NULL COMMENT '用户姓名',
  `password` varchar(50) DEFAULT NULL COMMENT '用户密码',
  `is_admin` varchar(2) DEFAULT NULL COMMENT '是否为管理员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 正在导出表  bookdb.users 的数据：~0 rows (大约)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
