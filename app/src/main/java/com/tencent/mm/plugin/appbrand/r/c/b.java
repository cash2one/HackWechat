package com.tencent.mm.plugin.appbrand.r.c;

public class b extends Exception {
    public int jTT;

    public b() {
        this.jTT = 1002;
    }

    public b(String str) {
        super(str);
        this.jTT = 1002;
    }

    public b(int i, Throwable th) {
        super(th);
        this.jTT = i;
    }
}
