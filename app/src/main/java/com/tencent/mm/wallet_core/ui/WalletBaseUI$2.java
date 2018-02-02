package com.tencent.mm.wallet_core.ui;

import android.view.View;

class WalletBaseUI$2 implements Runnable {
    final /* synthetic */ View nKs;
    final /* synthetic */ int pJx;
    final /* synthetic */ WalletBaseUI zJd;

    WalletBaseUI$2(WalletBaseUI walletBaseUI, View view, int i) {
        this.zJd = walletBaseUI;
        this.nKs = view;
        this.pJx = i;
    }

    public final void run() {
        this.nKs.scrollBy(0, this.pJx);
    }
}
