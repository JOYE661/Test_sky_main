package com.sky.controller.admin;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sky.result.Result;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/admin/common")
@Slf4j
public class CommonController {

    @Value("${sky.file.local.upload-path}")
    private String uploadPath;

    @Value("${sky.file.local.access-url-prefix}")
    private String accessUrlPrefix;

    /**
     * 上传图片
     * 
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) {
        log.info("上传图片：{}", file);
        String originalFilename = file.getOriginalFilename();
        String suffix = ".jpg";
        if (originalFilename != null) {
            suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        }
        String fileName = UUID.randomUUID().toString() + suffix;
        
        // 确保上传目录存在
        java.io.File uploadDir = new java.io.File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        
        // 构建完整的文件路径
        java.io.File destFile = new java.io.File(uploadPath + java.io.File.separator + fileName);
        String imgUrl = accessUrlPrefix + (accessUrlPrefix.endsWith("/") ? "" : "/") + fileName;
        
        try {
            file.transferTo(destFile);
            log.info("图片上传成功，保存到：{}，访问地址：{}", destFile.getAbsolutePath(), imgUrl);
            return Result.success(imgUrl);
        } catch (IllegalStateException | IOException e) {
            log.error("上传图片失败：{}", e);
            return Result.error("上传图片失败");
        }
    }
}
