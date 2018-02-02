package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.plugin.offline.a.s.g;
import com.tencent.mm.plugin.wallet_core.ui.m$a;
import com.tencent.mm.sdk.platformtools.x;

class c$15 implements m$a {
    final /* synthetic */ c oXK;
    final /* synthetic */ g oXL;

    c$15(c cVar, g gVar) {
        this.oXK = cVar;
        this.oXL = gVar;
    }

    public final void bho() {
        if (this.oXK.oXF != null) {
            this.oXK.oXF.o(0, this.oXL.id, "");
        }
        com.tencent.mm.plugin.offline.g.bQ(this.oXL.fwY, com.tencent.mm.plugin.offline.g.oVz);
        x.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do cancel pay");
    }
}
