package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class c extends a {
    public SQLiteStatement mOs;
    private SQLiteStatement mOt;

    protected final void AX() {
        if (AY()) {
            this.mJR.t(-105, 3);
            this.mJR.t(-200, Long.MAX_VALUE);
        }
        this.mJR.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_timestamp ON %s(timestamp);", new Object[]{aMR(), aMR()}));
        this.mJR.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_talker ON %s(talker);", new Object[]{aMR(), aMR()}));
        this.mOs = this.mJR.compileStatement(String.format("UPDATE %s SET status = ? WHERE aux_index = ? AND status <> ?", new Object[]{aMR()}));
        this.mOt = this.mJR.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, talker) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?);", new Object[]{aMR()}));
    }

    protected final boolean AZ() {
        this.mOs.close();
        this.mOt.close();
        return super.AZ();
    }

    protected final String getTableName() {
        return "Message";
    }

    public final String getName() {
        return "FTS5MessageStorage";
    }

    public final int getType() {
        return 4;
    }

    public final int getPriority() {
        return 4;
    }

    public final void a(int[] iArr, long j, long j2) {
        List arrayList = new ArrayList(4);
        String format = String.format("SELECT docid FROM %s WHERE type IN " + d.i(iArr) + " AND entity_id=? AND timestamp=?;", new Object[]{aMR()});
        Cursor rawQuery = this.mJR.rawQuery(format, new String[]{Long.toString(j), Long.toString(j2)});
        while (rawQuery.moveToNext()) {
            arrayList.add(Long.valueOf(rawQuery.getLong(0)));
        }
        rawQuery.close();
        aR(arrayList);
    }

    public final Cursor a(e eVar, String str, Set<String> set) {
        String str2;
        String aMX = eVar.aMX();
        String str3 = "";
        if (bh.ov(str)) {
            str2 = str3;
        } else {
            str2 = String.format(" AND aux_index = '%s'", new Object[]{str});
        }
        String str4 = "";
        StringBuffer stringBuffer = new StringBuffer();
        for (String str32 : set) {
            stringBuffer.append("'");
            stringBuffer.append(str32);
            stringBuffer.append("'");
            stringBuffer.append(",");
        }
        if (stringBuffer.length() > 0) {
            str32 = " AND talker IN (" + stringBuffer.substring(0, stringBuffer.length() - 1) + ")";
        } else {
            str32 = str4;
        }
        return this.mJR.rawQuery(String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + str32 + str2 + " AND status >= 0;", new Object[]{aMR(), aMR(), aMS(), aMR(), aMS(), aMS(), aMX}), null);
    }

    public final Cursor a(e eVar, List<String> list) {
        String aMX = eVar.aMX();
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : list) {
            stringBuffer.append("'");
            stringBuffer.append(str);
            stringBuffer.append("',");
        }
        String str2 = stringBuffer.substring(0, stringBuffer.length() - 1);
        return this.mJR.rawQuery(String.format("SELECT MessageCount(%d, aux_index) FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index IN (%s) AND status >= 0;", new Object[]{Integer.valueOf(list.size()), aMR(), aMS(), aMR(), aMS(), aMS(), aMX, str2}), null);
    }

    protected final boolean AY() {
        return !cB(-105, 3);
    }

    protected final String aIj() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, talker TEXT);", new Object[]{aMR()});
    }

    public final void a(int i, long j, String str, long j2, String str2, String str3) {
        try {
            this.mJS.bindString(1, str2);
            this.mJS.execute();
            this.mOt.bindLong(1, HardCoderJNI.ACTION_ALLOC_MEMORY);
            this.mOt.bindLong(2, (long) i);
            this.mOt.bindLong(3, j);
            this.mOt.bindString(4, str);
            this.mOt.bindLong(5, j2);
            this.mOt.bindString(6, str3);
            this.mOt.execute();
        } catch (SQLiteException e) {
            x.e("MicroMsg.FTS.FTS5MessageStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[]{Integer.valueOf(65536), Integer.valueOf(i), Long.valueOf(j), str, Long.valueOf(j2)}));
            String simpleQueryForString = this.mJZ.simpleQueryForString();
            if (simpleQueryForString != null && simpleQueryForString.length() > 0) {
                x.e("MicroMsg.FTS.FTS5MessageStorage", ">> " + simpleQueryForString);
            }
            throw e;
        }
    }
}
