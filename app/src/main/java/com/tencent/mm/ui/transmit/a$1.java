package com.tencent.mm.ui.transmit;

import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.k;
import com.tencent.mm.ui.transmit.a.a;
import java.util.ArrayList;

class a$1 implements k {
    final /* synthetic */ a znV;

    a$1(a aVar) {
        this.znV = aVar;
    }

    public final void b(h hVar) {
        a aVar = new a(this.znV, (byte) 0);
        aVar.fDj = hVar.mJc.fDj;
        aVar.mMb = hVar.mMb;
        aVar.mMc = hVar.mMc;
        if (aVar.mMc == null || aVar.mMc.size() == 0) {
            j jVar = new j();
            jVar.mLs = "no_result​";
            aVar.mMc = new ArrayList();
            aVar.mMc.add(jVar);
        }
        a.a(this.znV).add(aVar);
        a.b(this.znV);
    }
}
