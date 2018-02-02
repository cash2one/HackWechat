package com.tencent.mm.svg.b;

public final class c {
    private static a xCT = null;

    public interface a {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);
    }

    public static void b(a aVar) {
        xCT = aVar;
    }

    public static void e(String str, String str2, Object... objArr) {
        if (xCT != null) {
            xCT.e(str, str2, objArr);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (xCT != null) {
            xCT.i(str, str2, objArr);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (xCT != null) {
            xCT.d(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (xCT != null) {
            xCT.printErrStackTrace(str, th, str2, objArr);
        }
    }
}
