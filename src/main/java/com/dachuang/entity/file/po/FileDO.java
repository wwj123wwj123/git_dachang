package com.dachuang.entity.file.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author chong'chong'chong
 */
@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_sample")
public class FileDO {
    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;
    /**
     *  文件名
     */
    @TableField(value = "sample_name")
    private String sampleName;
    /**
     * 文件保存路径
     */
    @TableField(value = "path")
    private String path;
    /**
     *  样例状态（0显示  1隐藏）
     */
    @TableField(value = "visible")
    private String visible;
    /**
     *  样例状态（0 审核中  1 通过）
     */
    @TableField(value = "status")
    private String status;
    /**
     *  创建文件的人 存用户的userId
     */
    @TableField(value = "create_by")
    private Long createBy;
    /**
     * 文件创建的时间
     */
    @TableField(value = "create_time")
    private String createTime;
    /**
     * 文件更新的人
     */
    @TableField(value = "update_time")
    private Long updateBy;
    /**
     * 文件更新的时间
     */
    @TableField(value = "update_time")
    private String updateTime;
    /**
     * 文件是否被删除（0 未删除 1 已删除）
     */
    @TableField(value = "del_flag")
    private Integer delFlag;
    /**
     * 文件的备注
     */
    @TableField(value = "remark")
    private String remark;
    /**
     * 文件的大小
     */
    @TableField(value = "size")
    private Integer size;
    /**
     * 图片的地址
     */
    @TableField(value = "address")
    private String address;
}
