package com.tencent.mm.plugin.wallet_core.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.ui.MMScrollView.a;

class WalletCardImportUI$1 implements a {
    final /* synthetic */ WalletCardImportUI sSH;

    WalletCardImportUI$1(WalletCardImportUI walletCardImportUI) {
        this.sSH = walletCardImportUI;
    }

    public final void jL(boolean z) {
        int i = z ? 8 : 0;
        x.d("MicroMsg.WalletCardElmentUI", "onSizeChanged : " + z);
        WalletCardImportUI.b(this.sSH).post(new 1(this, i));
    }
}
