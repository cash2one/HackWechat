package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.plugin.wallet.balance.a.a.j.1;
import com.tencent.mm.protocal.c.azo;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.vending.h.e;

public class k$b implements e<azo, Void> {
    final /* synthetic */ k syC;

    public k$b(k kVar) {
        this.syC = kVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        j jVar = this.syC.syx;
        b czQ = g.czQ();
        czQ.czP();
        if (!an.isNetworkConnected(ac.getContext())) {
            czQ.cl(Boolean.valueOf(false));
        }
        new g().JV().f(new 1(jVar, czQ));
        return null;
    }

    public final String wx() {
        return "Vending.LOGIC";
    }
}
