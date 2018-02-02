package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;

class RechargeUI$14 implements OnClickListener {
    final /* synthetic */ RechargeUI pDQ;

    RechargeUI$14(RechargeUI rechargeUI) {
        this.pDQ = rechargeUI;
    }

    public final void onClick(View view) {
        if ((RechargeUI.f(this.pDQ) != null && RechargeUI.f(this.pDQ).getCount() > 0) || (RechargeUI.g(this.pDQ) != null && RechargeUI.g(this.pDQ).getCount() > 0)) {
            this.pDQ.showDialog(1);
        }
    }
}
