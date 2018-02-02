package com.tencent.mm.plugin.walletlock.gesture.ui;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.u.a;
import com.tencent.mm.plugin.walletlock.b.g;
import com.tencent.mm.plugin.walletlock.b.i;
import com.tencent.mm.plugin.walletlock.gesture.a.d;
import com.tencent.mm.protocal.c.bbw;
import com.tencent.mm.sdk.platformtools.x;

class GestureGuardLogicUI$14 implements a {
    final /* synthetic */ a hnT;
    final /* synthetic */ GestureGuardLogicUI tgm;

    GestureGuardLogicUI$14(GestureGuardLogicUI gestureGuardLogicUI, a aVar) {
        this.tgm = gestureGuardLogicUI;
        this.hnT = aVar;
    }

    public final int a(int i, int i2, String str, b bVar, k kVar) {
        x.i("MicroMsg.GestureGuardLogicUI", String.format("Scene doSwitchOn, errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str}));
        GestureGuardLogicUI.o(this.tgm);
        if (i == 0 && i2 == 0) {
            d.a(((bbw) bVar.hmh.hmo).wCm);
            g gVar = g.tho;
            g.jW(false);
            GestureGuardLogicUI.bOb();
        }
        i.ths.bOp();
        if (this.hnT != null) {
            return this.hnT.a(i, i2, str, bVar, kVar);
        }
        return 0;
    }
}
