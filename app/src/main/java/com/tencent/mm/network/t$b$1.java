package com.tencent.mm.network;

import com.tencent.mm.network.t.b;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class t$b$1 extends bc<Object> {
    final /* synthetic */ int hnG;
    final /* synthetic */ int hnH;
    final /* synthetic */ r iat;
    final /* synthetic */ b iau;

    t$b$1(b bVar, r rVar, int i, int i2) {
        this.iau = bVar;
        this.iat = rVar;
        this.hnG = i;
        this.hnH = i2;
        super(1000, null);
    }

    protected final Object run() {
        try {
            t.a(b.a(this.iau), this.iat);
        } catch (Throwable e) {
            x.e("MicroMsg.AutoAuth", "exception:%s", new Object[]{bh.i(e)});
        }
        return null;
    }
}
