package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ae.k;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.plugin.remittance.model.s;
import com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI.1;

class RemittanceDetailUI$1$1 implements OnClickListener {
    final /* synthetic */ nb pOP;
    final /* synthetic */ 1 pOQ;

    RemittanceDetailUI$1$1(1 1, nb nbVar) {
        this.pOQ = 1;
        this.pOP = nbVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        k sVar = new s(this.pOP.fEY.fuI, this.pOP.fEY.fEs, this.pOP.fEY.fEZ, "refuse", this.pOP.fEY.fFa, this.pOP.fEY.fFb);
        sVar.gOs = "RemittanceProcess";
        this.pOQ.pOO.l(sVar);
    }
}
