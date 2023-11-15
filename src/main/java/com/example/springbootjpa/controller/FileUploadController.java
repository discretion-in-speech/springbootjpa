package com.example.springbootjpa.controller;


import com.example.springbootjpa.util.OssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public void upload(MultipartFile file){
        OssUtil.uploadFileToOss(file);
    }

}
