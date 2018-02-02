package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

public class j$b implements Runnable {
    final /* synthetic */ j oGW;

    public j$b(j jVar) {
        this.oGW = jVar;
    }

    public final void run() {
        this.oGW.oGV.maM = true;
        if (this.oGW.oGV.mTJ != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (this.oGW.oGq != null) {
                this.oGW.oGq.a(q.FS(), this.oGW.oGV.mTJ, this.oGW.oGV.oGY, this.oGW.oGV.angle);
            }
            if (System.currentTimeMillis() - currentTimeMillis > 30) {
                x.d("MicroMsg.MT.MultiTalkVideoNativeReceiver", "steve: draw native picture use time total: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            }
            this.oGW.oGV.maM = false;
        }
        try {
            Thread.sleep(20);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MT.MultiTalkVideoNativeReceiver", e, "", new Object[0]);
        }
    }
}
