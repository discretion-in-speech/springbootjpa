package com.example.springbootjpa.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class OSSTest2 {




    /**
     * OSS 使用步骤 阿里云
     * 1）、引入SDK
     * 2）、配置好相应的属性
     */
    public static void main(String[] args) throws IOException {
//        AliOssUtil aliOssUtil = new AliOssUtil();
        // 上传文件流。
//        InputStream inputStream = new FileInputStream(new File("D:\\img\\8.jpg"));
//        byte[] ins = AliOssUtil.toByteArray(inputStream);\
//        aliOssUtil.upload(ins,aliOssUtil.getBucketName());


        System.out.println("测试完成");
    }
}
