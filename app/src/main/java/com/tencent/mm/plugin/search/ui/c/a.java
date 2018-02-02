package com.tencent.mm.plugin.search.ui.c;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.d.c;
import com.tencent.mm.plugin.fts.d.i.b;
import com.tencent.mm.plugin.search.ui.a.l;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public final class a extends c {
    private boolean qeS;

    public a(Context context, b bVar, int i) {
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
        x.d("MicroMsg.FTS.FTSAddFriendUIUnit", "[FTSAddFriendUIUnit doSearchMobile : %s]", new Object[]{Boolean.valueOf(this.qeS)});
    }

    protected final com.tencent.mm.plugin.fts.a.a.a a(af afVar, HashSet<String> hashSet) {
        String str = this.fDj;
        ArrayList arrayList = new ArrayList();
        if (this.qeS) {
            arrayList.add(Integer.valueOf(131073));
            arrayList.add(Integer.valueOf(131074));
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return ((m) g.k(m.class)).search(9, com.tencent.mm.plugin.fts.a.a.g.a(str, iArr, bqn(), -1, hashSet, com.tencent.mm.plugin.fts.a.c.b.mMz, this, afVar));
    }

    private int[] bqn() {
        ArrayList arrayList = new ArrayList();
        if (this.qeS) {
            arrayList.add(Integer.valueOf(16));
        }
        int[] iArr = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            iArr[i] = ((Integer) arrayList.get(i)).intValue();
        }
        return iArr;
    }

    protected final void a(h hVar, HashSet<String> hashSet) {
        List list = hVar.mMc;
        this.mOA.clear();
        com.tencent.mm.plugin.fts.d.i.a aVar = new com.tencent.mm.plugin.fts.d.i.a();
        aVar.hKY = -4;
        aVar.mOS = false;
        aVar.mOY = 1;
        aVar.mMb = hVar.mMb;
        aVar.mOV = new LinkedList();
        this.mOA.add(aVar);
        if (aU(list)) {
            list = d.a(list, com.tencent.mm.plugin.fts.a.c.mKo);
            if (aU(list)) {
                aVar = new com.tencent.mm.plugin.fts.d.i.a();
                aVar.hKY = -11;
                aVar.mOV = list;
                aVar.mMb = hVar.mMb;
                this.mOA.add(aVar);
            }
        }
    }

    protected final com.tencent.mm.plugin.fts.d.a.b a(int i, com.tencent.mm.plugin.fts.d.i.a aVar) {
        int i2 = (i - aVar.mOR) - 1;
        com.tencent.mm.plugin.fts.d.a.b bVar = null;
        if (i2 < aVar.mOV.size() && i2 >= 0) {
            com.tencent.mm.plugin.fts.d.a.b bVar2;
            j jVar = (j) aVar.mOV.get(i2);
            if (jVar.type == 131073 || jVar.type == 131074) {
                bVar = new l(i);
                bVar.iVU = jVar;
                bVar.mMb = aVar.mMb;
                bVar.qeF = true;
                bVar2 = bVar;
            } else {
                bVar2 = null;
            }
            bVar = bVar2;
        } else if (!aVar.mOS && i == 0) {
            bVar = new com.tencent.mm.plugin.search.ui.a.a(i);
            bVar.mMb = aVar.mMb;
        }
        if (bVar != null) {
            bVar.mPz = i2 + 1;
        }
        return bVar;
    }

    public final int getType() {
        return 8192;
    }
}
