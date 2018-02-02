package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.c.ayx;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;

class o$3 implements a<Void, ayx> {
    final /* synthetic */ o syW;
    final /* synthetic */ Bankcard syX;

    o$3(o oVar, Bankcard bankcard) {
        this.syW = oVar;
        this.syX = bankcard;
    }

    public final /* synthetic */ Object call(Object obj) {
        x.i("MicroMsg.LqtSaveFetchLogic", "doSaveLqt, prepayid: %s", new Object[]{((ayx) obj).wFW});
        o.a(this.syW, r6.wFW, this.syX);
        return null;
    }
}
