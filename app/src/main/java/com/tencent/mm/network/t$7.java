package com.tencent.mm.network;

import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class t$7 extends bc<Integer> {
    final /* synthetic */ t hZT;
    final /* synthetic */ r iaa;
    final /* synthetic */ l iab;

    t$7(t tVar, Integer num, r rVar, l lVar) {
        this.hZT = tVar;
        this.iaa = rVar;
        this.iab = lVar;
        super(3000, num);
    }

    public final /* synthetic */ Object run() {
        return Vy();
    }

    private Integer Vy() {
        try {
            return Integer.valueOf(t.a(this.hZT, this.iaa, this.iab));
        } catch (Throwable e) {
            x.e("MicroMsg.AutoAuth", "exception:%s", bh.i(e));
            t.a(this.hZT);
            return Integer.valueOf(-1);
        }
    }
}
