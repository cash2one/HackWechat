package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.ui.d;

class WalletDigitalCertUI$2 extends d {
    final /* synthetic */ WalletDigitalCertUI sGL;

    WalletDigitalCertUI$2(WalletDigitalCertUI walletDigitalCertUI) {
        this.sGL = walletDigitalCertUI;
    }

    public final void onClick(View view) {
        r.cBz();
        this.sGL.l(new e(r.cBy()));
        g.pQN.h(13731, new Object[]{Integer.valueOf(10)});
    }
}
