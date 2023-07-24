create table da_chuang.sys_sample
(
    id          bigint auto_increment
        primary key,
    sample_name varchar(64) default 'NULL' not null comment '文件名',
    path        varchar(200)               null comment '文件存储路径',
    visible     char        default '0'    null comment '样例状态（0显示 1隐藏）',
    status      char        default '0'    null comment '样例状态（0审核中 1审核通过）',
    create_by   bigint                     null,
    create_time datetime                   null,
    update_by   bigint                     null,
    update_time datetime                   null,
    del_flag    int         default 0      null comment '是否删除（0未删除 1已删除）',
    remark      varchar(500)               null comment '备注',
    size        int                        null comment '文件大小'
)
    comment '样例表';
