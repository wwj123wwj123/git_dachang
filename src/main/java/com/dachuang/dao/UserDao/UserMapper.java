package com.dachuang.dao.UserDao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dachuang.domin.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据email查询user
     * @param email
     * @return
     */
    @Select("select * from sys_user where email = #{email}")
    User selectUserByEmail(String email);
    @Insert("insert into sys_user set user_name =#{user.userName},nick_name = #{user.userName}," +
            "email = #{user.email},password = #{user.password} ")
    int registerUser(@Param("user") User user);
}
