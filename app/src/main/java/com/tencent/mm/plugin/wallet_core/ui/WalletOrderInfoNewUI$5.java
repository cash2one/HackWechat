package com.tencent.mm.plugin.wallet_core.ui;

import android.graphics.Paint;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class WalletOrderInfoNewUI$5 implements Runnable {
    final /* synthetic */ WalletOrderInfoNewUI sUp;

    WalletOrderInfoNewUI$5(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        this.sUp = walletOrderInfoNewUI;
    }

    public final void run() {
        if (WalletOrderInfoNewUI.r(this.sUp).getVisibility() == 0 && WalletOrderInfoNewUI.s(this.sUp).getRight() >= WalletOrderInfoNewUI.r(this.sUp).getLeft() && !bh.M(WalletOrderInfoNewUI.s(this.sUp).getText())) {
            float textSize = WalletOrderInfoNewUI.s(this.sUp).getTextSize();
            x.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv size exceed, tinyAppDescTv.getRight(): %s, tinyAppButton.getLeft(): %s", new Object[]{Integer.valueOf(WalletOrderInfoNewUI.s(this.sUp).getRight()), Integer.valueOf(WalletOrderInfoNewUI.r(this.sUp).getLeft())});
            Paint paint = new Paint();
            paint.setTextSize(textSize);
            String charSequence = WalletOrderInfoNewUI.s(this.sUp).getText().toString();
            float measureText = paint.measureText(charSequence) - ((float) (WalletOrderInfoNewUI.s(this.sUp).getRight() - WalletOrderInfoNewUI.r(this.sUp).getLeft()));
            int i = 1;
            while (paint.measureText(charSequence.substring(0, (charSequence.length() - i) - 1)) > measureText && i <= charSequence.length() - 1) {
                i++;
            }
            x.i("MicroMsg.WalletOrderInfoNewUI", "tinyAppDescTv, exceed len, final search count: %s, text.length: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(charSequence.length())});
            WalletOrderInfoNewUI.s(this.sUp).setText(charSequence.substring(0, (charSequence.length() - i) - 1));
            WalletOrderInfoNewUI.s(this.sUp).append("...");
        }
    }
}
