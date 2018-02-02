package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class PhoneRechargeUI$3 implements OnClickListener {
    final /* synthetic */ PhoneRechargeUI pDm;

    PhoneRechargeUI$3(PhoneRechargeUI phoneRechargeUI) {
        this.pDm = phoneRechargeUI;
    }

    public final void onClick(View view) {
        x.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", new Object[]{PhoneRechargeUI.c(this.pDm, PhoneRechargeUI.j(this.pDm).url)});
        PhoneRechargeUI.d(this.pDm, r0);
    }
}
