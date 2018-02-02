package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i$b;
import com.tencent.mm.plugin.search.ui.a.o;
import com.tencent.mm.sdk.platformtools.af;
import java.util.HashSet;

public final class c extends com.tencent.mm.plugin.fts.d.c {
    public c(Context context, i$b com_tencent_mm_plugin_fts_d_i_b, int i) {
        super(context, com_tencent_mm_plugin_fts_d_i_b, i);
    }

    protected final a a(af afVar, HashSet<String> hashSet) {
        g gVar = new g();
        gVar.mLR = 96;
        gVar.mLW = 3;
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
            aVar.mOV = hVar.mMc;
            aVar.hKY = -3;
            aVar.mMb = hVar.mMb;
            if (aVar.mOV.size() > 3) {
                if (((j) aVar.mOV.get(3)).mLs.equals("create_chatroom​")) {
                    boolean z;
                    if (aVar.mOV.size() > 4) {
                        z = true;
                    } else {
                        z = false;
                    }
                    aVar.mOU = z;
                    aVar.mOV = aVar.mOV.subList(0, 4);
                } else {
                    aVar.mOU = true;
                    aVar.mOV = aVar.mOV.subList(0, 3);
                }
            }
            this.mOA.add(aVar);
        }
    }

    protected final b a(int i, i.a aVar) {
        b gVar;
        int i2 = (i - aVar.mOR) - 1;
        if (i2 < aVar.mOV.size() && i2 >= 0) {
            j jVar = (j) aVar.mOV.get(i2);
            if (jVar.mLs.equals("create_chatroom​")) {
                gVar = new com.tencent.mm.plugin.search.ui.a.g(i);
                gVar.mMb = aVar.mMb;
            } else if (jVar.type == 131075) {
                b a = a(i, jVar, aVar);
                a.cC(jVar.type, jVar.mLr);
                gVar = a;
            }
            if (gVar != null) {
                gVar.mPz = i2 + 1;
            }
            return gVar;
        }
        gVar = null;
        if (gVar != null) {
            gVar.mPz = i2 + 1;
        }
        return gVar;
    }

    public final int getType() {
        return 48;
    }

    public final b a(int i, j jVar, i.a aVar) {
        b oVar = new o(i);
        oVar.iVU = jVar;
        oVar.mMb = aVar.mMb;
        oVar.cC(jVar.type, jVar.mLr);
        return oVar;
    }
}
