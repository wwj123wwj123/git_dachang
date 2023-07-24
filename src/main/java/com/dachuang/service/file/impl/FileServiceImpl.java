package com.dachuang.service.file.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dachuang.constant.StyleOfStudyConstant;
import com.dachuang.entity.file.dto.FileDownloadDTO;
import com.dachuang.entity.file.dto.FileUploadDTO;
import com.dachuang.entity.file.po.FileDO;
import com.dachuang.mapper.file.FileMapper;
import com.dachuang.service.file.FileService;
import com.dachuang.util.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, FileDO> implements FileService {
    @Value("${file.location}")
    private String fileLocation;
    @Autowired
    private FileDO fileDO;
    @Autowired
    private FileMapper fileMapper;

    @Override
    public HttpResult uploadFile(FileUploadDTO fileUploadDTO) {
        File folder = new File(fileLocation);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        MultipartFile file = fileUploadDTO.getFile();
        String filename = file.getOriginalFilename();
        String flag = IdUtil.fastSimpleUUID();
        String rootFilePath = fileLocation + flag + "_" + filename;
        try {
            FileUtil.writeBytes(file.getBytes(), rootFilePath);
        } catch (IOException e) {
            return HttpResult.error(e.getMessage());
        }
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        fileDO = FileDO.builder()
                .sampleName(flag + "_" + filename)
                .path(rootFilePath)
                .size((int) (fileUploadDTO.getFile().getSize() / 1024))
                .createBy(fileUploadDTO.getUserId())
                .createTime(formatter.format(calendar.getTime()))
                .build();
        int insert = fileMapper.insert(fileDO);
        if (insert != StyleOfStudyConstant.REVIEW_SUCCESS) {
            return HttpResult.error("文件上传失败，请重试！");
        }
        return HttpResult.success("上传成功");
    }

    @Override
    public void downloadFile(FileDownloadDTO fileDownloadDTO) {
        OutputStream os;
        String basePath = fileLocation;
        List<String> fileNames = FileUtil.listFileNames(basePath);
        String fileName = fileNames.stream().filter(name -> name.contains(fileDownloadDTO.getFlag())).findAny().orElse("");
        try {
            if(StrUtil.isNotEmpty(fileName)){
                fileDownloadDTO.getResponse().addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
                fileDownloadDTO.getResponse().setContentType("application/octet-stream");
                //通过文件的路径读取文件字节流
                byte[] bytes = FileUtil.readBytes(basePath + fileName);
                //通过response的输出流返回文件
                os = fileDownloadDTO.getResponse().getOutputStream();
                os.write(bytes);
                os.flush();
                os.close();
            }
        }catch (Exception e){
            System.out.println("文件下载失败");
        }
    }
}
