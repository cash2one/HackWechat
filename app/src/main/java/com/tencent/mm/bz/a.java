package com.tencent.mm.bz;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;

public class a {
    private static volatile a xCU;
    private af gMJ;
    private af mHandler;
    private HandlerThread mHandlerThread = e.Wf("WorkerThread#" + hashCode());

    private static a clk() {
        if (xCU == null) {
            synchronized (a.class) {
                if (xCU == null) {
                    xCU = new a();
                }
            }
        }
        return xCU;
    }

    private a() {
        this.mHandlerThread.start();
        this.mHandler = new af(this.mHandlerThread.getLooper());
        this.gMJ = new af(Looper.getMainLooper());
    }

    public static HandlerThread cll() {
        return clk().mHandlerThread;
    }

    public static boolean post(Runnable runnable) {
        return clk().mHandler.post(runnable);
    }

    public static boolean h(Runnable runnable) {
        return clk().mHandler.postDelayed(runnable, 1000);
    }

    public static boolean Z(Runnable runnable) {
        return clk().gMJ.post(runnable);
    }

    public static boolean i(Runnable runnable, long j) {
        return clk().gMJ.postDelayed(runnable, j);
    }
}
