package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.a.d;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i$b;
import com.tencent.mm.sdk.platformtools.af;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public final class k extends l {
    public k(Context context, i$b com_tencent_mm_plugin_fts_d_i_b, int i) {
        super(context, com_tencent_mm_plugin_fts_d_i_b, i);
    }

    protected final a a(af afVar, HashSet<String> hashSet) {
        this.qeT = false;
        g gVar = new g();
        gVar.fDj = this.fDj;
        gVar.mLX = hashSet;
        gVar.mLZ = this;
        gVar.handler = afVar;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(3, gVar);
    }

    protected final void a(h hVar, HashSet<String> hashSet) {
        List list = hVar.mMc;
        if (aU(list)) {
            if (list.size() > 0) {
                j jVar = (j) list.get(0);
                if (jVar.mLs.equals("create_talker_message​")) {
                    i.a aVar = new i.a();
                    aVar.mOS = false;
                    aVar.mOV = new ArrayList();
                    aVar.mOV.add(jVar);
                    aVar.mMb = hVar.mMb;
                    aVar.hKY = -2;
                    this.mOA.add(aVar);
                    list.remove(0);
                }
            }
            i.a aVar2 = new i.a();
            aVar2.hKY = -2;
            aVar2.mMb = hVar.mMb;
            if (list.size() == 0) {
                aVar2.mOS = false;
                j jVar2 = new j();
                jVar2.mLs = "no_result​";
                aVar2.mOV = new ArrayList();
                aVar2.mOV.add(jVar2);
            } else {
                aVar2.mOV = list;
            }
            this.mOA.add(aVar2);
        }
    }

    protected final b a(int i, i.a aVar) {
        int i2;
        int i3 = i - aVar.mOR;
        if (aVar.mOS) {
            i2 = i3 - 1;
        } else {
            i2 = i3;
        }
        b bVar = null;
        if (i2 < aVar.mOV.size() && i2 >= 0) {
            j jVar = (j) aVar.mOV.get(i2);
            if (jVar.mLs.equals("create_talker_message​")) {
                bVar = new com.tencent.mm.plugin.search.ui.a.h(i);
                bVar.mPw = false;
                this.qeT = true;
            } else if (jVar.mLs.equals("no_result​")) {
                bVar = new d(i);
            } else {
                b kVar = new com.tencent.mm.plugin.search.ui.a.k(i);
                kVar.iVU = jVar;
                kVar.cC(jVar.type, jVar.mLr);
                bVar = kVar;
            }
        }
        if (bVar != null) {
            bVar.mPz = i2 + 1;
            bVar.mMb = aVar.mMb;
        }
        return bVar;
    }

    public final int getType() {
        return 4160;
    }
}
