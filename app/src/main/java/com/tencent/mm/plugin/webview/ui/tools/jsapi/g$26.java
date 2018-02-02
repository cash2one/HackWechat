package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import com.tencent.mm.bm.d;

class g$26 implements Runnable {
    final /* synthetic */ g tIj;
    final /* synthetic */ Intent val$intent;

    g$26(g gVar, Intent intent) {
        this.tIj = gVar;
        this.val$intent = intent;
    }

    public final void run() {
        d.b(g.i(this.tIj), "webview", ".ui.tools.game.GameWebViewUI", this.val$intent);
    }
}
