package com.tencent.mm.z;

import com.tencent.mm.g.a.re;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class br {
    private a hhN = null;
    private long hhO = 0;
    private long hhP = 0;
    private String hhQ = "";
    private int hhR = 1;

    public interface a {
        boolean Id();
    }

    public br(a aVar) {
        Assert.assertTrue(true);
        this.hhN = aVar;
        HW();
    }

    private void HW() {
        this.hhR = 1;
        this.hhO = 0;
        this.hhP = 0;
        this.hhQ = "";
    }

    public final synchronized boolean HX() {
        boolean z = true;
        synchronized (this) {
            long Wp = bh.Wp();
            this.hhQ = bh.cgy().toString();
            if (this.hhR == 1) {
                this.hhP = Wp;
                this.hhO = 1800000;
                x.i("MicroMsg.SyncPauser", "requestToPause currState:STATE_RUNNING timeout:%d %s", new Object[]{Long.valueOf(1800000), this.hhQ});
                this.hhR = 2;
                if (this.hhN.Id()) {
                    HZ();
                }
            } else {
                long j = this.hhP + this.hhO;
                Wp += 1800000;
                if (Wp > j) {
                    this.hhO += Wp - j;
                }
                x.i("MicroMsg.SyncPauser", "requestToPause currState:%s ParamTimeout:%d diff:%s newTimeout:%s %s", new Object[]{Integer.valueOf(this.hhR), Long.valueOf(1800000), Long.valueOf(Wp - j), Long.valueOf(this.hhO), this.hhQ});
                z = false;
            }
        }
        return z;
    }

    public final synchronized void HY() {
        x.d("MicroMsg.SyncPauser", "restartSync currState:%d %s", new Object[]{Integer.valueOf(this.hhR), bh.cgy()});
        if (this.hhR == 1) {
            x.d("MicroMsg.SyncPauser", "warning: restartSync but currState has been STATE_RUNNING %s", new Object[]{bh.cgy()});
        } else {
            HW();
            b reVar = new re();
            reVar.fIU.status = 1;
            com.tencent.mm.sdk.b.a.xef.m(reVar);
        }
    }

    public final synchronized void HZ() {
        if (this.hhR != 2) {
            x.e("MicroMsg.SyncPauser", "ERR: setFullPause but currState is %d  %s", new Object[]{Integer.valueOf(this.hhR), bh.cgy()});
        } else {
            x.d("MicroMsg.SyncPauser", "setFullPause waitTime:%d %s", new Object[]{Long.valueOf(bh.bz(this.hhP)), bh.cgy()});
            this.hhR = 3;
            b reVar = new re();
            reVar.fIU.status = 3;
            com.tencent.mm.sdk.b.a.xef.m(reVar);
        }
    }

    private synchronized void Ia() {
        if (this.hhR != 1 && this.hhO + this.hhP < bh.Wp()) {
            HY();
        }
    }

    public final synchronized boolean Ib() {
        Ia();
        return this.hhR == 2;
    }

    public final synchronized boolean Ic() {
        Ia();
        return this.hhR == 3;
    }
}
