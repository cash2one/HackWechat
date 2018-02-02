package com.tencent.mm.plugin.appbrand.widget.input.b;

public enum b {
    DONE(6),
    SEARCH(3),
    NEXT(5),
    GO(2),
    SEND(4);
    
    public final int kbw;

    private b(int i) {
        this.kbw = i;
    }

    public static b anA() {
        return DONE;
    }

    public static b uZ(String str) {
        return (b) d.h(str, b.class);
    }
}
