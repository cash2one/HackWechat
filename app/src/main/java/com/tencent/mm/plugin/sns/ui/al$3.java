package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class al$3 implements OnCancelListener {
    final /* synthetic */ al rxo;

    al$3(al alVar) {
        this.rxo = alVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.rxo.ruB = null;
    }
}
