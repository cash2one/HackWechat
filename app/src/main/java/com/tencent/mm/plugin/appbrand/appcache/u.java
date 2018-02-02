package com.tencent.mm.plugin.appbrand.appcache;

public final class u {
    private static int iEL;

    static synchronized void jy(int i) {
        synchronized (u.class) {
            iEL = i;
        }
    }

    public static synchronized int ZM() {
        int i;
        synchronized (u.class) {
            i = iEL;
        }
        return i;
    }
}
