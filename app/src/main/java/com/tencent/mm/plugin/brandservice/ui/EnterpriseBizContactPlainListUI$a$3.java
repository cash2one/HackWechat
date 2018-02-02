package com.tencent.mm.plugin.brandservice.ui;

import com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactPlainListUI.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.applet.b.b;

class EnterpriseBizContactPlainListUI$a$3 implements b {
    final /* synthetic */ a kGG;

    EnterpriseBizContactPlainListUI$a$3(a aVar) {
        this.kGG = aVar;
    }

    public final String hC(int i) {
        if (i < 0 || i >= this.kGG.getCount()) {
            x.e("MicroMsg.EnterpriseBizListAdapter", "pos is invalid");
            return null;
        }
        com.tencent.mm.plugin.brandservice.a.b bVar = (com.tencent.mm.plugin.brandservice.a.b) this.kGG.getItem(i);
        return bVar == null ? null : bVar.userName;
    }

    public final int NJ() {
        return this.kGG.getCount();
    }
}
