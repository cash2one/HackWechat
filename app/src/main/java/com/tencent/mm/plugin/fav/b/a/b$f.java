package com.tencent.mm.plugin.fav.b.a;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.k;
import java.util.ArrayList;
import java.util.HashSet;

class b$f extends f {
    final /* synthetic */ b mop;

    b$f(b bVar, g gVar) {
        this.mop = bVar;
        super(gVar);
    }

    protected final void a(h hVar) {
        hVar.mMb = e.an(this.mLN.fDj, true);
        a aVar = this.mop.mom;
        int i = this.mLN.mLW + 1;
        String aMX = hVar.mMb.aMX();
        Cursor rawQuery = aVar.mJR.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' ORDER BY -timestamp, subtype limit " + (i + 1) + ";", new Object[]{aVar.aMR(), aVar.aMR(), aVar.aMS(), aVar.aMR(), aVar.aMS(), aVar.aMS(), aMX}), null);
        hVar.mMc = new ArrayList();
        HashSet hashSet = new HashSet();
        while (rawQuery.moveToNext()) {
            if (hashSet.add(String.valueOf(rawQuery.getLong(3)))) {
                hVar.mMc.add(new k().h(rawQuery));
                if (hVar.mMc.size() > this.mLN.mLW) {
                    break;
                } else if (Thread.interrupted()) {
                    rawQuery.close();
                    throw new InterruptedException();
                }
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
    }

    public final String getName() {
        return "SearchTopFavoriteTask";
    }

    public final int getId() {
        return 9;
    }
}
