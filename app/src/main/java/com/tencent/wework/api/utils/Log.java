package com.tencent.wework.api.utils;

public class Log {
    private static ILogger ApE = new WWAPILogger(new LogcatLogger((byte) 0));
    private static int zQh = 8;

    public static void d(String str, String str2) {
        if (zQh <= 3) {
            ApE.a(3, str, str2, null);
        }
    }

    public static void i(String str, String str2) {
        if (zQh <= 4) {
            ApE.a(4, str, str2, null);
        }
    }

    public static void w(String str, String str2) {
        if (zQh <= 5) {
            ApE.a(5, str, str2, null);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (zQh <= 5) {
            ApE.a(5, str, str2, th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (zQh <= 6) {
            ApE.a(6, str, str2, th);
        }
    }
}
