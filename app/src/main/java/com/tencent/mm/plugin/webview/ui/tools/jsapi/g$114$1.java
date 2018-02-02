package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.114;
import com.tencent.mm.sdk.platformtools.x;

class g$114$1 implements Runnable {
    final /* synthetic */ 114 tJy;

    g$114$1(114 114) {
        this.tJy = 114;
    }

    public final void run() {
        Runnable runnable = (Runnable) g.bUJ().pollFirst();
        if (runnable != null) {
            runnable.run();
            return;
        }
        x.i("MicroMsg.MsgHandler", "authJsApiQueue processed!");
        g.bUK();
    }
}
