package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.wallet_core.ui.a;

class RemittanceBusiUI$20 implements a {
    final /* synthetic */ RemittanceBusiUI pOd;

    RemittanceBusiUI$20(RemittanceBusiUI remittanceBusiUI) {
        this.pOd = remittanceBusiUI;
    }

    public final void hA(boolean z) {
        RemittanceBusiUI.a(this.pOd, z);
        if (z) {
            RemittanceBusiUI.a(this.pOd, RemittanceBusiUI.s(this.pOd), RemittanceBusiUI.t(this.pOd));
            return;
        }
        RemittanceBusiUI.s(this.pOd).scrollTo(0, 0);
        if (RemittanceBusiUI.d(this.pOd) != null && RemittanceBusiUI.d(this.pOd).getVisibility() == 0) {
            RemittanceBusiUI.d(this.pOd).setFocusable(false);
            RemittanceBusiUI.d(this.pOd).setFocusable(true);
        }
    }
}
