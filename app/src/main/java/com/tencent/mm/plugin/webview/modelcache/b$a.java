package com.tencent.mm.plugin.webview.modelcache;

public enum b$a {
    HTTP(1),
    HTTPS(2);
    
    final int fDt;

    private b$a(int i) {
        this.fDt = i;
    }

    public static boolean Aj(int i) {
        return (HTTP.fDt & i) > 0;
    }

    public static boolean Ak(int i) {
        return (HTTPS.fDt & i) > 0;
    }

    public static int Al(int i) {
        return HTTP.fDt | 0;
    }

    public static int Am(int i) {
        return HTTPS.fDt | i;
    }

    public static String toString(int i) {
        String str = "[ %s | %s ]";
        Object[] objArr = new Object[2];
        objArr[0] = Aj(i) ? "http" : "-";
        objArr[1] = Ak(i) ? "https" : "-";
        return String.format(str, objArr);
    }
}
