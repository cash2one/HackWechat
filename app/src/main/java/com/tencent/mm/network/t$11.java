package com.tencent.mm.network;

import com.tencent.mars.mm.MMLogic;
import com.tencent.mm.sdk.platformtools.bc;

class t$11 extends bc<Object> {
    final /* synthetic */ t hZT;
    final /* synthetic */ String ial;
    final /* synthetic */ String iam;

    t$11(t tVar, String str, String str2) {
        this.hZT = tVar;
        this.ial = str;
        this.iam = str2;
        super(1000, null);
    }

    protected final Object run() {
        MMLogic.setNewDnsDebugHost(this.ial, this.iam);
        return null;
    }
}
