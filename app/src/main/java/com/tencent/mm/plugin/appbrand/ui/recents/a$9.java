package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.plugin.appbrand.q.i;
import com.tencent.mm.plugin.appbrand.q.j.b;
import com.tencent.mm.plugin.appbrand.q.j.e;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.ArrayList;
import java.util.List;

class a$9 implements Runnable {
    final /* synthetic */ a jPj;
    final /* synthetic */ i jPp;
    final /* synthetic */ b jPq;

    a$9(a aVar, i iVar, b bVar) {
        this.jPj = aVar;
        this.jPp = iVar;
        this.jPq = bVar;
    }

    public final void run() {
        a.a(this.jPj).clear();
        a.a(this.jPj).addAll(this.jPp);
        ag.Df(-8);
        b bVar = this.jPq;
        k d = a.d(this.jPj);
        i iVar = d instanceof i ? (i) d : new i(d);
        List arrayList = new ArrayList();
        int i = bVar.jSk;
        int size = bVar.jSg.size() - 1;
        int i2 = bVar.jSl;
        int i3 = i;
        while (size >= 0) {
            e eVar = (e) bVar.jSg.get(size);
            int i4 = eVar.size;
            int i5 = eVar.x + i4;
            int i6 = eVar.y + i4;
            if (i5 < i3) {
                bVar.b(arrayList, iVar, i5, i3 - i5, i5);
            }
            if (i6 < i2) {
                bVar.a(arrayList, iVar, i5, i2 - i6, i6);
            }
            for (i5 = i4 - 1; i5 >= 0; i5--) {
                if ((bVar.jSh[eVar.x + i5] & 31) == 2) {
                    iVar.d(eVar.x + i5, 1, bVar.jSj.bT(eVar.x + i5, eVar.y + i5));
                }
            }
            i = eVar.x;
            size--;
            i2 = eVar.y;
            i3 = i;
        }
        iVar.alK();
    }
}
