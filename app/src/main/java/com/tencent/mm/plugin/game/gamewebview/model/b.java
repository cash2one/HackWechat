package com.tencent.mm.plugin.game.gamewebview.model;

import java.util.HashMap;

public final class b {
    private static HashMap<String, String> mXK = new HashMap();

    public static void cG(String str, String str2) {
        mXK.put(str, str2);
    }

    public static String BG(String str) {
        return (String) mXK.get(str);
    }

    public static void BH(String str) {
        mXK.remove(str);
    }
}
