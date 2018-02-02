package com.tencent.mm.plugin.ext.c;

public class e$a {
    public int mbu;
    private boolean mbv;
    public int type;
    public String url;

    public e$a(int i, String str, int i2) {
        this.mbv = false;
        this.type = i;
        this.url = str;
        this.mbv = false;
        this.mbu = i2;
    }

    public e$a() {
        this.mbv = false;
        this.mbv = true;
    }

    public final String toString() {
        return "QrCodeModel{type=" + this.type + ", url='" + this.url + '\'' + ", flagTimeout=" + this.mbv + '}';
    }
}
