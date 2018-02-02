package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.c.b;
import com.tencent.mm.plugin.webview.modeltools.f;

class g$77 implements OnCancelListener {
    final /* synthetic */ String tIR;
    final /* synthetic */ b tIS;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$77(g gVar, b bVar, String str, i iVar) {
        this.tIj = gVar;
        this.tIS = bVar;
        this.tIR = str;
        this.tIg = iVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        f.bRA().a(this.tIS);
        f.bRA();
        ac.Ok(this.tIR);
        g.a(this.tIj, this.tIg, "downloadVoice:fail", null);
    }
}
