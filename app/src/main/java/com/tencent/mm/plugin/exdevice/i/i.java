package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.g;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends ae {
    private a lRc;
    private g lRe;

    public i(int i) {
        this.lRe = new g(i);
    }

    public final boolean a(m mVar, d dVar) {
        if (u.aEL().cD(this.lRe.kAq)) {
            this.lRc = new a(this.lRe, dVar);
            return this.lRc.b(mVar);
        }
        x.w("MicroMsg.exdevice.MMSwitchBackGroudTaskExcuter", "push switch backgroud event to device before it do auth, device id = %d", new Object[]{Long.valueOf(this.lRe.kAq)});
        return true;
    }
}
