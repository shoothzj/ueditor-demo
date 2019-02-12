package com.github.shoothzj.ueditor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JacksonService {

    private static final Logger log = LoggerFactory.getLogger(JacksonService.class);

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String toJson(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            log.error("json process error, exception is {}", e);
        }
        return "";
    }

}
