package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.drawable.NinePatchDrawable;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.3;

class WalletSuccPageAwardWidget$3$1 implements Runnable {
    final /* synthetic */ NinePatchDrawable sYq;
    final /* synthetic */ 3 sYr;

    WalletSuccPageAwardWidget$3$1(3 3, NinePatchDrawable ninePatchDrawable) {
        this.sYr = 3;
        this.sYq = ninePatchDrawable;
    }

    public final void run() {
        this.sYr.sYo.sYe.setImageDrawable(this.sYq);
        this.sYr.sYo.sYe.setVisibility(0);
        this.sYr.sYo.sYe.post(new 1(this));
    }
}
