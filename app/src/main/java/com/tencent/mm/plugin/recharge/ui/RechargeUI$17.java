package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.bh;

class RechargeUI$17 implements OnClickListener {
    final /* synthetic */ RechargeUI pDQ;

    RechargeUI$17(RechargeUI rechargeUI) {
        this.pDQ = rechargeUI;
    }

    public final void onClick(View view) {
        RechargeUI.e(this.pDQ).pCp.findFocus();
        if (RechargeUI.e(this.pDQ).bmw().fqd == 2) {
            RechargeUI.e(this.pDQ).b(null);
        }
        if (bh.ov(RechargeUI.e(this.pDQ).getText().toString())) {
            RechargeUI.e(this.pDQ).pCp.showDropDown();
        }
        this.pDQ.showVKB();
    }
}
