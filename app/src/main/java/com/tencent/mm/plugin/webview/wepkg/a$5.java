package com.tencent.mm.plugin.webview.wepkg;

import com.tencent.mm.sdk.platformtools.x;

class a$5 implements Runnable {
    final /* synthetic */ boolean tLB;
    final /* synthetic */ a tLy;

    a$5(a aVar, boolean z) {
        this.tLy = aVar;
        this.tLB = z;
    }

    public final void run() {
        if (a.e(this.tLy) != null) {
            a.e(this.tLy).evaluateJavascript(String.format("javascript:(function() {window.__usewepkg__=%s;})();", new Object[]{Boolean.valueOf(this.tLB)}), null);
            return;
        }
        x.i("MicroMsg.Wepkg.WePkgPlugin", "injectWepkgState, webview == null");
    }
}
