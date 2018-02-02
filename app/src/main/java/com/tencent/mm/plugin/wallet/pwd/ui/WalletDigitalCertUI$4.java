package com.tencent.mm.plugin.wallet.pwd.ui;

import android.view.View;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.q;
import com.tencent.mm.wallet_core.ui.d;

class WalletDigitalCertUI$4 extends d {
    final /* synthetic */ WalletDigitalCertUI sGL;

    WalletDigitalCertUI$4(WalletDigitalCertUI walletDigitalCertUI) {
        this.sGL = walletDigitalCertUI;
    }

    public final void onClick(View view) {
        if (view.getTag() instanceof q) {
            q qVar = (q) view.getTag();
            h.a(this.sGL, this.sGL.getString(i.uTZ, new Object[]{qVar.wWP}), "", this.sGL.getString(i.dEw), this.sGL.getString(i.dEn), true, new 1(this, qVar), null);
        }
    }
}
