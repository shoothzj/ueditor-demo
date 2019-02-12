package com.github.shoothzj.ueditor.controller;

import com.github.shoothzj.javatool.service.JacksonService;
import com.github.shoothzj.javatool.tool.IOTool;
import com.github.shoothzj.ueditor.WebTool;
import com.github.shoothzj.ueditor.constant.UrlConstant;
import com.github.shoothzj.ueditor.module.BaseState;
import com.github.shoothzj.ueditor.service.FileMemoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EditorController {

    private static final Logger log = LoggerFactory.getLogger(EditorController.class);

    @Autowired
    private FileMemoryService fileMemoryService;

    @RequestMapping(value = "/editor")
    public ResponseEntity<String> editor(@RequestParam(required = false)String action, @RequestParam(required = false) String callback, @RequestParam(value = "upfile", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.info("callback is {}", callback);

        if (action == null) {
            request.setCharacterEncoding("utf-8");
            response.setHeader("Content-Type", "text/html");
            return new ResponseEntity<>(IOTool.readFile2String(EditorController.class.getClassLoader().getResource("config.json").getFile()), HttpStatus.OK);
        }
        request.setCharacterEncoding("utf-8");
        switch (action) {
            case "config":
                response.setHeader("Content-Type", "text/html");
                return new ResponseEntity<>(IOTool.readFile2String(EditorController.class.getClassLoader().getResource("config.json").getFile()), HttpStatus.OK);
            case "uploadimage":
                response.setHeader("Content-Type", "application/json");
                return uploadImage(file.getOriginalFilename(), file.getBytes());
        }
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type", "text/html");
        return new ResponseEntity<>(IOTool.readFile2String(EditorController.class.getClassLoader().getResource("config.json").getFile()), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST, value = UrlConstant.pic)
    public ResponseEntity<String> uploadPic(@RequestParam("file") MultipartFile file) {
        log.info("receive a file {} {}", file.getName(), file.getOriginalFilename());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<String> uploadImage(String name, byte[] bytes) {
        fileMemoryService.saveUploadPic(name, bytes);
        BaseState baseState = new BaseState();
        Map<String, String> map = new HashMap<>();
        map.put("url", "http://127.0.0.1:9596/singleFile" + name);
        map.put("type", "png");
        map.put("size", String.valueOf(bytes.length));
        map.put("title", name);
        baseState.setInfoMap(map);
        ResponseEntity<String> responseEntity = new ResponseEntity<>(JacksonService.toJson(baseState), WebTool.aa(), HttpStatus.OK);
        return responseEntity;
    }

}
