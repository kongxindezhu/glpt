DROP TABLE IF EXISTS `app_audit_log`;
CREATE TABLE `app_audit_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `logType` varchar(64) DEFAULT NULL COMMENT '模块对应的ID',
  `logId` varchar(64) DEFAULT NULL COMMENT '操作对象ID',
  `logDesc` varchar(128) DEFAULT NULL COMMENT '具体操作',
  `userUuid` varchar(16) DEFAULT NULL COMMENT '操作用户uuid',
  `userNickname` varchar(32) DEFAULT NULL COMMENT '操作用户昵称',
  `operateType` varchar(4) DEFAULT NULL COMMENT '操作类型:0新增,1修改,2删除',
  `operateIp` varchar(64) DEFAULT NULL COMMENT '操作人IP',
  `operateTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `app_course`;
CREATE TABLE `app_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `courseUuid` varchar(16) DEFAULT NULL COMMENT '课程唯一标识UUID',
  `fontType` varchar(16) DEFAULT NULL COMMENT '字体类别ID:例如楷体001,宋体002',
  `taskType` varchar(16) DEFAULT NULL COMMENT '任务类别:001笔画002部首003常见字',
  `number` int(11) DEFAULT NULL COMMENT '课程集对应的顺序',
  `sequence` int(11) DEFAULT NULL COMMENT '课程集中单个课程的顺序号',
  `courseName` varchar(32) DEFAULT NULL COMMENT '具体课程的名称:例如垂露竖、撇折、人、正',
  `courseDesc` varchar(512) DEFAULT NULL COMMENT '文字描述',
  `remark` varchar(512) DEFAULT NULL COMMENT '备注,备用字段',
  `audio` varchar(128) DEFAULT NULL COMMENT '音频存储路径',
  `picOne` varchar(128) DEFAULT NULL COMMENT '图片素材1的存储路径',
  `picTwo` varchar(128) DEFAULT NULL COMMENT '图片素材2的存储路径',
  `picThree` varchar(128) DEFAULT NULL,
  `picFour` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `app_user_info`;
CREATE TABLE `app_user_info` (
  `uuid` varchar(16) DEFAULT NULL COMMENT '注册用户ID,系统分配',
  `nickname` varchar(32) DEFAULT NULL COMMENT '昵称',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `email` varchar(32) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL COMMENT '男1女0',
  `degree` varchar(1) DEFAULT NULL COMMENT '学历：1小学\\2初中\\3中专\\4高中\\5专科\\6本科\\7硕士\\8博士',
  `occupation` varchar(32) DEFAULT NULL COMMENT '职业',
  `portrait` varchar(128) DEFAULT NULL COMMENT '头像存储路径',
  `regDevice` varchar(64) DEFAULT NULL COMMENT '注册的设备号',
  `regTime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '用户注册时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `u_dic_catalog`;
CREATE TABLE `u_dic_catalog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `catalogId` varchar(32) DEFAULT NULL,
  `catalogName` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_dic_catalog
-- ----------------------------
INSERT INTO `u_dic_catalog` VALUES ('1', 'MEDIA_TYPE', '文件类别');
INSERT INTO `u_dic_catalog` VALUES ('2', 'TASK_TYPE', '练习任务');
INSERT INTO `u_dic_catalog` VALUES ('3', 'FONT_TYPE', '字体类别');

DROP TABLE IF EXISTS `u_dic_item`;
CREATE TABLE `u_dic_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `itemId` varchar(16) DEFAULT NULL,
  `itemName` varchar(64) DEFAULT NULL,
  `catalogId` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_dic_item
-- ----------------------------
INSERT INTO `u_dic_item` VALUES ('1', '001', '图片', 'MEDIA_TYPE');
INSERT INTO `u_dic_item` VALUES ('2', '002', '视频', 'MEDIA_TYPE');
INSERT INTO `u_dic_item` VALUES ('3', '001', '笔画', 'TASK_TYPE');
INSERT INTO `u_dic_item` VALUES ('4', '002', '部首', 'TASK_TYPE');
INSERT INTO `u_dic_item` VALUES ('5', '003', '常见字', 'TASK_TYPE');
INSERT INTO `u_dic_item` VALUES ('6', 'test', 'testName', 'MEDIA_TYPE');
INSERT INTO `u_dic_item` VALUES ('7', 'testId1', 'testName1', 'MEDIA_TYPE');
INSERT INTO `u_dic_item` VALUES ('8', '1', '2', 'MEDIA_TYPE');
INSERT INTO `u_dic_item` VALUES ('9', '001', '楷体', 'FONT_TYPE');
INSERT INTO `u_dic_item` VALUES ('10', '002', '宋体', 'FONT_TYPE');
INSERT INTO `u_dic_item` VALUES ('11', '003', '黑体', 'FONT_TYPE');

DROP TABLE IF EXISTS `u_permission`;
CREATE TABLE `u_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(256) DEFAULT NULL COMMENT 'url地址',
  `name` varchar(64) DEFAULT NULL COMMENT 'url描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_permission
-- ----------------------------
INSERT INTO `u_permission` VALUES ('4', '/permission/index.shtml', '权限列表');
INSERT INTO `u_permission` VALUES ('6', '/permission/addPermission.shtml', '权限添加');
INSERT INTO `u_permission` VALUES ('7', '/permission/deletePermissionById.shtml', '权限删除');
INSERT INTO `u_permission` VALUES ('8', '/member/list.shtml', '用户列表');
INSERT INTO `u_permission` VALUES ('9', '/member/online.shtml', '在线用户');
INSERT INTO `u_permission` VALUES ('10', '/member/changeSessionStatus.shtml', '用户Session踢出');
INSERT INTO `u_permission` VALUES ('11', '/member/forbidUserById.shtml', '用户激活&禁止');
INSERT INTO `u_permission` VALUES ('12', '/member/deleteUserById.shtml', '用户删除');
INSERT INTO `u_permission` VALUES ('13', '/permission/addPermission2Role.shtml', '权限分配');
INSERT INTO `u_permission` VALUES ('14', '/role/clearRoleByUserIds.shtml', '用户角色分配清空');
INSERT INTO `u_permission` VALUES ('15', '/role/addRole2User.shtml', '角色分配保存');
INSERT INTO `u_permission` VALUES ('16', '/role/deleteRoleById.shtml', '角色列表删除');
INSERT INTO `u_permission` VALUES ('17', '/role/addRole.shtml', '角色列表添加');
INSERT INTO `u_permission` VALUES ('18', '/role/index.shtml', '角色列表');
INSERT INTO `u_permission` VALUES ('19', '/permission/allocation.shtml', '权限分配');
INSERT INTO `u_permission` VALUES ('20', '/role/allocation.shtml', '角色分配');
INSERT INTO `u_permission` VALUES ('21', '/dic/catalog.shtml', '字典类别管理');
INSERT INTO `u_permission` VALUES ('22', '/dic/item.shtml', '字典项管理');
INSERT INTO `u_permission` VALUES ('23', '/dic/addDicCatalog.shtml', 'addDicCatalog');
INSERT INTO `u_permission` VALUES ('24', '/dic/deleteDicCatalogById.shtml', 'deleteDicCatalogById');

DROP TABLE IF EXISTS `u_role`;
CREATE TABLE `u_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  `type` varchar(10) DEFAULT NULL COMMENT '角色类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_role
-- ----------------------------
INSERT INTO `u_role` VALUES ('1', '系统管理员', '888888');
INSERT INTO `u_role` VALUES ('3', '权限角色', '100003');
INSERT INTO `u_role` VALUES ('4', '用户中心', '100002');

DROP TABLE IF EXISTS `u_role_permission`;
CREATE TABLE `u_role_permission` (
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID',
  `pid` bigint(20) DEFAULT NULL COMMENT '权限ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_role_permission
-- ----------------------------
INSERT INTO `u_role_permission` VALUES ('4', '8');
INSERT INTO `u_role_permission` VALUES ('4', '9');
INSERT INTO `u_role_permission` VALUES ('4', '10');
INSERT INTO `u_role_permission` VALUES ('4', '11');
INSERT INTO `u_role_permission` VALUES ('4', '12');
INSERT INTO `u_role_permission` VALUES ('3', '4');
INSERT INTO `u_role_permission` VALUES ('3', '6');
INSERT INTO `u_role_permission` VALUES ('3', '7');
INSERT INTO `u_role_permission` VALUES ('3', '13');
INSERT INTO `u_role_permission` VALUES ('3', '14');
INSERT INTO `u_role_permission` VALUES ('3', '15');
INSERT INTO `u_role_permission` VALUES ('3', '16');
INSERT INTO `u_role_permission` VALUES ('3', '17');
INSERT INTO `u_role_permission` VALUES ('3', '18');
INSERT INTO `u_role_permission` VALUES ('3', '19');
INSERT INTO `u_role_permission` VALUES ('3', '20');
INSERT INTO `u_role_permission` VALUES ('1', '4');
INSERT INTO `u_role_permission` VALUES ('1', '6');
INSERT INTO `u_role_permission` VALUES ('1', '7');
INSERT INTO `u_role_permission` VALUES ('1', '8');
INSERT INTO `u_role_permission` VALUES ('1', '9');
INSERT INTO `u_role_permission` VALUES ('1', '10');
INSERT INTO `u_role_permission` VALUES ('1', '11');
INSERT INTO `u_role_permission` VALUES ('1', '12');
INSERT INTO `u_role_permission` VALUES ('1', '13');
INSERT INTO `u_role_permission` VALUES ('1', '14');
INSERT INTO `u_role_permission` VALUES ('1', '15');
INSERT INTO `u_role_permission` VALUES ('1', '16');
INSERT INTO `u_role_permission` VALUES ('1', '17');
INSERT INTO `u_role_permission` VALUES ('1', '18');
INSERT INTO `u_role_permission` VALUES ('1', '19');
INSERT INTO `u_role_permission` VALUES ('1', '20');
INSERT INTO `u_role_permission` VALUES ('1', '21');
INSERT INTO `u_role_permission` VALUES ('1', '22');
INSERT INTO `u_role_permission` VALUES ('1', '23');
INSERT INTO `u_role_permission` VALUES ('1', '24');

DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(20) DEFAULT NULL COMMENT '用户昵称',
  `email` varchar(128) DEFAULT NULL COMMENT '邮箱|登录帐号',
  `pswd` varchar(32) DEFAULT NULL COMMENT '密码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `status` bigint(1) DEFAULT '1' COMMENT '1:有效，0:禁止登录',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES ('1', 'admin', 'admin', '57eb72e6b78a87a12d46a7f5e9315138', '2016-06-16 11:15:33', '2017-08-15 20:12:39', '1');
INSERT INTO `u_user` VALUES ('11', 'soso', '8446666@qq.com', 'd57ffbe486910dd5b26d0167d034f9ad', '2016-05-26 20:50:54', '2016-06-16 11:24:35', '1');
INSERT INTO `u_user` VALUES ('12', '8446666', '8446666', '4afdc875a67a55528c224ce088be2ab8', '2016-05-27 22:34:19', '2016-06-15 17:03:16', '1');

DROP TABLE IF EXISTS `u_user_role`;
CREATE TABLE `u_user_role` (
  `uid` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `rid` bigint(20) DEFAULT NULL COMMENT '角色ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of u_user_role
-- ----------------------------
INSERT INTO `u_user_role` VALUES ('12', '4');
INSERT INTO `u_user_role` VALUES ('11', '3');
INSERT INTO `u_user_role` VALUES ('11', '4');
INSERT INTO `u_user_role` VALUES ('1', '1');
