package com.github.shoothzj.ueditor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class FileUploadUtil {

    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMddHHmm");

    public static String generateFileName() {
        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.format(DATETIME_FORMATTER) + UUID.randomUUID().toString().substring(0, 4);
    }

}
