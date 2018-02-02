package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.m;
import java.util.ArrayList;

class c$h extends f {
    final /* synthetic */ c mNG;

    c$h(c cVar, g gVar) {
        this.mNG = cVar;
        super(gVar);
    }

    protected final void a(h hVar) {
        Bg("start");
        hVar.mMb = e.a(this.mLN.fDj, false, this.mNG.mNF);
        a aVar = this.mNG.mNy;
        e eVar = hVar.mMb;
        String str = this.mLN.mLS;
        String aMX = eVar.aMX();
        aMX = String.format("SELECT %s.docid, type, subtype, entity_id, aux_index, timestamp, talker FROM %s JOIN %s ON (%s.docid = %s.rowid) WHERE %s MATCH '%s' AND aux_index = ? AND status >= 0 ORDER BY timestamp desc;", new Object[]{aVar.aMR(), aVar.aMR(), aVar.aMS(), aVar.aMR(), aVar.aMS(), aVar.aMS(), aMX});
        Cursor rawQuery = aVar.mJR.rawQuery(aMX, new String[]{str});
        hVar.mMc = new ArrayList();
        while (rawQuery.moveToNext()) {
            hVar.mMc.add(new k().f(rawQuery));
        }
        rawQuery.close();
        Bg("findConversationMessage");
        if (hVar.mMb.mLD.length > 1) {
            rawQuery = ((com.tencent.mm.plugin.fts.c.a) ((m) com.tencent.mm.kernel.g.k(m.class)).getFTSIndexStorage(3)).a(e.an(hVar.mMb.mLD[0], true), null, c.mKj, c.mKn);
            if (rawQuery.moveToNext()) {
                j jVar = new j();
                jVar.mLs = "create_talker_message​";
                hVar.mMc.add(0, jVar);
            }
            rawQuery.close();
            Bg("findTalkerConversation");
        }
    }

    public final String getName() {
        return "SearchConversationMessageTask";
    }

    public final int getId() {
        return 14;
    }
}
