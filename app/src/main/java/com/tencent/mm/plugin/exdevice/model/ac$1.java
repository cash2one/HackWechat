package com.tencent.mm.plugin.exdevice.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class ac$1 implements OnCancelListener {
    final /* synthetic */ ac lNC;

    ac$1(ac acVar) {
        this.lNC = acVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.lNC.hnr = true;
    }
}
