package com.tencent.mm.plugin.wallet_core.ui.view;

import android.graphics.Bitmap;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletSuccPageAwardWidget.1;

class WalletSuccPageAwardWidget$1$1 implements Runnable {
    final /* synthetic */ Bitmap jsN;
    final /* synthetic */ 1 sYp;

    WalletSuccPageAwardWidget$1$1(1 1, Bitmap bitmap) {
        this.sYp = 1;
        this.jsN = bitmap;
    }

    public final void run() {
        this.sYp.sYo.sYf.setScaleType(ScaleType.CENTER_CROP);
        this.sYp.sYo.sYf.setImageBitmap(this.jsN);
    }
}
