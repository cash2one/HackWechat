package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.sdk.platformtools.x;

class g$63 implements OnCancelListener {
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$63(g gVar, i iVar) {
        this.tIj = gVar;
        this.tIg = iVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        x.i("MicroMsg.MsgHandler", "cancel date set");
        g.a(this.tIj, this.tIg, "showDatePickerView:cancel", null);
    }
}
