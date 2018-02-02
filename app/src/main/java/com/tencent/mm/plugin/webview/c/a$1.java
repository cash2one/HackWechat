package com.tencent.mm.plugin.webview.c;

import com.tencent.mm.g.a.lv;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class a$1 extends c<lv> {
    final /* synthetic */ a tlh;

    a$1(a aVar) {
        this.tlh = aVar;
        this.xen = lv.class.getName().hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean a(b bVar) {
        lv lvVar = (lv) bVar;
        if (!(lvVar instanceof lv)) {
            return false;
        }
        this.tlh.tlf.a(lvVar.fDi.type, lvVar.fDi.fDj, lvVar.fDi.fDk, lvVar.fDi.fDl, lvVar.fDi.fDm);
        return true;
    }
}
