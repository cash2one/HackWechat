package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.remittance.model.t;

class RemittanceBaseUI$11 implements OnClickListener {
    final /* synthetic */ RemittanceBaseUI pMw;
    final /* synthetic */ String pMy;
    final /* synthetic */ t pMz;

    RemittanceBaseUI$11(RemittanceBaseUI remittanceBaseUI, String str, t tVar) {
        this.pMw = remittanceBaseUI;
        this.pMy = str;
        this.pMz = tVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pMw.a(this.pMy, this.pMw.gAb, this.pMw.pMj, this.pMz);
    }
}
