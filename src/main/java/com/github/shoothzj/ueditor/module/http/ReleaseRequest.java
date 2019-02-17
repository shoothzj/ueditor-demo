package com.github.shoothzj.ueditor.module.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReleaseRequest {

    String content;

    public ReleaseRequest() {
    }

    public ReleaseRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ReleaseRequest{" +
                "content='" + content + '\'' +
                '}';
    }
}
