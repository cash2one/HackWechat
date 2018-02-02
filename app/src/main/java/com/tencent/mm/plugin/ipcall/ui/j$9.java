package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class j$9 implements a {
    final /* synthetic */ j nOi;

    j$9(j jVar) {
        this.nOi = jVar;
    }

    public final void gf(boolean z) {
        x.d("MicroMsg.TalkUIController", "switch speaker, isChecked: %b", new Object[]{Boolean.valueOf(z)});
        if (i.aTB().aTs()) {
            this.nOi.nOc = z;
            this.nOi.nOd = z;
            i.aTA().fW(z);
            g.pQN.h(12057, new Object[]{Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0)});
        } else if (!i.aTH().aip() && !i.aTB().aTu()) {
            i.aTH().jp(z);
        }
    }
}
