package com.tencent.mm.plugin.remittance.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.remittance.model.t;
import com.tencent.mm.plugin.report.service.g;

class RemittanceBaseUI$10 implements OnClickListener {
    final /* synthetic */ RemittanceBaseUI pMw;
    final /* synthetic */ t pMx;

    RemittanceBaseUI$10(RemittanceBaseUI remittanceBaseUI, t tVar) {
        this.pMw = remittanceBaseUI;
        this.pMx = tVar;
    }

    public final void onClick(View view) {
        this.pMw.a(this.pMx.fwY, this.pMw.gAb, this.pMw.pMj, this.pMx);
        if (this.pMw.irz == 1) {
            g.pQN.h(12689, new Object[]{Integer.valueOf(12), Integer.valueOf(1)});
            return;
        }
        g.pQN.h(12689, new Object[]{Integer.valueOf(3), Integer.valueOf(1)});
    }
}
