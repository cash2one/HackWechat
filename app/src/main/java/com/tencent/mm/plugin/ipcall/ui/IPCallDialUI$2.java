package com.tencent.mm.plugin.ipcall.ui;

import com.tencent.mm.g.a.rv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;

class IPCallDialUI$2 extends c<rv> {
    final /* synthetic */ IPCallDialUI nJK;

    IPCallDialUI$2(IPCallDialUI iPCallDialUI) {
        this.nJK = iPCallDialUI;
        this.xen = rv.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        rv rvVar = (rv) bVar;
        if (rvVar instanceof rv) {
            String str = rvVar.fJC.countryCode;
            if (!(IPCallDialUI.a(this.nJK) == null || bh.ov(str))) {
                IPCallDialUI.a(this.nJK).CK(str);
            }
        }
        return false;
    }
}
