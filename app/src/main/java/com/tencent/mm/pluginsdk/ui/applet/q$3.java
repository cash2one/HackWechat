package com.tencent.mm.pluginsdk.ui.applet;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class q$3 implements OnClickListener {
    final /* synthetic */ q vow;

    q$3(q qVar) {
        this.vow = qVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.vow.pyk != null) {
            this.vow.pyk.dismiss();
            this.vow.pyk = null;
        }
        this.vow.onStop();
        if (this.vow.vot != null) {
            this.vow.vot.el(false);
        }
    }
}
