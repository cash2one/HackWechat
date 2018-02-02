package com.tencent.mm.plugin.card.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class l$1 implements Runnable {
    l$1() {
    }

    public final void run() {
        x.i("MicroMsg.CardMsgManager", "begin to clearRedDotAndWording()");
        ar.Hg();
        c.CU().a(a.xoi, "");
        ar.Hg();
        c.CU().a(a.xoo, Integer.valueOf(0));
        ar.Hg();
        c.CU().a(a.xol, "");
        ar.Hg();
        c.CU().a(a.xom, "");
        ar.Hg();
        c.CU().a(a.xon, "");
        ar.Hg();
        c.CU().a(a.xoz, "");
        ar.Hg();
        c.CU().a(a.xoA, Boolean.valueOf(false));
        if (com.tencent.mm.s.c.Bq().aR(262152, 266256)) {
            com.tencent.mm.s.c.Bq().p(262152, false);
        }
        if (com.tencent.mm.s.c.Bq().aQ(262152, 266256)) {
            com.tencent.mm.s.c.Bq().o(262152, false);
        }
        if (com.tencent.mm.s.c.Bq().a(a.xoc, a.xoe)) {
            com.tencent.mm.s.c.Bq().a(a.xoc, false);
        }
        if (com.tencent.mm.s.c.Bq().a(a.xod, a.xof)) {
            com.tencent.mm.s.c.Bq().a(a.xod, false);
        }
        x.i("MicroMsg.CardMsgManager", "end to clearRedDotAndWording()");
    }
}
