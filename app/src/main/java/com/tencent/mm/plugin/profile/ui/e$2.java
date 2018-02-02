package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class e$2 implements OnCancelListener {
    final /* synthetic */ e pje;

    e$2(e eVar) {
        this.pje = eVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.pje.isDeleteCancel = true;
    }
}
