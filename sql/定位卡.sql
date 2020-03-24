/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/3/24 23:06:40                           */
/*==============================================================*/


drop table if exists t_terminal_alarm;

drop table if exists t_terminal_dict;

drop table if exists t_terminal_fence;

drop table if exists t_terminal_gps_log;

drop table if exists t_terminal_group;

drop table if exists t_terminal_info;

drop table if exists t_terminal_kinship;

/*==============================================================*/
/* Table: t_terminal_alarm                                      */
/*==============================================================*/
create table t_terminal_alarm
(
   terminal_alarm_id    varchar(64) not null comment '主键id',
   terminal_id          varchar(64) comment '卡片主键',
   terminal_alarm_cycle_day varchar(20) comment '闹钟周期设置:0周日，1周一，2周二，3周三，4周四，5周五，6周六；多个逗号分隔',
   terminal_alarm_point varchar(20) comment '闹钟提醒时间点',
   terminal_alarm_type  int(1) comment '类型：0 闹钟 1整点报时',
   enable_flag          int(1) default 1 comment '启用禁用标志：0 禁用，1启用',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新人时间',
   primary key (terminal_alarm_id)
);

alter table t_terminal_alarm comment '定位卡关联闹钟信息';

/*==============================================================*/
/* Table: t_terminal_dict                                       */
/*==============================================================*/
create table t_terminal_dict
(
   terminal_dict_code   varchar(64) not null comment '终端字典编码',
   terminal_dict_name   varchar(255) comment '终端字典名称',
   terminal_dict_memo   text comment '终端字典备注信息',
   terminal_dict_type   int(1) comment '终端字典类型:0终端厂商字典，1终端设备类型',
   enable_flag          int(1) default 1 comment '启用禁用标志：0=禁用；1=启用',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (terminal_dict_code)
);

alter table t_terminal_dict comment '定位卡字典表';

/*==============================================================*/
/* Table: t_terminal_fence                                      */
/*==============================================================*/
create table t_terminal_fence
(
   terminal_fence_id    varchar(64) not null comment '主键id',
   terminal_id          varchar(64) comment '卡片主键',
   terminal_fence_type  varchar(20) comment '电子围栏类型：0圆形，1椭圆形，2线条形',
   terminal_fence_point varchar(64) comment '电子围栏顶点经纬度(多个顶点多条记录或者一条符号分隔开)',
   enable_flag          int(1) default 1 comment '启用禁用标志：0 禁用，1启用',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (terminal_fence_id)
);

alter table t_terminal_fence comment '定位卡电子围栏配置';

/*==============================================================*/
/* Table: t_terminal_gps_log                                    */
/*==============================================================*/
create table t_terminal_gps_log
(
   serial_id            varchar(64) not null comment 'GPS记录主键id',
   terminal_id          varchar(64) comment '定位卡主键',
   longitude            decimal(10,2) comment '经度',
   latitude             decimal(10,2) comment '纬度',
   battery_percentage   decimal(3,3) comment '上报时的电量百分比（0到100之间）',
   fence_flag           int(1) comment '电子围栏标志:0 不在围栏内，1在围栏内，2未设置围栏',
   create_time          datetime comment '创建时间',
   primary key (serial_id)
);

alter table t_terminal_gps_log comment '定位卡定位记录';

/*==============================================================*/
/* Table: t_terminal_group                                      */
/*==============================================================*/
create table t_terminal_group
(
   terminal_group_id    varchar(64) not null comment '卡片分组主键id',
   terminal_group_name  varchar(100) comment '卡片分组名称',
   terminal_group_level int(2) comment '分组层级，从0开始递增；0=root节点；',
   parent_terminal_group_id varchar(64) comment '上级分组id',
   enable_flag          int(1) default 1 comment '启用禁用标志：:0 禁用，1启用',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新时间',
   primary key (terminal_group_id)
);

alter table t_terminal_group comment '定位卡分组信息';

/*==============================================================*/
/* Table: t_terminal_info                                       */
/*==============================================================*/
create table t_terminal_info
(
   terminal_id          varchar(64) not null comment '卡片编码',
   terminal_name        varchar(100) comment '卡片名称',
   terminal_group_id    varchar(64) comment '卡片分组id',
   terminal_status      int(1) comment '卡片状态：0 在线 1离线',
   enable_flag          int(1) default 1 comment '启用禁用标志：0 禁用，1启用',
   battery_percentage   decimal(3,3) comment '电量百分比（0到100之间）',
   create_time          datetime comment '卡片开通时间',
   update_time          datetime comment '卡片更新时间',
   expire_time          datetime comment '卡片到期时间',
   primary key (terminal_id)
);

alter table t_terminal_info comment '定位卡基础信息';

/*==============================================================*/
/* Table: t_terminal_kinship                                    */
/*==============================================================*/
create table t_terminal_kinship
(
   terminal_kinship_id  varchar(64) not null comment '主键id',
   terminal_id          varchar(64) comment '卡片主键',
   terminal_kinship_phone varchar(20) comment '亲情手机号',
   terminal_kinship_contactor varchar(50) comment '亲情联络人姓名',
   terminal_kinship_type int(1) comment '号码类型：0亲情号,1sos号码',
   create_time          datetime comment '创建时间',
   update_time          datetime comment '更新人时间',
   primary key (terminal_kinship_id)
);

alter table t_terminal_kinship comment '定位卡关联亲情号码';

