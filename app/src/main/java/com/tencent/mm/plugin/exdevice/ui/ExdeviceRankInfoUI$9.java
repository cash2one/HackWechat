package com.tencent.mm.plugin.exdevice.ui;

class ExdeviceRankInfoUI$9 implements Runnable {
    final /* synthetic */ ExdeviceRankInfoUI lXj;

    ExdeviceRankInfoUI$9(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.lXj = exdeviceRankInfoUI;
    }

    public final void run() {
        ExdeviceRankInfoUI.u(this.lXj);
        if (ExdeviceRankInfoUI.v(this.lXj)) {
            ExdeviceRankInfoUI.b(this.lXj).notifyDataSetChanged();
        } else {
            ExdeviceRankInfoUI.h(this.lXj);
        }
    }
}
