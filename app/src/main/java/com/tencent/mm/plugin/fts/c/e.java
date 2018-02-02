package com.tencent.mm.plugin.fts.c;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e extends a {
    public SQLiteStatement mOv;
    public SQLiteStatement mOw;
    public SQLiteStatement mOx;

    protected final String getTableName() {
        return "TopHits";
    }

    public final String getName() {
        return "FTS5TopHitsStorage";
    }

    public final int getType() {
        return 1;
    }

    public final int getPriority() {
        return 768;
    }

    protected final void AX() {
        if (AY()) {
            this.mJR.t(-100, 3);
        }
        this.mJR.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_query ON %s(query);", new Object[]{aMR(), aMR()}));
        this.mJR.execSQL(String.format("CREATE INDEX IF NOT EXISTS %s_score ON %s(score);", new Object[]{aMR(), aMR()}));
        this.mOv = this.mJR.compileStatement(String.format("INSERT INTO %s (content) VALUES (?);", new Object[]{aMS()}));
        this.mOw = this.mJR.compileStatement(String.format("INSERT INTO %s (docid, type, subtype, entity_id, aux_index, timestamp, query, score, scene, meta_content) VALUES (last_insert_rowid(), ?, ?, ?, ?, ?, ?, ?, ?, ?);", new Object[]{aMR()}));
        this.mOx = this.mJR.compileStatement(String.format("UPDATE %s SET status=? WHERE aux_index=?", new Object[]{aMR()}));
    }

    public final int aNl() {
        Cursor rawQuery = this.mJR.rawQuery(String.format("SELECT docid, query, score, scene, aux_index, entity_id, type, subtype, timestamp, meta_content FROM %s WHERE status > 0;", new Object[]{aMR()}), null);
        List<i> arrayList = new ArrayList();
        while (rawQuery.moveToNext()) {
            i iVar = new i();
            iVar.b(rawQuery);
            arrayList.add(iVar);
        }
        rawQuery.close();
        List linkedList = new LinkedList();
        Object linkedList2 = new LinkedList();
        LinkedList linkedList3 = new LinkedList();
        for (i iVar2 : arrayList) {
            i iVar22;
            h fTSIndexStorage;
            if (iVar22.type == 262144) {
                fTSIndexStorage = ((m) g.k(m.class)).getFTSIndexStorage(17);
            } else {
                fTSIndexStorage = ((m) g.k(m.class)).getFTSIndexStorage(3);
            }
            String bp = fTSIndexStorage.bp(iVar22.mLs, iVar22.mLr);
            if (bh.ov(bp)) {
                linkedList2.add(Long.valueOf(iVar22.mMd));
            } else if (iVar22.fDj.equals("​chatroom_tophits")) {
                String str = "";
                for (String str2 : c.a.mKy.split(iVar22.mMg)) {
                    if (bp.indexOf(str2) >= 0) {
                        str = str + str2 + "​";
                    }
                }
                if (iVar22.mMg.equals(str)) {
                    linkedList.add(Long.valueOf(iVar22.mMd));
                } else {
                    iVar22.mMg = str;
                    linkedList2.add(Long.valueOf(iVar22.mMd));
                    linkedList3.add(iVar22);
                }
            } else if (iVar22.mMg.equals(bp)) {
                linkedList.add(Long.valueOf(iVar22.mMd));
            } else {
                iVar22.mMg = bp;
                linkedList2.add(Long.valueOf(iVar22.mMd));
                linkedList3.add(iVar22);
            }
        }
        x.i("MicroMsg.FTS.FTS5TopHitsStorage", "updateTopHitsDirty deleteDocIdList=%d needToInsertTopHitListSize=%d normalDocIdList=%d", new Object[]{Integer.valueOf(linkedList2.size()), Integer.valueOf(linkedList3.size()), Integer.valueOf(linkedList.size())});
        if (linkedList2.size() > 0) {
            aR(linkedList2);
        }
        if (linkedList3.size() > 0) {
            boolean inTransaction = this.mJR.inTransaction();
            if (!inTransaction) {
                this.mJR.beginTransaction();
            }
            Iterator it = linkedList3.iterator();
            while (it.hasNext()) {
                iVar22 = (i) it.next();
                if (!bh.ov(iVar22.mMg)) {
                    this.mOv.bindString(1, iVar22.mMg);
                    this.mOv.execute();
                    this.mOw.bindLong(1, (long) iVar22.type);
                    this.mOw.bindLong(2, (long) iVar22.mLr);
                    this.mOw.bindLong(3, iVar22.mMf);
                    this.mOw.bindString(4, iVar22.mLs);
                    this.mOw.bindLong(5, iVar22.timestamp);
                    this.mOw.bindString(6, iVar22.fDj);
                    this.mOw.bindLong(7, iVar22.mMe);
                    this.mOw.bindLong(8, iVar22.hil);
                    this.mOw.bindString(9, iVar22.mMg);
                    this.mOw.execute();
                }
            }
            if (!inTransaction) {
                commit();
            }
        }
        if (linkedList.size() > 0) {
            f(linkedList, 0);
        }
        return linkedList2.size();
    }

    protected final boolean AZ() {
        super.AZ();
        this.mOv.close();
        this.mOw.close();
        this.mOx.close();
        return true;
    }

    protected final String aIj() {
        return String.format("CREATE TABLE IF NOT EXISTS %s (docid INTEGER PRIMARY KEY, type INT, subtype INT DEFAULT 0, entity_id INTEGER, aux_index TEXT, timestamp INTEGER, status INT DEFAULT 0, query TEXT COLLATE NOCASE, score INT, scene INT, meta_content TEXT);", new Object[]{aMR()});
    }

    protected final boolean AY() {
        return !cB(-100, 3);
    }
}
