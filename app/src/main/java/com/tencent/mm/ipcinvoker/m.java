package com.tencent.mm.ipcinvoker;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;

class m {
    private static volatile m gMI;
    private af gMJ;
    private n gMK;
    private af mHandler;
    private HandlerThread mHandlerThread = e.Wf("IPCThreadCaller#Worker-" + hashCode());

    private static m Bw() {
        if (gMI == null) {
            synchronized (m.class) {
                if (gMI == null) {
                    gMI = new m();
                }
            }
        }
        return gMI;
    }

    private m() {
        this.mHandlerThread.start();
        this.mHandler = new af(this.mHandlerThread.getLooper());
        this.gMJ = new af(Looper.getMainLooper());
        this.gMK = n.By();
    }

    public static boolean g(Runnable runnable) {
        Bw().gMK.gMM.execute(runnable);
        return true;
    }
}
