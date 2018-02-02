package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.b.c.b.3.1;
import com.tencent.mm.plugin.backup.e.h.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class c$b$3$1$1 implements Runnable {
    final /* synthetic */ LinkedList kjP;
    final /* synthetic */ 1 kjQ;

    c$b$3$1$1(1 1, LinkedList linkedList) {
        this.kjQ = 1;
        this.kjP = linkedList;
    }

    public final void run() {
        int i = 0;
        while (this.kjP != null && i < this.kjP.size()) {
            Long l = (Long) this.kjP.get(i);
            a aVar = (a) this.kjQ.kjO.kjK.kjF.get(l);
            String str = this.kjQ.kjO.kjK.TAG;
            String str2 = "backupBigDataFiles svrIdIndex:%d(%d), svrId:%d media:%s item:%s";
            Object[] objArr = new Object[5];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(this.kjP.size());
            objArr[2] = l;
            objArr[3] = aVar == null ? "null" : aVar.knb.mediaId;
            objArr[4] = aVar == null ? "null" : aVar.knb.path;
            x.i(str, str2, objArr);
            if (aVar != null) {
                this.kjQ.kjO.kjK.kjD.add(aVar.knb.mediaId);
                this.kjQ.kjO.kjK.f(aVar.knb.mediaId, aVar.knb.path, true);
            }
            i++;
        }
        this.kjQ.kjO.kjK.kjz.offer(this.kjQ.kjO.kjK.kjJ);
    }
}
