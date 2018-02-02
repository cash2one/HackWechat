package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.a.c;
import com.tencent.mm.plugin.fts.d.a.d;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i$b;
import com.tencent.mm.plugin.search.ui.a.n;
import com.tencent.mm.sdk.platformtools.af;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class m extends l {
    public String mLT;

    public m(Context context, i$b com_tencent_mm_plugin_fts_d_i_b, int i) {
        super(context, com_tencent_mm_plugin_fts_d_i_b, i);
    }

    public int getType() {
        return 176;
    }

    protected a a(af afVar, HashSet<String> hashSet) {
        this.qeT = false;
        g gVar = new g();
        gVar.fDj = this.fDj;
        gVar.mLY = e.mMC;
        gVar.mLT = this.mLT;
        gVar.mLZ = this;
        gVar.handler = afVar;
        gVar.mLR = 10;
        return ((com.tencent.mm.plugin.fts.a.m) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.fts.a.m.class)).search(3, gVar);
    }

    protected final void a(h hVar, HashSet<String> hashSet) {
        switch (hVar.bjW) {
            case 0:
                if (hVar.mMc.size() > 0) {
                    int i = 0;
                    while (i < hVar.mMc.size()) {
                        i.a aVar = new i.a();
                        aVar.mOS = true;
                        aVar.mOX = (j) hVar.mMc.get(i);
                        aVar.mMb = hVar.mMb;
                        aVar.mOV = (List) aVar.mOX.userData;
                        if (aVar.mOV.size() <= 3 || i == hVar.mMc.size() - 1) {
                            aVar.mOW = false;
                            aVar.mOU = false;
                        } else {
                            aVar.mOW = true;
                            aVar.mOU = true;
                        }
                        this.mOA.add(aVar);
                        i++;
                    }
                    return;
                }
                i.a aVar2 = new i.a();
                aVar2.hKY = -2;
                aVar2.mMb = hVar.mMb;
                aVar2.mOS = false;
                j jVar = new j();
                jVar.mLs = "no_result​";
                aVar2.mOV = new ArrayList();
                aVar2.mOV.add(jVar);
                this.mOA.add(aVar2);
                return;
            default:
                return;
        }
    }

    public final int qe(int i) {
        int size = this.mOA.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            i.a aVar = (i.a) this.mOA.get(i3);
            aVar.mOR = i2;
            if (aVar.mOS) {
                i2++;
            }
            if (aVar.mOV.size() > 3) {
                if (aVar.mOW) {
                    i2 += 3;
                } else {
                    i2 += aVar.mOV.size();
                }
                aVar.mOT = i2;
                if (aVar.mOU) {
                    i2++;
                }
            } else {
                i2 += aVar.mOV.size();
                aVar.mOT = i2;
            }
        }
        return i2;
    }

    protected c b(int i, i.a aVar) {
        c mVar = new com.tencent.mm.plugin.search.ui.a.m(i);
        mVar.qdU = aVar.mOX;
        mVar.mMb = mVar.qdU.mMb;
        return mVar;
    }

    protected final com.tencent.mm.plugin.fts.d.a.e c(int i, i.a aVar) {
        com.tencent.mm.plugin.fts.d.a.e aVar2 = new com.tencent.mm.plugin.fts.d.a.a(i);
        aVar2.mPo = R.l.ekw;
        aVar2.mPp = aVar.mOW;
        return aVar2;
    }

    protected b a(int i, i.a aVar) {
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
        b nVar = new n(i);
        nVar.iVU = jVar;
        nVar.qdU = aVar.mOX;
        nVar.mMb = nVar.iVU.mMb;
        nVar.mPx = -14;
        nVar.showType = 2;
        nVar.cC(jVar.type, jVar.mLr);
        return nVar;
    }

    public final boolean a(View view, b bVar, boolean z) {
        boolean z2 = false;
        super.a(view, bVar, z);
        if (bVar instanceof com.tencent.mm.plugin.fts.d.a.a) {
            int i = 0;
            while (i < this.mOA.size()) {
                i.a aVar = (i.a) this.mOA.get(i);
                if (aVar.mOT == bVar.position) {
                    if (!aVar.mOW) {
                        z2 = true;
                    }
                    aVar.mOW = z2;
                } else {
                    i++;
                }
            }
        }
        return true;
    }

    protected int bqo() {
        return 2;
    }
}
