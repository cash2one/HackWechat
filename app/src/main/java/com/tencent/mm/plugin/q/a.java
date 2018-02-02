package com.tencent.mm.plugin.q;

import java.util.List;

public final class a {
    private static List<a> nYG;
    private static String nYH;

    public static synchronized void i(String str, List<a> list) {
        synchronized (a.class) {
            nYH = str;
            nYG = list;
        }
    }

    public static synchronized List<a> DS(String str) {
        List<a> list;
        synchronized (a.class) {
            if (str != null) {
                if (str.equals(nYH)) {
                    list = nYG;
                }
            }
            list = null;
        }
        return list;
    }
}
