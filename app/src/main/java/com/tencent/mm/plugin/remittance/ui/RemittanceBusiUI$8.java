package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.plugin.remittance.model.a;
import com.tencent.mm.protocal.c.vu;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.picker.b.b;

class RemittanceBusiUI$8 implements b {
    final /* synthetic */ RemittanceBusiUI pOd;

    RemittanceBusiUI$8(RemittanceBusiUI remittanceBusiUI) {
        this.pOd = remittanceBusiUI;
    }

    public final void hB(boolean z) {
        if (z) {
            vu vuVar = RemittanceBusiUI.B(this.pOd).pLI;
            String str = "MicroMsg.RemittanceBusiUI";
            String str2 = "onFavorSelected %s ";
            Object[] objArr = new Object[1];
            objArr[0] = vuVar == null ? "" : a.a(vuVar);
            x.i(str, str2, objArr);
            RemittanceBusiUI.C(this.pOd);
        }
    }
}
