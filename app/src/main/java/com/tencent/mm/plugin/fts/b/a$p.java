package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.a.a.j;
import java.util.ArrayList;

public class a$p extends f {
    final /* synthetic */ a mMS;

    public a$p(a aVar, g gVar) {
        this.mMS = aVar;
        super(gVar);
    }

    protected final void a(h hVar) {
        long longValue = Long.valueOf(this.mLN.fDj).longValue();
        Cursor rawQuery = r2.mJR.rawQuery(String.format("SELECT distinct(aux_index) FROM %s WHERE timestamp < %d AND type = %d", new Object[]{a.a(this.mMS).aMR(), Long.valueOf(longValue), Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)}), null);
        hVar.mMc = new ArrayList();
        while (rawQuery.moveToNext()) {
            j jVar = new j();
            jVar.mLs = rawQuery.getString(0);
            hVar.mMc.add(jVar);
        }
        rawQuery.close();
    }

    public final String getName() {
        return "SearchContactSmallerTimestampTask";
    }
}
