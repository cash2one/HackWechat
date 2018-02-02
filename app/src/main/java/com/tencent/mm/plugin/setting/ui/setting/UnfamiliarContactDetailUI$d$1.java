package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.d;

class UnfamiliarContactDetailUI$d$1 implements Runnable {
    final /* synthetic */ d qmu;

    UnfamiliarContactDetailUI$d$1(d dVar) {
        this.qmu = dVar;
    }

    public final void run() {
        if (this.qmu.qmp != null) {
            this.qmu.qmp.ds(this.qmu.qma.qlU.size(), this.qmu.qmr);
            this.qmu.qma.qlU.clear();
        }
    }
}
