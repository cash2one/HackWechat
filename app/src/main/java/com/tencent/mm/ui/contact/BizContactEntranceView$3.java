package com.tencent.mm.ui.contact;

import android.database.Cursor;
import com.tencent.mm.ag.e;
import com.tencent.mm.ag.y;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class BizContactEntranceView$3 implements Runnable {
    final /* synthetic */ BizContactEntranceView yRl;

    BizContactEntranceView$3(BizContactEntranceView bizContactEntranceView) {
        this.yRl = bizContactEntranceView;
    }

    public final void run() {
        long j = 0;
        e Mf = y.Mf();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select updateTime from BizInfo").append(" where type = 1");
        stringBuilder.append(" and status = 1").append(" ORDER BY updateTime DESC");
        x.i("MicroMsg.BizInfoStorage", "getLastNewBizUpdateTime, sql %s", stringBuilder.toString());
        Cursor rawQuery = Mf.rawQuery(r1, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                j = rawQuery.getLong(0);
                rawQuery.close();
            } else {
                rawQuery.close();
            }
        }
        ar.Hg();
        x.i("MicroMsg.BizContactEntranceView", "last updateTime %d, enterTime %d", Long.valueOf(j), Long.valueOf(bh.bZ(c.CU().get(233473, null))));
        ag.y(new 1(this, j, r4));
    }
}
