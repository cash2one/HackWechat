package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.b.c.b.2;
import com.tencent.mm.plugin.backup.f.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

class c$b$2$1 implements Runnable {
    final /* synthetic */ c kjL;
    final /* synthetic */ long kjM;
    final /* synthetic */ 2 kjN;

    c$b$2$1(2 2, c cVar, long j) {
        this.kjN = 2;
        this.kjL = cVar;
        this.kjM = j;
    }

    public final String toString() {
        return this.kjN.kjK.TAG + ".sendFile";
    }

    public final void run() {
        Assert.assertTrue(toString() + ", check running. ", this.kjN.kjK.iQP);
        long Wp = bh.Wp();
        this.kjL.apQ();
        long Wp2 = bh.Wp();
        x.i(this.kjN.kjK.TAG, "SendFileScene size:%d waitTime:%d netTime:%d [%s]", Integer.valueOf(this.kjL.apX()), Long.valueOf(Wp2 - this.kjM), Long.valueOf(Wp2 - Wp), this.kjL.koS.ktR);
    }
}
