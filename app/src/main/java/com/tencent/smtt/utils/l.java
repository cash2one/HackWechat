package com.tencent.smtt.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

public final class l {
    private static Class AaP;
    private static Method AaQ;

    static {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            AaP = cls;
            AaQ = cls.getDeclaredMethod("get", new Class[]{String.class, String.class});
        } catch (Throwable th) {
        }
    }

    public static String gb(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : gc(str, str2);
    }

    private static String gc(String str, String str2) {
        if (AaP == null || AaQ == null) {
            return str2;
        }
        try {
            return (String) AaQ.invoke(AaP, new Object[]{str, str2});
        } catch (Throwable th) {
            return str2;
        }
    }
}
