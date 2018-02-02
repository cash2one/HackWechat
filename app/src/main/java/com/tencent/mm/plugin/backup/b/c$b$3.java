package com.tencent.mm.plugin.backup.b;

import com.tencent.mm.plugin.backup.b.c.b;
import com.tencent.mm.plugin.backup.f.k;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

class c$b$3 implements Runnable {
    final /* synthetic */ b kjK;

    c$b$3(b bVar) {
        this.kjK = bVar;
    }

    public final String toString() {
        return this.kjK.TAG + ".reqBigFile";
    }

    public final void run() {
        boolean z = true;
        Assert.assertTrue(toString() + ", check running. ", this.kjK.iQP);
        x.i(this.kjK.TAG, "requestBigFileList svrIdCnt:%d timeDiff:%d caller:%s", new Object[]{Integer.valueOf(this.kjK.kjF.size()), Long.valueOf(bh.bz(this.kjK.kjG)), ai.cfH()});
        String str = "BigFileMap should not Empty";
        if (this.kjK.kjF.isEmpty()) {
            z = false;
        }
        Assert.assertTrue(str, z);
        new k(this.kjK.talker, this.kjK.kjF, new 1(this)).apQ();
    }
}
