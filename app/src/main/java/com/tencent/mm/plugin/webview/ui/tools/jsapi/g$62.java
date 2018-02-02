package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class g$62 implements OnClickListener {
    final /* synthetic */ String jBv;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$62(g gVar, i iVar, String str) {
        this.tIj = gVar;
        this.tIg = iVar;
        this.jBv = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.a(this.tIj, this.tIg, this.jBv + ":cancel", null);
    }
}
