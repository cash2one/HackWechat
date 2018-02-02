package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.sdk.platformtools.af;
import java.util.HashSet;

public final class h extends c {
    public h(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final a a(af afVar, HashSet<String> hashSet) {
        g gVar = new g();
        gVar.fDj = this.fDj;
        gVar.handler = afVar;
        gVar.mLX = hashSet;
        gVar.mLZ = this;
        gVar.mLY = com.tencent.mm.plugin.fts.a.c.c.mMA;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(4, gVar);
    }

    protected final void a(com.tencent.mm.plugin.fts.a.a.h hVar, HashSet<String> hashSet) {
        if (aU(hVar.mMc)) {
            i.a aVar = new i.a();
            aVar.hKY = -6;
            aVar.mMb = hVar.mMb;
            aVar.mOV = hVar.mMc;
            this.mOA.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.d.a.b a(int i, i.a aVar) {
        int i2 = (i - aVar.mOR) - 1;
        com.tencent.mm.plugin.fts.d.a.b bVar = null;
        if (i2 < aVar.mOV.size() && i2 >= 0) {
            bVar = a(i, (j) aVar.mOV.get(i2), aVar);
        }
        if (bVar != null) {
            bVar.mPz = i2 + 1;
        }
        return bVar;
    }

    public final int getType() {
        return 64;
    }

    public final com.tencent.mm.plugin.fts.d.a.b a(int i, j jVar, i.a aVar) {
        com.tencent.mm.plugin.fts.d.a.b iVar = new com.tencent.mm.plugin.search.ui.a.i(i);
        iVar.iVU = jVar;
        iVar.mMb = aVar.mMb;
        iVar.cC(jVar.type, jVar.mLr);
        return iVar;
    }
}
