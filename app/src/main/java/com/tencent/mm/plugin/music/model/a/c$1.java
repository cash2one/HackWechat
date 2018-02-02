package com.tencent.mm.plugin.music.model.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.qqmusic.mediaplayer.ILog;

class c$1 implements ILog {
    c$1() {
    }

    public final void d(String str, String str2) {
        x.d(str, str2);
    }

    public final void w(String str, String str2) {
        x.w(str, str2);
    }

    public final void e(String str, String str2) {
        x.e(str, str2);
    }

    public final void i(String str, String str2) {
        x.i(str, str2);
    }

    public final void i(String str, String str2, Throwable th) {
        x.printErrStackTrace(str, th, str2, new Object[0]);
    }

    public final void e(String str, Throwable th) {
        x.printErrStackTrace(str, th, " throwable", new Object[0]);
    }

    public final void e(String str, String str2, Throwable th) {
        x.printErrStackTrace(str, th, str2, new Object[0]);
    }

    public final void e(String str, String str2, Object... objArr) {
        x.e(str, String.format(str2, objArr));
    }
}
