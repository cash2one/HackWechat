package com.tencent.mm.network;

import com.tencent.mars.BaseEvent;
import com.tencent.mm.sdk.platformtools.bc;

class t$13 extends bc<Object> {
    final /* synthetic */ t hZT;

    t$13(t tVar, Object obj) {
        this.hZT = tVar;
        super(3000, obj);
    }

    public final Object run() {
        BaseEvent.onNetworkChange();
        return null;
    }
}
