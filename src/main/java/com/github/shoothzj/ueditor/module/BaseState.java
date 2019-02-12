package com.github.shoothzj.ueditor.module;

import com.baidu.ueditor.Encoder;
import com.baidu.ueditor.define.AppInfo;
import com.baidu.ueditor.define.State;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BaseState {

    private boolean state = false;
    private String info = null;
    private Map<String, String> infoMap = new HashMap<>();

    public BaseState() {
        this.state = true;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Map<String, String> getInfoMap() {
        return infoMap;
    }

    public void setInfoMap(Map<String, String> infoMap) {
        this.infoMap = infoMap;
    }
}
