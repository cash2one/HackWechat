package com.google.android.exoplayer2.d;

public final class b {
    public static boolean DEBUG = true;
    private static a apm = null;

    public static void a(a aVar) {
        apm = aVar;
    }

    public static void i(String str, String str2, Object... objArr) {
        if (apm != null) {
            apm.i(str, str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (apm != null) {
            apm.w(str, str2, objArr);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (apm != null) {
            apm.e(str, str2, objArr);
        }
    }
}
