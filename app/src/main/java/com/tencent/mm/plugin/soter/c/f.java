package com.tencent.mm.plugin.soter.c;

import com.tencent.d.a.c.b;
import com.tencent.mm.sdk.platformtools.x;

public final class f implements b {
    public final void v(String str, String str2, Object... objArr) {
        x.v(str, str2, objArr);
    }

    public final void d(String str, String str2, Object... objArr) {
        x.d(str, str2, objArr);
    }

    public final void i(String str, String str2, Object... objArr) {
        x.i(str, str2, objArr);
    }

    public final void w(String str, String str2, Object... objArr) {
        x.w(str, str2, objArr);
    }

    public final void e(String str, String str2, Object... objArr) {
        x.e(str, str2, objArr);
    }

    public final void a(String str, Throwable th, String str2) {
        x.printErrStackTrace(str, th, str2, new Object[0]);
    }
}
