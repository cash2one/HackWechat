package com.tencent.mm.plugin.exdevice.i;

import com.tencent.mm.plugin.exdevice.b.c;
import com.tencent.mm.plugin.exdevice.b.i;
import com.tencent.mm.plugin.exdevice.model.ae;
import com.tencent.mm.plugin.exdevice.service.m;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends ae {
    private c lRb;
    private a lRc;

    public g(byte[] bArr, int i, long j) {
        this.lRb = new i(bArr, i, j);
    }

    public final boolean a(m mVar, d dVar) {
        if (u.aEL().cD(this.lRb.kAq)) {
            this.lRc = new a(this.lRb, dVar);
            return this.lRc.b(mVar);
        }
        x.w("MicroMsg.exdevice.MMPushManufacturerSvrSendDataLogic", "Service push data to device before it do auth, device id = %d", new Object[]{Long.valueOf(this.lRb.kAq)});
        return true;
    }
}
