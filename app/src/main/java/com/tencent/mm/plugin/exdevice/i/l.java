package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.service.l$a;
import com.tencent.mm.plugin.exdevice.service.p;
import com.tencent.mm.z.ar;
import junit.framework.Assert;

public final class l extends l$a {
    private final long hno = 15000;
    private c lRi = null;
    boolean lRj = false;
    boolean lRk = false;
    Runnable lRl = new Runnable(this) {
        final /* synthetic */ l lRm;

        {
            this.lRm = r1;
        }

        public final void run() {
            this.lRm.lRj = true;
            if (!this.lRm.lRk) {
                this.lRm.lRi.a(-1, -1, -2, "TimeOut", null);
            }
        }

        public final String toString() {
            return super.toString() + "|mAsyncTimeOut";
        }
    };

    public l(c cVar) {
        Assert.assertNotNull(cVar);
        this.lRi = cVar;
    }

    public final void a(long j, int i, int i2, String str, p pVar) {
        if (!this.lRk && !this.lRj) {
            ar.Dm().cfF().removeCallbacks(this.lRl);
            ar.Dm().cfF().post(new 2(this, j, i, i2, str, pVar));
        }
    }
}
