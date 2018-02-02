package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.pluginsdk.ui.applet.l;

class g$27 implements l {
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;

    g$27(g gVar, i iVar) {
        this.tIj = gVar;
        this.tIg = iVar;
    }

    public final void kp(int i) {
        switch (i) {
            case -2:
                g.a(this.tIj, this.tIg, "add_contact:added", null);
                return;
            case -1:
                g.a(this.tIj, this.tIg, "add_contact:fail", null);
                return;
            case 0:
                g.a(this.tIj, this.tIg, "add_contact:cancel", null);
                return;
            case 1:
                g.a(this.tIj, this.tIg, "add_contact:ok", null);
                return;
            default:
                g.a(this.tIj, this.tIg, "add_contact:fail", null);
                return;
        }
    }
}
