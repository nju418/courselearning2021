
SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;




-- ----------------------------
-- Table structure for reply_notice
-- ----------------------------
DROP TABLE IF EXISTS `reply_notice`;
CREATE TABLE `reply_notice`  (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `user_id` int(11) NOT NULL,
                         `reply_id` int(11) NOT NULL UNIQUE,

                         PRIMARY KEY (`id`) USING BTREE,
                         INDEX `reply_notice_reply`(`reply_id`) USING BTREE,
                         INDEX `reply_notice_user`(`user_id`) USING BTREE,
                         CONSTRAINT `reply_notice_reply` FOREIGN KEY (`reply_id`) REFERENCES `reply` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
                         CONSTRAINT `reply_notice_user` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reply_notice
-- ----------------------------

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply`  (
                          `id` int(11) NOT NULL AUTO_INCREMENT,
                          `post_id` int(11) NOT NULL,
                          `user_id` int(11) NOT NULL,
                          `reply_id` int(11) NULL DEFAULT NULL,
                          `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                          `create_time` datetime(0) NOT NULL,

                          PRIMARY KEY (`id`) USING BTREE,
                          INDEX `reply_post`(`post_id`) USING BTREE,
                          INDEX `reply_user`(`user_id`) USING BTREE,

                          CONSTRAINT `reply_post` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
                          CONSTRAINT `reply_user` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reply
-- ----------------------------

-- ----------------------------
-- Table structure for post
-- ----------------------------
DROP TABLE IF EXISTS `post`;
CREATE TABLE `post`  (
                         `id` int(11) NOT NULL AUTO_INCREMENT,
                         `user_id` int(11) NOT NULL,
                         `course_id` int(11) NOT NULL,
                         `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                         `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
                         `create_time` datetime(0) NOT NULL,
                         `latest_reply_time` datetime(0) NOT NULL,


                         PRIMARY KEY (`id`) USING BTREE,
                         INDEX `post_course`(`course_id`) USING BTREE,
                         INDEX `post_user`(`user_id`) USING BTREE,
                         CONSTRAINT `post_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
                         CONSTRAINT `post_user` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of post
-- id user_id course_id title content create_time latest_reply_time
-- ----------------------------

INSERT INTO `post` VALUES (1, 3, 2, '视频很好，老师讲得也很好，明年还来', '如题', '2021-06-10 10:00:00', '2021-06-10 10:00:00');
INSERT INTO `post` VALUES (2, 4, 5, '伏晓牛逼', 'RT', '2021-06-10 10:00:00', '2021-06-10 10:00:00');
INSERT INTO `post` VALUES (3, 5, 6, '西五招人', '连418wifi', '2021-06-10 10:00:00', '2021-06-10 10:00:00');

INSERT INTO `post` VALUES (4, 2, 2, '讲得太好了', '这门课程讲得太好了是怎么回事呢？这门课程相信大家都很熟悉，但是这门课程讲得太好了是怎么回事呢，下面就让小编带大家一起了解吧。
　　这门课程讲得太好了，其实就是听不太懂，大家可能会很惊讶这门课程怎么会讲得太好了呢？但事实就是这样，小编也感到非常惊讶。
　　这就是关于这门课程讲得太好了的事情了，大家有什么想法呢，欢迎在评论区告诉小编一起讨论哦！', '2021-01-01 10:00:00', '2021-01-01 10:00:00');
INSERT INTO `post` VALUES (5, 1, 2, '软件工程基础', '如题', '2021-06-01 10:00:00', '2021-06-01 10:00:00');
INSERT INTO `post` VALUES (6, 1, 2, '软件工程的发展', '如题', '2021-06-02 10:00:00', '2021-06-02 10:00:00');
INSERT INTO `post` VALUES (7, 1, 2, '项目启动', '如题', '2021-06-03 10:00:00', '2021-06-03 10:00:00');
INSERT INTO `post` VALUES (8, 1, 2, '需求开发阶段', '如题', '2021-06-04 10:00:00', '2021-06-04 10:00:00');
INSERT INTO `post` VALUES (9, 1, 2, '软件需求基础', '如题', '2021-06-05 10:00:00', '2021-06-05 10:00:00');
INSERT INTO `post` VALUES (10, 1, 2, '需求分析方法', '如题', '2021-06-06 10:00:00', '2021-06-06 10:00:00');
INSERT INTO `post` VALUES (11, 1, 2, '需求文档化与验证', '如题', '2021-06-07 10:00:00', '2021-06-07 10:00:00');
INSERT INTO `post` VALUES (12, 1, 2, '软件设计', '如题', '2021-06-08 10:00:00', '2021-06-08 10:00:00');
INSERT INTO `post` VALUES (13, 1, 2, '软件设计基础', '如题', '2021-06-09 10:00:00', '2021-06-09 10:00:00');
INSERT INTO `post` VALUES (14, 1, 2, '软件体系结构基础', '如题', '2021-06-10 10:00:00', '2021-06-10 10:00:00');
INSERT INTO `post` VALUES (15, 1, 2, '软件体系结构设计与构建', '如题', '2021-06-11 10:00:00', '2021-06-11 10:00:00');
INSERT INTO `post` VALUES (16, 1, 2, '人机交互设计', '如题', '2021-06-12 10:00:00', '2021-06-12 10:00:00');
INSERT INTO `post` VALUES (17, 1, 2, '详细设计的基础', '如题', '2021-06-13 10:00:00', '2021-06-13 10:00:00');
INSERT INTO `post` VALUES (18, 1, 2, '视详细设计中的模块化与信息隐藏', '如题', '2021-06-14 10:00:00', '2021-06-14 10:00:00');
INSERT INTO `post` VALUES (19, 1, 2, '详细设计中面向对象方法下的模块化', '如题', '2021-06-15 10:00:00', '2021-06-15 10:00:00');


-- ----------------------------
-- Table structure for coupon
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `scope` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `metadata` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `start_time` datetime(0) NULL DEFAULT NULL,
  `end_time` datetime(0) NULL DEFAULT NULL,
  `is_valid` tinyint(1) NOT NULL DEFAULT 1,
  `is_sharable` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `school` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NOT NULL,
  `delete_time` datetime(0) NULL DEFAULT NULL,
  `cost` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `teacher_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_user_course`(`teacher_id`) USING BTREE,
  CONSTRAINT `fk_user_course` FOREIGN KEY (`teacher_id`) REFERENCES `user_info` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '软件工程与计算 I', '中级', '通过Scheme、Python和Java语言，让你分别体会函数式编程范式、结构化编程范式和面向对象编程范式', 'course1.png', '南京大学', '2020-12-20 10:00:00', NULL, 100, 1, '刘钦');
INSERT INTO `course` VALUES (2, '软件工程与计算 II', '中级', '基于DevOps培养团队开发中小规模软件系统的能力', 'course2.png', '南京大学', '2020-12-20 10:00:00', NULL, 200, 1, '刘钦');
INSERT INTO `course` VALUES (3, '互联网计算', '中级', '掌握计算机通信技术的基础原理', Null, '南京大学', '2020-12-20 10:00:00', NULL, 200, 7, '刘峰');
INSERT INTO `course` VALUES (4, 'C++高级程序设计', '高级', '课程内容主要包括过程化和面向对象两种程序设计方法、C++语言以及C++程序设计技巧。', NULL, '南京大学', '2020-12-20 10:00:00', NULL, 400, 8, '潘敏学');
INSERT INTO `course` VALUES (5, '数据管理基础', '初级', '本课程从理论和实践两方面详细介绍了数据库的设计和实现，包括关系理论，数据库设计，数据库的实现以及性能优化等问题。', NULL, '南京大学', '2020-12-20 10:00:00', NULL, 1, 9, '伏晓');
INSERT INTO `course` VALUES (6, '中国近现代史纲要', '初级', '通过本课程教学，提高学生对中国近现代史的认知能力与分析能力，坚定民族自信心，树立为中华民族伟大复兴而奋斗的使命感。', NULL, '南京大学', '2020-12-20 10:00:00', NULL, 0, 10, '周瑞瑞');

-- ----------------------------
-- Table structure for course_likes
-- ----------------------------
DROP TABLE IF EXISTS `course_likes`;
CREATE TABLE `course_likes`  (
  `course_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`course_id`, `user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course_order
-- ----------------------------
DROP TABLE IF EXISTS `course_order`;
CREATE TABLE `course_order`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `origin` int(11) NOT NULL,
  `cost` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `course_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  `user_id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_course_order`(`course_id`) USING BTREE,
  INDEX `fk_user_order`(`user_id`) USING BTREE,
  CONSTRAINT `fk_course_order` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_user_order` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course_order_coupon
-- ----------------------------
DROP TABLE IF EXISTS `course_order_coupon`;
CREATE TABLE `course_order_coupon`  (
  `order_id` int(11) NOT NULL,
  `coupon_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`, `coupon_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for course_ware
-- ----------------------------
DROP TABLE IF EXISTS `course_ware`;
CREATE TABLE `course_ware`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL,
  `number` int(11) NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `file_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `file_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `file_size` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `free_flag` tinyint(1) NOT NULL DEFAULT 0,
  `download_flag` tinyint(1) NOT NULL DEFAULT 1,
  `upload_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_course_ware`(`course_id`) USING BTREE,
  CONSTRAINT `fk_course_ware` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 198 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course_ware
-- ----------------------------
INSERT INTO `course_ware` VALUES (2, 1, 1, '00 - Overview', NULL, NULL, NULL, 0, 1, '2020-12-18 10:00:00');
INSERT INTO `course_ware` VALUES (3, 1, 2, '01 - 编程语言概述', NULL, NULL, NULL, 0, 1, '2020-12-18 10:00:00');

-- ----------------------------
-- Table structure for recharge_order
-- ----------------------------
DROP TABLE IF EXISTS `recharge_order`;
CREATE TABLE `recharge_order`  (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `value` int(11) NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`order_id`) USING BTREE,
  INDEX `fk_user_recharge`(`user_id`) USING BTREE,
  CONSTRAINT `fk_user_recharge` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_coupon
-- ----------------------------
DROP TABLE IF EXISTS `user_coupon`;
CREATE TABLE `user_coupon`  (
  `user_id` int(11) NOT NULL,
  `coupon_id` int(11) NOT NULL,
  `nums` int(11) NOT NULL,
  PRIMARY KEY (`user_id`, `coupon_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `balance` int(11) NOT NULL,
  `user_role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_time` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, '刘钦', '10112345678', '123456', NULL, 0, 'TEACHER', '2020-12-18 10:00:00');
INSERT INTO `user_info` VALUES (2, '小明', '10212345678', '123456', NULL, 0, 'STUDENT', '2020-12-18 10:00:00');
INSERT INTO `user_info` VALUES (3, '颜昊明', '19191250171', '123456', NULL, 0, 'STUDENT', '2020-12-18 10:00:00');
INSERT INTO `user_info` VALUES (4, '唐家伦', '19191250131', '123456', NULL, 0, 'STUDENT', '2020-12-18 10:00:00');
INSERT INTO `user_info` VALUES (5, '孙钰昇', '19191250128', '123456', NULL, 0, 'STUDENT', '2020-12-18 10:00:00');
INSERT INTO `user_info` VALUES (6, '杨骏丰', '19191250177', '123456', NULL, 0, 'STUDENT', '2020-12-18 10:00:00');
INSERT INTO `user_info` VALUES (7, '刘峰', '00000000001', '123456', NULL, 0, 'TEACHER', '2020-12-18 10:00:00');
INSERT INTO `user_info` VALUES (8, '潘敏学', '00000000002', '123456', NULL, 0, 'TEACHER', '2020-12-18 10:00:00');
INSERT INTO `user_info` VALUES (9, '伏晓', '00000000003', '123456', NULL, 0, 'TEACHER', '2020-12-18 10:00:00');
INSERT INTO `user_info` VALUES (10, '周瑞瑞', '00000000004', '123456', NULL, 0, 'TEACHER', '2020-12-18 10:00:00');
SET FOREIGN_KEY_CHECKS = 1;



create trigger create_reply_notice after insert on reply
    for each row
        begin
            declare reply_user_id int default null;
            declare post_user_id int default null;
            select user_id into reply_user_id from reply where id = new.reply_id;

            if (reply_user_id is not null) then
                insert into reply_notice values (null, reply_user_id, new.id);
            end if;

            select user_id into post_user_id from post where id = new.post_id;
            if (post_user_id <> new.user_id) then
            insert into reply_notice values (null, post_user_id, NEW.id);
            end if;
        end;