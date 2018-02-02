package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import com.tencent.mm.bm.d;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.pluginsdk.wallet.h;

class RemittanceDetailUI$7 implements a {
    final /* synthetic */ RemittanceDetailUI pOO;
    final /* synthetic */ boolean pOV;

    RemittanceDetailUI$7(RemittanceDetailUI remittanceDetailUI, boolean z) {
        this.pOO = remittanceDetailUI;
        this.pOV = z;
    }

    public final void onClick(View view) {
        if (this.pOV) {
            d.y(this.pOO, "wallet", ".balance.ui.lqt.WalletLqtDetailUI");
        } else {
            h.Y(this.pOO, 0);
        }
    }
}
