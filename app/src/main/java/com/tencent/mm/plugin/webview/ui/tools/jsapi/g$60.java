package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.c$b;
import com.tencent.mm.plugin.webview.modeltools.f;

class g$60 implements OnCancelListener {
    final /* synthetic */ String jBv;
    final /* synthetic */ String mXv;
    final /* synthetic */ c$b tIS;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$60(g gVar, c$b com_tencent_mm_plugin_webview_model_c_b, String str, i iVar, String str2) {
        this.tIj = gVar;
        this.tIS = com_tencent_mm_plugin_webview_model_c_b;
        this.mXv = str;
        this.tIg = iVar;
        this.jBv = str2;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        f.bRA().a(this.tIS);
        f.bRA();
        ac.qh(this.mXv);
        g.a(this.tIj, this.tIg, this.jBv + ":fail", null);
    }
}
