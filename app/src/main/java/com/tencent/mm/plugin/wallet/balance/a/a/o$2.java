package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.aua;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class o$2 implements a<Void, com.tencent.mm.ae.a.a<aua>> {
    final /* synthetic */ o syW;

    o$2(o oVar) {
        this.syW = oVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        return a((com.tencent.mm.ae.a.a) obj);
    }

    private Void a(com.tencent.mm.ae.a.a<aua> aVar) {
        x.i("MicroMsg.LqtSaveFetchLogic", "CgiLqtOnClickRedeem end, errType: %s, errCode: %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
        if (aVar.errType == 0 && aVar.errCode == 0) {
            l.bJn().a((aua) aVar.fJJ);
            i.syp.a(((aua) aVar.fJJ).wBS, false);
        }
        if (o.c(this.syW) != null) {
            o.c(this.syW).resume();
        }
        return zBS;
    }
}
