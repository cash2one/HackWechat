package com.tencent.mm.network;

import com.tencent.mm.network.t.a;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class t$a$1 extends bc<Object> {
    final /* synthetic */ int hnG;
    final /* synthetic */ int hnH;
    final /* synthetic */ r iaq;
    final /* synthetic */ String iar;
    final /* synthetic */ a ias;

    t$a$1(a aVar, r rVar, int i, int i2, String str) {
        this.ias = aVar;
        this.iaq = rVar;
        this.hnG = i;
        this.hnH = i2;
        this.iar = str;
        super(1000, null);
    }

    protected final Object run() {
        try {
            t.a(a.a(this.ias), this.iaq, this.iar);
        } catch (Throwable e) {
            x.e("MicroMsg.AutoAuth", "exception:%s", new Object[]{bh.i(e)});
        }
        return null;
    }
}
