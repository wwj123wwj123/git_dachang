-- auto-generated definition
create table sys_user
(
    id          bigint auto_increment comment '主键'
        primary key,
    user_name   varchar(256) default 'NULL' not null comment '用户名',
    nick_name   varchar(256) default 'NULL' not null comment '昵称',
    password    varchar(256) default 'NULL' not null comment '密码',
    status      char(255)    default '0'    null comment '账号状态（0正常 1停用）',
    email       varchar(255)                null comment '邮箱',
    phonenumber varchar(255)                null comment '手机号',
    sex         char(255)                   null comment '用户性别（0男，1女，2未知）',
    avatar      varchar(255)                null comment '头像',
    user_type   char(255)    default '1'    not null comment '用户类型（0管理员，1普通用户，2 高级会员，3终生会员）',
    create_by   bigint                      null comment '创建人的用户id',
    create_time datetime                    null comment '创建时间',
    update_by   bigint                      null comment '更新人',
    update_time datetime                    null comment '更新时间',
    del_flag    int          default 0      null comment '删除标志（0代表未删除，1代表已删除）'
)
    comment '用户表';

INSERT INTO da_chuang.sys_user (user_name, nick_name, password, status, email, phonenumber, sex, avatar, user_type, create_by, create_time, update_by, update_time, del_flag) VALUES
('user1', 'User1', '123456', '0', 'user1@example.com', '12345678901', '0', 'avatar1.jpg', '1', 1, NOW(), 1, NOW(), '0'),
('user2', 'User2', 'abcdef', '0', 'user2@example.com', '98765432101', '1', 'avatar2.jpg', '2', 1, NOW(), 1, NOW(), '0'),
('user3', 'User3', 'qwerty', '0', 'user3@example.com', '56789012345', '2', 'avatar3.jpg', '3', 1, NOW(), 1, NOW(), '0'),
('user4', 'User4', 'test123', '0', 'user4@example.com', '45678901234', '0', 'avatar4.jpg', '1', 1, NOW(), 1, NOW(), '0'),
('user5', 'User5', 'password', '0', 'user5@example.com', '56789012345', '1', 'avatar5.jpg', '2', 1, NOW(), 1, NOW(), '0'),
('user6', 'User6', 'mypassw0rd', '0', 'user6@example.com', '67890123456', '0', 'avatar6.jpg', '3', 1, NOW(), 1, NOW(), '0'),
('user7', 'User7', 'letmein!', '0', 'user7@example.com', '78901234567', '2', 'avatar7.jpg', '1', 1, NOW(), 1, NOW(), '0'),
('user8', 'User8', '[password]', '0', 'user8@example.com', '89012345678', '0', '', '', 1, NOW(), 1, NOW(), '0'),
('user9', 'User9', '$ecureP@ssw0rd!', '0', '', '', '', '', '', 1, NOW(), 1, NOW(), '0'),
('user10', '', '', '', '', '', '', '', '', 1, NOW(), 1, NOW(), '');
