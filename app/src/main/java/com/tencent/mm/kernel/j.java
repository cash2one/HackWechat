package com.tencent.mm.kernel;

public final class j {
    private static volatile a gRf = null;

    public interface a {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    public static void a(a aVar) {
        gRf = aVar;
    }

    public static void e(String str, String str2, Object... objArr) {
        if (gRf != null) {
            gRf.e(str, str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (gRf != null) {
            gRf.w(str, str2, objArr);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (gRf != null) {
            gRf.i(str, str2, objArr);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (gRf != null) {
            gRf.d(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (gRf != null) {
            gRf.printErrStackTrace(str, th, str2, objArr);
        }
    }
}
