package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.sdk.platformtools.af;
import java.util.HashSet;

public final class j extends c {
    public j(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final a a(af afVar, HashSet<String> hashSet) {
        g gVar = new g();
        gVar.fDj = this.fDj;
        gVar.mLZ = this;
        gVar.handler = afVar;
        gVar.mLX = hashSet;
        gVar.mLY = com.tencent.mm.plugin.fts.a.c.c.mMA;
        gVar.mLW = 3;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(5, gVar);
    }

    protected final void a(h hVar, HashSet<String> hashSet) {
        if (aU(hVar.mMc)) {
            i.a aVar = new i.a();
            aVar.hKY = -5;
            aVar.mOV = hVar.mMc;
            aVar.mMb = hVar.mMb;
            if (aVar.mOV.size() > 3) {
                aVar.mOU = true;
                aVar.mOV = aVar.mOV.subList(0, 3);
            }
            this.mOA.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.d.a.b a(int i, i.a aVar) {
        int i2 = (i - aVar.mOR) - 1;
        com.tencent.mm.plugin.fts.d.a.b bVar = null;
        if (i2 < aVar.mOV.size() && i2 >= 0) {
            com.tencent.mm.plugin.fts.a.a.j jVar = (com.tencent.mm.plugin.fts.a.a.j) aVar.mOV.get(i2);
            com.tencent.mm.plugin.fts.d.a.b jVar2 = new com.tencent.mm.plugin.search.ui.a.j(i);
            jVar2.iVU = jVar;
            jVar2.mMb = aVar.mMb;
            jVar2.cC(jVar.type, jVar.mLr);
            bVar = jVar2;
        }
        if (bVar != null) {
            bVar.mPz = i2 + 1;
        }
        return bVar;
    }

    public final int getType() {
        return 80;
    }
}
