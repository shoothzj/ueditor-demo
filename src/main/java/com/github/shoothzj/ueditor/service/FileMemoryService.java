package com.github.shoothzj.ueditor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 把文件存在内存模拟
 */
@Service
public class FileMemoryService {

    private static final Logger log = LoggerFactory.getLogger(FileMemoryService.class);

    public void saveUploadPic(String originalFilename, byte[] bytes) {
        log.info("originalFileName is {}", originalFilename);
    }


}
