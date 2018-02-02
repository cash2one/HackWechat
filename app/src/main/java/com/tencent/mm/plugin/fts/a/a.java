package com.tencent.mm.plugin.fts.a;

import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.by.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.b;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public abstract class a implements h {
    private volatile boolean fic;
    private boolean mJP;
    private f<String, String> mJQ;
    public volatile g mJR;
    public SQLiteStatement mJS;
    private SQLiteStatement mJT;
    private SQLiteStatement mJU;
    private SQLiteStatement mJV;
    private SQLiteStatement mJW;
    public SQLiteStatement mJX;
    private SQLiteStatement mJY;
    public SQLiteStatement mJZ;

    public abstract void AX();

    public /* synthetic */ int compareTo(Object obj) {
        h hVar = (h) obj;
        if (getPriority() < hVar.getPriority()) {
            return -1;
        }
        return getPriority() > hVar.getPriority() ? 1 : 0;
    }

    public a() {
        x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create %s", new Object[]{getName()});
    }

    public final synchronized void create() {
        x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "OnCreate %s | isCreated =%b", new Object[]{getName(), Boolean.valueOf(this.fic)});
        if (!this.fic) {
            Object obj;
            if (((m) g.k(m.class)).isFTSContextReady()) {
                this.mJR = ((m) g.k(m.class)).getFTSIndexDB();
                x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create Success!");
                x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "indexTableName=%s | metaTableName=%s | TableName=%s", new Object[]{aMS(), aMR(), getTableName()});
                if (this.mJR.AV(aMS()) && this.mJR.AV(r1) && !AY()) {
                    x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Table Exist, Not Need To Create");
                } else {
                    x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Table Not Exist, Need To Create");
                    String format = String.format("DROP TABLE IF EXISTS %s;", new Object[]{r0});
                    String format2 = String.format("DROP TABLE IF EXISTS %s;", new Object[]{r1});
                    this.mJR.execSQL(format);
                    this.mJR.execSQL(format2);
                    this.mJR.execSQL(String.format("CREATE VIRTUAL TABLE %s USING fts5(content, tokenize='mmSimple', prefix='1 2 3 4 5');", new Object[]{aMS()}));
                    this.mJR.execSQL(aIj());
                    this.mJR.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_typeId ON %s(type, entity_id);", new Object[]{r1, r1}));
                    this.mJR.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_entity_id_subtype ON %s(entity_id, subtype);", new Object[]{r1, r1}));
                    this.mJR.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_aux_index_subtype ON %s(aux_index, subtype);", new Object[]{r1, r1}));
                    this.mJR.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", new Object[]{r1, r1}));
                }
                this.mJS = this.mJR.compileStatement(String.format("INSERT INTO %s (content) VALUES (?);", new Object[]{r0}));
                this.mJT = this.mJR.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?);", new Object[]{r1}));
                this.mJU = this.mJR.compileStatement(String.format("DELETE FROM %s WHERE rowid=?;", new Object[]{r0}));
                this.mJV = this.mJR.compileStatement(String.format("DELETE FROM %s WHERE docid=?;", new Object[]{r1}));
                this.mJW = this.mJR.compileStatement(String.format("UPDATE %s SET status=? WHERE docid=?;", new Object[]{r1}));
                this.mJX = this.mJR.compileStatement(String.format("UPDATE %s SET status=? WHERE aux_index=? AND status=?", new Object[]{r1}));
                this.mJY = this.mJR.compileStatement(String.format("UPDATE %s SET timestamp=? WHERE aux_index=?", new Object[]{r1}));
                this.mJZ = this.mJR.compileStatement("SELECT mm_last_error();");
                this.mJQ = new f(100);
                AX();
                int i = 1;
            } else {
                x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "Create Fail!");
                obj = null;
            }
            if (obj != null) {
                x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "SetCreated");
                this.fic = true;
            }
        }
    }

    public String getTableName() {
        return "Common";
    }

    public final void a(int i, int i2, long j, String str, long j2, String str2) {
        String Bc = d.Bc(str2);
        if (!bh.ov(Bc)) {
            boolean inTransaction = this.mJR.inTransaction();
            if (!inTransaction) {
                this.mJR.beginTransaction();
            }
            try {
                this.mJS.bindString(1, Bc);
                this.mJS.execute();
                this.mJT.bindLong(1, (long) i);
                this.mJT.bindLong(2, (long) i2);
                this.mJT.bindLong(3, j);
                this.mJT.bindString(4, str);
                this.mJT.bindLong(5, j2);
                this.mJT.execute();
                if (!inTransaction) {
                    this.mJR.commit();
                }
                if (aMT()) {
                    this.mJQ.put(bo(str, i2), Bc);
                }
            } catch (SQLiteException e) {
                x.e("MicroMsg.FTS.BaseFTS5NativeStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), str, Long.valueOf(j2)}));
                String simpleQueryForString = this.mJZ.simpleQueryForString();
                if (simpleQueryForString != null && simpleQueryForString.length() > 0) {
                    x.e("MicroMsg.FTS.BaseFTS5NativeStorage", ">> " + simpleQueryForString);
                }
                throw e;
            }
        }
    }

    private static String bo(String str, int i) {
        return str + "​" + i;
    }

    public final void a(int[] iArr, String str) {
        List arrayList = new ArrayList(16);
        String format = String.format("SELECT docid FROM %s WHERE type IN " + d.i(iArr) + " AND aux_index=?;", new Object[]{aMR()});
        Cursor rawQuery = this.mJR.rawQuery(format, new String[]{str});
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        aR(arrayList);
    }

    public final void h(int[] iArr) {
        List arrayList = new ArrayList(2048);
        Cursor rawQuery = this.mJR.rawQuery(String.format("SELECT docid FROM %s WHERE type IN " + d.i(iArr) + ";", new Object[]{aMR()}), null);
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        aR(arrayList);
    }

    public final void b(int[] iArr, long j) {
        List arrayList = new ArrayList(16);
        String format = String.format("SELECT docid FROM %s WHERE type IN " + d.i(iArr) + " AND entity_id=?;", new Object[]{aMR()});
        Cursor rawQuery = this.mJR.rawQuery(format, new String[]{Long.toString(j)});
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        aR(arrayList);
    }

    public final void aR(List<Long> list) {
        boolean inTransaction = this.mJR.inTransaction();
        if (!inTransaction) {
            this.mJR.beginTransaction();
        }
        for (Long longValue : list) {
            this.mJU.bindLong(1, longValue.longValue());
            this.mJU.execute();
        }
        for (Long longValue2 : list) {
            this.mJV.bindLong(1, longValue2.longValue());
            this.mJV.execute();
        }
        if (!inTransaction) {
            commit();
        }
    }

    public final void B(String str, long j) {
        this.mJY.bindLong(1, j);
        this.mJY.bindString(2, str);
        this.mJY.execute();
    }

    public final void g(Long l) {
        boolean inTransaction = this.mJR.inTransaction();
        if (!inTransaction) {
            this.mJR.beginTransaction();
        }
        this.mJU.bindLong(1, l.longValue());
        this.mJU.execute();
        this.mJV.bindLong(1, l.longValue());
        this.mJV.execute();
        if (!inTransaction) {
            commit();
        }
    }

    public final void f(List<Long> list, int i) {
        boolean inTransaction = this.mJR.inTransaction();
        if (!inTransaction) {
            this.mJR.beginTransaction();
        }
        this.mJW.bindLong(1, (long) i);
        for (Long longValue : list) {
            this.mJW.bindLong(2, longValue.longValue());
            this.mJW.execute();
        }
        if (!inTransaction) {
            this.mJR.commit();
        }
    }

    public final List<Long> b(int[] iArr, String str) {
        String format = String.format("SELECT docid FROM %s WHERE aux_index=? AND type IN " + d.i(iArr) + ";", new Object[]{aMR()});
        Cursor rawQuery = this.mJR.rawQuery(format, new String[]{str});
        List<Long> arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        f(arrayList, 1);
        return arrayList;
    }

    public final List<b> e(int[] iArr, int i) {
        Cursor rawQuery = this.mJR.rawQuery(String.format("SELECT docid, type, subtype, aux_index FROM %s WHERE type IN " + d.i(iArr) + ";", new Object[]{aMR()}), null);
        List<b> arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        while (rawQuery.moveToNext()) {
            b bVar = new b();
            bVar.mLq = rawQuery.getLong(0);
            bVar.type = rawQuery.getInt(1);
            bVar.mLr = rawQuery.getInt(2);
            bVar.mLs = rawQuery.getString(3);
            arrayList.add(bVar);
            arrayList2.add(Long.valueOf(bVar.mLq));
        }
        rawQuery.close();
        f(arrayList2, i);
        return arrayList;
    }

    public final Cursor a(e eVar, int[] iArr, int[] iArr2, boolean z, boolean z2) {
        String aMX = eVar.aMX();
        String format = z ? String.format(", MMHighlight(%s, %d, type, subtype)", new Object[]{aMS(), Integer.valueOf(eVar.mLE.size())}) : "";
        String str = "";
        String str2 = (iArr2 == null || iArr2.length <= 0) ? "" : " AND subtype IN " + d.i(iArr2);
        String str3 = (iArr == null || iArr.length <= 0) ? "" : " AND type IN " + d.i(iArr);
        return this.mJR.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp" + (z2 ? ", content" : "") + format + " FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + str3 + str + " AND status >= 0" + str2 + ";", new Object[]{aMR(), aMR(), aMS(), aMR(), aMS(), aMS(), aMX}), null);
    }

    public final Cursor a(int[] iArr, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        if (!z && !z2 && !z3 && !z4 && !z5) {
            return d.ckM();
        }
        if (iArr == null || iArr.length == 0) {
            return d.ckM();
        }
        StringBuilder stringBuilder = new StringBuilder(64);
        if (z) {
            stringBuilder.append("docid,");
        }
        if (z2) {
            stringBuilder.append("entity_id,");
        }
        if (z3) {
            stringBuilder.append("aux_index,");
        }
        if (z4) {
            stringBuilder.append("timestamp,");
        }
        if (z5) {
            stringBuilder.append("status,");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        String stringBuilder2 = stringBuilder.toString();
        return this.mJR.rawQuery(String.format("SELECT %s FROM %s WHERE type IN " + d.i(iArr) + ";", new Object[]{stringBuilder2, aMR()}), null);
    }

    public final void destroy() {
        x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "OnDestroy %s | isDestroyed %b | isCreated %b", new Object[]{getName(), Boolean.valueOf(this.mJP), Boolean.valueOf(this.fic)});
        if (!this.mJP && this.fic && AZ()) {
            x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "SetDestroyed");
            this.mJP = true;
        }
    }

    public boolean AZ() {
        this.mJR = null;
        this.mJS.close();
        this.mJT.close();
        this.mJU.close();
        this.mJV.close();
        this.mJW.close();
        this.mJZ.close();
        if (this.mJQ != null) {
            this.mJQ.clear();
        }
        return true;
    }

    public final String aMR() {
        return "FTS5Meta" + getTableName();
    }

    public final String aMS() {
        return "FTS5Index" + getTableName();
    }

    public final void beginTransaction() {
        this.mJR.beginTransaction();
    }

    public final void commit() {
        this.mJR.commit();
    }

    public final void t(long j, long j2) {
        this.mJR.t(j, j2);
    }

    public final boolean cB(int i, int i2) {
        return this.mJR.cB(i, i2);
    }

    public String aIj() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[]{aMR()});
    }

    public boolean AY() {
        return false;
    }

    public final String bp(String str, int i) {
        String bo;
        if (aMT()) {
            bo = bo(str, i);
            if (this.mJQ.bt(bo)) {
                x.i("MicroMsg.FTS.BaseFTS5NativeStorage", "hit lru insert content map");
                return (String) this.mJQ.get(bo);
            }
        }
        bo = String.format("SELECT content FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE aux_index=? AND subtype=?", new Object[]{aMR(), aMS(), aMR(), aMS()});
        Cursor rawQuery = this.mJR.rawQuery(bo, new String[]{str, String.valueOf(i)});
        bo = null;
        if (rawQuery.moveToFirst()) {
            bo = rawQuery.getString(0);
        }
        rawQuery.close();
        return bo;
    }

    public boolean aMT() {
        return false;
    }

    public final void Ba(String str) {
        HashSet hashSet = new HashSet();
        for (String str2 : this.mJQ.map.keySet()) {
            if (str2.startsWith(str)) {
                hashSet.add(str2);
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            this.mJQ.remove((String) it.next());
        }
    }
}
