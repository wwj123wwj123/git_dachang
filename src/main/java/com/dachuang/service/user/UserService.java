package com.dachuang.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dachuang.entity.user.dto.UserDTO;
import com.dachuang.entity.user.po.UserDO;
import com.dachuang.util.HttpResult;

public interface UserService extends IService<UserDO> {
    public HttpResult login(UserDTO userDTO);
    public HttpResult register(UserDTO userDTO);
    public boolean selectUserByEmail(String email);
}
