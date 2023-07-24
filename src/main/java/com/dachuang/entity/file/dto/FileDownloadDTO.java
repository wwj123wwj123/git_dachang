package com.dachuang.entity.file.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class FileDownloadDTO {
    /**
     * 文件名
     */
   private String flag;
    /**
     * 响应头
     */
    private HttpServletResponse response;
}
