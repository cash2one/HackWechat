package com.tencent.mm.network;

import com.tencent.mars.BaseEvent;
import com.tencent.mars.mm.MMLogic;
import com.tencent.mm.sdk.platformtools.bc;

class t$10 extends bc<Object> {
    final /* synthetic */ t hZT;
    final /* synthetic */ String iah;
    final /* synthetic */ String iai;
    final /* synthetic */ String iaj;
    final /* synthetic */ String iak;

    t$10(t tVar, Object obj, String str, String str2, String str3, String str4) {
        this.hZT = tVar;
        this.iah = str;
        this.iai = str2;
        this.iaj = str3;
        this.iak = str4;
        super(3000, obj);
    }

    public final Object run() {
        MMLogic.setDebugIP(this.iah, this.iai, this.iaj, this.iak);
        BaseEvent.onNetworkChange();
        return null;
    }
}
