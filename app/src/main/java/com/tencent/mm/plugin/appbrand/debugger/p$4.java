package com.tencent.mm.plugin.appbrand.debugger;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class p$4 implements OnClickListener {
    final /* synthetic */ p iRt;

    p$4(p pVar) {
        this.iRt = pVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (p.d(this.iRt) != null) {
            p.d(this.iRt).aco();
        }
    }
}
