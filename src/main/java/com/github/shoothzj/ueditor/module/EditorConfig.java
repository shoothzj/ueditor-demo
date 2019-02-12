package com.github.shoothzj.ueditor.module;


import java.util.Arrays;
import java.util.List;

public class EditorConfig {

    String imageActionName = "uploadImage";

    String imageUrlPrefix = "image";

    List<String> imageAllowFiles = Arrays.asList(".png", ".jpg", ".jpeg", ".gif", ".bmp");

    public EditorConfig() {

    }

    public String getImageActionName() {
        return imageActionName;
    }

    public void setImageActionName(String imageActionName) {
        this.imageActionName = imageActionName;
    }

    public String getImageUrlPrefix() {
        return imageUrlPrefix;
    }

    public void setImageUrlPrefix(String imageUrlPrefix) {
        this.imageUrlPrefix = imageUrlPrefix;
    }

    public List<String> getImageAllowFiles() {
        return imageAllowFiles;
    }

    public void setImageAllowFiles(List<String> imageAllowFiles) {
        this.imageAllowFiles = imageAllowFiles;
    }
}
