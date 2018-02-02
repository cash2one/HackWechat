package com.tencent.mm.plugin.appbrand.f;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.d;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashSet;
import java.util.List;

public final class f extends c {
    public f(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final a a(af afVar, HashSet<String> hashSet) {
        g gVar = new g();
        gVar.fDj = this.fDj;
        gVar.mLY = d.mMB;
        gVar.mLZ = this;
        gVar.handler = afVar;
        gVar.mLX = hashSet;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(7, gVar);
    }

    protected final void a(h hVar, HashSet<String> hashSet) {
        List list = hVar.mMc;
        if (!(list == null || list.isEmpty())) {
            com.tencent.mm.modelsns.d dVar = new com.tencent.mm.modelsns.d();
            String str = this.fDj;
            if (str != null) {
                str = str.replaceAll(",", " ");
            }
            dVar.q("20KeyWordId", str + ",");
            dVar.q("21ViewType", "2,");
            dVar.q("22OpType", "1,");
            dVar.q("23ResultCount", list.size() + ",");
            dVar.q("24ClickPos", ",");
            dVar.q("25ClickAppUserName", ",");
            x.i("MicroMsg.FTSWeAppDetailUIUnit", "report oreh LocalSearchWeApp(13963), %s", new Object[]{dVar.Sz()});
            com.tencent.mm.plugin.report.service.g.pQN.h(13963, new Object[]{dVar});
        }
        if (aU(hVar.mMc)) {
            i.a aVar = new i.a();
            aVar.hKY = -13;
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
            com.tencent.mm.plugin.fts.d.a.b dVar = new d(i);
            dVar.iVU = jVar;
            dVar.mMb = aVar.mMb;
            dVar.cC(jVar.type, jVar.mLr);
            bVar = dVar;
        }
        if (bVar != null) {
            bVar.mPz = i2 + 1;
        }
        return bVar;
    }

    public final int getType() {
        return 4208;
    }
}
