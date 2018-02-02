package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.sdk.platformtools.x;

class ExdeviceRankInfoUI$14 implements Runnable {
    final /* synthetic */ ExdeviceRankInfoUI lXj;

    ExdeviceRankInfoUI$14(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.lXj = exdeviceRankInfoUI;
    }

    public final void run() {
        if (ExdeviceRankInfoUI.e(this.lXj) != null && ExdeviceRankInfoUI.e(this.lXj).isShowing()) {
            ExdeviceRankInfoUI.e(this.lXj).dismiss();
            ExdeviceRankInfoUI.f(this.lXj);
            x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
        }
    }
}
