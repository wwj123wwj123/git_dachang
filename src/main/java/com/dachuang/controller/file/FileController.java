package com.dachuang.controller.file;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import com.dachuang.entity.file.dto.FileDownloadDTO;
import com.dachuang.entity.file.dto.FileUploadDTO;
import com.dachuang.service.file.FileService;
import com.dachuang.util.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
@RestController
@RequestMapping("/file")
public class FileController {
    @Value("${file.location}")
    private String fileLocation;
    @Autowired
    private FileService fileService;

    /**
     * 上传接口
     * @param fileUploadDTO
     * @return
     */
    @PostMapping("/upload")
    public HttpResult upload(FileUploadDTO fileUploadDTO) {
        return fileService.uploadFile(fileUploadDTO);
    }
    /**
    下载接口
     */
    @GetMapping("/download/{flag}")
    public void getFiles(@PathVariable String flag, HttpServletResponse response)  {
        fileService.downloadFile(new FileDownloadDTO(flag,response));
    }
}
