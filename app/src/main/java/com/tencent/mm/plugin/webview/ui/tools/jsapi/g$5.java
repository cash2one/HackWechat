package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.aq.o;

class g$5 implements OnCancelListener {
    final /* synthetic */ String hAS;
    final /* synthetic */ g tIj;

    g$5(g gVar, String str) {
        this.tIj = gVar;
        this.hAS = str;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        o.Pv().le(this.hAS);
        g.a(this.tIj, g.j(this.tIj), "send_app_msg:cancel", null);
    }
}
