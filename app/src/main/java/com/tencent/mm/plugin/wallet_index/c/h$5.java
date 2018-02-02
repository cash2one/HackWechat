package com.tencent.mm.plugin.wallet_index.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class h$5 implements OnClickListener {
    final /* synthetic */ h tax;

    h$5(h hVar) {
        this.tax = hVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.tax.tas.fqI != null) {
            this.tax.tas.fxc.ret = 1;
            this.tax.tas.fqI.run();
        }
    }
}
