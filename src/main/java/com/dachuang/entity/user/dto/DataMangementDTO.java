package com.dachuang.entity.user.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DataMangementDTO {
    /**
     * 文件保存路径
     */
    private String path;
    /**
     *  样例状态（0 审核中  1 通过）
     */
    private String status;
    /**
     *  创建文件的人 存用户的userId
     */
    private Long createBy;
    /**
     * 文件创建的时间
     */
    private String createTime;
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
