package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.Thread.UncaughtExceptionHandler;

public final class b {
    private static af iRH;
    private static af iRI;
    private static af iRJ = new af(Looper.getMainLooper());

    static {
        HandlerThread Wf = e.Wf("DynamicPage#WorkerThread");
        Wf.start();
        Wf.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            public final void uncaughtException(Thread thread, Throwable th) {
                x.e("MicroMsg.DynamicPageLogic", "uncaughtException(%s, %s)", new Object[]{thread.getName(), Log.getStackTraceString(th)});
            }
        });
        iRH = new af(Wf.getLooper());
        Wf = e.Wf("DynamicPage#IPCThread");
        Wf.start();
        Wf.setUncaughtExceptionHandler(new 2());
        iRI = new af(Wf.getLooper());
    }

    public static af acC() {
        return iRH;
    }

    public static boolean m(Runnable runnable) {
        if (runnable == null) {
            return false;
        }
        return iRH.post(runnable);
    }

    public static boolean d(Runnable runnable, long j) {
        if (runnable == null) {
            return false;
        }
        return iRH.postDelayed(runnable, j);
    }

    public static boolean n(Runnable runnable) {
        return iRJ.post(runnable);
    }
}
