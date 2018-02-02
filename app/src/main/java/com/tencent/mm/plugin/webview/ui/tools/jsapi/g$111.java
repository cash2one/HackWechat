package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class g$111 implements OnCancelListener {
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$111(g gVar, i iVar) {
        this.tIj = gVar;
        this.tIg = iVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.a(this.tIj, this.tIg, "chooseIdCard:cancel", null);
    }
}
