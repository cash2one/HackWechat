package com.tencent.mm.modelfriend;

import com.tencent.mm.modelfriend.AddrBookObserver.AddrBookService;
import com.tencent.mm.modelfriend.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class AddrBookObserver$AddrBookService$1 implements b {
    final /* synthetic */ AddrBookService huX;

    AddrBookObserver$AddrBookService$1(AddrBookService addrBookService) {
        this.huX = addrBookService;
    }

    public final void bM(boolean z) {
        if (z) {
            System.currentTimeMillis();
            ar.CG().a(new aa(m.NU(), m.NT()), 0);
            this.huX.stopSelf();
            AddrBookService.huT = false;
            return;
        }
        x.v("MicroMsg.AddrBookObserver", "onSyncEnd not sync succ, do not upload");
        this.huX.stopSelf();
        AddrBookService.huT = false;
    }
}
