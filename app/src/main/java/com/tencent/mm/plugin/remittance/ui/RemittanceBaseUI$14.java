package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.ui.view.a;
import com.tencent.mm.plugin.wxpay.a.i;

class RemittanceBaseUI$14 implements OnClickListener {
    final /* synthetic */ RemittanceBaseUI pMw;

    RemittanceBaseUI$14(RemittanceBaseUI remittanceBaseUI) {
        this.pMw = remittanceBaseUI;
    }

    public final void onClick(View view) {
        String string;
        String string2;
        RemittanceBaseUI.b(this.pMw);
        g.pQN.h(12689, Integer.valueOf(9), Integer.valueOf(1));
        if (this.pMw.irz == 1 || this.pMw.irz == 6) {
            string = this.pMw.getString(i.uMR);
            string2 = this.pMw.getString(i.uNg);
            g.pQN.h(14074, Integer.valueOf(1));
        } else {
            string = this.pMw.getString(i.uMQ);
            string2 = this.pMw.getString(i.uMU);
        }
        a.a(this.pMw, string, this.pMw.gAT, string2, 20, new 1(this), new 2(this));
    }
}
