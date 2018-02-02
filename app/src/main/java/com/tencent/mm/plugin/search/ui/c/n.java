package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import java.util.HashSet;
import java.util.List;

public final class n extends c {
    private boolean qeS = false;

    public n(Context context, b bVar, int i) {
        boolean z;
        super(context, bVar, i);
        ar.Hg();
        String str = (String) com.tencent.mm.z.c.CU().get(6, null);
        if (str == null || str.length() <= 0) {
            z = false;
        } else {
            z = true;
        }
        this.qeS = z;
        this.qeS &= bh.PT();
    }

    protected final a a(af afVar, HashSet<String> hashSet) {
        g gVar = new g();
        gVar.mLU = this.qeS ? new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075, 131073, 131074, 262144, 131076} : new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 131075, 262144, 131076};
        gVar.mLW = 3;
        gVar.mLZ = this;
        gVar.handler = afVar;
        gVar.scene = 0;
        gVar.mLX = hashSet;
        if (this.fDj.startsWith("@@")) {
            gVar.fDj = this.fDj.substring(2);
            return ((m) com.tencent.mm.kernel.g.k(m.class)).search(10000, gVar);
        }
        gVar.fDj = this.fDj;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(1, gVar);
    }

    protected final void a(h hVar, HashSet<String> hashSet) {
        for (j jVar : hVar.mMc) {
            hashSet.add(jVar.mLs);
        }
        if (aU(hVar.mMc)) {
            i.a aVar = new i.a();
            aVar.hKY = -8;
            List list = hVar.mMc;
            if (com.tencent.mm.plugin.fts.d.b.aU(list) && list.size() > 3) {
                list = list.subList(0, 3);
            }
            aVar.mOV = list;
            aVar.mOU = false;
            aVar.mMb = hVar.mMb;
            this.mOA.add(aVar);
        }
        d.aS(hVar.mMc);
    }

    protected final com.tencent.mm.plugin.fts.d.a.b a(int i, i.a aVar) {
        com.tencent.mm.plugin.fts.d.a.b a;
        int i2 = (i - aVar.mOR) - 1;
        if (i2 < aVar.mOV.size() && i2 >= 0) {
            j jVar = (j) aVar.mOV.get(i2);
            c cVar = jVar.type == 131075 ? (c) com.tencent.mm.plugin.fts.d.h.a(48, this.context, this.mOy, this.mOz) : (jVar.type == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT || jVar.type == 131073 || jVar.type == 131074) ? (c) com.tencent.mm.plugin.fts.d.h.a(32, this.context, this.mOy, this.mOz) : jVar.type == 262144 ? (c) com.tencent.mm.plugin.fts.d.h.a(64, this.context, this.mOy, this.mOz) : jVar.type == 131076 ? (c) com.tencent.mm.plugin.fts.d.h.a(96, this.context, this.mOy, this.mOz) : null;
            if (cVar != null) {
                a = cVar.a(i, jVar, aVar);
                if (a != null) {
                    a.mPz = i2 + 1;
                }
                return a;
            }
        }
        a = null;
        if (a != null) {
            a.mPz = i2 + 1;
        }
        return a;
    }

    public final int getType() {
        return 16;
    }
}
