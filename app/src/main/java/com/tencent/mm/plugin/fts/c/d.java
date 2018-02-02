package com.tencent.mm.plugin.fts.c;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.g;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteStatement;

public final class d implements h {
    private boolean fic;
    private boolean mJP;
    public g mJR;
    public SQLiteStatement mJS;
    public SQLiteStatement mJT;
    public SQLiteStatement mOu;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return 0;
    }

    public d() {
        x.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create %s", new Object[]{"FTS5SOSHistoryStorage"});
    }

    public final void create() {
        x.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnCreate %s | isCreated =%b", new Object[]{"FTS5SOSHistoryStorage", Boolean.valueOf(this.fic)});
        if (!this.fic) {
            int i;
            if (((m) com.tencent.mm.kernel.g.k(m.class)).isFTSContextReady()) {
                this.mJR = ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSIndexDB();
                x.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Success!");
                if (this.mJR.AV(aMS()) && this.mJR.AV(aMR())) {
                    x.d("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Exist, Not Need To Create");
                } else {
                    x.d("MicroMsg.FTS.FTS5SOSHistoryStorage", "Table Not Exist, Need To Create");
                    String format = String.format("DROP TABLE IF EXISTS %s;", new Object[]{aMS()});
                    String format2 = String.format("DROP TABLE IF EXISTS %s;", new Object[]{aMR()});
                    this.mJR.execSQL(format);
                    this.mJR.execSQL(format2);
                    this.mJR.execSQL(String.format("CREATE VIRTUAL TABLE %s USING fts5(content, tokenize='mmSimple', prefix='1 2 3 4 5');", new Object[]{aMS()}));
                    this.mJR.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, history TEXT, timestamp INTEGER);", new Object[]{aMR()}));
                    this.mJR.execSQL(String.format("CREATE INDEX IF NOT EXISTS SOSHistory_history ON %s(history);", new Object[]{aMR()}));
                    this.mJR.execSQL(String.format("CREATE INDEX IF NOT EXISTS SOSHistory_timestamp ON %s(timestamp);", new Object[]{aMR()}));
                }
                this.mJS = this.mJR.compileStatement(String.format("INSERT INTO %s (content) VALUES (?);", new Object[]{aMS()}));
                this.mJT = this.mJR.compileStatement(String.format("INSERT INTO %s (docid, history, timestamp) VALUES (last_insert_rowid(), ?, ?);", new Object[]{aMR()}));
                this.mOu = this.mJR.compileStatement(String.format("UPDATE %s SET timestamp=? WHERE docid = ?", new Object[]{aMR()}));
                boolean z = true;
            } else {
                x.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "Create Fail!");
                i = 0;
            }
            if (i != 0) {
                x.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetCreated");
                this.fic = true;
            }
        }
    }

    public final void destroy() {
        x.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "OnDestroy %s | isDestroyed %b | isCreated %b", new Object[]{"FTS5SOSHistoryStorage", Boolean.valueOf(this.mJP), Boolean.valueOf(this.fic)});
        if (!this.mJP && this.fic) {
            this.mJS.close();
            this.mOu.close();
            this.mJT.close();
            x.i("MicroMsg.FTS.FTS5SOSHistoryStorage", "SetDestroyed");
            this.mJP = true;
        }
    }

    public final String getName() {
        return "FTS5SOSHistoryStorage";
    }

    public final int getType() {
        return WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
    }

    public final int getPriority() {
        return WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
    }

    public static String aMR() {
        return new StringBuilder("FTS5MetaSOSHistory").toString();
    }

    public static String aMS() {
        return new StringBuilder("FTS5IndexSOSHistory").toString();
    }

    public final String bp(String str, int i) {
        return null;
    }
}
