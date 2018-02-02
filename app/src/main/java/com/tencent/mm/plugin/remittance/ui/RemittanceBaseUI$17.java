package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.ad.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak.b.a;

class RemittanceBaseUI$17 implements a {
    final /* synthetic */ long lkU;
    final /* synthetic */ RemittanceBaseUI pMw;

    RemittanceBaseUI$17(RemittanceBaseUI remittanceBaseUI, long j) {
        this.pMw = remittanceBaseUI;
        this.lkU = j;
    }

    public final void v(String str, boolean z) {
        if (z) {
            x.v("MicroMsg.RemittanceBaseUI", "getContact suc; cost=" + (bh.Wp() - this.lkU) + " ms");
            b.I(str, 3);
        } else {
            x.w("MicroMsg.RemittanceBaseUI", "getContact failed");
        }
        RemittanceBaseUI.d(this.pMw);
    }
}
