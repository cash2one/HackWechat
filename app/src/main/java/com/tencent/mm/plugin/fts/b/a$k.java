package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import java.util.ArrayList;

class a$k extends f {
    final /* synthetic */ a mMS;

    public a$k(a aVar, g gVar) {
        this.mMS = aVar;
        super(gVar);
    }

    protected final void a(h hVar) {
        super.a(hVar);
        a a = a.a(this.mMS);
        String str = this.mLN.fDj;
        String format = String.format("SELECT aux_index FROM %s NOT INDEXED JOIN FTS5ChatRoomMembers ON (aux_index = chatroom) WHERE member=? AND subtype=38 AND type=131075 ORDER BY timestamp desc", new Object[]{a.aMR()});
        Cursor rawQuery = a.mJR.rawQuery(format, new String[]{str});
        hVar.mMc = new ArrayList();
        while (rawQuery.moveToNext()) {
            j jVar = new j();
            jVar.mLs = rawQuery.getString(0);
            hVar.mMc.add(jVar);
        }
        rawQuery.close();
        hVar.bjW = 0;
    }

    public final String getName() {
        return "SearchChatroomByMemberTask";
    }
}
