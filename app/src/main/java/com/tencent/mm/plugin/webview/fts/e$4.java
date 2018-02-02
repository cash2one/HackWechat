package com.tencent.mm.plugin.webview.fts;

import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.ArrayList;

class e$4 implements k {
    final /* synthetic */ e tms;

    e$4(e eVar) {
        this.tms = eVar;
    }

    public final void b(h hVar) {
        if (hVar.bjW == 0) {
            ArrayList arrayList = new ArrayList();
            for (j jVar : hVar.mMc) {
                arrayList.add(jVar.content);
            }
            ag.y(new 1(this, hVar, arrayList));
        }
    }
}
