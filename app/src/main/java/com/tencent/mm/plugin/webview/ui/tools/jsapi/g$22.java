package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class g$22 implements OnDismissListener {
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$22(g gVar, i iVar) {
        this.tIj = gVar;
        this.tIg = iVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        g.a(this.tIj, this.tIg, "share_weibo:not_bind_qq", null);
    }
}
