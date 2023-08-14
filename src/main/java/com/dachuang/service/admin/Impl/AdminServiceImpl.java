package com.dachuang.service.admin.Impl;

import com.dachuang.entity.admin.DataStatusDTO;
import com.dachuang.entity.file.po.FileDO;
import com.dachuang.mapper.admin.AdminMapper;
import com.dachuang.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public int statusChange(DataStatusDTO dataStatusDTO) {
        FileDO fileDO = FileDO.builder()
                .id(dataStatusDTO.getId())
                .status(dataStatusDTO.getStatus())
                .updateTime(LocalDateTime.now())
                .build();
        adminMapper.statusChange(fileDO);
        return  adminMapper.statusChange(fileDO);
    }
}
