package com.tencent.mm.sdk.platformtools;

import java.util.HashMap;

public final class bd {
    private static final HashMap<String, String> xik = new HashMap();

    public static String getProperty(String str) {
        return (String) xik.get(str);
    }

    public static void setProperty(String str, String str2) {
        xik.put(str, str2);
    }
}
