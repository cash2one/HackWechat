package com.tencent.mm.pluginsdk;

import com.tencent.mm.plugin.k.a.a;
import com.tencent.mm.plugin.k.a.b;
import java.util.HashMap;

public final class c {
    private static HashMap<String, Integer> vce = null;

    public static int Rd(String str) {
        if (vce == null) {
            HashMap hashMap = new HashMap();
            vce = hashMap;
            hashMap.put("avi", Integer.valueOf(b.dvA));
            vce.put("m4v", Integer.valueOf(b.dvA));
            vce.put("vob", Integer.valueOf(b.dvA));
            vce.put("mpeg", Integer.valueOf(b.dvA));
            vce.put("mpe", Integer.valueOf(b.dvA));
            vce.put("asx", Integer.valueOf(b.dvA));
            vce.put("asf", Integer.valueOf(b.dvA));
            vce.put("f4v", Integer.valueOf(b.dvA));
            vce.put("flv", Integer.valueOf(b.dvA));
            vce.put("mkv", Integer.valueOf(b.dvA));
            vce.put("wmv", Integer.valueOf(b.dvA));
            vce.put("wm", Integer.valueOf(b.dvA));
            vce.put("3gp", Integer.valueOf(b.dvA));
            vce.put("mp4", Integer.valueOf(b.dvA));
            vce.put("rmvb", Integer.valueOf(b.dvA));
            vce.put("rm", Integer.valueOf(b.dvA));
            vce.put("ra", Integer.valueOf(b.dvA));
            vce.put("ram", Integer.valueOf(b.dvA));
            vce.put("mp3pro", Integer.valueOf(b.dvn));
            vce.put("vqf", Integer.valueOf(b.dvn));
            vce.put("cd", Integer.valueOf(b.dvn));
            vce.put("md", Integer.valueOf(b.dvn));
            vce.put("mod", Integer.valueOf(b.dvn));
            vce.put("vorbis", Integer.valueOf(b.dvn));
            vce.put("au", Integer.valueOf(b.dvn));
            vce.put("amr", Integer.valueOf(b.dvn));
            vce.put("silk", Integer.valueOf(b.dvn));
            vce.put("wma", Integer.valueOf(b.dvn));
            vce.put("mmf", Integer.valueOf(b.dvn));
            vce.put("mid", Integer.valueOf(b.dvn));
            vce.put("midi", Integer.valueOf(b.dvn));
            vce.put("mp3", Integer.valueOf(b.dvn));
            vce.put("aac", Integer.valueOf(b.dvn));
            vce.put("ape", Integer.valueOf(b.dvn));
            vce.put("aiff", Integer.valueOf(b.dvn));
            vce.put("aif", Integer.valueOf(b.dvn));
            vce.put("jfif", Integer.valueOf(a.byV));
            vce.put("tiff", Integer.valueOf(a.byV));
            vce.put("tif", Integer.valueOf(a.byV));
            vce.put("jpe", Integer.valueOf(a.byV));
            vce.put("dib", Integer.valueOf(a.byV));
            vce.put("jpeg", Integer.valueOf(a.byV));
            vce.put("jpg", Integer.valueOf(a.byV));
            vce.put("png", Integer.valueOf(a.byV));
            vce.put("bmp", Integer.valueOf(a.byV));
            vce.put("gif", Integer.valueOf(a.byV));
            vce.put("rar", Integer.valueOf(b.dvv));
            vce.put("zip", Integer.valueOf(b.dvv));
            vce.put("7z", Integer.valueOf(b.dvv));
            vce.put("iso", Integer.valueOf(b.dvv));
            vce.put("cab", Integer.valueOf(b.dvv));
            vce.put("doc", Integer.valueOf(b.dvE));
            vce.put("docx", Integer.valueOf(b.dvE));
            vce.put("ppt", Integer.valueOf(b.dvt));
            vce.put("pptx", Integer.valueOf(b.dvt));
            vce.put("xls", Integer.valueOf(b.dvh));
            vce.put("xlsx", Integer.valueOf(b.dvh));
            vce.put("txt", Integer.valueOf(b.dvw));
            vce.put("rtf", Integer.valueOf(b.dvw));
            vce.put("pdf", Integer.valueOf(b.dvr));
        }
        Integer num = (Integer) vce.get(str);
        if (num == null) {
            return b.dvx;
        }
        return num.intValue();
    }

    public static int bXX() {
        return b.dvx;
    }
}
