package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ff;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKFileItem;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.ui.base.h;

class g$79 implements Runnable {
    final /* synthetic */ String jjz;
    final /* synthetic */ boolean tIW;
    final /* synthetic */ WebViewJSSDKFileItem tIY;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$79(g gVar, boolean z, i iVar, String str, WebViewJSSDKFileItem webViewJSSDKFileItem) {
        this.tIj = gVar;
        this.tIW = z;
        this.tIg = iVar;
        this.jjz = str;
        this.tIY = webViewJSSDKFileItem;
    }

    public final void run() {
        if (this.tIW) {
            g gVar = this.tIj;
            Context i = g.i(this.tIj);
            g.i(this.tIj).getString(R.l.dGO);
            g.a(gVar, h.a(i, g.i(this.tIj).getString(R.l.eYE), true, new 1(this)));
        }
        b ffVar = new ff();
        ffVar.fuq.fus = this.jjz;
        ffVar.fuq.fileName = this.tIY.fileName;
        ffVar.fuq.fut = 0;
        ffVar.fuq.scene = 8;
        ffVar.fuq.fuu = new 2(this, ffVar);
        a.xef.m(ffVar);
    }
}
