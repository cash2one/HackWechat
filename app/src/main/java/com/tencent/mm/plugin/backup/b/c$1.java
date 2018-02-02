package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.a.f.a;
import com.tencent.mm.plugin.backup.b.c.c;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.plugin.backup.g.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import junit.framework.Assert;

class c$1 implements Runnable {
    final /* synthetic */ LinkedList kjs;
    final /* synthetic */ long kjt;
    final /* synthetic */ boolean kju;
    final /* synthetic */ c kjv;

    c$1(c cVar, LinkedList linkedList, long j, boolean z) {
        this.kjv = cVar;
        this.kjs = linkedList;
        this.kjt = j;
        this.kju = z;
    }

    public final void run() {
        if (this.kjs == null) {
            x.e("MicroMsg.BackupPackAndSend", "backupChatRunnable backupSessionList is null.");
            if (this.kjv.kjo != null) {
                this.kjv.kjo.aoi();
                this.kjv.kjp.aol().kiJ = -21;
                this.kjv.kjo.mz(-21);
                return;
            }
            return;
        }
        int i;
        b.apL();
        LinkedList linkedList = this.kjs;
        HashSet hashSet = new HashSet();
        if (linkedList == null) {
            i = 0;
        } else {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                hashSet.add(((a) it.next()).kiN);
            }
            i = hashSet.size();
        }
        this.kjv.kjp.aol().F(14, 1, i);
        this.kjv.kjo.mz(14);
        String str = (String) d.aqe().aqf().CU().get(2, null);
        this.kjv.kjr = bh.Wp();
        c cVar = new c(this.kjv);
        for (int i2 = 0; i2 < this.kjs.size(); i2++) {
            this.kjv.a((a) this.kjs.get(i2), cVar, str, this.kjt, this.kju);
            if (this.kjv.kjn) {
                break;
            }
        }
        if (this.kjv.kjn) {
            x.e("MicroMsg.BackupPackAndSend", "backupChatRunnable cancel!");
            return;
        }
        long Wp = bh.Wp();
        long Wp2 = bh.Wp();
        cVar.kjU.offer(cVar.kjV);
        cVar.kjV.block();
        x.i("MicroMsg.BackupPackAndSend.TagQueueSucker", "waitFinish Finish Now:%d", new Object[]{Long.valueOf(bh.bz(Wp2))});
        Assert.assertTrue(cVar.kjU.isEmpty());
        x.i("MicroMsg.BackupPackAndSend", "backupChatRunnable finish, Session[%d], loopTime[%d], waitSendTime[%d]", new Object[]{Integer.valueOf(this.kjs.size()), Long.valueOf(bh.bz(this.kjv.kjr)), Long.valueOf(bh.bz(Wp))});
        this.kjv.aoz();
        this.kjv.kjp.aol().F(15, i, i);
        this.kjv.kjo.mz(15);
        this.kjv.dC(true);
        b.apK();
        b.apM();
        this.kjv.kjo.aoh();
        x.i("MicroMsg.BackupPackAndSend", "backupChatRunnable backupfinish, backupDataSize[%d], backupCostTime[%d], backupStartTime[%d]", new Object[]{Long.valueOf(this.kjv.kjq), Long.valueOf(bh.bz(this.kjv.kjr)), Long.valueOf(this.kjv.kjr)});
    }
}
