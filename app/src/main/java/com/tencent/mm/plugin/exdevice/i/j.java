package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.h;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends ae {
    private a lRf;
    private h lRg;

    public j(int i, int i2, long j) {
        this.lRg = new h(i, i2, j);
    }

    public final boolean a(m mVar, d dVar) {
        if (u.aEL().cD(this.lRg.kAq)) {
            this.lRf = new b(this.lRg, dVar);
            return this.lRf.b(mVar);
        }
        x.w("MicroMsg.exdevice.MMSwitchViewPushTaskExcuter", "push switchview event to device before it do auth, device id = %d", new Object[]{Long.valueOf(this.lRg.kAq)});
        return true;
    }
}
