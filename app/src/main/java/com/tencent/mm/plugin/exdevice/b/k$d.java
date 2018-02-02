package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

final class k$d implements Runnable {
    final /* synthetic */ k lKj;
    private long lKm = -1;

    public k$d(k kVar, long j) {
        this.lKj = kVar;
        Assert.assertTrue(j >= 0);
        this.lKm = j;
    }

    public final void run() {
        x.w("MicroMsg.exdevice.MMSendDataToManufacturerLogic", "Time Out Sequnence(%d)", new Object[]{Long.valueOf(this.lKm)});
        k.a(this.lKj).obtainMessage(0, Long.valueOf(this.lKm)).sendToTarget();
    }
}
