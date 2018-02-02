package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.R;
import com.tencent.mm.ag.a.c;
import com.tencent.mm.ag.a.e;
import com.tencent.mm.ag.y;
import com.tencent.mm.aq.o;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.ui.base.h;

class g$91 implements a {
    final /* synthetic */ String fgO;
    final /* synthetic */ String fgU;
    final /* synthetic */ String hAS;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;
    final /* synthetic */ f tIp;
    final /* synthetic */ long tIw;

    g$91(g gVar, String str, long j, f fVar, String str2, String str3, i iVar) {
        this.tIj = gVar;
        this.hAS = str;
        this.tIw = j;
        this.tIp = fVar;
        this.fgU = str2;
        this.fgO = str3;
        this.tIg = iVar;
    }

    public final void a(boolean z, String str, int i) {
        if (!z) {
            g.a(this.tIj, this.tIg, "sendEnterpriseChat:cancel", null);
        } else if (bh.ov(this.hAS)) {
            c ag = y.Mh().ag(this.tIw);
            synchronized (e.hqR) {
                String HD = e.HD();
                e.d(ag);
                g.a(this.tIj, this.tIp, this.fgU, this.fgO, this.hAS, null, null, str, null);
                e.ks(HD);
            }
            g.a(this.tIj, this.tIg, "sendEnterpriseChat:ok", null);
            if (g.i(this.tIj) != null) {
                h.bu(g.i(this.tIj), g.i(this.tIj).getResources().getString(R.l.dGG));
            }
        } else {
            o.Pv().a(this.hAS, new 1(this, str));
        }
    }
}
