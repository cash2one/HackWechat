package com.tencent.mm.wallet_core.ui.formview;

import android.text.method.NumberKeyListener;

class WalletFormView$3 extends NumberKeyListener {
    final /* synthetic */ WalletFormView zJP;

    WalletFormView$3(WalletFormView walletFormView) {
        this.zJP = walletFormView;
    }

    public final int getInputType() {
        return 3;
    }

    protected final char[] getAcceptedChars() {
        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    }
}
