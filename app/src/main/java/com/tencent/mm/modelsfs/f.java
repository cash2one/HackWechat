package com.tencent.mm.modelsfs;

import com.tencent.mm.sdk.platformtools.bh;

public final class f {
    public static boolean ml(String str) {
        if (str.lastIndexOf(";?enc=") > 0) {
            return true;
        }
        return false;
    }

    public static String p(String str, long j) {
        if (j == 0) {
            return String.format(str + ";?enc=%d", new Object[]{Long.valueOf(314159265)});
        }
        return String.format(str + ";?enc=%d", new Object[]{Long.valueOf(j)});
    }

    public static String mm(String str) {
        int lastIndexOf = str.lastIndexOf(";?enc=");
        if (lastIndexOf > 0) {
            return str.substring(0, lastIndexOf);
        }
        return str;
    }

    public static long mn(String str) {
        int lastIndexOf = str.lastIndexOf(";?enc=");
        if (lastIndexOf > 0) {
            return bh.VJ(str.substring(lastIndexOf + 6));
        }
        return 0;
    }

    public static String mo(String str) {
        int lastIndexOf = str.lastIndexOf(";?enc=");
        if (lastIndexOf > 0) {
            return str.substring(lastIndexOf + 6).trim();
        }
        return "";
    }
}
