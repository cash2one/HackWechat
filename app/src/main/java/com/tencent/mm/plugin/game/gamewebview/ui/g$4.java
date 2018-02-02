package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.sdk.platformtools.x;

class g$4 implements Runnable {
    final /* synthetic */ g mZW;
    final /* synthetic */ d mZX;

    g$4(g gVar, d dVar) {
        this.mZW = gVar;
        this.mZX = dVar;
    }

    public final void run() {
        if (this.mZW.mYx.isFinishing()) {
            x.i("MicroMsg.GameWebViewMenuHelp", "tryShow sheet failed, the activity has been destroyed.");
        } else {
            this.mZX.bUk();
        }
    }
}
