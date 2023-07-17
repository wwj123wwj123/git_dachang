package com.dachuang.dao.UserDao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dachuang.domin.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from sys_user where email = #{email}")
    User selectUserByEmail(String email);
}
