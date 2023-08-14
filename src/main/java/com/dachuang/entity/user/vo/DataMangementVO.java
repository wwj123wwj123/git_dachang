package com.dachuang.entity.user.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataMangementVO {
    /**
     * 数据库中的id
     */
    private Long id;
    /**
     * 文件保存路径
     */
    private String path;
    /**
     *  样例状态（0 审核中  1 通过）
     */
    private Integer status;
    /**
     *  创建文件的人 存用户的userId
     */
    private Long createBy;
    /**
     * 文件创建的时间
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    /**
     * 文件的备注
     */
    private String remark;
    /**
     * 文件的大小
     */
    private Integer size;
    /**
     * 图片的地址
     */
    private String address;
}
