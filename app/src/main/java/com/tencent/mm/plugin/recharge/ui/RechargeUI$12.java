package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;

class RechargeUI$12 implements OnClickListener {
    final /* synthetic */ RechargeUI pDQ;

    RechargeUI$12(RechargeUI rechargeUI) {
        this.pDQ = rechargeUI;
    }

    public final void onClick(View view) {
        if (RechargeUI.b(this.pDQ) && RechargeUI.c(this.pDQ)) {
            RechargeUI.d(this.pDQ);
        }
    }
}
