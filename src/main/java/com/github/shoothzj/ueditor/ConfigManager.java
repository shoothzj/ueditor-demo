//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.github.shoothzj.ueditor;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public final class ConfigManager {

    private static final Logger log = LoggerFactory.getLogger(ConfigManager.class);

    public static JSONObject initEnv() throws FileNotFoundException, IOException {
        File file = new File(ConfigManager.class.getClassLoader().getResource("config.json").getFile());
        log.info("path is {}", file.getAbsolutePath());
        String configContent = readFile(file.getAbsolutePath());
        JSONObject jsonConfig = null;
        try {
            jsonConfig = new JSONObject(configContent);
        } catch (Exception var4) {
        }
        return jsonConfig;
    }

    private static String readFile(String path) throws IOException {
        StringBuilder builder = new StringBuilder();

        try {
            InputStreamReader reader = new InputStreamReader(new FileInputStream(path), "UTF-8");
            BufferedReader bfReader = new BufferedReader(reader);
            String tmpContent = null;

            while ((tmpContent = bfReader.readLine()) != null) {
                builder.append(tmpContent);
            }

            bfReader.close();
        } catch (UnsupportedEncodingException var6) {
        }

        return filter(builder.toString());
    }

    private static String filter(String input) {
        return input.replaceAll("/\\*[\\s\\S]*?\\*/", "");
    }

}
