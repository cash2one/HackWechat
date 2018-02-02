package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.plugin.wallet_core.ui.WalletCheckPwdUI.5;

class WalletCheckPwdUI$5$1 implements Runnable {
    final /* synthetic */ boolean sTt;
    final /* synthetic */ 5 sTu;

    WalletCheckPwdUI$5$1(5 5, boolean z) {
        this.sTu = 5;
        this.sTt = z;
    }

    public final void run() {
        if (this.sTt) {
            WalletCheckPwdUI.h(this.sTu.sTs).fullScroll(130);
        } else {
            WalletCheckPwdUI.h(this.sTu.sTs).fullScroll(33);
        }
    }
}
