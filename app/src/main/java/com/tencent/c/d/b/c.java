package com.tencent.c.d.b;

import android.os.Build.VERSION;
import java.lang.reflect.Method;

public final class c {
    private static Object zTv;
    private static Method zTw;
    private static boolean zTx;

    static {
        zTv = null;
        zTw = null;
        if (VERSION.SDK_INT >= 14) {
            try {
                zTv = e.fV("libcore.io.Libcore", "os");
                zTw = e.a("libcore.io.Os", "stat", String.class);
                zTx = true;
                return;
            } catch (Throwable th) {
            }
        }
        zTx = false;
    }

    public static boolean isAvailable() {
        return zTx;
    }

    public static int aaT(String str) {
        if (!zTx) {
            return 0;
        }
        Object invoke = zTw.invoke(zTv, new Object[]{str});
        if (invoke != null) {
            return ((Integer) e.a(invoke.getClass(), "st_mode", invoke)).intValue();
        }
        return 0;
    }
}
