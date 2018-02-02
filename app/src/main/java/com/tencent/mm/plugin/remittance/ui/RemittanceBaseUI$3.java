package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.report.service.g;

class RemittanceBaseUI$3 implements OnClickListener {
    final /* synthetic */ RemittanceBaseUI pMw;

    RemittanceBaseUI$3(RemittanceBaseUI remittanceBaseUI) {
        this.pMw = remittanceBaseUI;
    }

    public final void onClick(View view) {
        b.a(this.pMw, this.pMw.irz, RemittanceBaseUI.f(this.pMw), RemittanceBaseUI.a(this.pMw));
        if (this.pMw.irz == 1) {
            g.pQN.h(12689, new Object[]{Integer.valueOf(13), Integer.valueOf(1)});
            return;
        }
        g.pQN.h(12689, new Object[]{Integer.valueOf(4), Integer.valueOf(1)});
    }
}
