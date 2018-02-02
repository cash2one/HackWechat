package com.tencent.d.a.c;

import junit.framework.Assert;

public final class c {
    private static b Ack = new a((byte) 0);

    public static void a(b bVar) {
        Assert.assertTrue(bVar != null);
        Ack = bVar;
    }

    public static void v(String str, String str2, Object... objArr) {
        Ack.v(str, str2, objArr);
    }

    public static void d(String str, String str2, Object... objArr) {
        Ack.d(str, str2, objArr);
    }

    public static void i(String str, String str2, Object... objArr) {
        Ack.i(str, str2, objArr);
    }

    public static void w(String str, String str2, Object... objArr) {
        Ack.w(str, str2, objArr);
    }

    public static void e(String str, String str2, Object... objArr) {
        Ack.e(str, str2, objArr);
    }

    public static void a(String str, Throwable th, String str2) {
        Ack.a(str, th, str2);
    }
}
