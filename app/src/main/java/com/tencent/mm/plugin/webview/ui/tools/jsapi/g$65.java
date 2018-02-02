package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.c.b;
import com.tencent.mm.plugin.webview.modeltools.f;

class g$65 implements OnCancelListener {
    final /* synthetic */ String jBv;
    final /* synthetic */ String mXv;
    final /* synthetic */ b tIS;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$65(g gVar, b bVar, String str, i iVar, String str2) {
        this.tIj = gVar;
        this.tIS = bVar;
        this.mXv = str;
        this.tIg = iVar;
        this.jBv = str2;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        f.bRA().a(this.tIS);
        f.bRA();
        ac.qh(this.mXv);
        g.B(this.tIj);
        g.a(this.tIj, this.tIg, this.jBv + ":cancel", null);
    }
}
