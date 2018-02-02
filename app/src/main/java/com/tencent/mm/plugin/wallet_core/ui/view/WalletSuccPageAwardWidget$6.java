package com.tencent.mm.plugin.wallet_core.ui.view;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletScratchShakeView.a;
import com.tencent.mm.sdk.platformtools.x;

class WalletSuccPageAwardWidget$6 implements a {
    final /* synthetic */ WalletSuccPageAwardWidget sYo;

    WalletSuccPageAwardWidget$6(WalletSuccPageAwardWidget walletSuccPageAwardWidget) {
        this.sYo = walletSuccPageAwardWidget;
    }

    public final void jT(boolean z) {
        int i = 2;
        x.i("MicroMsg.WalletSuccPageAwardWidget", "onStartScratchOrShake, isScratch: %s", new Object[]{Boolean.valueOf(z)});
        WalletSuccPageAwardWidget.a(this.sYo, z ? 1 : 2, false);
        g gVar;
        Object[] objArr;
        if (z) {
            gVar = g.pQN;
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(5);
            if (!WalletSuccPageAwardWidget.n(this.sYo)) {
                i = 1;
            }
            objArr[1] = Integer.valueOf(i);
            gVar.h(15225, objArr);
        } else {
            gVar = g.pQN;
            objArr = new Object[2];
            objArr[0] = Integer.valueOf(4);
            if (!WalletSuccPageAwardWidget.n(this.sYo)) {
                i = 1;
            }
            objArr[1] = Integer.valueOf(i);
            gVar.h(15225, objArr);
        }
        WalletSuccPageAwardWidget.q(this.sYo);
    }

    public final void bMZ() {
        x.i("MicroMsg.WalletSuccPageAwardWidget", "onFinishScratchOrShake");
        if (WalletSuccPageAwardWidget.a(this.sYo).Avh != 0) {
            WalletSuccPageAwardWidget.bNf();
        }
    }
}
