package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.a.c;
import com.tencent.mm.plugin.fts.d.a.d;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.search.ui.a.f;
import com.tencent.mm.sdk.platformtools.af;
import java.util.HashSet;

public final class g extends m {
    public String mLS;
    public int showType;
    public String talker;

    public g(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    public final int getType() {
        return ar.CTRL_INDEX;
    }

    protected final a a(af afVar, HashSet<String> hashSet) {
        this.qeT = false;
        com.tencent.mm.plugin.fts.a.a.g gVar = new com.tencent.mm.plugin.fts.a.a.g();
        gVar.fDj = this.fDj;
        gVar.mLY = e.mMC;
        gVar.mLS = this.mLS;
        gVar.mLT = this.mLT;
        gVar.talker = this.talker;
        gVar.mLZ = this;
        gVar.handler = afVar;
        gVar.mLR = 11;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(3, gVar);
    }

    protected final c b(int i, i.a aVar) {
        c eVar = new com.tencent.mm.plugin.search.ui.a.e(i);
        eVar.qdU = aVar.mOX;
        eVar.mLS = this.mLS;
        return eVar;
    }

    protected final com.tencent.mm.plugin.fts.d.a.b a(int i, i.a aVar) {
        int i2;
        if (aVar.mOS) {
            i2 = (i - aVar.mOR) - 1;
        } else {
            i2 = i - aVar.mOR;
        }
        if (i2 < 0 || i2 >= aVar.mOV.size()) {
            return null;
        }
        j jVar = (j) aVar.mOV.get(i2);
        if (jVar.mLs.equals("no_result​")) {
            return new d(i);
        }
        com.tencent.mm.plugin.fts.d.a.b fVar = new f(i);
        fVar.iVU = jVar;
        fVar.mMb = fVar.iVU.mMb;
        fVar.cC(jVar.type, jVar.mLr);
        return fVar;
    }

    public final int bqo() {
        return this.showType;
    }
}
