package com.tencent.mm.plugin.wallet_index.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class h$4 implements OnClickListener {
    final /* synthetic */ h tax;

    h$4(h hVar) {
        this.tax = hVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.tax.tat.fqI != null) {
            this.tax.tat.fCQ.ret = 1;
            this.tax.tat.fqI.run();
        }
    }
}
