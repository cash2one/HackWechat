package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.wallet_core.ui.a;

class RemittanceBaseUI$2 implements a {
    final /* synthetic */ RemittanceBaseUI pMw;

    RemittanceBaseUI$2(RemittanceBaseUI remittanceBaseUI) {
        this.pMw = remittanceBaseUI;
    }

    public final void hA(boolean z) {
        if (z) {
            RemittanceBaseUI.a(this.pMw, this.pMw.pJd, this.pMw.lRZ);
        } else {
            this.pMw.pJd.scrollTo(0, 0);
        }
    }
}
