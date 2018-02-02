package com.tencent.mm.plugin.wallet_core.ui;

import android.graphics.Paint;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WalletBindCardResultUI$6 implements Runnable {
    final /* synthetic */ WalletBindCardResultUI sRR;

    WalletBindCardResultUI$6(WalletBindCardResultUI walletBindCardResultUI) {
        this.sRR = walletBindCardResultUI;
    }

    public final void run() {
        if (WalletBindCardResultUI.g(this.sRR).getVisibility() == 0 && WalletBindCardResultUI.h(this.sRR).getRight() >= WalletBindCardResultUI.g(this.sRR).getLeft() && !bh.M(WalletBindCardResultUI.h(this.sRR).getText())) {
            float textSize = WalletBindCardResultUI.h(this.sRR).getTextSize();
            x.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", Integer.valueOf(WalletBindCardResultUI.h(this.sRR).getRight()), Integer.valueOf(WalletBindCardResultUI.g(this.sRR).getLeft()));
            Paint paint = new Paint();
            paint.setTextSize(textSize);
            String charSequence = WalletBindCardResultUI.h(this.sRR).getText().toString();
            float measureText = paint.measureText(charSequence) - ((float) (WalletBindCardResultUI.h(this.sRR).getRight() - WalletBindCardResultUI.g(this.sRR).getLeft()));
            int i = 1;
            while (paint.measureText(charSequence.substring(0, (charSequence.length() - i) - 1)) > measureText && i <= charSequence.length() - 1) {
                i++;
            }
            x.i("MicroMsg.WalletBindCardResultUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", Integer.valueOf(i), Integer.valueOf(charSequence.length()));
            WalletBindCardResultUI.h(this.sRR).setText(charSequence.substring(0, (charSequence.length() - i) - 1));
            WalletBindCardResultUI.h(this.sRR).append("...");
        }
    }
}
