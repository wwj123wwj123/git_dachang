package com.dachuang.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dachuang.entity.file.po.FileDO;
import com.dachuang.entity.user.po.UserDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
    /**
     * 根据email查询user
     * @param email
     * @return
     */
    @Select("select * from sys_user where email = #{email}")
    UserDO selectUserByEmail(String email);

    /**
     * 根据创建人的userId查询所创建的所有信息
     * @param userId
     * @return
     */
    List<FileDO> selectDataMangement(Long userId);
}
