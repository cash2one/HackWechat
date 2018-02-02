package com.tencent.mm.plugin.webview.wepkg;

import com.tencent.mm.plugin.webview.wepkg.model.WepkgVersionManager;
import com.tencent.mm.plugin.webview.wepkg.utils.d;

class a$2 implements Runnable {
    final /* synthetic */ a tLy;

    a$2(a aVar) {
        this.tLy = aVar;
    }

    public final void run() {
        WepkgVersionManager.U(d.Qq(a.b(this.tLy)), 0, a.a(this.tLy));
    }
}
