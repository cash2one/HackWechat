package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webview.model.i;
import com.tencent.mm.z.ar;

class g$88 implements OnCancelListener {
    final /* synthetic */ g tIj;
    final /* synthetic */ i tJl;

    g$88(g gVar, i iVar) {
        this.tIj = gVar;
        this.tJl = iVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.tJl);
    }
}
