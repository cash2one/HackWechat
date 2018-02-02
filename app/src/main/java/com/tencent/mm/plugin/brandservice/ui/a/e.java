package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.sdk.platformtools.af;
import java.util.HashSet;

public final class e extends c {
    public e(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    protected final a a(af afVar, HashSet<String> hashSet) {
        return ((m) g.k(m.class)).search(2, com.tencent.mm.plugin.fts.a.a.g.a(this.fDj, new int[]{131076}, null, 4, hashSet, com.tencent.mm.plugin.fts.a.c.b.mMz, this, afVar));
    }

    protected final void a(h hVar, HashSet<String> hashSet) {
        if (aU(hVar.mMc)) {
            i.a aVar = new i.a();
            aVar.hKY = -7;
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
            j jVar = (j) aVar.mOV.get(i2);
            com.tencent.mm.plugin.fts.d.a.b a = a(i, jVar, aVar);
            a.cC(jVar.type, jVar.mLr);
            bVar = a;
        }
        if (bVar != null) {
            bVar.mPz = i2 + 1;
        }
        return bVar;
    }

    public final int getType() {
        return 96;
    }

    public final com.tencent.mm.plugin.fts.d.a.b a(int i, j jVar, i.a aVar) {
        com.tencent.mm.plugin.fts.d.a.b aVar2 = new a(i);
        aVar2.iVU = jVar;
        aVar2.mMb = aVar.mMb;
        aVar2.cC(jVar.type, jVar.mLr);
        return aVar2;
    }
}
