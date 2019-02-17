package com.github.shoothzj.ueditor.controller;

import com.github.shoothzj.javatool.service.JacksonService;
import com.github.shoothzj.ueditor.module.http.CollectRequest;
import com.github.shoothzj.ueditor.module.http.ReleaseRequest;
import com.github.shoothzj.ueditor.module.http.CollectResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;

@Controller
public class JsController {

    private static final Logger log = LoggerFactory.getLogger(JsController.class);

    @RequestMapping(value = "/editor/release", method = RequestMethod.POST)
    public ResponseEntity<Void> editor(@RequestBody ReleaseRequest releaseRequest) throws IOException {
        log.info("receive a request {}", releaseRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/editor/collect", method = RequestMethod.POST)
    public ResponseEntity<String> collect(@RequestBody CollectRequest collectRequest) throws IOException {
        log.info("receive a request {}", collectRequest);
        CollectResponse response = new CollectResponse();
        response.setHtmlContent("<p>\n" +
                "    我是一头鹿ddd&amp;amp\n" +
                "</p>");
        return new ResponseEntity<>(JacksonService.toJson(response), HttpStatus.OK);
    }

}
