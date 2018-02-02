package com.tencent.mm.plugin.search.a;

public final class b {
    private static String[] mKG = new String[]{"wxid_", "wx_", "gh_"};

    public static boolean IQ(String str) {
        if (str != null && str.length() < 20 && str.matches("^[0-9]+$")) {
            return true;
        }
        return false;
    }

    public static boolean IR(String str) {
        if (str != null && str.length() < 20 && str.matches("^[A-Za-z0-9\\-_]+$")) {
            return true;
        }
        return false;
    }
}
