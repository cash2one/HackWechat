package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI.14;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h.b;

class RemittanceBaseUI$14$1 implements b {
    final /* synthetic */ 14 pMA;

    RemittanceBaseUI$14$1(14 14) {
        this.pMA = 14;
    }

    public final boolean v(CharSequence charSequence) {
        if (bh.ov(charSequence.toString())) {
            this.pMA.pMw.gAT = null;
            RemittanceBaseUI.c(this.pMA.pMw);
        } else {
            this.pMA.pMw.gAT = charSequence.toString();
            RemittanceBaseUI.c(this.pMA.pMw);
        }
        return true;
    }
}
