package com.tencent.mm.ui.transmit;

import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import java.util.ArrayList;

class b$1 implements k {
    final /* synthetic */ b zoa;

    b$1(b bVar) {
        this.zoa = bVar;
    }

    public final void b(h hVar) {
        if (hVar.bjW == 0) {
            b.a(this.zoa, hVar);
        } else {
            b.a(this.zoa, null);
        }
        if (hVar.mMc.size() == 0) {
            j jVar = new j();
            jVar.mLs = "no_result​";
            hVar.mMc = new ArrayList();
            hVar.mMc.add(jVar);
        }
        this.zoa.clearCache();
        this.zoa.notifyDataSetChanged();
        b.a(this.zoa).r(hVar.mJc.fDj, hVar.mMc.size(), true);
    }
}
