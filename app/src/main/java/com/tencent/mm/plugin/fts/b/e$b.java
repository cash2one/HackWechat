package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.c.b;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

class e$b extends f {
    final /* synthetic */ e mOb;

    public e$b(e eVar, g gVar) {
        this.mOb = eVar;
        super(gVar);
    }

    protected final void a(h hVar) {
        hVar.mMb = e.an(this.mLN.fDj, true);
        x.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "MatchQuery %s", new Object[]{hVar.mMb.aMX().replaceAll("​", ",")});
        HashSet hashSet = new HashSet();
        hashSet.addAll(this.mLN.mLX);
        hVar.mMc = new ArrayList();
        a aVar = this.mOb.mNX;
        e eVar = hVar.mMb;
        int[] iArr = this.mLN.mLU;
        int i = this.mLN.scene;
        int size = this.mLN.mLW + this.mLN.mLX.size();
        String str = eVar.mLA + '%';
        String aMX = eVar.aMX();
        String str2 = "query LIKE ?";
        aMX = String.format("AND %s MATCH '%s'", new Object[]{aVar.aMS(), aMX});
        String str3 = "AND type IN " + d.i(iArr);
        String str4 = "AND status >= 0 AND score >= 3";
        String str5 = size > 0 ? "LIMIT " + size : "";
        long size2 = (long) eVar.mLE.size();
        Cursor rawQuery = aVar.mJR.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype), query, scene FROM %s, %s WHERE %s %s %s %s %s AND %s.docid = %s.rowid ORDER BY score desc %s;", new Object[]{aVar.aMR(), aVar.aMS(), Long.valueOf(size2), aVar.aMS(), aVar.aMR(), str2, aMX, str3, "AND scene=?", str4, aVar.aMR(), aVar.aMS(), str5}), new String[]{str, String.valueOf(i)});
        while (rawQuery.moveToNext()) {
            k h;
            try {
                h = new k().h(rawQuery);
                if (hashSet.add(h.mLs)) {
                    h.aMY();
                    h.userData = "";
                    if (h.type == 262144) {
                        h.userData = ((b) ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSIndexStorage(17)).qd((int) h.mMf);
                        if (h.userData == null) {
                            continue;
                        }
                    }
                    hVar.mMc.add(h);
                    if (hVar.mMc.size() >= this.mLN.mLW) {
                        break;
                    }
                }
            } catch (Throwable th) {
                rawQuery.close();
            }
        }
        rawQuery.close();
        x.d("MicroMsg.FTS.FTS5SearchTopHitsLogic", "History TopHits %s", new Object[]{Integer.valueOf(hVar.mMc.size())});
        if (hVar.mMb.mLC.length > 1) {
            if (hVar.mMc.size() > 2) {
                hVar.mMc = hVar.mMc.subList(0, 2);
            }
            hashSet.clear();
            for (int i2 = 0; i2 < hVar.mMc.size(); i2++) {
                hashSet.add(((j) hVar.mMc.get(i2)).mLs);
            }
            HashSet hashSet2 = new HashSet();
            a aVar2 = this.mOb.mNX;
            eVar = hVar.mMb;
            int[] iArr2 = this.mLN.mLU;
            size = this.mLN.scene;
            int size3 = this.mLN.mLW + this.mLN.mLX.size();
            String aMX2 = eVar.aMX();
            Cursor rawQuery2 = aVar2.mJR.rawQuery(String.format("SELECT aux_index FROM %s, %s WHERE %s.docid = %s.rowid AND query = ? AND scene = " + size + (" AND type IN " + d.i(iArr2)) + " AND status >= 0 AND score >= 2" + String.format(" AND %s MATCH '%s'", new Object[]{aVar2.aMS(), aMX2}) + " ORDER BY score desc limit " + size3 + ";", new Object[]{aVar2.aMR(), aVar2.aMS(), aVar2.aMR(), aVar2.aMS(), aVar2.aMR(), aVar2.aMS()}), new String[]{"​chatroom_tophits"});
            while (rawQuery2.moveToNext()) {
                aMX2 = rawQuery2.getString(0);
                if (!hashSet.contains(aMX2)) {
                    hashSet2.add(aMX2);
                }
            }
            rawQuery2.close();
            com.tencent.mm.plugin.fts.c.a aVar3 = (com.tencent.mm.plugin.fts.c.a) ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSIndexStorage(3);
            Iterator it = hashSet2.iterator();
            while (it.hasNext()) {
                String str6 = (String) it.next();
                eVar = hVar.mMb;
                String aMX3 = eVar.aMX();
                long size4 = (long) eVar.mLE.size();
                rawQuery = aVar3.mJR.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, content, MMHighlight(%s, %d, type, subtype) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND type = 131075 AND subtype= 38" + ";", new Object[]{aVar3.aMR(), aVar3.aMS(), Long.valueOf(size4), aVar3.aMR(), aVar3.aMS(), aVar3.aMR(), aVar3.aMS(), aVar3.aMS(), aMX3}), new String[]{str6});
                if (rawQuery.moveToNext()) {
                    h = new k().h(rawQuery);
                    h.userData = "​chatroom_tophits";
                    h.aMY();
                    hVar.mMc.add(h);
                    if (hVar.mMc.size() >= this.mLN.mLW) {
                        return;
                    }
                }
                rawQuery.close();
            }
        }
    }

    public final String getName() {
        return "SearchTopHitsTask";
    }

    public final int getId() {
        return 8;
    }
}
