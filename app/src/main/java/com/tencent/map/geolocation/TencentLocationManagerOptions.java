package com.tencent.map.geolocation;

import android.text.TextUtils;

public class TencentLocationManagerOptions {
    private static boolean a = true;
    private static String b = "";

    public static void setLoadLibraryEnabled(boolean z) {
        a = z;
    }

    public static boolean isLoadLibraryEnabled() {
        return a;
    }

    public static boolean setKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        b = str;
        return true;
    }

    public static String getKey() {
        return b;
    }
}
