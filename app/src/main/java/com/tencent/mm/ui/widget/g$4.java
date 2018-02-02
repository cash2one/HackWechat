package com.tencent.mm.ui.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class g$4 implements OnDismissListener {
    final /* synthetic */ g ztC;

    g$4(g gVar) {
        this.ztC = gVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        if (!g.m(this.ztC)) {
            this.ztC.ztB.onDismiss();
        }
    }
}
