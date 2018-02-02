package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.ui.base.n;

class g$2 implements b {
    final /* synthetic */ g mZW;

    g$2(g gVar) {
        this.mZW = gVar;
    }

    public final void a(n nVar) {
        g.pQN.a(480, 0, 1, false);
        n b = g.b(this.mZW);
        if (b != null) {
            nVar.ycc.addAll(b.ycc);
        }
    }
}
