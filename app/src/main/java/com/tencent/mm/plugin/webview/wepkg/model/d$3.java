package com.tencent.mm.plugin.webview.wepkg.model;

import android.content.Context;
import com.tencent.mm.bm.d;
import com.tencent.mm.g.a.kj;

class d$3 implements Runnable {
    final /* synthetic */ Context rkw;
    final /* synthetic */ kj tMJ;

    d$3(Context context, kj kjVar) {
        this.rkw = context;
        this.tMJ = kjVar;
    }

    public final void run() {
        d.b(this.rkw, "webview", ".ui.tools.game.GameWebViewUI", this.tMJ.fBG.intent);
    }
}
