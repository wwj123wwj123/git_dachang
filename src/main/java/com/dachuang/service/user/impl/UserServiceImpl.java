package com.dachuang.service.user.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dachuang.entity.file.po.FileDO;
import com.dachuang.entity.user.vo.DataMangementVO;
import com.dachuang.entity.user.dto.UserDTO;
import com.dachuang.entity.user.po.UserDO;
import com.dachuang.enums.ResultCodeEnum;
import com.dachuang.mapper.user.UserMapper;
import com.dachuang.service.user.UserService;
import com.dachuang.util.HttpResult;
import com.dachuang.util.copy.BeanCopyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,UserDO> implements UserService {
     @Autowired
     private UserMapper userMapper;
     @Autowired
    private UserDO userDO;
    /**
     *
     * @param userDTO
     * @return Result
     * 登录实现
     */
    @Override
    public HttpResult login(UserDTO userDTO) {

        userDO= userMapper.selectUserByEmail(userDTO.getEmail());
        if(userDO==null)
        {
            return HttpResult.error(ResultCodeEnum.USER_NOT_EXIST);
        }
        if(!userDO.getPassword().equals(userDTO.getPassword()))
        {
            return HttpResult.error(ResultCodeEnum.USER_CREDENTIALS_ERROR);
        }
        return HttpResult.success(ResultCodeEnum.SUCCESS);
    }

    /**
     * 注册实现
     * @param userDTO
     * @return
     */
    @Override
    public HttpResult register(UserDTO userDTO) {
        userDO = userMapper.selectUserByEmail(userDTO.getEmail());
        if(userDO!=null)
        {
            return HttpResult.error(ResultCodeEnum.USER_ALREADY_EXIST);
        }
        userDO = UserDO.builder()
                .userName(userDTO.getUserName())
                .nickName(userDTO.getUserName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .createTime(LocalDateTime.now())
                .build();
        return userMapper.insert(userDO)>0?HttpResult.success("注册成功！"): HttpResult.error();
    }

    @Override
    public boolean selectUserByEmail(String email) {
        return userMapper.selectUserByEmail(email)!=null;
    }

    @Override
    public HttpResult dataMangement(Long userId) {

        List<FileDO> fileDOS = userMapper.selectDataMangement(userId);
        List<DataMangementVO> dataMangementVOS  = BeanCopyUtil.copyListProperties(fileDOS, DataMangementVO::new);
        return HttpResult.success(dataMangementVOS);
    }
}
