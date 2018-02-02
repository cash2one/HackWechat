package com.tencent.mm.plugin.wallet_core.ui.view;

import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.3.1;
import com.tencent.mm.plugin.wxpay.a$f;

class WalletSuccPageAwardWidget$3$1$1 implements Runnable {
    final /* synthetic */ 1 sYs;

    WalletSuccPageAwardWidget$3$1$1(1 1) {
        this.sYs = 1;
    }

    public final void run() {
        LayoutParams layoutParams = WalletSuccPageAwardWidget.g(this.sYs.sYr.sYo).getLayoutParams();
        layoutParams.height = WalletSuccPageAwardWidget.d(this.sYs.sYr.sYo).getHeight();
        layoutParams.width = WalletSuccPageAwardWidget.d(this.sYs.sYr.sYo).getWidth();
        WalletSuccPageAwardWidget.g(this.sYs.sYr.sYo).setLayoutParams(layoutParams);
        this.sYs.sYr.sYo.findViewById(a$f.usk).setVisibility(8);
        this.sYs.sYr.sYo.findViewById(a$f.usl).setVisibility(8);
    }
}
