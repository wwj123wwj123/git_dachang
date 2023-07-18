package com.dachuang.service;

import com.dachuang.controller.common.Result;
import com.dachuang.domin.User;

public interface UserService {
    public Result login(User user);
    public Result register(User user);
    public boolean selectUserByEmail(String email);
}
