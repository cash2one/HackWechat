package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.List;

public final class a extends com.tencent.mm.plugin.fts.a.a {
    public SQLiteStatement mOj;
    public SQLiteStatement mOk;
    private SQLiteStatement mOl;
    public SQLiteStatement mOm;
    public SQLiteStatement mOn;
    private SQLiteStatement mOo;
    public SQLiteStatement mOp;

    protected final void AX() {
        if (AY()) {
            this.mJR.t(-102, 4);
        }
        this.mJR.execSQL("CREATE TABLE IF NOT EXISTS FTS5ChatRoomMembers (chatroom TEXT, member TEXT);");
        this.mJR.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_chatroom ON FTS5ChatRoomMembers(chatroom);");
        this.mJR.execSQL("CREATE INDEX IF NOT EXISTS FTS5ChatRoomMembers_member ON FTS5ChatRoomMembers(member);");
        this.mJR.execSQL("CREATE TABLE IF NOT EXISTS FTS5ContactLabels (user TEXT, label_id INTEGER);");
        this.mJR.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_user ON FTS5ContactLabels(user);");
        this.mJR.execSQL("CREATE INDEX IF NOT EXISTS FTS5ContactLabels_label ON FTS5ContactLabels(label_id);");
        this.mOj = this.mJR.compileStatement("INSERT INTO FTS5ChatRoomMembers (chatroom, member) VALUES (?, ?);");
        this.mOk = this.mJR.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=? AND member=?;");
        this.mOl = this.mJR.compileStatement("DELETE FROM FTS5ChatRoomMembers WHERE chatroom=?;");
        this.mOm = this.mJR.compileStatement("INSERT INTO FTS5ContactLabels (user, label_id) VALUES (?, ?);");
        this.mOn = this.mJR.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=? AND label_id=?;");
        this.mOo = this.mJR.compileStatement("DELETE FROM FTS5ContactLabels WHERE user=?;");
        this.mOp = this.mJR.compileStatement("SELECT changes();");
    }

    protected final boolean AZ() {
        super.AZ();
        this.mOj.close();
        this.mOk.close();
        this.mOl.close();
        this.mOm.close();
        this.mOn.close();
        this.mOo.close();
        this.mOp.close();
        return true;
    }

    public final void g(String str, List<Long> list) {
        if (list != null && !list.isEmpty()) {
            boolean inTransaction = this.mJR.inTransaction();
            if (!inTransaction) {
                this.mJR.beginTransaction();
            }
            this.mOm.bindString(1, str);
            for (Long longValue : list) {
                this.mOm.bindLong(2, longValue.longValue());
                this.mOm.execute();
            }
            if (!inTransaction) {
                this.mJR.commit();
            }
        }
    }

    public final void Bn(String str) {
        this.mOo.bindString(1, str);
        this.mOo.execute();
    }

    public final Cursor Bo(String str) {
        return this.mJR.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers WHERE member=?;", new String[]{str});
    }

    public final void j(String str, String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            boolean inTransaction = this.mJR.inTransaction();
            if (!inTransaction) {
                this.mJR.beginTransaction();
            }
            this.mOj.bindString(1, str);
            for (String bindString : strArr) {
                this.mOj.bindString(2, bindString);
                this.mOj.execute();
            }
            if (!inTransaction) {
                this.mJR.commit();
            }
        }
    }

    public final void Bp(String str) {
        this.mOl.bindString(1, str);
        this.mOl.execute();
    }

    protected final String getTableName() {
        return "Contact";
    }

    public final String getName() {
        return "FTS5ContactStorage";
    }

    public final int getType() {
        return 3;
    }

    public final int getPriority() {
        return 3;
    }

    protected final String aIj() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0);", new Object[]{aMR()});
    }

    protected final boolean AY() {
        return !cB(-102, 4);
    }

    public final Cursor a(e eVar, String str, int[] iArr, int[] iArr2) {
        String aMX = eVar.aMX();
        String format = bh.ov(str) ? "" : String.format(" AND aux_index = '%s'", new Object[]{str});
        String str2 = (iArr == null || iArr.length <= 0) ? "" : " AND type IN " + d.i(iArr);
        String str3 = (iArr2 == null || iArr2.length <= 0) ? "" : " AND subtype IN " + d.i(iArr2);
        return this.mJR.rawQuery(String.format("SELECT aux_index, type, subtype FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s'" + format + str2 + str3 + " AND status >= 0 ORDER BY subtype;", new Object[]{aMR(), aMS(), aMR(), aMS(), aMS(), aMX}), null);
    }

    public final boolean b(e eVar) {
        Cursor rawQuery = this.mJR.rawQuery(String.format("SELECT 1 FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND type=131072 LIMIT 1;", new Object[]{aMR(), aMS(), aMR(), aMS(), aMS(), eVar.aMX()}), null);
        boolean moveToNext = rawQuery.moveToNext();
        rawQuery.close();
        return moveToNext;
    }

    protected final boolean aMT() {
        return true;
    }
}
