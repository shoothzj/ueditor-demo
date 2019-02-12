package com.github.shoothzj.ueditor.controller;

import com.github.shoothzj.ueditor.WebTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PortalController {

    private static final Logger log = LoggerFactory.getLogger(PortalController.class);

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String other() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{url}")
    public String t(@PathVariable String url) {
        String[] split = url.split("\\.");
        log.info("receive a request url is {}", url);
        return split[0];
    }

    @RequestMapping(method = RequestMethod.GET, value = "/canvas/{url}")
    public String tt(@PathVariable String url) {
        return "canvas/" + WebTool.pro(url);
    }


}
