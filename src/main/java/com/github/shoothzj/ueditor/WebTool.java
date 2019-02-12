package com.github.shoothzj.ueditor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

public class WebTool {

    private static final Logger log = LoggerFactory.getLogger(WebTool.class);

    public static String pro(String str) {
        if (str.endsWith(".html")) {
            return str.substring(0, str.length() - 5);
        }
        return str;
    }

    public static MultiValueMap<String, String> aa() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return headers;
    }

}
