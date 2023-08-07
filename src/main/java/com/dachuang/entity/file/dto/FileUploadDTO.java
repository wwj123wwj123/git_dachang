package com.dachuang.entity.file.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class FileUploadDTO {
    /**
     * 文件
     */
   private MultipartFile file;
    /**
     * useid
     */
    private Long userId;
    /**
     * 文件的地理信息
     */
    private String address;
}
