package com.tencent.mm.plugin.offline.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.d;

class WalletOfflineCoinPurseUI$17 implements Runnable {
    final /* synthetic */ Bitmap jsN;
    final /* synthetic */ ImageView kXE;
    final /* synthetic */ WalletOfflineCoinPurseUI oYH;
    final /* synthetic */ Integer oYW;

    WalletOfflineCoinPurseUI$17(WalletOfflineCoinPurseUI walletOfflineCoinPurseUI, Integer num, Bitmap bitmap, ImageView imageView) {
        this.oYH = walletOfflineCoinPurseUI;
        this.oYW = num;
        this.jsN = bitmap;
        this.kXE = imageView;
    }

    public final void run() {
        int intValue = this.oYW.intValue();
        this.kXE.setImageBitmap(d.a(this.jsN, intValue, intValue, true, false));
    }
}
