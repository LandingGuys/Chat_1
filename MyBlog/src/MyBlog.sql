/*
Navicat Oracle Data Transfer
Oracle Client Version : 10.2.0.5.0

Source Server         : ORCL
Source Server Version : 110200
Source Host           : 127.0.0.1:1521
Source Schema         : SCOTT

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2019-01-03 08:47:01
*/


-- ----------------------------
-- Table structure for T_ARTICLES
-- ----------------------------
DROP TABLE "SCOTT"."T_ARTICLES";
CREATE TABLE "SCOTT"."T_ARTICLES" (
"ARTICLE_ID" NUMBER NOT NULL ,
"USER_ID" NUMBER NOT NULL ,
"ARTICLE_TITLE" VARCHAR2(50 BYTE) NOT NULL ,
"ARTICLE_CONTENT" VARCHAR2(4000 BYTE) NOT NULL ,
"ARTICLE_IMAGES" VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_ARTICLES
-- ----------------------------
INSERT INTO "SCOTT"."T_ARTICLES" VALUES ('17', '1', 'Android框架设计理念', 'gggg', '1544941936199.jpg');
INSERT INTO "SCOTT"."T_ARTICLES" VALUES ('28', '26', '我还叫邢仁元', '我还叫邢仁元我还叫邢仁元我还叫邢仁元我还叫邢仁元我还叫邢仁元我还叫邢仁元我还叫邢仁元我还叫邢仁元我还叫邢仁元我还叫邢仁元我还叫邢仁元我还叫邢仁元我还叫邢仁元我还叫邢仁元', '1544951230502.jpg');
INSERT INTO "SCOTT"."T_ARTICLES" VALUES ('23', '2', '第二个文章', '这是我的第二个文章', '1544945201080.jpg');
INSERT INTO "SCOTT"."T_ARTICLES" VALUES ('27', '26', '我叫邢仁元', '邢仁元邢仁元邢仁元邢仁元邢仁元邢仁元邢仁元邢仁元邢仁元邢仁元邢仁元邢仁元邢仁元邢仁元邢仁元邢仁元邢仁元邢仁元邢仁元邢仁元邢仁元邢仁元邢仁元邢仁元', null);
INSERT INTO "SCOTT"."T_ARTICLES" VALUES ('30', '2', '这是第四个文章', '这是第四个文章这是第四个文章这是第四个文章这是第四个文章这是第四个文章这是第四个文章这是第四个文章这是第四个文章', '1544951404723.jpg');
INSERT INTO "SCOTT"."T_ARTICLES" VALUES ('7', '1', 'jksafj', 'fghghhjjhhhfddfdsfdfsdsdsd', '1544884039231.jpg');
INSERT INTO "SCOTT"."T_ARTICLES" VALUES ('59', '58', '第一个文章', 'gafsdhdaghjdfasjhj', null);
INSERT INTO "SCOTT"."T_ARTICLES" VALUES ('22', '2', '第一个文章', '这是我的第一个文章', '1544945173378.jpg');
INSERT INTO "SCOTT"."T_ARTICLES" VALUES ('60', '58', '第二个文章', 'sdasdfhjjadssd', '1545611998700.jpg');
INSERT INTO "SCOTT"."T_ARTICLES" VALUES ('21', '1', '111', '这是一个文章', '1544944962775.jpg');
INSERT INTO "SCOTT"."T_ARTICLES" VALUES ('56', '2', '第三个文章', 'fhhjhfajadadjdfjfs', '1545610775517.jpg');
INSERT INTO "SCOTT"."T_ARTICLES" VALUES ('53', '1', '第二个文章', '第二个文章', '1545269470022.jpg');
INSERT INTO "SCOTT"."T_ARTICLES" VALUES ('54', '1', 'Android框架设计理念', 'aaa', '1545271267125.jpg');
INSERT INTO "SCOTT"."T_ARTICLES" VALUES ('57', '2', '第四个文章', '得监事会和建行卡上空间', '1545610899698.jpg');

-- ----------------------------
-- Table structure for T_USER
-- ----------------------------
DROP TABLE "SCOTT"."T_USER";
CREATE TABLE "SCOTT"."T_USER" (
"USER_ID" NUMBER NOT NULL ,
"USER_NAME" VARCHAR2(20 BYTE) NULL ,
"USER_PASSWORD" VARCHAR2(20 BYTE) NULL ,
"USER_EMAIL" VARCHAR2(20 BYTE) NULL ,
"USER_IMAGE" VARCHAR2(20 BYTE) NULL ,
"USER_USERNAME" VARCHAR2(20 BYTE) NULL ,
"USER_REGION" VARCHAR2(20 BYTE) NULL ,
"USER_INDUSTRY" VARCHAR2(20 BYTE) NULL ,
"USER_POSITION" VARCHAR2(20 BYTE) NULL ,
"USER_INTRODUCTION" VARCHAR2(50 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of T_USER
-- ----------------------------
INSERT INTO "SCOTT"."T_USER" VALUES ('1', 'zhoulei', '123456', 'sdjdasf@qq.com', '1545557655780.jpg', '周磊', '中国', 'IT', '学生', '爱学习');
INSERT INTO "SCOTT"."T_USER" VALUES ('2', '30号小学生', '123456', 'fhajk@qq.com', '1545617049371.jpg', '邢任元1', '中国', '学生111', '学生', '爱学习');
INSERT INTO "SCOTT"."T_USER" VALUES ('3', 'zhangsan', '123456', null, null, null, null, null, null, null);
INSERT INTO "SCOTT"."T_USER" VALUES ('4', 'wanger', '123456', null, null, null, null, null, null, null);
INSERT INTO "SCOTT"."T_USER" VALUES ('5', 'lisi', '123456', null, null, null, null, null, null, null);
INSERT INTO "SCOTT"."T_USER" VALUES ('26', '邢仁元', '123456', 'sdfha@qq.com', '1544951129366.jpg', null, null, null, null, null);
INSERT INTO "SCOTT"."T_USER" VALUES ('58', '123456', '123456', 'dhsfhja@qq.com', '1545611950055.jpg', '邢任元', '中国', '学生', '学生', '爱学习');

-- ----------------------------
-- Indexes structure for table T_ARTICLES
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_ARTICLES
-- ----------------------------
ALTER TABLE "SCOTT"."T_ARTICLES" ADD CHECK ("ARTICLE_ID" IS NOT NULL);
ALTER TABLE "SCOTT"."T_ARTICLES" ADD CHECK ("USER_ID" IS NOT NULL);
ALTER TABLE "SCOTT"."T_ARTICLES" ADD CHECK ("ARTICLE_TITLE" IS NOT NULL);
ALTER TABLE "SCOTT"."T_ARTICLES" ADD CHECK ("ARTICLE_CONTENT" IS NOT NULL);
ALTER TABLE "SCOTT"."T_ARTICLES" ADD CHECK ("ARTICLE_ID" IS NOT NULL);
ALTER TABLE "SCOTT"."T_ARTICLES" ADD CHECK ("USER_ID" IS NOT NULL);
ALTER TABLE "SCOTT"."T_ARTICLES" ADD CHECK ("ARTICLE_TITLE" IS NOT NULL);
ALTER TABLE "SCOTT"."T_ARTICLES" ADD CHECK ("ARTICLE_CONTENT" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_ARTICLES
-- ----------------------------
ALTER TABLE "SCOTT"."T_ARTICLES" ADD PRIMARY KEY ("ARTICLE_ID");

-- ----------------------------
-- Indexes structure for table T_USER
-- ----------------------------

-- ----------------------------
-- Checks structure for table T_USER
-- ----------------------------
ALTER TABLE "SCOTT"."T_USER" ADD CHECK ("USER_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table T_USER
-- ----------------------------
ALTER TABLE "SCOTT"."T_USER" ADD PRIMARY KEY ("USER_ID");

-- ----------------------------
-- Foreign Key structure for table "SCOTT"."T_ARTICLES"
-- ----------------------------
ALTER TABLE "SCOTT"."T_ARTICLES" ADD FOREIGN KEY ("USER_ID") REFERENCES "SCOTT"."T_USER" ("USER_ID") ON DELETE CASCADE;
