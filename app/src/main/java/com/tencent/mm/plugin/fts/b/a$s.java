package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class a$s extends f {
    final /* synthetic */ a mMS;

    public a$s(a aVar, g gVar) {
        this.mMS = aVar;
        super(gVar);
    }

    protected final void a(h hVar) {
        hVar.mMb = e.an(this.mLN.fDj, true);
        a a = a.a(this.mMS);
        e eVar = hVar.mMb;
        String aMX = eVar.aMX();
        long currentTimeMillis = System.currentTimeMillis() - 1105032704;
        long size = (long) eVar.mLE.size();
        aMX = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), MMContactRank(%s, timestamp / 1000 - %d / 1000, subtype, ?, %d) AS Rank FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type = 131072 ORDER BY Rank ;", new Object[]{a.aMR(), a.aMS(), Long.valueOf(size), a.aMS(), Long.valueOf(currentTimeMillis), Long.valueOf(size), a.aMR(), a.aMS(), a.aMR(), a.aMS(), a.aMS(), aMX});
        Cursor rawQuery = a.mJR.rawQuery(aMX, new String[]{eVar.mLB});
        List<k> arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.mLN.mLX);
        long j = 0;
        while (rawQuery.moveToNext()) {
            k g = new k().g(rawQuery);
            if (hashSet.add(g.mLs)) {
                if (j < g.mMn) {
                    if (arrayList.size() > this.mLN.mLW) {
                        break;
                    }
                    j = g.mMn;
                    arrayList.add(g);
                } else {
                    arrayList.add(g);
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
        return "SearchTopContactInnerRankTask";
    }

    public final int getId() {
        return 26;
    }
}
