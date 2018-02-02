package com.tencent.mm.plugin.sns.data;

public final class h {
    public String desc = "";
    public int fileSize = 0;
    public String fvC = "";
    public int height = -1;
    public String path = "";
    public int qQV = 0;
    public int qQW;
    public int qQX;
    public int qQY;
    public String qQZ = "";
    public String qRa = "";
    public String qRb = "";
    public boolean qRc = false;
    public int type;
    public int width = -1;

    public h(String str, int i) {
        this.path = str;
        this.type = i;
        this.qQY = -1;
    }

    public h(int i, int i2) {
        this.qQY = i;
        this.type = i2;
        this.path = "";
    }
}
