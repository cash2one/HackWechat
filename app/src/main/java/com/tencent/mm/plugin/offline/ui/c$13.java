package com.tencent.mm.plugin.offline.ui;

import com.tencent.mm.plugin.offline.a.s.g;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.ui.m.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

class c$13 implements c {
    final /* synthetic */ c oXK;
    final /* synthetic */ g oXL;

    c$13(c cVar, g gVar) {
        this.oXK = cVar;
        this.oXL = gVar;
    }

    public final void a(String str, FavorPayInfo favorPayInfo, boolean z) {
        if (this.oXK.mActivity instanceof MMActivity) {
            ((MMActivity) this.oXK.mActivity).aWs();
        }
        if (this.oXK.oXF != null) {
            this.oXK.oXF.o(1, this.oXL.id, str);
        }
        x.i("MicroMsg.OfflineLogicMgr", "launchPwdDialog do pay");
    }
}
