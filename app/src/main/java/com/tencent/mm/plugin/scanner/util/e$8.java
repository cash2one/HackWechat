package com.tencent.mm.plugin.scanner.util;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class e$8 implements OnClickListener {
    final /* synthetic */ e qab;

    e$8(e eVar) {
        this.qab = eVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.qab.pZY != null) {
            this.qab.pZY.m(1, null);
        }
    }
}
