package com.tencent.mm.plugin.fav.b.a;

import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteException;
import com.tencent.wcdb.database.SQLiteStatement;

public final class a extends com.tencent.mm.plugin.fts.a.a {
    private SQLiteStatement mok;

    protected final void AX() {
        if (AY()) {
            this.mJR.t(-106, 4);
        }
        this.mok = this.mJR.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, fav_type) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?);", new Object[]{aMR()}));
    }

    protected final boolean AY() {
        return !cB(-106, 4);
    }

    protected final String getTableName() {
        return "Favorite";
    }

    public final String getName() {
        return "FTS5FavoriteStorage";
    }

    public final int getType() {
        return 256;
    }

    public final int getPriority() {
        return 256;
    }

    protected final String aIj() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, fav_type INT DEFAULT 0);", new Object[]{aMR()});
    }

    public final void a(int i, long j, String str, long j2, String str2, int i2) {
        String Bc = d.Bc(str2);
        if (!bh.ov(Bc)) {
            boolean inTransaction = this.mJR.inTransaction();
            if (!inTransaction) {
                this.mJR.beginTransaction();
            }
            try {
                this.mJS.bindString(1, Bc);
                this.mJS.execute();
                this.mok.bindLong(1, 196608);
                this.mok.bindLong(2, (long) i);
                this.mok.bindLong(3, j);
                this.mok.bindString(4, str);
                this.mok.bindLong(5, j2);
                this.mok.bindLong(6, (long) i2);
                this.mok.execute();
                if (!inTransaction) {
                    this.mJR.commit();
                }
            } catch (SQLiteException e) {
                x.e("MicroMsg.FTS.FTS5FavoriteStorage", String.format("Failed inserting index: 0x%x, %d, %d, %s, %d", new Object[]{Integer.valueOf(196608), Integer.valueOf(i), Long.valueOf(j), str, Long.valueOf(j2)}));
                String simpleQueryForString = this.mJZ.simpleQueryForString();
                if (simpleQueryForString != null && simpleQueryForString.length() > 0) {
                    x.e("MicroMsg.FTS.FTS5FavoriteStorage", ">> " + simpleQueryForString);
                }
                throw e;
            }
        }
    }
}
