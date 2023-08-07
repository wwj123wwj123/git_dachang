package com.dachuang.service.user;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dachuang.entity.user.dto.UserDTO;
import com.dachuang.entity.user.po.UserDO;
import com.dachuang.util.HttpResult;

public interface UserService extends IService<UserDO> {
    /**
     * 登录
     * @param userDTO
     * @return
     */
    public HttpResult login(UserDTO userDTO);

    /**
     * 注册
     * @param userDTO
     * @return
     */
    public HttpResult register(UserDTO userDTO);

    /**
     * 根据邮箱查用户
     * @param email
     * @return
     */
    public boolean selectUserByEmail(String email);
    /**
     * 用户上传数据管理
     * @param userId
     * @return
     */
    public HttpResult dataMangement(Long userId);
}
