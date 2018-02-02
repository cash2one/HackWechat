package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.plugin.fts.a.a;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import java.util.ArrayList;

class a$l extends f {
    final /* synthetic */ a mMS;

    public a$l(a aVar, g gVar) {
        this.mMS = aVar;
        super(gVar);
    }

    protected final void a(h hVar) {
        int i = 0;
        super.a(hVar);
        a a = a.a(this.mMS);
        String str = this.mLN.fDj;
        Cursor rawQuery = a.mJR.rawQuery("SELECT count(*) FROM FTS5ChatRoomMembers WHERE member=?", new String[]{str});
        if (rawQuery.moveToNext()) {
            i = rawQuery.getInt(0);
        }
        rawQuery.close();
        j jVar = new j();
        jVar.userData = Integer.valueOf(i);
        hVar.mMc = new ArrayList();
        hVar.mMc.add(jVar);
    }

    public final String getName() {
        return "SearchChatroomCountTask";
    }
}
