package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.plugin.exdevice.service.c;
import com.tencent.mm.plugin.exdevice.service.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;

class d$5 implements Runnable {
    final /* synthetic */ d lKJ;
    final /* synthetic */ String lKN;
    final /* synthetic */ boolean lKO;

    d$5(d dVar, String str, boolean z) {
        this.lKJ = dVar;
        this.lKN = str;
        this.lKO = z;
    }

    public final void run() {
        if (d.a(this.lKJ) == null) {
            d.a(this.lKJ, new c());
            d.a(this.lKJ).lQd = new 1(this);
            d.a(this.lKJ).cx(ac.getContext());
            synchronized (d.b(this.lKJ)) {
                try {
                    d.b(this.lKJ).wait();
                } catch (Throwable e) {
                    x.e("MicroMsg.exdevice.ExdeviceConnectManager", "mSyncLock.wait failed!!!, %s", new Object[]{e.getMessage()});
                    x.printErrStackTrace("MicroMsg.exdevice.ExdeviceConnectManager", e, "", new Object[0]);
                }
            }
            return;
        }
        e.aEC().ai(this.lKN, this.lKO);
    }

    public final String toString() {
        return super.toString() + "|ranging";
    }
}
