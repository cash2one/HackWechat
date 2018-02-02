package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.search.ui.a.o;
import com.tencent.mm.sdk.platformtools.af;
import java.util.HashSet;

public final class b extends c {
    public b(Context context, com.tencent.mm.plugin.fts.d.i.b bVar, int i) {
        super(context, bVar, i);
    }

    protected final a a(af afVar, HashSet<String> hashSet) {
        g gVar = new g();
        gVar.mLR = 32;
        gVar.fDj = this.fDj;
        gVar.mLX = hashSet;
        gVar.mLY = com.tencent.mm.plugin.fts.a.c.a.mMy;
        gVar.mLZ = this;
        gVar.handler = afVar;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(2, gVar);
    }

    protected final void a(h hVar, HashSet<String> hashSet) {
        if (aU(hVar.mMc)) {
            i.a aVar = new i.a();
            aVar.hKY = -3;
            aVar.mOV = hVar.mMc;
            aVar.mMb = hVar.mMb;
            aVar.mOU = false;
            this.mOA.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.d.a.b a(int i, i.a aVar) {
        int i2 = (i - aVar.mOR) - 1;
        com.tencent.mm.plugin.fts.d.a.b bVar = null;
        if (i2 < aVar.mOV.size() && i2 >= 0) {
            j jVar = (j) aVar.mOV.get(i2);
            if (jVar.mLs.equals("create_chatroom​")) {
                bVar = new com.tencent.mm.plugin.search.ui.a.g(i);
                bVar.mMb = aVar.mMb;
            } else {
                com.tencent.mm.plugin.fts.d.a.b oVar = new o(i);
                oVar.iVU = jVar;
                oVar.mMb = aVar.mMb;
                oVar.cC(jVar.type, jVar.mLr);
                bVar = oVar;
            }
        }
        if (bVar != null) {
            bVar.mPz = i2 + 1;
        }
        return bVar;
    }

    public final int getType() {
        return 4128;
    }
}
