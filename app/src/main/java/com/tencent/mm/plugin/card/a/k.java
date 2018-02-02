package com.tencent.mm.plugin.card.a;

import android.database.Cursor;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.pluginsdk.q.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;

public final class k implements c {
    public final boolean auj() {
        return l.axf();
    }

    public final boolean auk() {
        return l.axh();
    }

    public final String aul() {
        ar.Hg();
        return (String) com.tencent.mm.z.c.CU().get(a.USERINFO_CARD_REDOT_WORDING_STRING_SYNC, null);
    }

    public final int aum() {
        int i = 0;
        com.tencent.mm.plugin.card.model.c auA = am.auA();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where (status=0 OR ").append("status=5) and (block_mask").append("= '1' OR block_mask= '0' ").append(")");
        Cursor a = auA.gJP.a("select count(*) from UserCardInfo" + stringBuilder.toString(), null, 2);
        if (a != null) {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
        }
        x.i("MicroMsg.CardMgrImpl", "getGiftCardCount:" + i);
        return i;
    }

    public final boolean nG(int i) {
        return l.nG(i);
    }
}
