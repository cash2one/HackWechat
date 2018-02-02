package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.g.a;
import com.tencent.mm.protocal.c.amh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.a.b;
import com.tencent.mm.u.a.b$a;

class g$3 implements b$a<b> {
    final /* synthetic */ int iTc;
    final /* synthetic */ i tIg;
    final /* synthetic */ g tIj;
    final /* synthetic */ a tIk;

    g$3(g gVar, i iVar, a aVar, int i) {
        this.tIj = gVar;
        this.tIg = iVar;
        this.tIk = aVar;
        this.iTc = i;
    }

    public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
        b bVar = (b) kVar;
        x.d("MicroMsg.MsgHandler", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i != 0 || i2 != 0) {
            g.a(this.tIj, this.tIg, "authorize:fail", null);
            this.tIk.afC();
        } else if (!(bVar instanceof b)) {
        } else {
            if (this.iTc == 2) {
                x.d("MicroMsg.MsgHandler", "press reject button");
                this.tIk.afC();
                return;
            }
            amh BW = bVar.BW();
            int i3 = BW.wte.fts;
            String str2 = BW.wte.ftt;
            x.i("MicroMsg.MsgHandler", "NetSceneJSAuthorizeConfirm jsErrcode %d", new Object[]{Integer.valueOf(i3)});
            if (i3 == 0) {
                g.a(this.tIj, this.tIg, "authorize:ok", null);
                this.tIk.afC();
                return;
            }
            x.e("MicroMsg.MsgHandler", "onSceneEnd NetSceneJSAuthorizeConfirm ERROR %s", new Object[]{str2});
            g.a(this.tIj, this.tIg, "authorize:fail", null);
            this.tIk.afC();
        }
    }
}
