package com.tencent.mm.plugin.mall.ui;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.plugin.wallet_core.model.w.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p.c;

class MallIndexUI$13 implements c {
    final /* synthetic */ MallIndexUI omF;
    final /* synthetic */ w omG;

    MallIndexUI$13(MallIndexUI mallIndexUI, w wVar) {
        this.omF = mallIndexUI;
        this.omG = wVar;
    }

    public final void a(n nVar) {
        nVar.add(0, 0, 0, this.omF.getString(i.uLd));
        nVar.add(0, 1, 1, this.omF.getString(i.uRX));
        nVar.add(0, 2, 2, this.omF.getString(i.uRY));
        nVar.add(0, 3, 3, this.omF.getString(i.uRW));
        if (MallIndexUI.h(this.omF).fKO) {
            nVar.add(0, 4, 4, this.omF.getString(i.uRZ));
        }
        int size = this.omG.list.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                nVar.add(0, i + 100, i + 100, ((a) this.omG.list.get(i)).sPz);
                g.pQN.h(14409, new Object[]{Integer.valueOf(1), Integer.valueOf(r0.sPw), r0.sPx, r0.sPA, r0.sPy});
            }
        }
    }
}
