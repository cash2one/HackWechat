package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.remittance.model.i;

class RemittanceBusiUI$10 implements OnClickListener {
    final /* synthetic */ RemittanceBusiUI pOd;
    final /* synthetic */ i pOh;

    RemittanceBusiUI$10(RemittanceBusiUI remittanceBusiUI, i iVar) {
        this.pOd = remittanceBusiUI;
        this.pOh = iVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (RemittanceBusiUI.a(this.pOd, this.pOh)) {
            RemittanceBusiUI.E(this.pOd);
        } else {
            RemittanceBusiUI.b(this.pOd, this.pOh.pKw.fwY);
        }
    }
}
