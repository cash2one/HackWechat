package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webview.model.k;
import com.tencent.mm.z.ar;

class g$8 implements OnCancelListener {
    final /* synthetic */ g tIj;
    final /* synthetic */ k tIu;

    g$8(g gVar, k kVar) {
        this.tIj = gVar;
        this.tIu = kVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        ar.CG().c(this.tIu);
    }
}
