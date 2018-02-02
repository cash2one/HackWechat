package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.remittance.model.y;

class RemittanceOSUI$2 implements OnClickListener {
    final /* synthetic */ RemittanceOSUI pPj;
    final /* synthetic */ y pPk;

    RemittanceOSUI$2(RemittanceOSUI remittanceOSUI, y yVar) {
        this.pPj = remittanceOSUI;
        this.pPk = yVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pPj.Iu(this.pPk.pKC);
    }
}
