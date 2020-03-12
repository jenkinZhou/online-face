/*
Navicat MySQL Data Transfer

Source Server         : 腾讯云
Source Server Version : 50725
Source Host           : 119.29.175.198:1995
Source Database       : face_online

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2020-03-12 22:58:03
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
  `last_updated_by` varchar(50) NOT NULL COMMENT '更新人',
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
  `last_updated_by` varchar(50) NOT NULL COMMENT '更新人',
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
  `last_updated_by` varchar(50) NOT NULL COMMENT '更新人',
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
  `parent_id` int(11) NOT NULL,
  `del_flag` varchar(4) NOT NULL DEFAULT 'N' COMMENT '逻辑删除字段',
  `created_by` varchar(255) NOT NULL COMMENT '创建人',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(50) NOT NULL COMMENT '更新人',
  `version_number` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of face_question_types
-- ----------------------------
INSERT INTO `face_question_types` VALUES ('1', '计算机编程语言', '1', '0', 'N', 'jenkin', '2020-03-12 15:42:25', '2020-03-12 15:42:29', 'jenkin', '0');
INSERT INTO `face_question_types` VALUES ('2', 'JAVA', '2', '1', 'N', 'jenkin', '2020-03-12 15:45:33', '2020-03-12 15:45:36', 'jenkin', '0');
INSERT INTO `face_question_types` VALUES ('3', '基础知识', '3', '2', 'N', 'jenkin', '2020-03-12 15:46:10', '2020-03-12 15:46:14', 'jenkin', '0');

-- ----------------------------
-- Table structure for face_questions
-- ----------------------------
DROP TABLE IF EXISTS `face_questions`;
CREATE TABLE `face_questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `face_seq_number` int(11) NOT NULL COMMENT '题目序号',
  `face_title` varchar(400) NOT NULL COMMENT '题目标题',
  `face_content` text COMMENT '题目描述',
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
  `last_updated_by` varchar(50) NOT NULL COMMENT '更新人',
  `version_number` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of face_questions
-- ----------------------------
INSERT INTO `face_questions` VALUES ('1', '1', '两个对象的 hashCode（）相同，则 equals（）也一定为 true，对吗?', '', '两个对象equals相等，则它们的hashcode必须相等，反之则不一定。\r\n两个对象==相等，则其hashcode一定相等，反之不一定成立。\r\nhashCode 的常规协定：\r\n\r\n1.在 Java 应用程序执行期间，在对同一对象多次调用 hashCode 方法时，必须一致地返回相同的整数，前提是将对象进行 equals 比较时所用的信息没有被修改。从某一应用程序的一次执行到同一应用程序的另一次执行，该整数无需保持一致。\r\n\r\n2.两个对象的equals()相等，那么对这两个对象中的每个对象调用 hashCode 方法都必须生成相同的整数结果。\r\n\r\n3.两个对象的equals()不相等，那么对这两个对象中的任一对象上调用 hashCode 方法不要求一定生成不同的整数结果。但是，为不相等的对象生成不同整数结果可以提高哈希表的性能。', null, '3', '2', '1', '计算机语言;java;', null, null, 'approve', 'N', 'jenkin', '2020-03-12 14:05:23', '2020-03-12 14:05:30', '', '0');
INSERT INTO `face_questions` VALUES ('2', '2', '串行，并行和并发有什么区别？', '', '1、串行指的是一个所有的任务都按照先后顺序执行，在前一个任务没处理完的情况下是不会去处理下一个任务的，就像理发店只有一个理发师，每个人剪头发都需要等待前面的人处理完\r\n2、并行是指将任务分给不同的处理器去处理，每一个处理器再串行处理，比如火车站售票会有多个窗口\r\n3、并发实质上是一种现象，并发的需要处理器的支持，比如在处理一个任务的时候操作系统可以进行调度再处理其他任务，不论串行还是并行，都需要操作系统支持并发，假设喝水是一个任务，那么每个火车售票员在卖票的同时也能喝水，那么就支持并发', null, '3', '2', '1', '计算机语言;java;', '', '', 'approve', 'N', 'jenkin', '2020-03-12 14:05:23', '2020-03-12 14:05:30', '', '0');

-- ----------------------------
-- Table structure for face_train_questions_suit
-- ----------------------------
DROP TABLE IF EXISTS `face_train_questions_suit`;
CREATE TABLE `face_train_questions_suit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `face_train_question_id` int(11) NOT NULL COMMENT '当前题目的ID',
  `face_train_id` int(11) NOT NULL COMMENT '训练计划的ID',
  `face_train_queston_answer` text NOT NULL COMMENT '当前题目你的解答',
  `face_train_difficulty` int(11) NOT NULL COMMENT '1-10 的整数，当前题目的困难程度',
  `face_train_pass` varchar(4) NOT NULL COMMENT '当前题目你认为是否通过（Y、N）',
  `face_train_note` text COMMENT '你对当前题目做的笔记',
  `del_flag` varchar(4) NOT NULL DEFAULT 'N' COMMENT '逻辑删除字段',
  `created_by` varchar(255) NOT NULL COMMENT '创建人',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(50) NOT NULL COMMENT '更新人',
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
  `last_updated_by` varchar(50) NOT NULL COMMENT '更新人',
  `version_number` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of face_user
-- ----------------------------
INSERT INTO `face_user` VALUES ('1', 'jenkin', 'Jenkin', '1294046585@qq.com', '123456', 'Enable', '0', 'N', 'jenkin', '2020-03-12 20:40:31', '2020-03-12 20:40:31', 'jenkin', '0');

-- ----------------------------
-- Table structure for face_user_questions
-- ----------------------------
DROP TABLE IF EXISTS `face_user_questions`;
CREATE TABLE `face_user_questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `face_user_code` varchar(40) NOT NULL COMMENT '用户编码',
  `face_question_id` int(11) NOT NULL COMMENT '用户需要忽略的问题ID',
  `face_question_flag` varchar(40) NOT NULL COMMENT '忽略（ignore）还是 收藏（star）',
  `del_flag` varchar(4) NOT NULL DEFAULT 'N' COMMENT '逻辑删除字段',
  `created_by` varchar(255) NOT NULL COMMENT '创建人',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(50) NOT NULL COMMENT '更新人',
  `version_number` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of face_user_questions
-- ----------------------------
INSERT INTO `face_user_questions` VALUES ('1', '1', '1', 'star', 'N', 'jenkin', '2020-03-12 17:45:36', '2020-03-12 17:45:41', 'jenkin', '0');
INSERT INTO `face_user_questions` VALUES ('2', '1', '2', 'star', 'N', 'jenkin', '2020-03-12 17:45:36', '2020-03-12 17:45:41', 'jenkin', '0');

-- ----------------------------
-- Table structure for face_user_train
-- ----------------------------
DROP TABLE IF EXISTS `face_user_train`;
CREATE TABLE `face_user_train` (
  `id` int(11) NOT NULL,
  `user_code` varchar(40) NOT NULL COMMENT '用户编码',
  `question_record_id` int(11) NOT NULL COMMENT '问题套餐记录ID',
  `face_train_type` varchar(40) NOT NULL COMMENT '当前进行的训练的类型（自定义随机）',
  `question_num` int(11) NOT NULL DEFAULT '50' COMMENT '题目数目，默认50',
  `filter_question_first_type` varchar(100) DEFAULT NULL COMMENT '过滤的题目的一级分类，保存ID，分号分割',
  `filter_question_second_type` varchar(400) DEFAULT NULL COMMENT '过滤的题目的二级分类，保存ID，分号分割',
  `filter_question_third_type` varchar(400) DEFAULT NULL COMMENT '过滤的题目的三级分类，保存ID，分号分割',
  `filter_question_fourth_type` varchar(400) DEFAULT NULL COMMENT '过滤的题目的四级分类，保存ID，分号分割',
  `filter_type` varchar(20) DEFAULT NULL COMMENT '过滤类型：最近一次（lastOne），两次（lastTwo），三次（lastThree）做过的不做，或者做过的（LastAll）不做,为空不过滤',
  `face_train_result` double(9,2) NOT NULL COMMENT '本次训练的结果',
  `del_flag` varchar(4) NOT NULL DEFAULT 'N' COMMENT '逻辑删除字段',
  `created_by` varchar(255) NOT NULL COMMENT '创建人',
  `creation_date` datetime NOT NULL COMMENT '创建时间',
  `last_update_date` datetime NOT NULL COMMENT '更新时间',
  `last_updated_by` varchar(50) NOT NULL COMMENT '更新人',
  `version_number` int(11) NOT NULL DEFAULT '0' COMMENT '版本号',
  `face_train_status` varchar(40) NOT NULL DEFAULT 'running' COMMENT '本次训练状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of face_user_train
-- ----------------------------
