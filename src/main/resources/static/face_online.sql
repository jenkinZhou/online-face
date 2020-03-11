/*
Navicat MySQL Data Transfer

Source Server         : 腾讯云
Source Server Version : 50725
Source Host           : 119.29.175.198:1995
Source Database       : face_online

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-03-11 22:06:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for face_attachments
-- ----------------------------
DROP TABLE IF EXISTS `face_attachments`;
CREATE TABLE `face_attachments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `attachment_code` varchar(255) NOT NULL COMMENT '附件编码',
  `attachment_name` varchar(255) NOT NULL COMMENT '附件名称',
  `attachment_format` varchar(255) DEFAULT NULL COMMENT '附件格式（目前只能是图片）',
  `attachment_path` varchar(255) NOT NULL COMMENT '附件路径',
  `attachment_locate_year` varchar(4) NOT NULL COMMENT '附件归档年',
  `attachment_locate_month` varchar(2) NOT NULL COMMENT '附件归档月',
  `attachment_locate_day` varchar(2) NOT NULL COMMENT '附件归档日',
  `attachment_type` varchar(100) NOT NULL COMMENT '附件类型（评论附件，题目附件）',
  `del_flag` varchar(4) NOT NULL DEFAULT 'N' COMMENT '逻辑删除字段',
  `created_by` varchar(255) NOT NULL COMMENT '创建人',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` datetime NOT NULL COMMENT '更新人',
  `version_number` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of face_attachments
-- ----------------------------

-- ----------------------------
-- Table structure for face_point_change
-- ----------------------------
DROP TABLE IF EXISTS `face_point_change`;
CREATE TABLE `face_point_change` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `face_user_code` varchar(255) NOT NULL COMMENT '用户编码',
  `point_change_num` int(11) NOT NULL COMMENT '积分变动数目',
  `point_change_date` datetime NOT NULL COMMENT '积分变动时间',
  `point_change_type` varchar(255) NOT NULL COMMENT '积分变动类型，上传题目？做题？。。。',
  `point_change_content` varchar(4000) DEFAULT NULL COMMENT '积分变动详情',
  `del_flag` varchar(4) NOT NULL DEFAULT 'N' COMMENT '逻辑删除字段',
  `created_by` varchar(255) NOT NULL COMMENT '创建人',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` datetime NOT NULL COMMENT '更新人',
  `version_number` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of face_point_change
-- ----------------------------

-- ----------------------------
-- Table structure for face_question_comments
-- ----------------------------
DROP TABLE IF EXISTS `face_question_comments`;
CREATE TABLE `face_question_comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NOT NULL COMMENT '题目的ID',
  `reply_comment_id` int(11) NOT NULL DEFAULT '-1' COMMENT '回复的评论的ID',
  `question_comment` text COMMENT '评论内容',
  `del_flag` varchar(4) NOT NULL DEFAULT 'N' COMMENT '逻辑删除字段',
  `created_by` varchar(255) NOT NULL COMMENT '创建人',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` datetime NOT NULL COMMENT '更新人',
  `version_number` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of face_question_comments
-- ----------------------------

-- ----------------------------
-- Table structure for face_question_types
-- ----------------------------
DROP TABLE IF EXISTS `face_question_types`;
CREATE TABLE `face_question_types` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `face_question_type_name` varchar(255) NOT NULL COMMENT '题目类型的名称',
  `face_question_type_level` int(11) NOT NULL COMMENT '题目类型的级别 1,2,3,4',
  `del_flag` varchar(4) NOT NULL DEFAULT 'N' COMMENT '逻辑删除字段',
  `created_by` varchar(255) NOT NULL COMMENT '创建人',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` datetime NOT NULL COMMENT '更新人',
  `version_number` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of face_question_types
-- ----------------------------

-- ----------------------------
-- Table structure for face_questions
-- ----------------------------
DROP TABLE IF EXISTS `face_questions`;
CREATE TABLE `face_questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `face_seq_number` int(11) NOT NULL COMMENT '题目序号',
  `face_title` varchar(400) NOT NULL COMMENT '题目标题',
  `face_content` text NOT NULL COMMENT '题目描述',
  `face_standard_answer` text NOT NULL COMMENT '题目标准答案',
  `face_type_fourth` int(11) DEFAULT NULL,
  `face_type_third` int(11) DEFAULT NULL COMMENT '题目的三级分类（基础，并发，网络。。。）',
  `face_type_seond` int(11) DEFAULT NULL COMMENT '题目的二级分类（java，C，C++。。。）',
  `face_type_first` int(11) NOT NULL COMMENT '题目的以及分类（计算机网络、编程语言）',
  `face_tag` varchar(2000) DEFAULT NULL COMMENT '题目标签',
  `answer_note` text COMMENT '答案描述',
  `face_note` text COMMENT '题目描述',
  `face_approve_status` varchar(255) NOT NULL DEFAULT 'approve' COMMENT '题目的审核状态',
  `del_flag` varchar(4) NOT NULL DEFAULT 'N' COMMENT '逻辑删除字段',
  `created_by` varchar(255) NOT NULL COMMENT '创建人',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` datetime NOT NULL COMMENT '更新人',
  `version_number` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of face_questions
-- ----------------------------

-- ----------------------------
-- Table structure for face_train_questions_suit
-- ----------------------------
DROP TABLE IF EXISTS `face_train_questions_suit`;
CREATE TABLE `face_train_questions_suit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `face_train_question_id` int(11) NOT NULL COMMENT '当前题目的ID',
  `face_train_queston_answer` text NOT NULL COMMENT '当前题目你的解答',
  `face_train_difficulty` int(11) NOT NULL COMMENT '1-10 的整数，当前题目的困难程度',
  `face_train_pass` varchar(4) NOT NULL COMMENT '当前题目你认为是否通过（Y、N）',
  `face_train_note` text COMMENT '你对当前题目做的笔记',
  `del_flag` varchar(4) NOT NULL DEFAULT 'N' COMMENT '逻辑删除字段',
  `created_by` varchar(255) NOT NULL COMMENT '创建人',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` datetime NOT NULL COMMENT '更新人',
  `version_number` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of face_train_questions_suit
-- ----------------------------

-- ----------------------------
-- Table structure for face_user
-- ----------------------------
DROP TABLE IF EXISTS `face_user`;
CREATE TABLE `face_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `face_user_code` varchar(40) NOT NULL COMMENT '用户编号',
  `face_user_name` varchar(50) NOT NULL COMMENT '用户名称',
  `face_user_email` varchar(100) NOT NULL COMMENT '用户邮箱',
  `face_user_password` varchar(255) NOT NULL COMMENT '用户密码',
  `face_user_status` varchar(50) NOT NULL DEFAULT 'Enable' COMMENT '用户状态',
  `face_user_points` int(11) NOT NULL DEFAULT '0' COMMENT '用户的积分',
  `del_flag` varchar(4) NOT NULL DEFAULT 'N' COMMENT '逻辑删除字段',
  `created_by` varchar(255) NOT NULL COMMENT '创建人',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` datetime NOT NULL COMMENT '更新人',
  `version_number` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of face_user
-- ----------------------------

-- ----------------------------
-- Table structure for face_user_questions
-- ----------------------------
DROP TABLE IF EXISTS `face_user_questions`;
CREATE TABLE `face_user_questions` (
  `id` int(11) NOT NULL,
  `face_user_id` int(11) NOT NULL COMMENT '用户ID',
  `face_question_id` int(11) NOT NULL COMMENT '用户需要忽略的问题ID',
  `face_question_flag` varchar(40) NOT NULL COMMENT '忽略（ignore）还是 收藏（star）',
  `del_flag` varchar(4) NOT NULL DEFAULT 'N' COMMENT '逻辑删除字段',
  `created_by` varchar(255) NOT NULL COMMENT '创建人',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` datetime NOT NULL COMMENT '更新人',
  `version_number` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of face_user_questions
-- ----------------------------

-- ----------------------------
-- Table structure for face_user_train
-- ----------------------------
DROP TABLE IF EXISTS `face_user_train`;
CREATE TABLE `face_user_train` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `question_record_id` int(11) NOT NULL COMMENT '问题套餐记录ID',
  `face_train_type` varchar(40) NOT NULL COMMENT '当前进行的训练的类型（专项随机，专项顺序。。）',
  `face_train_result` double(9,2) NOT NULL COMMENT '本次训练的结果',
  `del_flag` varchar(4) NOT NULL DEFAULT 'N' COMMENT '逻辑删除字段',
  `created_by` varchar(255) NOT NULL COMMENT '创建人',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` datetime NOT NULL COMMENT '更新人',
  `version_number` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of face_user_train
-- ----------------------------
