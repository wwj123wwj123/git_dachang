package com.dachuang.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dachuang.entity.user.po.UserDO;
import org.apache.ibatis.annotations.*;
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
    /**
     * 根据email查询user
     * @param email
     * @return
     */
    @Select("select * from sys_user where email = #{email}")
    UserDO selectUserByEmail(String email);
}
