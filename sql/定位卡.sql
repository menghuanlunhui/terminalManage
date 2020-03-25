/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : ry

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 25/03/2020 00:29:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_terminal_kinship
-- ----------------------------
DROP TABLE IF EXISTS `t_terminal_kinship`;
CREATE TABLE `t_terminal_kinship`  (
  `terminal_kinship_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `terminal_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '卡片主键',
  `terminal_kinship_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '亲情手机号',
  `terminal_kinship_contactor` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '亲情联络人姓名',
  `terminal_kinship_type` int(1) NULL DEFAULT 0 COMMENT '号码类型：0亲情号,1sos号码',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新人时间',
  PRIMARY KEY (`terminal_kinship_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定位卡关联亲情号码' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_terminal_info
-- ----------------------------
DROP TABLE IF EXISTS `t_terminal_info`;
CREATE TABLE `t_terminal_info`  (
  `terminal_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '卡片编码',
  `terminal_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '卡片名称',
  `terminal_group_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '卡片分组id',
  `terminal_status` int(1) NULL DEFAULT 0 COMMENT '卡片状态：0 在线 1离线',
  `enable_flag` int(1) NULL DEFAULT 1 COMMENT '启用禁用标志：0 禁用，1启用',
  `battery_percentage` decimal(3, 3) NULL DEFAULT NULL COMMENT '电量百分比（0到100之间）',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '卡片开通时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '卡片更新时间',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '卡片到期时间',
  PRIMARY KEY (`terminal_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定位卡基础信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_terminal_group
-- ----------------------------
DROP TABLE IF EXISTS `t_terminal_group`;
CREATE TABLE `t_terminal_group`  (
  `terminal_group_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '卡片分组主键id',
  `terminal_group_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '卡片分组名称',
  `terminal_group_level` int(2) NULL DEFAULT 0 COMMENT '分组层级，从0开始递增；0=root节点；',
  `parent_terminal_group_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '上级分组id',
  `enable_flag` int(1) NULL DEFAULT 1 COMMENT '启用禁用标志：:0 禁用，1启用',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`terminal_group_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定位卡分组信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_terminal_gps_log
-- ----------------------------
DROP TABLE IF EXISTS `t_terminal_gps_log`;
CREATE TABLE `t_terminal_gps_log`  (
  `serial_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'GPS记录主键id',
  `terminal_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '定位卡主键',
  `longitude` decimal(10, 2) NULL DEFAULT NULL COMMENT '经度',
  `latitude` decimal(10, 2) NULL DEFAULT NULL COMMENT '纬度',
  `battery_percentage` decimal(3, 3) NULL DEFAULT NULL COMMENT '上报时的电量百分比（0到100之间）',
  `fence_flag` int(1) NULL DEFAULT 2 COMMENT '电子围栏标志:0 不在围栏内，1在围栏内，2未设置围栏',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`serial_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定位卡定位记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_terminal_fence
-- ----------------------------
DROP TABLE IF EXISTS `t_terminal_fence`;
CREATE TABLE `t_terminal_fence`  (
  `terminal_fence_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `terminal_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '卡片主键',
  `terminal_fence_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子围栏类型：0圆形，1椭圆形，2线条形',
  `terminal_fence_point` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电子围栏顶点经纬度(多个顶点多条记录或者一条符号分隔开)',
  `enable_flag` int(1) NULL DEFAULT 1 COMMENT '启用禁用标志：0 禁用，1启用',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`terminal_fence_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定位卡电子围栏配置' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_terminal_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_terminal_dict`;
CREATE TABLE `t_terminal_dict`  (
  `terminal_dict_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '终端字典编码',
  `terminal_dict_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '终端字典名称',
  `terminal_dict_memo` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '终端字典备注信息',
  `terminal_dict_type` int(1) NULL DEFAULT NULL COMMENT '终端字典类型:0终端厂商字典，1终端设备类型',
  `enable_flag` int(1) NULL DEFAULT 1 COMMENT '启用禁用标志：0=禁用；1=启用',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`terminal_dict_code`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定位卡字典表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_terminal_alarm
-- ----------------------------
DROP TABLE IF EXISTS `t_terminal_alarm`;
CREATE TABLE `t_terminal_alarm`  (
  `terminal_alarm_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '主键id',
  `terminal_id` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '卡片主键',
  `terminal_alarm_cycle_day` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '闹钟周期设置:0周日，1周一，2周二，3周三，4周四，5周五，6周六；多个逗号分隔',
  `terminal_alarm_point` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '闹钟提醒时间点',
  `terminal_alarm_type` int(1) NULL DEFAULT 0 COMMENT '类型：0 闹钟 1整点报时',
  `enable_flag` int(1) NULL DEFAULT 1 COMMENT '启用禁用标志：0 禁用，1启用',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新人时间',
  PRIMARY KEY (`terminal_alarm_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '定位卡关联闹钟信息' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
