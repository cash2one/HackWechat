package com.tencent.mm.app;

import android.os.HandlerThread;
import android.os.Process;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.h.d;

public final class h {
    static h fff;
    HandlerThread ffg;
    d ffh;
    af handler = new af(this.ffg.getLooper());

    public h(String str) {
        this.ffg = e.cZ(str, 10);
        this.ffg.start();
        this.ffh = new com.tencent.mm.vending.h.h(com.tencent.mm.cd.d.c(this.handler), str);
    }

    public final void tS() {
        if (this.ffg == null || !this.ffg.isAlive()) {
            x.e("MicroMsg.InitThreadController", "setHighPriority failed thread is dead");
            return;
        }
        int threadId = this.ffg.getThreadId();
        try {
            if (-8 == Process.getThreadPriority(threadId)) {
                x.w("MicroMsg.InitThreadController", "setHighPriority No Need.");
                return;
            }
            Process.setThreadPriority(threadId, -8);
            x.i("MicroMsg.InitThreadController", "InitThreadController:%d setHighPriority to %d", new Object[]{Integer.valueOf(threadId), Integer.valueOf(Process.getThreadPriority(threadId))});
        } catch (Throwable e) {
            x.w("MicroMsg.InitThreadController", "thread:%d setHighPriority failed", new Object[]{Integer.valueOf(threadId)});
            x.printErrStackTrace("MicroMsg.InitThreadController", e, "", new Object[0]);
        }
    }
}
