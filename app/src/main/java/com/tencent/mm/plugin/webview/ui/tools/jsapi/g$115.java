package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d;

class g$115 implements Runnable {
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$115(g gVar, i iVar) {
        this.tIj = gVar;
        this.tIg = iVar;
    }

    public final void run() {
        if (this.tIg.tJI.equals("login")) {
            g.a(this.tIj, this.tIg, g.bUL());
        } else if (this.tIg.tJI.equals(d.NAME)) {
            g.b(this.tIj, this.tIg, g.bUL());
        }
    }
}
