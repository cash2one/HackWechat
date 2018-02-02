package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.ui.base.n;

class GameWebViewUI$4 implements b {
    final /* synthetic */ GameWebViewUI tFJ;

    GameWebViewUI$4(GameWebViewUI gameWebViewUI) {
        this.tFJ = gameWebViewUI;
    }

    public final void a(n nVar) {
        g.pQN.a(480, 0, 1, false);
        n F = GameWebViewUI.F(this.tFJ);
        if (F != null) {
            nVar.ycc.addAll(F.ycc);
        }
    }
}
