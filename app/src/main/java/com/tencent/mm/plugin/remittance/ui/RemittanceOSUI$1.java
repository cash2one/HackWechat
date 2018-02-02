package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.g.a.tr;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class RemittanceOSUI$1 extends c<tr> {
    final /* synthetic */ RemittanceOSUI pPj;

    RemittanceOSUI$1(RemittanceOSUI remittanceOSUI) {
        this.pPj = remittanceOSUI;
        this.xen = tr.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        if (RemittanceOSUI.a(this.pPj)) {
            this.pPj.finish();
        }
        return false;
    }
}
