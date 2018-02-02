package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ae.k;
import com.tencent.mm.protocal.c.amj;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.a.a;

class g$4 implements a<com.tencent.mm.u.a.a> {
    final /* synthetic */ String fgU;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;
    final /* synthetic */ g.a tIk;

    g$4(g gVar, i iVar, g.a aVar, String str) {
        this.tIj = gVar;
        this.tIg = iVar;
        this.tIk = aVar;
        this.fgU = str;
    }

    public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
        com.tencent.mm.u.a.a aVar = (com.tencent.mm.u.a.a) kVar;
        x.i("MicroMsg.MsgHandler", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            g.a(this.tIj, this.tIg, "authorize:fail", null);
            this.tIk.afC();
        } else if (aVar instanceof com.tencent.mm.u.a.a) {
            amj BV = aVar.BV();
            int i3 = BV.wte.fts;
            String str2 = BV.wte.ftt;
            x.i("MicroMsg.MsgHandler", "NetSceneJSAuthorize jsErrcode %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == -12000) {
                ag.y(new 1(this, BV));
            } else if (i3 == 0) {
                g.a(this.tIj, this.tIg, "authorize:ok", null);
                this.tIk.afC();
            } else {
                x.e("MicroMsg.MsgHandler", "onSceneEnd NetSceneJSAuthorize ERROR %s", new Object[]{str2});
                g.a(this.tIj, this.tIg, "authorize:fail", null);
                this.tIk.afC();
            }
        }
    }
}
