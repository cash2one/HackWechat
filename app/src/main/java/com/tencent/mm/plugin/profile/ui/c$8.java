package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class c$8 implements OnCancelListener {
    final /* synthetic */ c piX;

    c$8(c cVar) {
        this.piX = cVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.piX.isDeleteCancel = true;
    }
}
