package com.tencent.mm.ipcinvoker;

import android.os.HandlerThread;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class n {
    private static volatile n gML;
    ExecutorService gMM;
    private int gMN = 3;
    private af mHandler;

    private static n Bx() {
        if (gML == null) {
            synchronized (n.class) {
                if (gML == null) {
                    gML = new n();
                }
            }
        }
        return gML;
    }

    static n By() {
        return new n();
    }

    private n() {
        HandlerThread Wf = e.Wf("IPCThreadPool#WorkerThread-" + hashCode());
        Wf.start();
        this.mHandler = new af(Wf.getLooper());
        this.gMM = Executors.newScheduledThreadPool(this.gMN, new 1(this, Wf));
        x.i("IPC.IPCThreadPool", "initialize IPCInvoker IPCThreadPool(hashCode : %s)", new Object[]{Integer.valueOf(hashCode())});
    }

    public static boolean post(Runnable runnable) {
        Bx().gMM.execute(runnable);
        return true;
    }

    public static boolean h(Runnable runnable) {
        return Bx().mHandler.postDelayed(runnable, 2000);
    }
}
