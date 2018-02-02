package com.tencent.mm.plugin.qqmail.b;

import java.util.Map;

public class h$c {
    String content;
    Map<String, String> poy;
    int status = 0;

    public h$c(int i, Map<String, String> map, String str) {
        this.status = i;
        this.poy = map;
        this.content = str;
    }

    public final String toString() {
        return "Response status:" + this.status + ", cookie:" + (this.poy != null ? this.poy : "") + ", content length :" + (this.content != null ? this.content.length() : 0);
    }
}
