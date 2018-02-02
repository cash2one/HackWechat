package com.tencent.mm.plugin.wear.a;

public final class b {
    public static final boolean NP(String str) {
        try {
            return str.split("/")[2].equals("wear");
        } catch (Exception e) {
            return false;
        }
    }

    public static final int NQ(String str) {
        try {
            return Integer.valueOf(str.split("/")[4]).intValue();
        } catch (Exception e) {
            return 0;
        }
    }
}
