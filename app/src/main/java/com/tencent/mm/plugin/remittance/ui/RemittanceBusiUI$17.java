package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.wallet_core.ui.view.a;
import com.tencent.mm.plugin.wxpay.a.i;

class RemittanceBusiUI$17 implements OnClickListener {
    final /* synthetic */ RemittanceBusiUI pOd;

    RemittanceBusiUI$17(RemittanceBusiUI remittanceBusiUI) {
        this.pOd = remittanceBusiUI;
    }

    public final void onClick(View view) {
        if (!RemittanceBusiUI.j(this.pOd)) {
            RemittanceBusiUI.k(this.pOd);
        }
        g.pQN.h(15235, new Object[]{Integer.valueOf(6)});
        a.a(this.pOd, this.pOd.getString(i.uvp), RemittanceBusiUI.l(this.pOd), this.pOd.getString(i.uMU), 20, new 1(this), new 2(this));
    }
}
