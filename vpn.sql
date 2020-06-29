/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : vpn

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2020-04-26 10:34:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cms_comment
-- ----------------------------
DROP TABLE IF EXISTS `cms_comment`;
CREATE TABLE `cms_comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `comment_type` int(1) DEFAULT NULL COMMENT '0->功能性问题1->优化问题2->其他',
  `nick_name` varchar(255) DEFAULT NULL,
  `member_icon` varchar(255) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `delete_status` int(1) DEFAULT NULL COMMENT '0->正常状态1->删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户评论表';

-- ----------------------------
-- Records of cms_comment
-- ----------------------------


-- ----------------------------
-- Table structure for cms__
-- ----------------------------
DROP TABLE IF EXISTS `cms_comment_official_reply`;
CREATE TABLE `cms_comment_official_reply` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `comment_id` bigint(20) DEFAULT NULL COMMENT '用户反馈问题的id',
  `nick_name` varchar(255) DEFAULT NULL,
  `official_icon` varchar(255) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `delete_status` int(1) DEFAULT NULL COMMENT '0->正常状态1->删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='官方回复表';

-- ----------------------------
-- Records of cms_comment_official_reply
-- ----------------------------


-- ----------------------------
-- Table structure for cms_app_file
-- ----------------------------
DROP TABLE IF EXISTS `cms_app_file`;
CREATE TABLE `cms_app_file` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `app_name` varchar(255) DEFAULT NULL COMMENT 'app名字',
  `app_address` varchar(255) DEFAULT NULL COMMENT 'apk地址',
  `v` varchar(255) DEFAULT NULL COMMENT 'app版本号',
  `is_must_update` int(1) DEFAULT NULL COMMENT '0->正常更新1->强制更新',
  `create_time` datetime DEFAULT NULL,
  `platform` int(1) DEFAULT NULL COMMENT '0->android1->ios2->pc',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='官方回复表';

-- ----------------------------
-- Records of cms_app_file
-- ----------------------------




-- ----------------------------
-- Table structure for ums_member
-- ----------------------------
DROP TABLE IF EXISTS `ums_member`;
CREATE TABLE `ums_member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_level_id` bigint(20) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(64) DEFAULT NULL COMMENT '昵称',
  `phone` varchar(64) DEFAULT NULL COMMENT '手机号码',
  `status` int(1) DEFAULT NULL COMMENT '帐号启用状态:0->禁用；1->启用',
  `create_time` datetime DEFAULT NULL COMMENT '注册时间',
  `icon` varchar(500) DEFAULT NULL COMMENT '头像',
  `gender` int(1) DEFAULT NULL COMMENT '性别：0->未知；1->男；2->女',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `city` varchar(64) DEFAULT NULL COMMENT '所做城市',
  `job` varchar(100) DEFAULT NULL COMMENT '职业',
  `personalized_signature` varchar(200) DEFAULT NULL COMMENT '个性签名',
  `source_type` int(1) DEFAULT NULL COMMENT '用户来源',
  `integration` int(11) DEFAULT NULL COMMENT '积分',
  `luckey_count` int(11) DEFAULT NULL COMMENT '剩余抽奖次数',
  `history_integration` int(11) DEFAULT NULL COMMENT '历史积分数量',
  `vpn_connect_type` int(11) DEFAULT 1 COMMENT 'vpn连击方式:1->ss;2->wireguard;3->openvpn',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_username` (`username`),
  UNIQUE KEY `idx_phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='会员表';

-- ----------------------------
-- Records of ums_member
-- ----------------------------
INSERT INTO `ums_member` VALUES ('1', '1', 'tianming', '$2a$10$fSo2BDPV8GeVYpPEylseHuYhw5QreqOXgVKSD89ho0NAfCQlysUR2', 'windir', '18061581849', '1', '2018-08-02 10:35:44', null, '1', '2009-06-01', '上海', '学生', 'test', null, '5000', null, null,'1');
INSERT INTO `ums_member` VALUES ('3', '1', 'tiandao', '$2a$10$fSo2BDPV8GeVYpPEylseHuYhw5QreqOXgVKSD89ho0NAfCQlysUR2', 'windy', '18061581848', '1', '2018-08-03 16:46:38', null, '1', '2009-06-01', '上海', '学生', 'test', null, '5000', null, null,'1');


-- ----------------------------
-- Table structure for ums_member_device_id
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_device_id`;
CREATE TABLE `ums_member_device_id` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `device_id` varchar(100) DEFAULT NULL,
  `member_id` bigint(20) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `devicebrand` varchar(100) DEFAULT NULL COMMENT '设备品牌名称',
  `platform` int(1) DEFAULT NULL COMMENT '0->android1->ios2->pc',
  PRIMARY KEY (`id`),
  KEY `idx_device_id` (`device_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='设备唯一标识表根据此表可以查询使用过几台设备登录过';

-- ----------------------------
-- Records of ums_member_device_id
-- ----------------------------


-- ----------------------------
-- Table structure for ums_member_level
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_level`;
CREATE TABLE `ums_member_level` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `growth_point` int(11) DEFAULT NULL,
  `default_status` int(1) DEFAULT NULL COMMENT '是否为默认等级：0->不是；1->是',
  `note` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='会员等级表';

-- ----------------------------
-- Records of ums_member_level
-- ----------------------------
INSERT INTO `ums_member_level` VALUES ('5', '钻石会员', '1000', '0', '189.00');
INSERT INTO `ums_member_level` VALUES ('4', '白金会员', '1000', '0', '122.00');
INSERT INTO `ums_member_level` VALUES ('3', '黄金会员', '1000', '0', '89.00');
INSERT INTO `ums_member_level` VALUES ('2', '普通会员', '1000', '0', '49.00');
INSERT INTO `ums_member_level` VALUES ('1', '试用期会员', '1000', '0', '0.00');


-- ----------------------------
-- Table structure for ums_member_login_log
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_login_log`;
CREATE TABLE `ums_member_login_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `member_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `from_ip` varchar(64) DEFAULT NULL COMMENT '用户登录的目标IP',
  `ip_location` varchar(64) DEFAULT NULL COMMENT '用户IP归属地',
  `service_ip` varchar(64) DEFAULT NULL COMMENT '连接选择的服务器ip',
  `city` varchar(64) DEFAULT NULL,
  `device_id` varchar(64) DEFAULT NULL COMMENT '用户的设备ID',
  `login_type` int(1) DEFAULT NULL COMMENT '登录类型：0->PC；1->android;2->ios;',
  `login_mac` varchar(64) DEFAULT NULL,
  `login_uid` varchar(64) DEFAULT NULL, 
  `connect_time`  datetime  DEFAULT NULL COMMENT '开始连接时间',
  `disconnect_time`  datetime  DEFAULT NULL COMMENT '断开时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员登录记录';

-- ----------------------------
-- Records of ums_member_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for ums_member_filter_app
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_filter_app`;
CREATE TABLE `ums_member_filter_app` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `member_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `filter_app` varchar(1000) DEFAULT NULL COMMENT '过滤app->1:不过滤->2:不允许哪些app->3允许哪些APP用{\"type\":\"1\",\"app\":['','']}',
  `login_type` int(1) DEFAULT NULL COMMENT '登录类型：0->PC；1->android;2->ios;',
  `login_mac` varchar(64) DEFAULT NULL,
  `device_id` varchar(64) DEFAULT NULL COMMENT '用户登录的设备唯一号', 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员登录记录';

-- ----------------------------
-- Records of ums_member_filter_app
-- ----------------------------



-- ----------------------------
-- Table structure for ums_vpn_ss_encription_type
-- ----------------------------
DROP TABLE IF EXISTS `ums_vpn_ss_encription_type` ;
CREATE TABLE `ums_vpn_ss_encription_type` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `encription_type` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='加密类型';

INSERT INTO `ums_vpn_ss_encription_type` VALUES ('1', 'none');
INSERT INTO `ums_vpn_ss_encription_type` VALUES ('2', 'table');
INSERT INTO `ums_vpn_ss_encription_type` VALUES ('3', 'RC4');
INSERT INTO `ums_vpn_ss_encription_type` VALUES ('4', 'RC4-MD5');
INSERT INTO `ums_vpn_ss_encription_type` VALUES ('5', 'RC4-MD5-6');
INSERT INTO `ums_vpn_ss_encription_type` VALUES ('6', 'AES-128-CFB');
INSERT INTO `ums_vpn_ss_encription_type` VALUES ('7', 'AES-192-CFB');
INSERT INTO `ums_vpn_ss_encription_type` VALUES ('8', 'AES-256-CFB');
INSERT INTO `ums_vpn_ss_encription_type` VALUES ('9', 'AES-128-CTR');
INSERT INTO `ums_vpn_ss_encription_type` VALUES ('10', 'AES-192-CTR');
INSERT INTO `ums_vpn_ss_encription_type` VALUES ('11', 'AES-256-CTR');
INSERT INTO `ums_vpn_ss_encription_type` VALUES ('12', 'BF-CFB');
INSERT INTO `ums_vpn_ss_encription_type` VALUES ('13', 'CAMELLIA-128-CFB');
INSERT INTO `ums_vpn_ss_encription_type` VALUES ('14', 'CAMELLIA-192-CFB');
INSERT INTO `ums_vpn_ss_encription_type` VALUES ('15', 'CAMELLIA-256-CFB');
INSERT INTO `ums_vpn_ss_encription_type` VALUES ('16', 'SALSA20');
INSERT INTO `ums_vpn_ss_encription_type` VALUES ('17', 'CHACHA20');
INSERT INTO `ums_vpn_ss_encription_type` VALUES ('18', 'CHACHA20-IETF');

-- ----------------------------
-- Records of ums_vpn_ss_encription_type
-- ----------------------------


-- ----------------------------
-- Table structure for ums_vpn_ss_protocal_type
-- ----------------------------
DROP TABLE IF EXISTS `ums_vpn_ss_protocal_type`;
CREATE TABLE `ums_vpn_ss_protocal_type` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `protocal_type` varchar(64) DEFAULT NULL COMMENT '协议',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='ss加密协议';

INSERT INTO `ums_vpn_ss_protocal_type` VALUES ('1', 'origin');
INSERT INTO `ums_vpn_ss_protocal_type` VALUES ('2', 'verify_simple');
INSERT INTO `ums_vpn_ss_protocal_type` VALUES ('3', 'verify_sha1');
INSERT INTO `ums_vpn_ss_protocal_type` VALUES ('4', 'auth_sha1');
INSERT INTO `ums_vpn_ss_protocal_type` VALUES ('5', 'auth_sha1_v2');
INSERT INTO `ums_vpn_ss_protocal_type` VALUES ('6', 'auth_sha1_v4');
INSERT INTO `ums_vpn_ss_protocal_type` VALUES ('7', 'auth_aes128_sha1');
INSERT INTO `ums_vpn_ss_protocal_type` VALUES ('8', 'auth_aes128_md5');
INSERT INTO `ums_vpn_ss_protocal_type` VALUES ('9', 'auth_chain_a');
INSERT INTO `ums_vpn_ss_protocal_type` VALUES ('10', 'auth_chain_b');

-- ----------------------------
-- Records of ums_vpn_ss_protocal_type
-- ----------------------------

-- ----------------------------
-- Table structure for ums_vpn_ss_obfs
-- ----------------------------

DROP TABLE IF EXISTS `ums_vpn_ss_obfs`;
CREATE TABLE `ums_vpn_ss_obfs` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `obfs` varchar(64) DEFAULT NULL COMMENT '混淆',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='混淆';

INSERT INTO `ums_vpn_ss_obfs` VALUES ( '1', 'plain');
INSERT INTO `ums_vpn_ss_obfs` VALUES ( '2', 'http_simple');
INSERT INTO `ums_vpn_ss_obfs` VALUES ( '3', 'http_post');
INSERT INTO `ums_vpn_ss_obfs` VALUES ( '4', 'tls_simple');
INSERT INTO `ums_vpn_ss_obfs` VALUES ( '5', 'tls1.2_ticket_auth');

-- ----------------------------
-- Records of ums_vpn_ss_obfs
-- ----------------------------


-- ----------------------------
-- Table structure for ums_vpn_service
-- ----------------------------
DROP TABLE IF EXISTS `ums_vpn_service`;
CREATE TABLE `ums_vpn_service` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `line_name` varchar(64) DEFAULT NULL COMMENT '线路名称',
  `use_status` int(1) DEFAULT '0' COMMENT '这条vpn是否被使用0->未使用1->使用',
  `delete_status` int(1) DEFAULT NULL COMMENT '删除状态：0->未删除；1->已删除',
  `ip` varchar(20) DEFAULT NULL COMMENT '服务器ip',
  `type` varchar(20) DEFAULT NULL COMMENT '阿里云/谷歌云/亚马逊云/微软云',
  `province` varchar(100) DEFAULT NULL COMMENT '省份/直辖市',
  `city` varchar(100) DEFAULT NULL COMMENT '城市',
  `region` varchar(100) DEFAULT NULL COMMENT '区',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_ip` (`ip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='vpn->ss数据库';

INSERT INTO `ums_vpn_service` VALUES ( '1', 'china hangzhou Line', '0', '0','98.142.138.64', '阿里云', '杭州', '杭州', '杭州');
INSERT INTO `ums_vpn_service` VALUES ( '2', 'china hangkong Line', '0', '0','47.244.169.80', '阿里云', '杭州', '杭州', '杭州');
INSERT INTO `ums_vpn_service` VALUES ( '3', 'Indonesia Line',      '0', '0','147.139.137.168', '亚马逊云', 'Indonesia', 'Indonesia', 'Indonesia');

-- ----------------------------
-- Records of ums_vpn_service
-- ----------------------------


-- ----------------------------
-- Table structure for ums_vpn_wireguard
-- ----------------------------
DROP TABLE IF EXISTS `ums_vpn_wireguard`;
CREATE TABLE `ums_vpn_wireguard` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `use_status` int(1) DEFAULT '0' COMMENT '这条vpn是否被使用0->未使用1->使用',
  `delete_status` int(1) DEFAULT NULL COMMENT '删除状态：0->未删除；1->已删除',
  `line_name` varchar(64) DEFAULT NULL COMMENT '线路名称',
  `service_id` bigint(20) DEFAULT NULL COMMENT '服务器id',
  `privatekey` varchar(1024) DEFAULT NULL COMMENT '私钥',
  `address`  varchar(64) DEFAULT NULL,
  `dns` varchar(64) DEFAULT NULL,
  `mtu` varchar(64) DEFAULT NULL,
  `publickey` varchar(1024) DEFAULT NULL,
  `endpoint` varchar(64) DEFAULT NULL,
  `allowed_ips` varchar(64) DEFAULT NULL,
  `persistent_keepalive` int(5) DEFAULT 25,
  `update_time` datetime DEFAULT NULL COMMENT '更新状态时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='vpn->wireguard数据库';

INSERT INTO `ums_vpn_wireguard` VALUES ( '1', '0', '0', 'CHINA Line','1','0HvBmNS79bH8DTehScAsBznDlxRMDNKgShTIN6tYemU=','10.77.77.2/32','8.8.8.8','1420','fShlhFxOtwwBP5wL8RfvLFloiQL4WkZ6e3e1RYqrAnQ=','121.196.120.24:33649','0.0.0.0/0, ::0/0','25',null);
INSERT INTO `ums_vpn_wireguard` VALUES ( '2', '0', '0', 'CHINA HANGKONG Line','2','oOhoIT9JMBFJ0qDoXNMLbfwHXUfT6OFR1kMc1Dfz/Ww=','10.0.0.30/24','8.8.8.8','1420','+jHagwWwKFUv/juiNYD0r8gypmMrcGHxUNwiuc9tc0s=','47.244.169.80:45184','0.0.0.0/0, ::0/0','25',null);
INSERT INTO `ums_vpn_wireguard` VALUES ( '3', '0', '0', 'CHINA HANGKONG Line','2','QCFtvVpYgMMwojrRqVCpOH5XC7LY/H8a+8IoLPUclVg=','10.0.0.28/24','8.8.8.8','1420','+jHagwWwKFUv/juiNYD0r8gypmMrcGHxUNwiuc9tc0s=','47.244.169.80:45184','0.0.0.0/0, ::0/0','25',null);
INSERT INTO `ums_vpn_wireguard` VALUES ( '4', '0', '0', 'CHINA HANGKONG Line','2','oHKc6znqFBXVVGB4AYhPMWY0b+w+2CyLHIrfTQ+sz14=','10.0.0.31/24','8.8.8.8','1420','+jHagwWwKFUv/juiNYD0r8gypmMrcGHxUNwiuc9tc0s=','47.244.169.80:45184','0.0.0.0/0, ::0/0','25',null);
INSERT INTO `ums_vpn_wireguard` VALUES ( '5', '0', '0', 'CHINA HANGKONG Line','2','mN389cyR8uCDYJ6v6/hC9LqNJiqZxxHRw93INnfCkWQ=','10.0.0.29/24','8.8.8.8','1420','+jHagwWwKFUv/juiNYD0r8gypmMrcGHxUNwiuc9tc0s=','47.244.169.80:45184','0.0.0.0/0, ::0/0','25',null);
INSERT INTO `ums_vpn_wireguard` VALUES ( '6', '0', '0', 'INDONESIA Line','3','SMr5qW9jIR70Vi8sHhcpSeJc3S2Qu1VaEFq1yAimcFs=','10.77.77.22/32','8.8.8.8','1420','N1/ROyXTmoCRYgGG51R6XgeMv0wM3VTaPjzFS437GBc=','147.139.137.168:21892','0.0.0.0/0, ::0/0','25',null);
INSERT INTO `ums_vpn_wireguard` VALUES ( '7', '0', '0', 'INDONESIA Line','3','oKJuvcA1g/jDkDlei6Ge6cf61WeZSSwvbFfxkNslg1k=','10.77.77.23/32','8.8.8.8','1420','N1/ROyXTmoCRYgGG51R6XgeMv0wM3VTaPjzFS437GBc=','147.139.137.168:21892','0.0.0.0/0, ::0/0','25',null);
INSERT INTO `ums_vpn_wireguard` VALUES ( '8', '0', '0', 'INDONESIA Line','3','QNXZ0L7jQiOYv+gb8DEeX6eFMnzi8v6QeYaL5+IODnA=','10.77.77.24/32','8.8.8.8','1420','N1/ROyXTmoCRYgGG51R6XgeMv0wM3VTaPjzFS437GBc=','147.139.137.168:21892','0.0.0.0/0, ::0/0','25',null);

-- ----------------------------
-- Records of ums_vpn_wireguard
-- ----------------------------

-- ----------------------------
-- Table structure for ums_vpn_ss
-- ----------------------------
DROP TABLE IF EXISTS `ums_vpn_ss`;
CREATE TABLE `ums_vpn_ss` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `line_name` varchar(64) DEFAULT NULL COMMENT '线路名称',
  `use_status` int(1) DEFAULT '0' COMMENT '这条vpn是否被使用0->未使用1->使用',
  `delete_status` int(1) DEFAULT NULL COMMENT '删除状态：0->未删除；1->已删除',
  `service_id` bigint(20) DEFAULT NULL COMMENT '服务器id',
  `ip` varchar(64) DEFAULT NULL COMMENT '服务器ip',
  `port` varchar(64) DEFAULT NULL COMMENT '服务器端口', 
  `password` varchar(64) DEFAULT NULL COMMENT 'ssl 密码',
  `encription_type_id` int(8) DEFAULT 18 COMMENT '加密类型',
  `protocal_type_id`  int(8) DEFAULT 8 COMMENT '协议类型',
  `protocal_param` varchar(64) DEFAULT NULL,
  `obfs_id`  Int(8) DEFAULT 2 COMMENT '混淆',
  `cofused_param`  varchar(64) DEFAULT NULL COMMENT '混淆参数', 
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='vpn->ss数据库';

INSERT INTO `ums_vpn_ss` VALUES ( '1', 'USA Line', '0', '0', '1','98.142.138.64','19999','hello','18','8','','2','');
INSERT INTO `ums_vpn_ss` VALUES ( '2', 'China Line', '0', '0', '1','98.142.138.64','19999','hello','18','8','','2','');


-- ----------------------------
-- Records of ums_vpn_ss
-- ----------------------------


-- ----------------------------
-- Table structure for ums_member_statistics_info
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_statistics_info`;
CREATE TABLE `ums_member_statistics_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `consume_amount` decimal(10,2) DEFAULT NULL COMMENT '累计消费金额',
  `order_count` int(11) DEFAULT NULL COMMENT '订单数量',
  `coupon_count` int(11) DEFAULT NULL COMMENT '优惠券数量',
  `comment_count` int(11) DEFAULT NULL COMMENT '评价数',
  `return_order_count` int(11) DEFAULT NULL COMMENT '退货数量',
  `login_count` int(11) DEFAULT NULL COMMENT '登录次数',
  `attend_count` int(11) DEFAULT NULL COMMENT '关注数量',
  `fans_count` int(11) DEFAULT NULL COMMENT '粉丝数量',
  `invite_friend_count` int(11) DEFAULT NULL COMMENT '邀请好友数',
  `last_login_time`  datetime  DEFAULT NULL COMMENT '最近登录时间',
  `first_login_time`  datetime  DEFAULT NULL COMMENT '第一次登录时间',
  `start_rec_member_time`  datetime  DEFAULT NULL COMMENT '会员的开始时间->倒计时加上过期时间',
  `expire_time` int(11) DEFAULT 7 COMMENT '默认7试用时间',
  `total_time` int(11) DEFAULT 7 COMMENT '可用的总时间',
  `last_connectway` int(11) DEFAULT NULL COMMENT '上次登录的方式',
  `ss_id` bigint(20) DEFAULT NULL,
  `wireguard_id` bigint(20) DEFAULT NULL,
  `recent_order_time` datetime DEFAULT NULL COMMENT '最后一次下订单时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员统计信息';

-- ----------------------------
-- Records of ums_member_statistics_info
-- ----------------------------

-- ----------------------------
-- Table structure for ums_product
-- ----------------------------

DROP TABLE IF EXISTS `ums_product`;
CREATE TABLE `ums_product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_id` bigint(20) DEFAULT NULL,
  `product_name` varchar(64) DEFAULT NULL,
  `product_sn` varchar(64) NOT NULL COMMENT '货号',
  `delete_status` int(1) DEFAULT NULL COMMENT '删除状态：0->未删除；1->已删除',
  `publish_status` int(1) DEFAULT NULL COMMENT '上架状态：0->下架；1->上架',
  `new_status` int(1) DEFAULT NULL COMMENT '新品状态:0->不是新品；1->新品',
  `sort` int(11) DEFAULT NULL COMMENT '排序',
  `sale` int(11) DEFAULT NULL COMMENT '销量',
  `price` decimal(10,2) DEFAULT NULL,
  `promotion_price` decimal(10,2) DEFAULT NULL COMMENT '促销价格',
  `original_price` decimal(10,2) DEFAULT NULL COMMENT '市场价',
  `detail_title` varchar(255) DEFAULT NULL,
  `detail_html` text COMMENT '产品详情网页内容',
  `detail_mobile_html` text COMMENT '移动端网页详情',
  `promotion_start_time` datetime DEFAULT NULL COMMENT '促销开始时间',
  `promotion_end_time` datetime DEFAULT NULL COMMENT '促销结束时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='产品定价表';


INSERT INTO `ums_product` VALUES ('20','1','普通vip', 'No86577', '0', '1', '1', '1', '2', '30.00', '30.00', '30.00','包月','','',null,null);
INSERT INTO `ums_product` VALUES ('50','1','超级vip', 'No86578', '0', '1', '1', '1', '2', '30.00', '30.00', '30.00','包月','','',null,null);

-- ----------------------------
-- Table structure for ums_product
-- ----------------------------

-- ----------------------------
-- Table structure for pms_sku_stock
-- ----------------------------
DROP TABLE IF EXISTS `pms_sku_stock`;
CREATE TABLE `pms_sku_stock` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) DEFAULT NULL,
  `sku_code` varchar(64) NOT NULL COMMENT 'sku编码',
  `price` decimal(10,2) DEFAULT NULL,
  `stock` int(11) DEFAULT '0' COMMENT '库存',
  `low_stock` int(11) DEFAULT NULL COMMENT '预警库存',
  `pic` varchar(255) DEFAULT NULL COMMENT '展示图片',
  `sale` int(11) DEFAULT NULL COMMENT '销量',
  `promotion_price` decimal(10,2) DEFAULT NULL COMMENT '单品促销价格',
  `lock_stock` int(11) DEFAULT '0' COMMENT '锁定库存',
  `detail_desc` text COMMENT '1->2->3说明购买几个月的',
  `sp_data` varchar(500) DEFAULT NULL COMMENT '商品销售属性，json格式',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='sku的库存';

INSERT INTO `pms_sku_stock` VALUES ('1', '20', '202005070027001', '30.00', '100', null, null, null, null, '0', '1一个月','');
INSERT INTO `pms_sku_stock` VALUES ('2', '20', '202005070027002', '60', '100', null, null, null, null, '0', '2个月','');
INSERT INTO `pms_sku_stock` VALUES ('3', '20', '202005070027003', '80', '100', null, null, null, null, '0', '连续包季','');
INSERT INTO `pms_sku_stock` VALUES ('4', '20', '202005070027004', '110', '100', null, null, null, null, '0', '4个月','');
INSERT INTO `pms_sku_stock` VALUES ('5', '20', '202005070027005', '140', '100', null, null, null, null, '0', '5个月','');
INSERT INTO `pms_sku_stock` VALUES ('6', '20', '202005070027006', '160', '100', null, null, null, null, '0', '半年','');
INSERT INTO `pms_sku_stock` VALUES ('7', '20', '202005070027007', '300', '100', null, null, null, null, '0', '连续包年12个月','');

INSERT INTO `pms_sku_stock` VALUES ('21', '50', '202005070028001', '40.00', '100', null, null, null, null, '0', '1一个月','');
INSERT INTO `pms_sku_stock` VALUES ('22', '50', '202005070028002', '80', '100', null, null, null, null, '0', '2个月','');
INSERT INTO `pms_sku_stock` VALUES ('23', '50', '202005070028003', '110', '100', null, null, null, null, '0', '连续包季','');
INSERT INTO `pms_sku_stock` VALUES ('24', '50', '202005070028004', '150', '100', null, null, null, null, '0', '4个月','');
INSERT INTO `pms_sku_stock` VALUES ('25', '50', '202005070028005', '180', '100', null, null, null, null, '0', '5个月','');
INSERT INTO `pms_sku_stock` VALUES ('26', '50', '202005070028006', '210', '100', null, null, null, null, '0', '半年','');
INSERT INTO `pms_sku_stock` VALUES ('27', '50', '202005070028007', '400', '100', null, null, null, null, '0', '连续包年12个月','');

-- ----------------------------
-- Table structure for pms_sku_stock
-- ----------------------------


-- ----------------------------
-- Table structure for oms_order
-- ----------------------------
DROP TABLE IF EXISTS `oms_order`;
CREATE TABLE `oms_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `member_id` bigint(20) NOT NULL,
  `order_sn` varchar(64) DEFAULT NULL COMMENT '订单编号',
  `create_time` datetime DEFAULT NULL COMMENT '提交时间',
  `member_username` varchar(64) DEFAULT NULL COMMENT '用户帐号',
  `total_amount` decimal(10,2) DEFAULT NULL COMMENT '订单总金额',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '应付金额（实际支付金额）',
  `pay_type` int(1) DEFAULT NULL COMMENT '支付方式：0->未支付；1->支付宝；2->微信',
  `source_type` int(1) DEFAULT NULL COMMENT '订单来源：0->PC订单；1->app订单',
  `status` int(1) DEFAULT NULL COMMENT '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
  `order_type` int(1) DEFAULT NULL COMMENT '订单类型：0->正常订单；1->秒杀订单',
  `delete_status` int(1) NOT NULL DEFAULT '0' COMMENT '删除状态：0->未删除；1->已删除',
  `use_integration` int(11) DEFAULT NULL COMMENT '下单时使用的积分',
  `payment_time` datetime DEFAULT NULL COMMENT '支付时间',
   `coupon_id` bigint(20) DEFAULT NULL,
  `freight_amount` decimal(10,2) DEFAULT NULL COMMENT '运费金额',
  `promotion_amount` decimal(10,2) DEFAULT NULL COMMENT '促销优化金额（促销价、满减、阶梯价）',
  `integration_amount` decimal(10,2) DEFAULT NULL COMMENT '积分抵扣金额',
  `coupon_amount` decimal(10,2) DEFAULT NULL COMMENT '优惠券抵扣金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Table structure for oms_order
-- ----------------------------


-- ----------------------------
-- Table structure for oms_order_item
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_item`;
CREATE TABLE `oms_order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单id',
  `order_sn` varchar(64) DEFAULT NULL COMMENT '订单编号',
  `product_id` bigint(20) DEFAULT NULL,
  `product_pic` varchar(500) DEFAULT NULL,
  `product_name` varchar(200) DEFAULT NULL,
  `product_brand` varchar(200) DEFAULT NULL,
  `product_sn` varchar(64) DEFAULT NULL,
  `product_price` decimal(10,2) DEFAULT NULL COMMENT '销售价格',
  `product_quantity` int(11) DEFAULT NULL COMMENT '购买数量',
  `product_sku_id` bigint(20) DEFAULT NULL COMMENT '商品sku编号',
  `product_sku_code` varchar(50) DEFAULT NULL COMMENT '商品sku条码',
  `product_category_id` bigint(20) DEFAULT NULL COMMENT '商品分类id',
  `promotion_name` varchar(200) DEFAULT NULL COMMENT '商品促销名称',
  `promotion_amount` decimal(10,2) DEFAULT NULL COMMENT '商品促销分解金额',
  `coupon_amount` decimal(10,2) DEFAULT NULL COMMENT '优惠券优惠分解金额',
  `integration_amount` decimal(10,2) DEFAULT NULL COMMENT '积分优惠分解金额',
  `real_amount` decimal(10,2) DEFAULT NULL COMMENT '该商品经过优惠后的分解金额',
  `gift_integration` int(11) DEFAULT '0',
  `gift_growth` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COMMENT='订单中所包含的商品';


-- ----------------------------
-- Table structure for oms_order_operate_history
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_operate_history`;
CREATE TABLE `oms_order_operate_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单id',
  `operate_man` varchar(100) DEFAULT NULL COMMENT '操作人：用户；系统；后台管理员',
  `create_time` datetime DEFAULT NULL COMMENT '操作时间',
  `order_status` int(1) DEFAULT NULL COMMENT '订单状态：0->待付款；1->待发货；2->已发货；3->已完成；4->已关闭；5->无效订单',
  `note` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='订单操作历史记录';

-- ----------------------------
-- Records of oms_order_operate_history


-- ----------------------------
-- Table structure for oms_order_return_reason
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_return_reason`;
CREATE TABLE `oms_order_return_reason` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL COMMENT '退货类型',
  `sort` int(11) DEFAULT NULL,
  `status` int(1) DEFAULT NULL COMMENT '状态：0->不启用；1->启用',
  `create_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='退货原因表';

-- ----------------------------
-- Records of oms_order_return_reason


-- ----------------------------
-- Table structure for oms_order_setting
-- ----------------------------
DROP TABLE IF EXISTS `oms_order_setting`;
CREATE TABLE `oms_order_setting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `flash_order_overtime` int(11) DEFAULT NULL COMMENT '秒杀订单超时关闭时间(分)',
  `normal_order_overtime` int(11) DEFAULT NULL COMMENT '正常订单超时时间(分)',
  `confirm_overtime` int(11) DEFAULT NULL COMMENT '发货后自动确认收货时间（天）',
  `finish_overtime` int(11) DEFAULT NULL COMMENT '自动完成交易时间，不能申请售后（天）',
  `comment_overtime` int(11) DEFAULT NULL COMMENT '订单完成后自动好评时间（天）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='订单设置表';

-- ----------------------------
-- Records of oms_order_setting
-- ----------------------------
INSERT INTO `oms_order_setting` VALUES ('1', '60', '120', '15', '7', '7');



-- ----------------------------
-- Table structure for ums_member_receive_address
-- ----------------------------
DROP TABLE IF EXISTS `ums_member_receive_address`;
CREATE TABLE `ums_member_receive_address` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `member_id` bigint(20) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '收货人名称',
  `phone_number` varchar(64) DEFAULT NULL,
  `default_status` int(1) DEFAULT NULL COMMENT '是否为默认',
  `post_code` varchar(100) DEFAULT NULL COMMENT '邮政编码',
  `province` varchar(100) DEFAULT NULL COMMENT '省份/直辖市',
  `city` varchar(100) DEFAULT NULL COMMENT '城市',
  `region` varchar(100) DEFAULT NULL COMMENT '区',
  `detail_address` varchar(128) DEFAULT NULL COMMENT '详细地址(街道)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='会员收货地址表';

-- ----------------------------
-- Records of ums_member_receive_address
-- ----------------------------
INSERT INTO `ums_member_receive_address` VALUES ('1', '1', 'tianming', '18033441849', '0', '518000', '广东省', '深圳市', '南山区', '科兴科学园');
INSERT INTO `ums_member_receive_address` VALUES ('3', '1', 'tianming', '18033441849', '0', '518000', '广东省', '深圳市', '福田区', '清水河街道');
INSERT INTO `ums_member_receive_address` VALUES ('4', '1', 'tianming', '18033441849', '1', '518000', '广东省', '深圳市', '福田区', '东晓街道');



