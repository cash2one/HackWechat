package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webview.model.q;
import com.tencent.mm.z.ar;

class g$14 implements OnCancelListener {
    final /* synthetic */ g tIj;
    final /* synthetic */ q tIv;

    g$14(g gVar, q qVar) {
        this.tIj = gVar;
        this.tIv = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.tIv);
    }
}
