DROP TABLE IF EXISTS `u_dic_catalog`;
CREATE TABLE `u_dic_catalog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `catalogId` varchar(32) DEFAULT NULL,
  `catalogName` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_dic_catalog
-- ----------------------------
INSERT INTO `u_dic_catalog` VALUES ('1', 'MEDIA_TYPE', '文件类别');
INSERT INTO `u_dic_catalog` VALUES ('2', 'TASK_TYPE', '练习任务');
INSERT INTO `u_dic_catalog` VALUES ('3', 'FONT_TYPE', '字体类别');
INSERT INTO `u_dic_catalog` VALUES ('4', 'DEGREE_TYPE', '学历');

INSERT INTO `u_dic_item` VALUES ('12', '1', '研究生', 'DEGREE_TYPE');
INSERT INTO `u_dic_item` VALUES ('13', '2', '本科', 'DEGREE_TYPE');
INSERT INTO `u_dic_item` VALUES ('14', '3', '高中', 'DEGREE_TYPE');
INSERT INTO `u_dic_item` VALUES ('15', '4', '初中', 'DEGREE_TYPE');
INSERT INTO `u_dic_item` VALUES ('16', '5', '小学', 'DEGREE_TYPE');
INSERT INTO `u_dic_item` VALUES ('17', '6', '其他', 'DEGREE_TYPE');

DROP TABLE IF EXISTS `app_user_info`;
CREATE TABLE `app_user_info` (
  `uuid` varchar(32) NOT NULL COMMENT '注册用户ID,系统分配',
  `nickname` varchar(32) DEFAULT NULL COMMENT '昵称',
  `phone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `email` varchar(32) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL COMMENT '男1女0',
  `degree` varchar(8) DEFAULT NULL COMMENT '1研究生、2本科、3高中、4初中、5小学、6其他',
  `occupation` varchar(32) DEFAULT NULL COMMENT '职业',
  `portrait` varchar(128) DEFAULT NULL COMMENT '头像存储路径',
  `regDevice` varchar(64) DEFAULT NULL COMMENT '注册的设备号',
  `regTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '用户注册时间',
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;