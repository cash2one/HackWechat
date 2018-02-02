package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.backup.bakoldlogic.c.c;
import com.tencent.mm.sdk.platformtools.x;

class d$2 implements e {
    final /* synthetic */ d kqR;

    d$2(d dVar) {
        this.kqR = dVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.BakPCServer", "onSceneEnd %s, %d, %d", new Object[]{((c) kVar).koS.ktR, Integer.valueOf(i), Integer.valueOf(i2)});
        synchronized (this.kqR.lock) {
            this.kqR.kqJ.remove(r14.koS.ktR);
            x.i("MicroMsg.BakPCServer", "onSceneEnd left: size:%d", new Object[]{Integer.valueOf(this.kqR.kqJ.size())});
            if (this.kqR.kqJ.size() <= 10) {
                this.kqR.lock.notifyAll();
            }
        }
        d dVar = this.kqR;
        dVar.kqQ++;
        if (this.kqR.kqQ % 100 == 0) {
            dVar = this.kqR;
            System.gc();
            long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
            long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
            x.i("MicroMsg.BakPCServer", "memoryInfo avail/total, dalvik[%dk, %dk, user:%dk], recoverCnt:%d", new Object[]{Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory), Integer.valueOf(dVar.kqQ)});
        }
        this.kqR.aqs();
    }
}
