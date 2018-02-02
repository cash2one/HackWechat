package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ak.b.a;

class RemittanceBusiUI$16 implements a {
    final /* synthetic */ RemittanceBusiUI pOd;

    RemittanceBusiUI$16(RemittanceBusiUI remittanceBusiUI) {
        this.pOd = remittanceBusiUI;
    }

    public final void v(String str, boolean z) {
        x.i("MicroMsg.RemittanceBusiUI", "getContact %s", new Object[]{Boolean.valueOf(z)});
        RemittanceBusiUI.i(this.pOd);
    }
}
