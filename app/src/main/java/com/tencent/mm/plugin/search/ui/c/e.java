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
import com.tencent.mm.plugin.search.ui.a.l;
import com.tencent.mm.plugin.search.ui.a.p;
import com.tencent.mm.sdk.platformtools.af;
import java.util.HashSet;

public final class e extends c {
    public e(Context context, i$b com_tencent_mm_plugin_fts_d_i_b, int i) {
        super(context, com_tencent_mm_plugin_fts_d_i_b, i);
    }

    protected final a a(af afVar, HashSet<String> hashSet) {
        g gVar = new g();
        gVar.mLR = 64;
        gVar.fDj = this.fDj;
        gVar.mLU = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
        gVar.mLW = 3;
        gVar.mLY = b.mMz;
        gVar.mLX = hashSet;
        gVar.mLZ = this;
        gVar.handler = afVar;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(2, gVar);
    }

    protected final void a(h hVar, HashSet<String> hashSet) {
        i.a aVar = new i.a();
        aVar.hKY = -4;
        aVar.mOV = hVar.mMc;
        aVar.mOS = aU(hVar.mMc);
        aVar.mMb = hVar.mMb;
        if (aVar.mOV.size() > 3) {
            aVar.mOU = true;
            aVar.mOV = aVar.mOV.subList(0, 3);
        }
        if (aU(hVar.mMc)) {
            this.mOA.add(aVar);
        }
    }

    protected final com.tencent.mm.plugin.fts.d.a.b a(int i, i.a aVar) {
        com.tencent.mm.plugin.fts.d.a.b bVar;
        int i2 = 0;
        if (aVar.mOS) {
            int i3 = (i - aVar.mOR) - 1;
            if (i3 >= aVar.mOV.size() || i3 < 0) {
                i2 = i3;
                bVar = null;
            } else {
                j jVar = (j) aVar.mOV.get(i3);
                com.tencent.mm.plugin.fts.d.a.b a = a(i, jVar, aVar);
                if (a != null) {
                    a.cC(jVar.type, jVar.mLr);
                }
                i2 = i3;
                bVar = a;
            }
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.mPz = i2 + 1;
        }
        return bVar;
    }

    public final int getType() {
        return 32;
    }

    public final com.tencent.mm.plugin.fts.d.a.b a(int i, j jVar, i.a aVar) {
        com.tencent.mm.plugin.fts.d.a.b pVar;
        if (jVar.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
            pVar = new p(i);
            pVar.iVU = jVar;
            pVar.mMb = aVar.mMb;
            pVar.cC(jVar.type, jVar.mLr);
            return pVar;
        } else if (jVar.type != 131073 && jVar.type != 131074) {
            return null;
        } else {
            pVar = new l(i);
            pVar.iVU = jVar;
            pVar.mMb = aVar.mMb;
            pVar.cC(jVar.type, jVar.mLr);
            return pVar;
        }
    }
}
