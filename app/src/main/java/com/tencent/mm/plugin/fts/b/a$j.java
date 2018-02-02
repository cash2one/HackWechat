package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class a$j extends f {
    final /* synthetic */ a mMS;

    public a$j(a aVar, g gVar) {
        this.mMS = aVar;
        super(gVar);
    }

    protected final void a(h hVar) {
        hVar.mMb = e.an(this.mLN.fDj, true);
        Cursor a = a.a(this.mMS).a(hVar.mMb, this.mLN.mLU, this.mLN.mLV, true, true);
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        while (a.moveToNext()) {
            k h = new k().h(a);
            if (!this.mLN.mLX.contains(h.mLs)) {
                j jVar;
                if (d.f(c.mKi, h.type)) {
                    jVar = (j) hashMap.get(h.mLs);
                    if (jVar == null || d.c(c.mKt, h.mLr, jVar.mLr) < 0) {
                        hashMap.put(h.mLs, h);
                    }
                } else if (d.f(c.mKk, h.type)) {
                    jVar = (j) hashMap2.get(Long.valueOf(h.mMf));
                    if (jVar == null || d.c(c.mKt, h.mLr, jVar.mLr) < 0) {
                        hashMap2.put(Long.valueOf(h.mMf), h);
                    }
                }
                if (Thread.interrupted()) {
                    a.close();
                    throw new InterruptedException();
                }
            }
        }
        a.close();
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        hVar.mMc = new ArrayList(hashMap.size());
        for (k kVar : hashMap.values()) {
            kVar.aMY();
            kVar.a(hVar.mMb);
            hVar.mMc.add(kVar);
        }
        hVar.mMc.addAll(hashMap2.values());
        if (Thread.interrupted()) {
            throw new InterruptedException();
        } else if (this.mLN.mLY != null) {
            Collections.sort(hVar.mMc, this.mLN.mLY);
        }
    }

    public final String getName() {
        return "SearchContactLogic.SearchTask";
    }

    public final int getId() {
        return 11;
    }
}
