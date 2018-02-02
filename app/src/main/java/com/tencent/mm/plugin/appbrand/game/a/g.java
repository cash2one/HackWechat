package com.tencent.mm.plugin.appbrand.game.a;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.a.f;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.d;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i$b;
import com.tencent.mm.sdk.platformtools.af;
import java.util.HashSet;

public final class g extends c {
    public g(Context context, i$b com_tencent_mm_plugin_fts_d_i_b, int i) {
        super(context, com_tencent_mm_plugin_fts_d_i_b, i);
    }

    protected final a a(af afVar, HashSet<String> hashSet) {
        com.tencent.mm.plugin.fts.a.a.g gVar = new com.tencent.mm.plugin.fts.a.a.g();
        gVar.fDj = this.fDj;
        gVar.mLY = d.mMB;
        gVar.mLZ = this;
        gVar.handler = afVar;
        gVar.mLX = hashSet;
        gVar.mLY = h.iXZ;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(10, gVar);
    }

    protected final void a(h hVar, HashSet<String> hashSet) {
        if (aU(hVar.mMc)) {
            i.a aVar = new i.a();
            aVar.hKY = -15;
            aVar.mOV = hVar.mMc;
            aVar.mMb = hVar.mMb;
            for (j jVar : hVar.mMc) {
                hashSet.add(jVar.mLs);
            }
            if (aVar.mOV.size() > 3) {
                aVar.mOU = true;
                aVar.mOV = aVar.mOV.subList(0, 3);
            }
            this.mOA.add(aVar);
        }
    }

    protected final b a(int i, i.a aVar) {
        int i2 = (i - aVar.mOR) - 1;
        b bVar = null;
        if (i2 < aVar.mOV.size() && i2 >= 0) {
            j jVar = (j) aVar.mOV.get(i2);
            b cVar = new c(i);
            cVar.iVU = jVar;
            cVar.mMb = aVar.mMb;
            cVar.cC(jVar.type, jVar.mLr);
            bVar = cVar;
        }
        if (bVar != null) {
            bVar.mPz = i2 + 1;
        }
        return bVar;
    }

    public final int getType() {
        return f.CTRL_INDEX;
    }
}
