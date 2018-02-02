package com.tencent.mm.modelmulti;

import com.tencent.mars.comm.WakerLock.IAutoUnlockCallback;
import com.tencent.mm.sdk.platformtools.x;

class r$1 implements IAutoUnlockCallback {
    final /* synthetic */ r hHn;

    r$1(r rVar) {
        this.hHn = rVar;
    }

    public final void autoUnlockCallback() {
        x.e("MicroMsg.SyncService", "ERROR: %s auto unlock syncWakerLock", new Object[]{r.a(this.hHn)});
        r.a(this.hHn, r.a(this.hHn));
    }
}
