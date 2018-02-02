package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet_core.ui.WalletCardImportUI.1;

class WalletCardImportUI$1$1 implements Runnable {
    final /* synthetic */ int sSI;
    final /* synthetic */ 1 sSJ;

    WalletCardImportUI$1$1(1 1, int i) {
        this.sSJ = 1;
        this.sSI = i;
    }

    public final void run() {
        if (this.sSI != WalletCardImportUI.a(this.sSJ.sSH).getVisibility()) {
            WalletCardImportUI.a(this.sSJ.sSH).setVisibility(this.sSI);
        }
    }
}
