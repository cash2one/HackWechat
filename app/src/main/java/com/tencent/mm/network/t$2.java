package com.tencent.mm.network;

import com.tencent.mars.magicbox.IPxxLogic;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.x;

class t$2 extends bc<Object> {
    final /* synthetic */ t hZT;
    final /* synthetic */ String hZU;

    t$2(t tVar, String str) {
        this.hZT = tVar;
        this.hZU = str;
        super(1000, null);
    }

    protected final Object run() {
        x.cfk();
        IPxxLogic.onIPxx(this.hZU, 0);
        return null;
    }
}
