package com.tencent.mm.plugin.search.ui;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.bc.i;
import com.tencent.mm.protocal.c.bez;
import com.tencent.mm.protocal.c.bfa;
import com.tencent.mm.sdk.platformtools.x;

class FTSMainUI$3 implements e {
    final /* synthetic */ FTSMainUI qdk;

    FTSMainUI$3(FTSMainUI fTSMainUI) {
        this.qdk = fTSMainUI;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 1944) {
            this.qdk.qdd = null;
            if (i != 0 || i2 != 0) {
                x.w("MicroMsg.FTS.FTSMainUI", "search local page error" + str);
            } else if (FTSMainUI.h(this.qdk).getVisibility() == 0) {
                i iVar = (i) kVar;
                if (FTSMainUI.a(this.qdk).a(((bfa) iVar.gJQ.hmh.hmo).wKj, ((bfa) iVar.gJQ.hmh.hmo).vPs, ((bez) iVar.gJQ.hmg.hmo).wKh)) {
                    FTSMainUI.a(this.qdk).setVisibility(0);
                }
            }
        }
    }
}
