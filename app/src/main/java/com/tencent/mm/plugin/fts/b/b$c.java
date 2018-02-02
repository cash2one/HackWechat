package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

class b$c extends f {
    final /* synthetic */ b mNv;

    private b$c(b bVar, g gVar) {
        this.mNv = bVar;
        super(gVar);
    }

    protected final void a(h hVar) {
        hVar.mMb = e.an(this.mLN.fDj, true);
        hVar.mMc = new ArrayList();
        HashSet hashSet = new HashSet();
        Cursor a = this.mNv.mNt.a(hVar.mMb, c.mKc, this.mLN.mLV, true, true);
        while (a.moveToNext()) {
            k kVar = new k();
            kVar.h(a);
            if (!(hashSet.contains(Long.valueOf(kVar.mMf)) || this.mLN.mLX.contains(kVar.mLs))) {
                kVar.aMY();
                hVar.mMc.add(kVar);
                hashSet.add(Long.valueOf(kVar.mMf));
            }
        }
        if (a != null) {
            a.close();
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (this.mLN.mLY != null) {
            Collections.sort(hVar.mMc, this.mLN.mLY);
        }
        for (j jVar : hVar.mMc) {
            jVar.userData = this.mNv.mNt.qd((int) jVar.mMf);
        }
    }

    public final String getName() {
        return "SearchFeatureTask";
    }

    public final int getId() {
        return 12;
    }
}
