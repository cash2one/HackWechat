package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.bv.a;
import com.tencent.mm.plugin.wxpay.a.f;

class WalletLqtDetailUI$10 implements Runnable {
    final /* synthetic */ WalletLqtDetailUI sAM;

    WalletLqtDetailUI$10(WalletLqtDetailUI walletLqtDetailUI) {
        this.sAM = walletLqtDetailUI;
    }

    public final void run() {
        LayoutParams layoutParams = (LayoutParams) WalletLqtDetailUI.d(this.sAM).getLayoutParams();
        layoutParams.topMargin = Math.max(((this.sAM.findViewById(f.umk).getHeight() - this.sAM.findViewById(f.umj).getBottom()) - a.fromDPToPix(this.sAM, 20)) - a.fromDPToPix(this.sAM, 20), a.fromDPToPix(this.sAM, 50));
        layoutParams.bottomMargin = a.fromDPToPix(this.sAM, 20);
        WalletLqtDetailUI.d(this.sAM).setLayoutParams(layoutParams);
        WalletLqtDetailUI.d(this.sAM).setVisibility(0);
    }
}
