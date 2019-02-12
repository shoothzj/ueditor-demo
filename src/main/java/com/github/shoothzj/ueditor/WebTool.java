package com.github.shoothzj.ueditor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebTool {

    private static final Logger log = LoggerFactory.getLogger(WebTool.class);

    public static String pro(String str) {
        if (str.endsWith(".html")) {
            return str.substring(0, str.length() - 5);
        }
        return str;
    }

}
