package com.tencent.mm.booter;

import com.tencent.mm.network.aa;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class CoreService$4 implements a {
    final /* synthetic */ CoreService gxZ;

    CoreService$4(CoreService coreService) {
        this.gxZ = coreService;
    }

    public final boolean uF() {
        boolean z;
        f a = CoreService.a(this.gxZ);
        if (bh.bA(a.ibZ) < a.ibX) {
            x.i("MicroMsg.FrequncyLimiter", "frequency limited, last=" + a.ibZ + ", cur=" + bh.Wq() + ", retries=" + a.ica);
            if (a.ica <= 0) {
                z = false;
            } else {
                a.ica--;
                a.ibZ = bh.Wq();
                z = true;
            }
        } else {
            a.ica = a.ibY;
            a.ibZ = bh.Wq();
            z = true;
        }
        if (z) {
            x.i("MicroMsg.CoreService", "setNetworkAvailable  deal with Sync Check isSessionKeyNull:%b, isMMProcessExist:%b", new Object[]{Boolean.valueOf(bh.bw(CoreService.b(this.gxZ).hZK.CF())), Boolean.valueOf(aa.VQ().Vx())});
            if (bh.bw(CoreService.b(this.gxZ).hZK.CF()) || r3 || !f.a(1, 0, null, CoreService.b(this.gxZ).hZK.CF(), bh.Wp())) {
                CoreService.wC();
            } else {
                x.i("MicroMsg.CoreService", "setNetworkAvailable deal with notify sync in push");
                return true;
            }
        }
        x.e("MicroMsg.CoreService", "setNetworkAvailable checker frequency limited");
        x.i("MicroMsg.CoreService", "setNetworkAvailable finish lockCount:%d delayCount:%d delayDur:%d", new Object[]{Long.valueOf(CoreService.c(this.gxZ)), Long.valueOf(CoreService.d(this.gxZ)), Long.valueOf(bh.Wp() - CoreService.e(this.gxZ))});
        CoreService.f(this.gxZ);
        CoreService.g(this.gxZ);
        CoreService.h(this.gxZ);
        new ak(new 1(this), false).J(500, 500);
        return true;
    }
}
