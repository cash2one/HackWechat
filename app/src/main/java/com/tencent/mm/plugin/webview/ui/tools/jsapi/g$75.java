package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.c.b;
import com.tencent.mm.plugin.webview.modeltools.f;

class g$75 implements OnCancelListener {
    final /* synthetic */ String mXv;
    final /* synthetic */ b tIS;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$75(g gVar, b bVar, String str, i iVar) {
        this.tIj = gVar;
        this.tIS = bVar;
        this.mXv = str;
        this.tIg = iVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        f.bRA().a(this.tIS);
        f.bRA();
        ac.qh(this.mXv);
        g.a(this.tIj, this.tIg, "uploadVoice:fail", null);
    }
}
