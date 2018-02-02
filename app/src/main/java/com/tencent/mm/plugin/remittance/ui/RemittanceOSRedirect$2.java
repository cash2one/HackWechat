package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class RemittanceOSRedirect$2 implements OnClickListener {
    final /* synthetic */ RemittanceOSRedirect pPb;

    RemittanceOSRedirect$2(RemittanceOSRedirect remittanceOSRedirect) {
        this.pPb = remittanceOSRedirect;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pPb.finish();
    }
}
