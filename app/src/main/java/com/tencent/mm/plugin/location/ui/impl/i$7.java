package com.tencent.mm.plugin.location.ui.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class i$7 implements OnCancelListener {
    final /* synthetic */ i nYD;

    i$7(i iVar) {
        this.nYD = iVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.nYD.nVY = false;
    }
}
