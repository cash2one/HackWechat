package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.m;
import java.util.LinkedList;

class c$k extends f {
    final /* synthetic */ c mNG;
    private int mNS = 0;
    private int mNT = 0;

    public c$k(c cVar, g gVar) {
        this.mNG = cVar;
        super(gVar);
    }

    protected final void a(h hVar) {
        Bg("start");
        hVar.mMb = e.a(this.mLN.fDj, false, this.mNG.mNF);
        a aVar = this.mNG.mNy;
        e eVar = hVar.mMb;
        int i = this.mLN.mLW;
        String aMX = eVar.aMX();
        Cursor rawQuery = aVar.mJR.rawQuery(String.format("SELECT type, subtype, entity_id, aux_index, MAX(timestamp) as maxTime, count(aux_index) as msgCount FROM %s NOT INDEXED JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND status >= 0 GROUP BY aux_index ORDER BY timestamp desc" + (i != Integer.MAX_VALUE ? " LIMIT " + (i + 1) : "") + ";", new Object[]{aVar.aMR(), aVar.aMS(), aVar.aMR(), aVar.aMS(), aVar.aMS(), aMX}), null);
        hVar.mMc = new LinkedList();
        while (rawQuery.moveToNext()) {
            j jVar = new j();
            jVar.type = rawQuery.getInt(0);
            jVar.mLr = rawQuery.getInt(1);
            jVar.mMf = rawQuery.getLong(2);
            jVar.mLs = rawQuery.getString(3);
            jVar.timestamp = rawQuery.getLong(4);
            jVar.userData = Integer.valueOf(rawQuery.getInt(5));
            hVar.mMc.add(jVar);
            this.mNS = ((Integer) jVar.userData).intValue() + this.mNS;
            this.mNT++;
        }
        rawQuery.close();
        Bg("groupMessage");
        if (hVar.mMb.mLD.length > 1) {
            Cursor a = ((com.tencent.mm.plugin.fts.c.a) ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSIndexStorage(3)).a(e.an(hVar.mMb.mLD[0], true), null, c.mKj, c.mKn);
            if (a.moveToNext()) {
                j jVar2 = new j();
                jVar2.mLs = "create_talker_message​";
                hVar.mMc.add(0, jVar2);
            }
            a.close();
            Bg("findTalkerConversation");
        }
    }

    public final String ado() {
        return String.format("{totalMsgCount: %d conversationCount: %d}", new Object[]{Integer.valueOf(this.mNS), Integer.valueOf(this.mNT)});
    }

    public final String getName() {
        return "SearchTopGroupMessageTask";
    }

    public final int getId() {
        return 15;
    }
}
