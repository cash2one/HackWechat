package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class j$6 implements OnClickListener {
    final /* synthetic */ j nOi;

    j$6(j jVar) {
        this.nOi = jVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.nOi.nNX.finish();
        this.nOi.nNX = null;
    }
}
