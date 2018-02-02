package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class q$5 implements OnCancelListener {
    final /* synthetic */ q vow;

    q$5(q qVar) {
        this.vow = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.vow.onStop();
        if (this.vow.vot != null) {
            this.vow.vot.el(false);
        }
    }
}
