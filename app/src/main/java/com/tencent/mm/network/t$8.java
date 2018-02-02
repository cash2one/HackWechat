package com.tencent.mm.network;

import com.tencent.mars.BaseEvent;
import com.tencent.mm.aj.a;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.bc;

class t$8 extends bc<Object> {
    final /* synthetic */ t hZT;
    final /* synthetic */ boolean iac;

    t$8(t tVar, Object obj, boolean z) {
        this.hZT = tVar;
        this.iac = z;
        super(3000, obj);
    }

    public final Object run() {
        BaseEvent.onForeground(this.iac);
        a.bK(this.iac);
        b.bD(this.iac);
        return null;
    }
}
