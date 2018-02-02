package com.tencent.mm.pluginsdk;

import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;

public final class b$a {
    public static final HashMap<String, Long> vcc;

    public static Long Rc(String str) {
        if (str == null) {
            return null;
        }
        return (Long) vcc.get(str.toLowerCase());
    }

    static {
        HashMap hashMap = new HashMap();
        vcc = hashMap;
        hashMap.put("doc", Long.valueOf(64));
        vcc.put("docx", Long.valueOf(128));
        vcc.put("ppt", Long.valueOf(256));
        vcc.put("pptx", Long.valueOf(512));
        vcc.put("xls", Long.valueOf(1024));
        vcc.put("xlsx", Long.valueOf(2048));
        vcc.put("pdf", Long.valueOf(4096));
        vcc.put("1", Long.valueOf(1));
        vcc.put(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, Long.valueOf(2));
        vcc.put("48", Long.valueOf(4));
        vcc.put("43", Long.valueOf(8));
        vcc.put("mp3", Long.valueOf(16));
        vcc.put("wav", Long.valueOf(16));
        vcc.put("wma", Long.valueOf(16));
        vcc.put("avi", Long.valueOf(8));
        vcc.put("rmvb", Long.valueOf(8));
        vcc.put("rm", Long.valueOf(8));
        vcc.put("mpg", Long.valueOf(8));
        vcc.put("mpeg", Long.valueOf(8));
        vcc.put("wmv", Long.valueOf(8));
        vcc.put("mp4", Long.valueOf(8));
        vcc.put("mkv", Long.valueOf(8));
    }
}
