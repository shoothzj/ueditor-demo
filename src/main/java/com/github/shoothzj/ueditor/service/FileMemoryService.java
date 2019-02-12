package com.github.shoothzj.ueditor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 把文件存在内存模拟
 */
@Service
public class FileMemoryService {

    private static final Logger log = LoggerFactory.getLogger(FileMemoryService.class);

    private static final ConcurrentHashMap<String, byte[]> singlePicMap = new ConcurrentHashMap<>();

    public void saveUploadPic(String originalFilename, byte[] bytes) {
        log.info("originalFileName is {}", originalFilename);
        singlePicMap.put(originalFilename, bytes);
    }


    public byte[] getUploadPic(String fileName) {
        return singlePicMap.get(fileName);
    }
}
