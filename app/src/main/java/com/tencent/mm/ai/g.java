package com.tencent.mm.ai;

import android.database.Cursor;
import com.tencent.mm.by.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.af;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;
import com.tencent.mm.z.s;

public final class g extends af {
    public final String getTag() {
        return "MicroMsg.App.SyncTopConversation";
    }

    public final boolean gN(int i) {
        return i != 0 && i < 620758015;
    }

    public final void transfer(int i) {
        x.d("MicroMsg.App.SyncTopConversation", "the previous version is %d", new Object[]{Integer.valueOf(i)});
        com.tencent.mm.plugin.report.service.g.pQN.h(336, 15);
        ar.Hg();
        h EV = c.EV();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select username from rconversation");
        stringBuilder.append(" where flag & 4611686018427387904").append(" != 0");
        x.d("MicroMsg.App.SyncTopConversation", "sql:%s", new Object[]{stringBuilder});
        Cursor a = EV.a(stringBuilder.toString(), null, 2);
        if (a != null) {
            while (a.moveToNext()) {
                x.v("MicroMsg.App.SyncTopConversation", "userName %s", new Object[]{a.getString(0)});
                s.r(r1, false);
            }
            a.close();
        }
    }
}
