package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.protocal.c.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class f$1 implements a<Void, com.tencent.mm.ae.a.a<q>> {
    final /* synthetic */ f ihD;
    final /* synthetic */ b ihn;

    f$1(f fVar, b bVar) {
        this.ihD = fVar;
        this.ihn = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ae.a.a aVar = (com.tencent.mm.ae.a.a) obj;
        x.i("MicroMsg.PaylistAAInteractor", "errType: %s, errCode: %s, retCode: %s, retMsg: %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode), Integer.valueOf(((q) aVar.fJJ).liH), ((q) aVar.fJJ).liI});
        this.ihn.resume();
        return zBS;
    }
}
