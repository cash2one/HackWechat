package com.tencent.mm.plugin.location.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class l$9 implements OnClickListener {
    final /* synthetic */ l nUS;

    public l$9(l lVar) {
        this.nUS = lVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.nUS.nUR != null) {
            this.nUS.nUR.aWk();
        }
        this.nUS.iRs = null;
    }
}
