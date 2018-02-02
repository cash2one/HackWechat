package com.tencent.mm.sdk.c;

import java.util.Map;

public class b$c {
    public String content;
    public Map<String, String> poy;
    public int status;
    public b$a xeu;

    public b$c(int i, Map<String, String> map, String str) {
        this.status = 0;
        this.status = 0;
        this.poy = null;
        this.content = str;
    }

    public String toString() {
        return "Response status:" + this.status + ", cookie:" + (this.poy != null ? this.poy : "") + ", content length :" + (this.content != null ? this.content.length() : 0);
    }

    public void onComplete() {
    }
}
