package com.tencent.mm.plugin.wallet_core.ui.view;

import android.widget.FrameLayout.LayoutParams;

class WalletSuccPageAwardWidget$2 implements Runnable {
    final /* synthetic */ WalletSuccPageAwardWidget sYo;

    WalletSuccPageAwardWidget$2(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
        this.sYo = walletSuccPageAwardWidget;
    }

    public final void run() {
        if (WalletSuccPageAwardWidget.c(this.sYo).getHeight() != this.sYo.getHeight()) {
            LayoutParams layoutParams = (LayoutParams) WalletSuccPageAwardWidget.c(this.sYo).getLayoutParams();
            layoutParams.width = WalletSuccPageAwardWidget.d(this.sYo).getWidth();
            layoutParams.height = WalletSuccPageAwardWidget.d(this.sYo).getHeight();
            WalletSuccPageAwardWidget.c(this.sYo).setLayoutParams(layoutParams);
        }
        WalletSuccPageAwardWidget.e(this.sYo);
    }
}
