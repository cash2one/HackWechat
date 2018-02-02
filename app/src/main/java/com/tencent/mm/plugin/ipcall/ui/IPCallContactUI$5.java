package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.tools.p.b;

class IPCallContactUI$5 implements b {
    final /* synthetic */ IPCallContactUI nIW;

    IPCallContactUI$5(IPCallContactUI iPCallContactUI) {
        this.nIW = iPCallContactUI;
    }

    public final void Xs() {
        x.d("MicroMsg.IPCallContactUI", "onEnterSearch");
        g.pQN.h(12767, new Object[]{Integer.valueOf(1)});
        IPCallContactUI.a(this.nIW).setVisibility(0);
        IPCallContactUI.b(this.nIW).setVisibility(8);
        IPCallContactUI.c(this.nIW).setVisibility(8);
        this.nIW.gd(false);
    }

    public final void Xr() {
        x.d("MicroMsg.IPCallContactUI", "onQuitSearch");
        this.nIW.CN("");
        this.nIW.gd(true);
        IPCallContactUI.a(this.nIW).setVisibility(8);
        IPCallContactUI.b(this.nIW).setVisibility(0);
        IPCallContactUI.c(this.nIW).setVisibility(0);
    }

    public final void oL(String str) {
        x.d("MicroMsg.IPCallContactUI", "onSearchChange");
        this.nIW.CN(str);
        if (!bh.ov(str)) {
            IPCallContactUI.a(this.nIW).setVisibility(8);
            IPCallContactUI.b(this.nIW).setVisibility(0);
            IPCallContactUI.c(this.nIW).setVisibility(8);
        }
    }

    public final boolean oK(String str) {
        x.d("MicroMsg.IPCallContactUI", "onSearchKeyDown");
        return false;
    }

    public final void Xt() {
        IPCallContactUI.a(this.nIW).setVisibility(0);
        IPCallContactUI.b(this.nIW).setVisibility(8);
        IPCallContactUI.c(this.nIW).setVisibility(8);
    }

    public final void Xu() {
    }
}
