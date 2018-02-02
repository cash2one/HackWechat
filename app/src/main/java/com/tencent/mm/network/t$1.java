package com.tencent.mm.network;

import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class t$1 extends bc<Object> {
    final /* synthetic */ t hZT;
    final /* synthetic */ int hny;

    t$1(t tVar, int i) {
        this.hZT = tVar;
        this.hny = i;
        super(1000, null);
    }

    protected final Object run() {
        try {
            t.iQ(this.hny);
        } catch (Throwable e) {
            x.e("MicroMsg.AutoAuth", "exception:%s", new Object[]{bh.i(e)});
        }
        return null;
    }
}
