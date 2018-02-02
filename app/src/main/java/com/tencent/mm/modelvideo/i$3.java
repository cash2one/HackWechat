package com.tencent.mm.modelvideo;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.Iterator;

class i$3 implements Runnable {
    final /* synthetic */ i hUL;
    final /* synthetic */ f hUM;

    i$3(i iVar, f fVar) {
        this.hUL = iVar;
        this.hUM = fVar;
    }

    public final void run() {
        long j = this.hUM.fqm;
        synchronized (this.hUL.hUB) {
            Iterator it = this.hUL.hUB.iterator();
            while (it.hasNext()) {
                au auVar = (au) it.next();
                if (auVar != null && auVar.field_msgId == j) {
                    x.i("MicroMsg.PreloadVideoService", "%d find msg[%d], remove now", Integer.valueOf(this.hUL.hashCode()), Long.valueOf(j));
                    it.remove();
                }
            }
        }
        this.hUL.bY(true);
        if (this.hUL.hUJ != null) {
            this.hUL.hUJ.hUk = null;
        }
        this.hUL.hUJ = null;
        i.a(this.hUL);
        this.hUL.TN();
    }
}
