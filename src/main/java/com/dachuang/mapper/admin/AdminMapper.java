package com.dachuang.mapper.admin;

import com.dachuang.entity.file.po.FileDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminMapper {
    /**
     * 审核图片 管理员更改状态
     * @param fileDO
     */
    @Update("update sys_sample set status = #{status},update_time = #{updateTime} where id = #{id} ")
    int statusChange(FileDO fileDO);
}
