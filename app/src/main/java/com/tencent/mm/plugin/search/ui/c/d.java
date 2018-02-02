package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.b;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i$b;
import com.tencent.mm.plugin.search.ui.a.p;
import com.tencent.mm.sdk.platformtools.af;
import java.util.HashSet;

public final class d extends c {
    public d(Context context, i$b com_tencent_mm_plugin_fts_d_i_b, int i) {
        super(context, com_tencent_mm_plugin_fts_d_i_b, i);
    }

    protected final a a(af afVar, HashSet<String> hashSet) {
        g gVar = new g();
        gVar.fDj = this.fDj;
        gVar.mLU = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
        gVar.mLY = b.mMz;
        gVar.mLX = hashSet;
        gVar.mLZ = this;
        gVar.handler = afVar;
        gVar.mLR = 16;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(2, gVar);
    }

    protected final void a(h hVar, HashSet<String> hashSet) {
        if (aU(hVar.mMc)) {
            i.a aVar = new i.a();
            aVar.hKY = -4;
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
            com.tencent.mm.plugin.fts.d.a.b pVar = new p(i);
            pVar.iVU = jVar;
            pVar.mMb = aVar.mMb;
            pVar.cC(jVar.type, jVar.mLr);
            bVar = pVar;
        }
        if (bVar != null) {
            bVar.mPz = i2 + 1;
        }
        return bVar;
    }

    public final int getType() {
        return 4112;
    }
}
