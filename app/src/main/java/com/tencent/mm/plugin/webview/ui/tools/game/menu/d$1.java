package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class d$1 implements OnDismissListener {
    final /* synthetic */ d tGm;

    d$1(d dVar) {
        this.tGm = dVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        this.tGm.bxh();
    }
}
