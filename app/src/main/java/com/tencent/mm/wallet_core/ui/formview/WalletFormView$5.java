package com.tencent.mm.wallet_core.ui.formview;

import android.text.method.NumberKeyListener;

class WalletFormView$5 extends NumberKeyListener {
    final /* synthetic */ WalletFormView zJP;

    WalletFormView$5(WalletFormView walletFormView) {
        this.zJP = walletFormView;
    }

    public final int getInputType() {
        return 18;
    }

    protected final char[] getAcceptedChars() {
        return new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
    }
}
