package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.20;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.c;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j.d;
import com.tencent.mm.sdk.platformtools.bh;

class g$20$1 implements d {
    final /* synthetic */ 20 tIC;

    g$20$1(20 20) {
        this.tIC = 20;
    }

    public final void Bc(int i) {
        aP(i, "cancel");
    }

    public final void pQ(int i) {
        aP(i, "fail");
    }

    public final void vb(int i) {
        aP(i, "ok");
    }

    private void aP(int i, String str) {
        c a = g.a(this.tIC.tIj, i);
        if (a != null && a.tHp != null && a.fBH != null) {
            g.a(this.tIC.tIj, g.z(this.tIC.tIj), g.j(this.tIC.tIj), "openMapNavigateMenu:" + bh.az(str, "fail"));
        }
    }

    public final void Bd(int i) {
        g.c(this.tIC.tIj, i);
    }
}
