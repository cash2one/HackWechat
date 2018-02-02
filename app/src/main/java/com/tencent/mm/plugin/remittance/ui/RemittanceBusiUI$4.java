package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.plugin.remittance.model.c;
import com.tencent.mm.protocal.c.vv;
import java.util.List;

class RemittanceBusiUI$4 implements c {
    final /* synthetic */ RemittanceBusiUI pOd;

    RemittanceBusiUI$4(RemittanceBusiUI remittanceBusiUI) {
        this.pOd = remittanceBusiUI;
    }

    public final void bA(List<vv> list) {
        if (list.size() > 0) {
            RemittanceBusiUI.a(this.pOd, list);
        }
    }
}
