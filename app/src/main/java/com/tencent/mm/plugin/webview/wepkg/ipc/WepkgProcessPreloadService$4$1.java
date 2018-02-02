package com.tencent.mm.plugin.webview.wepkg.ipc;

import com.tencent.mm.plugin.webview.wepkg.ipc.WepkgProcessPreloadService.4;
import com.tencent.mm.plugin.webview.wepkg.model.g;

class WepkgProcessPreloadService$4$1 implements Runnable {
    final /* synthetic */ 4 tMy;
    final /* synthetic */ String val$url;

    WepkgProcessPreloadService$4$1(4 4, String str) {
        this.tMy = 4;
        this.val$url = str;
    }

    public final void run() {
        g.Qd(this.val$url);
        WepkgProcessPreloadService.a(this.tMy.tMw, this.tMy.tMx);
    }
}
