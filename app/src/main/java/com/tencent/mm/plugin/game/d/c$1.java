package com.tencent.mm.plugin.game.d;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class c$1 implements OnCancelListener {
    final /* synthetic */ Dialog nxc;

    c$1(Dialog dialog) {
        this.nxc = dialog;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.nxc.setOnCancelListener(null);
    }
}
