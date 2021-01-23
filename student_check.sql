/*
 Navicat Premium Data Transfer

 Source Server         : StudentSearch
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : student

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 1/15/2021 08:50:20
*/

-- CREATE TABLE `class`  (
--   `CLno` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
--   `CLnum` int(11) NULL DEFAULT NULL,
--   `CLdept` char(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   `CLmajor` char(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   PRIMARY KEY (`CLno`) USING BTREE
-- ) ENGINE = InnoDB CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Dynamic;
-- 
-- INSERT INTO `class` VALUES ('18070241', 48, '大数据学院', '物联网工程');
-- INSERT INTO `class` VALUES ('18070242', 50, '大数据学院', '物联网工程');


-- SET NAMES utf8mb4;
-- SET FOREIGN_KEY_CHECKS = 0;
-- 
-- ----------------------------
-- Table structure for classcourse
-- ----------------------------
-- DROP TABLE IF EXISTS `classcourse`;
-- CREATE TABLE `classcourse`  (
--   `CLno` char(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
--   `Cno` char(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
--   `Cyear` char(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   `Cterm` char(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   PRIMARY KEY (`CLno`, `Cno`) USING BTREE,
--   INDEX `CCno`(`Cno`) USING BTREE,
--   CONSTRAINT `CCno` FOREIGN KEY (`Cno`) REFERENCES `course` (`Cno`) ON DELETE RESTRICT ON UPDATE RESTRICT,
--   CONSTRAINT `CLno` FOREIGN KEY (`CLno`) REFERENCES `class` (`CLno`) ON DELETE RESTRICT ON UPDATE RESTRICT
-- ) ENGINE = InnoDB CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Dynamic;



-- ----------------------------
-- Records of classcourse
-- ----------------------------
-- INSERT INTO `classcourse` VALUES ('18070241', 'B02076605', '2020-2021', '第一学期');
-- INSERT INTO `classcourse` VALUES('18070241', 'B03076603', '2020-2021', '第一学期');
-- INSERT INTO `classcourse` VALUES('18070241', 'B03070904', '2020-2021', '第一学期');

-- INSERT INTO `classcourse` VALUES ('18070242', 'B02076605', '2020-2021', '第一学期');
-- INSERT INTO `classcourse` VALUES('18070242', 'B03076603', '2020-2021', '第一学期');
-- INSERT INTO `classcourse` VALUES('18070242', 'B03070904', '2020-2021', '第一学期');



-- ----------------------------
-- Table structure for course
-- ----------------------------
-- CREATE TABLE `course`  (
--   `Cno` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
--   `Cname` varchar(50) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
--   `Cperiod` int(2) NULL DEFAULT NULL,
--   `Ccredit` double(4, 0) NULL DEFAULT NULL,
--   `Cattribute` char(4) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
--   PRIMARY KEY (`Cno`) USING BTREE
-- ) ENGINE = InnoDB CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Dynamic;



-- ----------------------------
-- Records of course
-- ----------------------------
-- INSERT INTO `course` VALUES ('B02076605', '数据库原理及应用', 56, 3.5, '必修');
-- INSERT INTO `course` VALUES ('B03076603', '数值分析', 40, 2.5, '必修');
-- INSERT INTO `course` VALUES ('B03070904', 'RFID原理及应用', 40, 2.5, '必修');




-- ----------------------------
-- Table structure for csgrade
-- ----------------------------
-- CREATE TABLE `csgrade`  (
--   `Sno` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
--   `Cno` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
--   `Grade` double(4, 0) NULL DEFAULT NULL,
--   PRIMARY KEY (`Sno`, `Cno`) USING BTREE,
--   INDEX `Sno`(`Sno`) USING BTREE,
--   INDEX `Cno`(`Cno`) USING BTREE,
--   CONSTRAINT `Sno` FOREIGN KEY (`Sno`) REFERENCES `student` (`Sno`) ON DELETE RESTRICT ON UPDATE RESTRICT
-- ) ENGINE = InnoDB CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Dynamic;
-- 


-- ----------------------------
-- Records of csgrade
-- ----------------------------
-- INSERT INTO `csgrade` VALUES ('1807004120', 'B02076605', 96);
-- INSERT INTO `csgrade` VALUES ('1807004120', 'B03076603', 90);
-- INSERT INTO `csgrade` VALUES ('1807004120', 'B03070904', 91);

-- INSERT INTO `csgrade` VALUES ('1807004501', 'B02076605', 99);
-- INSERT INTO `csgrade` VALUES ('1807004501', 'B03076603', 98);
-- INSERT INTO `csgrade` VALUES ('1807004501', 'B03070904', 97);

-- INSERT INTO `csgrade` VALUES ('1807004503', 'B02076605', 99);
-- INSERT INTO `csgrade` VALUES ('1807004503', 'B03076603', 97);
-- INSERT INTO `csgrade` VALUES ('1807004503', 'B03070904', 98);
-- 
-- INSERT INTO `csgrade` VALUES ('1807004507', 'B02076605', 99);
-- INSERT INTO `csgrade` VALUES ('1807004507', 'B03076603', 97);
-- INSERT INTO `csgrade` VALUES ('1807004507', 'B03070904', 98);

-- INSERT INTO `csgrade` VALUES ('1807004518', 'B02076605', 100);
-- INSERT INTO `csgrade` VALUES ('1807004518', 'B03076603', 99);
-- INSERT INTO `csgrade` VALUES ('1807004518', 'B03070904', 98);
-- 

-- ----------------------------
-- Table structure for manager
-- ----------------------------
-- DROP TABLE IF EXISTS `manager`;
-- CREATE TABLE `manager`  (
--   `Mno` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
--   `Mname` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
--   `Msex` varchar(2) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
--   `Mage` int(2) NULL DEFAULT NULL,
--   `Mpassword` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   `Mtel` varchar(11) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
--   `Memail` varchar(25) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   PRIMARY KEY (`Mno`) USING BTREE
-- ) ENGINE = InnoDB CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for student
-- ----------------------------
-- CREATE TABLE `student`  (
--   `Sno` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
--   `Sname` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   `Ssex` char(2) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   `Sage` int(2) NULL DEFAULT NULL,
--   `Sclass` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   `Spassword` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
--   `Stel` varchar(11) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   `Semail` varchar(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   PRIMARY KEY (`Sno`) USING BTREE,
--   INDEX `Sclass`(`Sclass`) USING BTREE,
--   CONSTRAINT `Sclass` FOREIGN KEY (`Sclass`) REFERENCES `class` (`CLno`) ON DELETE RESTRICT ON UPDATE RESTRICT
-- ) ENGINE = InnoDB CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Records of student
-- ----------------------------
-- INSERT INTO `student` VALUES ('1807004120', '秦嘉豪', '男', 21, '18070241', '123456', '18603428353', '656673477@qq.com');
-- INSERT INTO `student` VALUES('1807004501', '张立莹', '女', 21, '18070241', '123456', '13068070890', '2624782876@qq.com');
-- INSERT INTO `student` VALUES('1807004503', '霍鑫', '女', 21, '18070241', '123456', '18335647885', '2751308258@qq.com');
-- INSERT INTO `student` VALUES('1807004518', '布嘉琦', '男', 21, '18070242', '123456', '19834406823', '2579760416@qq.com');
-- INSERT INTO `student` VALUES('1807004507', '贾向茹', '女', 21, '18070242', '123456', '13994096151', '2374938099@qq.com');
-- 



-- ----------------------------
-- Table structure for teacher
-- ----------------------------
-- CREATE TABLE `teacher`  (
--   `Tno` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
--   `Tname` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   `Tsex` char(2) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   `Tage` int(2) NULL DEFAULT NULL,
--   `Tdept` varchar(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   `Tdegree` varchar(8) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
--   `Ttitle` varchar(4) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   `Tduty` varchar(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   `Ttel` varchar(11) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   `Temail` varchar(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   `Tpassword` varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
--   PRIMARY KEY (`Tno`) USING BTREE
-- ) ENGINE = InnoDB CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Dynamic;
-- 


-- ----------------------------
-- Records of teacher
-- ----------------------------
-- INSERT INTO `teacher` VALUES ('T01', '蔺素珍', '女', 48, '大数据学院', '博士', '教授', '学科部副主任', '13753167088', 'lsz@nuc.edu.cn', '123456');
-- INSERT INTO `teacher` VALUES ('T02', '秦品乐', '男', 47, '大数据学院', '博士', '教授', '教学院长', '15935133641', 'qpl@nuc.edu.cn', '123456');
-- INSERT INTO `teacher` VALUES ('T03', '柴锐', '男', 39, '大数据学院', '博士', '讲师', '无', '18734862829', '282218567@qq.com', '123456');


-- ----------------------------
-- Table structure for teaching
-- ----------------------------
-- CREATE TABLE `teaching`  (
--   `Tno` char(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
--   `Cno` char(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
--   `Cposition` char(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   `Cweek` char(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   `Ctime1` char(30) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   `Ctime2` char(30) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   `Cyear` char(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   `Cterm` char(20) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,
--   PRIMARY KEY (`Tno`, `Cno`) USING BTREE,
--   INDEX `TCno`(`Cno`) USING BTREE,
--   CONSTRAINT `TCno` FOREIGN KEY (`Cno`) REFERENCES `course` (`Cno`) ON DELETE RESTRICT ON UPDATE RESTRICT,
--   CONSTRAINT `TTno` FOREIGN KEY (`Tno`) REFERENCES `teacher` (`Tno`) ON DELETE RESTRICT ON UPDATE RESTRICT
-- ) ENGINE = InnoDB CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Dynamic;
-- 

-- INSERT INTO `teaching` VALUES ('T01', 'B02076605', '14301H', '3-13 周', '周一 10:10-11:50', '周二 10:10-11:50', '2020-2021', '第一学期');
-- INSERT INTO `teaching` VALUES ('T02', 'B03076603', '15502H', '11-18 周', '周二 14:00-15:40', '周四 14:00-15:40', '2020-2021', '第一学期');
-- INSERT INTO `teaching` VALUES ('T03', 'B03070904', '15502H', '3-10 周', '周二 14:00-15:40', '周四 14:00-15:40', '2020-2021', '第一学期');