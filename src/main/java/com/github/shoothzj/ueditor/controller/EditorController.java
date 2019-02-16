package com.github.shoothzj.ueditor.controller;

import com.github.shoothzj.javatool.tool.IOTool;
import com.github.shoothzj.ueditor.FileUploadUtil;
import com.github.shoothzj.ueditor.WebTool;
import com.github.shoothzj.ueditor.constant.UrlConstant;
import com.github.shoothzj.ueditor.module.BaseState;
import com.github.shoothzj.ueditor.service.FileMemoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class EditorController {

    private static final Logger log = LoggerFactory.getLogger(EditorController.class);

    private final FileMemoryService fileMemoryService;

    private BaseState baseState;

    @Autowired
    public EditorController(FileMemoryService fileMemoryService) {
        this.fileMemoryService = fileMemoryService;
    }

    @RequestMapping(value = "/editor")
    public ResponseEntity<String> editor(@RequestParam(required = false) String action, @RequestParam(required = false) String callback, @RequestParam(value = "upfile", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("callback is {}", callback);

        if (action == null) {
            request.setCharacterEncoding("utf-8");
            response.setHeader("Content-Type", "text/html");
            return new ResponseEntity<>(IOTool.readFile2String(Objects.requireNonNull(EditorController.class.getClassLoader().getResource("config.json")).getFile()), HttpStatus.OK);
        }

        request.setCharacterEncoding("utf-8");
        switch (action) {
            case "config":
                response.setHeader("Content-Type", "text/html");
                return new ResponseEntity<>(IOTool.readFile2String(Objects.requireNonNull(EditorController.class.getClassLoader().getResource("config.json")).getFile()), HttpStatus.OK);
            case "uploadimage":
                response.setHeader("Content-Type", "application/json");
                return uploadImage(file.getOriginalFilename(), file.getBytes());
            case "uploadvideo":
                log.info("uploadvideo!");
                response.setHeader("Content-Type", "application/json");
                return uploadVideo(file.getOriginalFilename(), file.getBytes());
        }

        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type", "text/html");

        return new ResponseEntity<>(IOTool.readFile2String(Objects.requireNonNull(EditorController.class.getClassLoader().getResource("config.json")).getFile()), HttpStatus.OK);
    }

    @GetMapping(value = UrlConstant.pic + "/{fileName}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public @ResponseBody
    byte[] getFile(@PathVariable String fileName) throws IOException {
        return fileMemoryService.getUploadPic(fileName);
    }

    public ResponseEntity<String> uploadImage(String name, byte[] bytes) {
        String imageName = FileUploadUtil.generateFileName();

        fileMemoryService.saveUploadPic(imageName, bytes);
        baseState = new BaseState();

        Map<String, String> map = new HashMap<>();
        baseState.putInfo("url", UrlConstant.pic + "/" + imageName);
        baseState.putInfo("type", "png");
        baseState.putInfo("size", String.valueOf(bytes.length));
        baseState.putInfo("title", imageName);
        baseState.putInfo("original", imageName);

        return new ResponseEntity<>(baseState.toString(), WebTool.aa(), HttpStatus.OK);
    }

    public ResponseEntity<String> uploadVideo(String name, byte[] bytes) {
        String videoName = FileUploadUtil.generateFileName();

        fileMemoryService.saveUploadPic(videoName, bytes);
        baseState = new BaseState();

        Map<String, String> map = new HashMap<>();
        baseState.putInfo("url", UrlConstant.pic + "/" + videoName);
        baseState.putInfo("type", "mp4");
        baseState.putInfo("size", String.valueOf(bytes.length));
        baseState.putInfo("title", videoName);
        baseState.putInfo("original", videoName);

        return new ResponseEntity<>(baseState.toString(), WebTool.aa(), HttpStatus.OK);
    }

}
