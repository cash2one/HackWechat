package com.tencent.mm.plugin.wallet_core.ui;

import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.x;

class WalletOrderInfoNewUI$14 implements Runnable {
    final /* synthetic */ WalletOrderInfoNewUI sUp;

    WalletOrderInfoNewUI$14(WalletOrderInfoNewUI walletOrderInfoNewUI) {
        this.sUp = walletOrderInfoNewUI;
    }

    public final void run() {
        int i;
        int i2;
        int height = WalletOrderInfoNewUI.e(this.sUp).getHeight();
        int height2 = this.sUp.findViewById(f.uwk).getHeight();
        int i3 = WalletOrderInfoNewUI.f(this.sUp).getVisibility() == 0 ? 1 : 0;
        if (WalletOrderInfoNewUI.g(this.sUp).getVisibility() == 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (WalletOrderInfoNewUI.h(this.sUp).getVisibility() == 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i3 != 0 && i != 0) {
            i3 = WalletOrderInfoNewUI.f(this.sUp).getBottom();
        } else if (i != 0) {
            i3 = WalletOrderInfoNewUI.g(this.sUp).getBottom();
        } else if (i3 != 0) {
            i3 = WalletOrderInfoNewUI.f(this.sUp).getBottom();
        } else if (i2 != 0) {
            i3 = WalletOrderInfoNewUI.h(this.sUp).getBottom();
        } else {
            i3 = this.sUp.findViewById(f.usR).getBottom();
        }
        if (WalletOrderInfoNewUI.i(this.sUp).getVisibility() == 0 || WalletOrderInfoNewUI.c(this.sUp).getVisibility() == 0) {
            i = height;
        } else {
            i = a.fromDPToPix(this.sUp, 70) + height;
        }
        height = (height2 - i3) - i;
        i2 = a.fromDPToPix(this.sUp, 50);
        x.i("MicroMsg.WalletOrderInfoNewUI", "autoAdjustLayout inner, height: %s, topViewPos: %s, contentHeight: %s, topMargin: %s, 50dp: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i3), Integer.valueOf(height2), Integer.valueOf(height), Integer.valueOf(i2)});
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) WalletOrderInfoNewUI.e(this.sUp).getLayoutParams();
        if (height > i2) {
            marginLayoutParams.topMargin = height;
        } else {
            marginLayoutParams.topMargin = i2;
        }
        WalletOrderInfoNewUI.e(this.sUp).setLayoutParams(marginLayoutParams);
        WalletOrderInfoNewUI.e(this.sUp).setVisibility(0);
    }
}
