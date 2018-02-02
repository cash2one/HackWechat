package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class c$14 implements OnCancelListener {
    final /* synthetic */ c oXK;

    c$14(c cVar) {
        this.oXK = cVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.oXK.bhm();
    }
}
