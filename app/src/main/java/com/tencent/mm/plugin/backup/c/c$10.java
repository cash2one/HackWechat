package com.tencent.mm.plugin.backup.c;

import com.tencent.mm.plugin.backup.c.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class c$10 implements Runnable {
    final /* synthetic */ c klx;
    final /* synthetic */ LinkedBlockingQueue klz;

    c$10(c cVar, LinkedBlockingQueue linkedBlockingQueue) {
        this.klx = cVar;
        this.klz = linkedBlockingQueue;
    }

    public final void run() {
        while (!c.n(this.klx)) {
            a aVar;
            try {
                aVar = (a) this.klz.poll(500, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                aVar = null;
            }
            x.d("MicroMsg.BackupMoveRecoverServer", "datapushQueue size:%d, startNext receiveData:%s", new Object[]{Integer.valueOf(this.klz.size()), aVar});
            if (aVar != null) {
                this.klx.a(aVar.jtk, aVar.type, aVar.buf, aVar.hOH);
            }
        }
    }
}
