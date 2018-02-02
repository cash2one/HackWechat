package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.webview.model.l;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a.a;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements OnClickListener {
    final /* synthetic */ int fmb;
    final /* synthetic */ c tGB;
    final /* synthetic */ l tGz;

    c$2(c cVar, l lVar, int i) {
        this.tGB = cVar;
        this.tGz = lVar;
        this.fmb = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        x.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click cancel");
        this.tGz.tsa.a(a.RET_REJECT, "cancel", null, this.fmb, this.tGz.bQD().wsK.fts);
    }
}
