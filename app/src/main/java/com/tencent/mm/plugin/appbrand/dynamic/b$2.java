package com.tencent.mm.plugin.appbrand.dynamic;

import android.util.Log;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.Thread.UncaughtExceptionHandler;

class b$2 implements UncaughtExceptionHandler {
    b$2() {
    }

    public final void uncaughtException(Thread thread, Throwable th) {
        x.e("MicroMsg.DynamicPageLogic", "uncaughtException(%s, %s)", new Object[]{thread.getName(), Log.getStackTraceString(th)});
    }
}
