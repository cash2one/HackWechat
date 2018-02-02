package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class PhoneRechargeUI$17 implements OnClickListener {
    final /* synthetic */ PhoneRechargeUI pDm;

    PhoneRechargeUI$17(PhoneRechargeUI phoneRechargeUI) {
        this.pDm = phoneRechargeUI;
    }

    public final void onClick(View view) {
        if (PhoneRechargeUI.f(this.pDm) != null) {
            PhoneRechargeUI.g(this.pDm);
        } else {
            x.e("MicroMsg.PhoneRechargeUI", "hy: no banner but show ad. should not happen");
        }
        PhoneRechargeUI.h(this.pDm).setVisibility(8);
    }
}
