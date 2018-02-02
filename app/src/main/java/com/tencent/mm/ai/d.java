package com.tencent.mm.ai;

import android.database.Cursor;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.af;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class d extends af {
    public final void transfer(int i) {
        x.d("MicroMsg.VerifyFlagDataTransfer", "the previous version is %d", new Object[]{Integer.valueOf(i)});
        if (gN(i)) {
            g.pQN.h(336, 10);
            long currentTimeMillis = System.currentTimeMillis();
            ar.Hg();
            if (bh.e((Integer) c.CU().get(86017, null)) == 3) {
                x.w("MicroMsg.VerifyFlagDataTransfer", "check old contact not exist");
                return;
            }
            ar.Hg();
            c.EV().fx("rcontact", "update rcontact set verifyflag=0 where verifyflag is null;");
            ar.Hg();
            Cursor b = c.EY().b("@all.weixin.android", "", null);
            b.moveToFirst();
            while (!b.isAfterLast()) {
                com.tencent.mm.g.b.af xVar = new com.tencent.mm.storage.x();
                xVar.b(b);
                ar.Hg();
                c.EY().c(xVar.field_username, xVar);
                b.moveToNext();
            }
            b.close();
            x.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag from the beginning to update finish use %d ms", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
            ar.Hg();
            c.CU().set(86017, Integer.valueOf(3));
            x.d("MicroMsg.VerifyFlagDataTransfer", "update verifyflag use time " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return;
        }
        x.w("MicroMsg.VerifyFlagDataTransfer", "do not need transfer");
    }

    public final boolean gN(int i) {
        return i != 0 && i < 604176383;
    }

    public final String getTag() {
        return "MicroMsg.VerifyFlagDataTransfer";
    }
}
