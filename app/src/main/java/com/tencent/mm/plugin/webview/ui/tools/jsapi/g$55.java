package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.g.a.qt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class g$55 extends c<qt> {
    final /* synthetic */ g tIj;

    g$55(g gVar) {
        this.tIj = gVar;
        this.xen = qt.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qt qtVar = (qt) bVar;
        if (qtVar != null && (qtVar instanceof qt)) {
            x.d("MicroMsg.MsgHandler", "StartVoipCSResultEvent = %s", new Object[]{Integer.valueOf(qtVar.fIB.status)});
            g.b(this.tIj, qtVar.fIB.status);
        }
        return false;
    }
}
