package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;

class RemittanceDetailUI$1 extends c<nb> {
    final /* synthetic */ RemittanceDetailUI pOO;

    RemittanceDetailUI$1(RemittanceDetailUI remittanceDetailUI) {
        this.pOO = remittanceDetailUI;
        this.xen = nb.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        nb nbVar = (nb) bVar;
        if (!(bh.ov(nbVar.fEY.fuI) || bh.ov(nbVar.fEY.fEs))) {
            h.a(this.pOO, this.pOO.getString(i.uNq, new Object[]{RemittanceDetailUI.ax(RemittanceDetailUI.a(this.pOO), false)}), this.pOO.getString(i.dGt), this.pOO.getString(i.uNv), this.pOO.getString(i.dEn), new 1(this, nbVar), new OnClickListener(this) {
                final /* synthetic */ RemittanceDetailUI$1 pOQ;

                {
                    this.pOQ = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
        return false;
    }
}
