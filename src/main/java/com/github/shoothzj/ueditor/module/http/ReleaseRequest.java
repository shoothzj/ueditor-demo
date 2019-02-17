package com.github.shoothzj.ueditor.module.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReleaseRequest {

    String content;

    String articleTitle;

    public ReleaseRequest() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }
}
