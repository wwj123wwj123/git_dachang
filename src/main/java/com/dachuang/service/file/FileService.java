package com.dachuang.service.file;

import com.baomidou.mybatisplus.extension.service.IService;
import com.dachuang.entity.file.dto.FileDownloadDTO;
import com.dachuang.entity.file.dto.FileUploadDTO;
import com.dachuang.entity.file.po.FileDO;
import com.dachuang.util.HttpResult;

import java.io.IOException;

public interface FileService extends IService<FileDO> {
    /**
     * 文件上传
     * @param fileServiceDTO
     * @return
     */
    HttpResult uploadFile(FileUploadDTO fileServiceDTO);

    /**
     * 文件下载
     * @param fileDownloadDTO
     * @return
     */
    void downloadFile(FileDownloadDTO fileDownloadDTO) ;
}
