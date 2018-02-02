package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.g.a.tp;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class q$1 extends c<tp> {
    final /* synthetic */ q ttX;

    q$1(q qVar) {
        this.ttX = qVar;
        this.xen = tp.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        tp tpVar = (tp) bVar;
        if (tpVar != null) {
            this.ttX.Dm().F(new 1(this, new f(tpVar.fMg.url, tpVar.fMg.filePath, tpVar.fMg.version, tpVar.fMg.appId, tpVar.fMg.fMh, tpVar.fMg.fMi, tpVar.fMg.fMj, tpVar.fMg.aBD, tpVar.fMg.fMk, tpVar.fMg.exception)));
        }
        return false;
    }
}
