package com.github.shoothzj.ueditor.controller;

import com.github.shoothzj.ueditor.constant.UrlConstant;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import static com.github.shoothzj.ueditor.ConfigManager.initEnv;

@Controller
public class EditorController {

    private static final Logger log = LoggerFactory.getLogger(EditorController.class);

    @RequestMapping(value = "/editor")
    public ResponseEntity<String> editor(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type", "text/html");
        JSONObject jsonObject = initEnv();
        return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = UrlConstant.pic)
    public ResponseEntity<String> uploadPic(@RequestParam("file") MultipartFile file) {
        log.info("receive a file {} {}", file.getName(), file.getOriginalFilename());
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
