package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class a$q extends f {
    final /* synthetic */ a mMS;

    public a$q(a aVar, g gVar) {
        this.mMS = aVar;
        super(gVar);
    }

    protected final void a(h hVar) {
        hVar.mMb = e.an(this.mLN.fDj, true);
        a a = a.a(this.mMS);
        e eVar = hVar.mMb;
        int[] iArr = this.mLN.mLU;
        String aMX = eVar.aMX();
        String str = (iArr == null || iArr.length <= 0) ? "" : " AND type IN " + d.i(iArr);
        long size = (long) eVar.mLE.size();
        Cursor rawQuery = a.mJR.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + str + " AND status >= 0 ORDER BY subtype;", new Object[]{a.aMR(), a.aMS(), Long.valueOf(size), a.aMR(), a.aMS(), a.aMR(), a.aMS(), a.aMS(), aMX}), null);
        List<k> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.mLN.mLX);
        int i = 0;
        while (rawQuery.moveToNext()) {
            if (hashSet.add(rawQuery.getString(3))) {
                k h = new k().h(rawQuery);
                if (i < h.mLr) {
                    if (arrayList.size() > this.mLN.mLW) {
                        break;
                    }
                    i = h.mLr;
                    arrayList.add(h);
                } else {
                    arrayList.add(h);
                }
                if (Thread.interrupted()) {
                    rawQuery.close();
                    throw new InterruptedException("Task is Cancel: " + this.mLN.fDj);
                }
            }
        }
        rawQuery.close();
        hVar.mMc = new ArrayList();
        for (k kVar : arrayList) {
            kVar.aMY();
            kVar.a(hVar.mMb);
            hVar.mMc.add(kVar);
        }
        if (this.mLN.mLY != null) {
            Collections.sort(hVar.mMc, this.mLN.mLY);
        }
    }

    public final String getName() {
        return "SearchContactTask";
    }

    public final int getId() {
        return 20;
    }
}
