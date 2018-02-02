package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import android.view.View;
import com.tencent.mm.bc.e;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.a.b;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i;
import com.tencent.mm.plugin.fts.d.i$b;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.search.ui.a.k;
import com.tencent.mm.sdk.platformtools.af;
import java.util.HashSet;

public class l extends c {
    protected boolean qeT = false;

    public l(Context context, i$b com_tencent_mm_plugin_fts_d_i_b, int i) {
        super(context, com_tencent_mm_plugin_fts_d_i_b, i);
    }

    protected a a(af afVar, HashSet<String> hashSet) {
        this.qeT = false;
        g gVar = new g();
        gVar.fDj = this.fDj;
        gVar.mLX = hashSet;
        gVar.mLZ = this;
        gVar.handler = afVar;
        gVar.mLR = 1;
        gVar.mLW = 3;
        return ((m) com.tencent.mm.kernel.g.k(m.class)).search(3, gVar);
    }

    protected void a(h hVar, HashSet<String> hashSet) {
        if (aU(hVar.mMc)) {
            i.a aVar = new i.a();
            aVar.hKY = -2;
            aVar.mMb = hVar.mMb;
            aVar.mOV = hVar.mMc;
            if (aVar.mOV.size() > 3) {
                if (((j) hVar.mMc.get(3)).mLs.equals("create_talker_message​")) {
                    aVar.mOU = false;
                    aVar.mOV = aVar.mOV.subList(0, 4);
                } else {
                    aVar.mOU = true;
                    aVar.mOV = aVar.mOV.subList(0, 3);
                }
            } else if (hVar.mMc.size() == 1 && ((j) hVar.mMc.get(0)).mLs.equals("create_talker_message​")) {
                aVar.mOS = false;
            }
            this.mOA.add(aVar);
        }
    }

    protected b a(int i, i.a aVar) {
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
                b hVar = new com.tencent.mm.plugin.search.ui.a.h(i);
                hVar.qej = aVar.mOV.size() == 1;
                this.qeT = true;
                bVar = hVar;
            } else {
                b kVar = new k(i);
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

    public int getType() {
        return MMGIFException.D_GIF_ERR_IMAGE_DEFECT;
    }

    public boolean a(View view, b bVar, boolean z) {
        if (bVar instanceof k) {
            e.a(bVar, bqo(), this.qeT);
        }
        return false;
    }

    protected int bqo() {
        return 0;
    }
}
