package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class h extends i<g> {
    public static final String[] gJN = new String[]{i.a(g.gJc, "CardMsgInfo")};
    public e gJP;

    public h(e eVar) {
        super(eVar, g.gJc, "CardMsgInfo", null);
        this.gJP = eVar;
    }

    public final Cursor Tj() {
        return this.gJP.rawQuery("select * from CardMsgInfo order by time desc", null);
    }

    public final int Tq() {
        int i = 0;
        Cursor a = this.gJP.a(" select count(*) from CardMsgInfo where read_state = ? ", new String[]{"1"}, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        return i;
    }

    public final boolean auv() {
        return this.gJP.fx("CardMsgInfo", " update CardMsgInfo set read_state = 0  where read_state = 1");
    }
}
