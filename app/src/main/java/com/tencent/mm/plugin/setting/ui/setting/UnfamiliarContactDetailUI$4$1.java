package com.tencent.mm.plugin.setting.ui.setting;

import com.tencent.mm.plugin.setting.ui.setting.UnfamiliarContactDetailUI.4;

class UnfamiliarContactDetailUI$4$1 implements Runnable {
    final /* synthetic */ 4 qmc;

    UnfamiliarContactDetailUI$4$1(4 4) {
        this.qmc = 4;
    }

    public final void run() {
        UnfamiliarContactDetailUI.e(this.qmc.qma).UR.notifyChanged();
        UnfamiliarContactDetailUI.c(this.qmc.qma, false);
    }
}
