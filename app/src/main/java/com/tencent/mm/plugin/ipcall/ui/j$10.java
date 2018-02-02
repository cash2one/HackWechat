package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.ui.IPCallFuncButton.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

class j$10 implements a {
    final /* synthetic */ j nOi;

    j$10(j jVar) {
        this.nOi = jVar;
    }

    public final void gf(boolean z) {
        if (i.aTB().aTt()) {
            x.d("MicroMsg.TalkUIController", "switch mute, isChecked: %b", new Object[]{Boolean.valueOf(z)});
            com.tencent.mm.plugin.ipcall.a.c.a aTy = i.aTy();
            int td = z ? aTy.nEG.td(412) : aTy.nEG.td(413);
            if (td < 0) {
                x.e("MicroMsg.IPCallEngineManager", "tryMuteMicrophone ret:" + td);
            }
            i.aTA().nEl.setMute(z);
            g.pQN.h(12057, new Object[]{Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0)});
        }
    }
}
