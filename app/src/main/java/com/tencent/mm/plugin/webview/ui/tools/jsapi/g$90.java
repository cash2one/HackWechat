package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ae.e;
import com.tencent.mm.plugin.webview.model.i;
import com.tencent.mm.z.ar;

class g$90 implements OnCancelListener {
    final /* synthetic */ g tIj;
    final /* synthetic */ i tJl;
    final /* synthetic */ e tJm;

    g$90(g gVar, i iVar, e eVar) {
        this.tIj = gVar;
        this.tJl = iVar;
        this.tJm = eVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.tJl);
        ar.CG().b(1393, this.tJm);
    }
}
