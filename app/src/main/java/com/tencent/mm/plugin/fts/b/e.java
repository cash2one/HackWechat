package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public final class e extends b {
    private l gJk;
    com.tencent.mm.plugin.fts.c.e mNX;
    HashSet<String> mNY;

    private class c extends a {
        private String fDj;
        private HashMap<String, String> mKF;
        final /* synthetic */ e mOb;
        private j mOc;
        private int scene;

        private c(e eVar) {
            this.mOb = eVar;
        }

        public final boolean execute() {
            int i;
            int i2;
            com.tencent.mm.plugin.fts.a.a aVar = this.mOb.mNX;
            String str = this.fDj;
            j jVar = this.mOc;
            int i3 = this.scene;
            HashMap hashMap = this.mKF;
            Object trim = str.trim();
            hashMap.remove(jVar.mLs);
            boolean inTransaction = aVar.mJR.inTransaction();
            if (!inTransaction) {
                aVar.mJR.beginTransaction();
            }
            long currentTimeMillis = System.currentTimeMillis();
            Cursor rawQuery = aVar.mJR.rawQuery(String.format("SELECT docid, score FROM %s WHERE query=? AND aux_index=? AND subtype = ? AND scene=?;", new Object[]{aVar.aMR()}), new String[]{trim, jVar.mLs, String.valueOf(jVar.mLr), String.valueOf(i3)});
            if (rawQuery.moveToNext()) {
                int i4 = rawQuery.getInt(0);
                i = rawQuery.getInt(1);
                i2 = i4;
            } else {
                i = -1;
                i2 = -1;
            }
            rawQuery.close();
            String str2 = "";
            for (Entry entry : hashMap.entrySet()) {
                str2 = !((String) entry.getValue()).equals("​chatroom_tophits") ? str2 + "'" + ((String) entry.getKey()) + "'," : str2;
            }
            if (str2.length() > 0) {
                str = "AND aux_index IN (" + str2.substring(0, str2.length() - 1) + ")";
                aVar.mJR.execSQL(String.format("UPDATE %s SET score=CASE WHEN score > 6 THEN 6 WHEN score > 2 THEN (score - 1) ELSE score END WHERE scene = %d %s;", new Object[]{aVar.aMR(), Integer.valueOf(i3), str}));
            }
            str2 = "";
            for (Entry entry2 : hashMap.entrySet()) {
                str2 = ((String) entry2.getValue()).equals("​chatroom_tophits") ? str2 + "'" + ((String) entry2.getKey()) + "'," : str2;
            }
            if (str2.length() > 0) {
                str = "AND aux_index IN(" + str2.substring(0, str2.length() - 1) + ")";
                aVar.mJR.execSQL(String.format("UPDATE %s SET score=CASE WHEN score = 1 THEN 0 WHEN score < 5 THEN (score - 1) ELSE 4 END WHERE query = ? AND scene = %d %s;", new Object[]{aVar.aMR(), Integer.valueOf(i3), str}), new String[]{"​chatroom_tophits"});
            }
            if (i2 < 0 || i < 0) {
                aVar.mOv.bindString(1, jVar.content);
                aVar.mOv.execute();
                aVar.mOw.bindLong(1, (long) jVar.type);
                aVar.mOw.bindLong(2, (long) jVar.mLr);
                aVar.mOw.bindLong(3, jVar.mMf);
                aVar.mOw.bindString(4, jVar.mLs);
                aVar.mOw.bindLong(5, currentTimeMillis);
                aVar.mOw.bindString(6, trim);
                aVar.mOw.bindLong(7, 3);
                aVar.mOw.bindLong(8, (long) i3);
                aVar.mOw.bindString(9, jVar.content);
                aVar.mOw.execute();
            } else {
                int i5 = i > 6 ? i + 1 : i + 3;
                aVar.mJR.execSQL(String.format("UPDATE %s SET score=?, timestamp=? WHERE docid=?", new Object[]{aVar.aMR()}), new String[]{String.valueOf(i5), String.valueOf(currentTimeMillis), String.valueOf(i2)});
            }
            if (!inTransaction) {
                aVar.mJR.commit();
            }
            String[] split = com.tencent.mm.plugin.fts.a.c.a.mKC.split(trim);
            if (split.length > 1 && jVar.type == 131075 && jVar.mLr == 38) {
                HashSet hashSet = new HashSet();
                i iVar = new i();
                Cursor rawQuery2 = aVar.mJR.rawQuery(String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE aux_index=? AND query=?;", new Object[]{aVar.aMR()}), new String[]{jVar.mLs, "​chatroom_tophits"});
                if (rawQuery2.moveToNext()) {
                    iVar.b(rawQuery2);
                    for (Object add : com.tencent.mm.plugin.fts.a.c.a.mKy.split(iVar.mMg)) {
                        hashSet.add(add);
                    }
                }
                rawQuery2.close();
                i4 = 0;
                while (i4 < jVar.mMm.size() && i4 < split.length) {
                    d dVar = (d) jVar.mMm.get(i4);
                    if (hashSet.add(dVar.content)) {
                        iVar.mMg += dVar.content + "​";
                    }
                    i4++;
                }
                x.i("MicroMsg.FTS.FTS5TopHitsStorage", "update tophits content=%s", new Object[]{iVar.mMg});
                if (iVar.mMd > 0) {
                    aVar.g(Long.valueOf(iVar.mMd));
                }
                iVar.mMd = 0;
                iVar.fDj = "​chatroom_tophits";
                iVar.mMe++;
                iVar.hil = (long) i3;
                iVar.mLs = jVar.mLs;
                iVar.mMf = jVar.mMf;
                iVar.type = jVar.type;
                iVar.mLr = jVar.mLr;
                iVar.timestamp = currentTimeMillis;
                aVar.mOv.bindString(1, iVar.mMg);
                aVar.mOv.execute();
                aVar.mOw.bindLong(1, (long) iVar.type);
                aVar.mOw.bindLong(2, (long) iVar.mLr);
                aVar.mOw.bindLong(3, iVar.mMf);
                aVar.mOw.bindString(4, iVar.mLs);
                aVar.mOw.bindLong(5, iVar.timestamp);
                aVar.mOw.bindString(6, iVar.fDj);
                aVar.mOw.bindLong(7, iVar.mMe);
                aVar.mOw.bindLong(8, iVar.hil);
                aVar.mOw.bindString(9, iVar.mMg);
                aVar.mOw.execute();
            }
            return true;
        }

        public final String toString() {
            return String.format("%s : query=%s scene=%d", new Object[]{super.toString(), this.fDj, Integer.valueOf(this.scene)});
        }

        public final String getName() {
            return "UpdateTopHitsWithQueryTask";
        }
    }

    protected final boolean onCreate() {
        if (((m) g.k(m.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Success!");
            this.mNY = new HashSet();
            this.mNX = (com.tencent.mm.plugin.fts.c.e) ((m) g.k(m.class)).getFTSIndexStorage(1);
            this.gJk = ((m) g.k(m.class)).getFTSTaskDaemon();
            this.gJk.a(65626, new a(this, (byte) 0));
            return true;
        }
        x.i("MicroMsg.FTS.FTS5SearchTopHitsLogic", "Create Fail!");
        return false;
    }

    protected final boolean AZ() {
        if (this.mNY != null) {
            this.mNY.clear();
        }
        this.mNX = null;
        this.gJk = null;
        return true;
    }

    public final a a(com.tencent.mm.plugin.fts.a.a.g gVar) {
        return this.gJk.a(-65536, new b(this, gVar));
    }

    public final void Bm(String str) {
        if (this.mNY.add(str)) {
            com.tencent.mm.plugin.fts.c.e eVar = this.mNX;
            eVar.mOx.bindLong(1, 1);
            eVar.mOx.bindString(2, str);
            eVar.mOx.execute();
        }
    }

    public final void c(int[] iArr, String str) {
        this.mNX.a(iArr, str);
    }

    public final String getName() {
        return "FTS5SearchTopHitsLogic";
    }

    public final void a(String str, j jVar, int i, HashMap<String, String> hashMap) {
        c cVar = new c();
        cVar.fDj = str;
        cVar.mOc = jVar;
        cVar.scene = i;
        cVar.mKF = hashMap;
        this.gJk.a(65626, cVar);
    }
}
