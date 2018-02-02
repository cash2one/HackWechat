package com.tencent.mm.plugin.fav.ui.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.d;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.sdk.platformtools.af;
import java.util.HashSet;

public final class c extends com.tencent.mm.plugin.fts.d.c {
    public c(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final a a(af afVar, HashSet<String> hashSet) {
        g gVar = new g();
        gVar.mLR = 2;
        gVar.fDj = this.fDj;
        gVar.mLX = hashSet;
        gVar.handler = afVar;
        gVar.mLZ = this;
        gVar.mLY = d.mMB;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(6, gVar);
    }

    protected final void a(h hVar, HashSet<String> hashSet) {
        if (aU(hVar.mMc)) {
            i.a aVar = new i.a();
            aVar.hKY = -1;
            aVar.mMb = hVar.mMb;
            aVar.mOV = hVar.mMc;
            this.mOA.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.d.a.b a(int i, i.a aVar) {
        int i2 = (i - aVar.mOR) - 1;
        com.tencent.mm.plugin.fts.d.a.b bVar = null;
        if (i2 < aVar.mOV.size() && i2 >= 0) {
            j jVar = (j) aVar.mOV.get(i2);
            com.tencent.mm.plugin.fts.d.a.b aVar2 = new a(i);
            aVar2.iVU = jVar;
            aVar2.mMb = aVar.mMb;
            aVar2.cC(jVar.type, jVar.mLr);
            bVar = aVar2;
        }
        if (bVar != null) {
            bVar.mPz = i2 + 1;
        }
        return bVar;
    }

    public final int getType() {
        return 4176;
    }
}
