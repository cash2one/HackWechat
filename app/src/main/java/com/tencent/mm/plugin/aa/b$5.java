package com.tencent.mm.plugin.aa;

import com.tencent.mm.ae.d.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.protocal.d;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.Map;

class b$5 implements m {
    final /* synthetic */ b ifC;

    b$5(b bVar) {
        this.ifC = bVar;
    }

    public final void b(String str, Map<String, String> map, a aVar) {
        x.d("MicroMsg.SubCoreAA", "paymsgtype: %d, current version: %d", new Object[]{Integer.valueOf(bh.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), 0)), Integer.valueOf(d.vAz)});
        if (bh.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), 0) == 32) {
            int i = bh.getInt((String) map.get(".sysmsg.paymsg.receiveorpayreddot"), 0);
            int i2 = bh.getInt((String) map.get(".sysmsg.paymsg.grouppayreddot"), 0);
            int i3 = bh.getInt((String) map.get(".sysmsg.paymsg.facingreceivereddot"), 0);
            int i4 = bh.getInt((String) map.get(".sysmsg.paymsg.f2fhongbaoreddot"), 0);
            int i5 = bh.getInt((String) map.get(".sysmsg.paymsg.rewardcodereddot"), 0);
            int i6 = bh.getInt((String) map.get(".sysmsg.paymsg.android_minclientversion"), 0);
            String az = bh.az((String) map.get(".sysmsg.paymsg.facingreceivereddotwording"), "");
            g.Dk();
            g.Dj().CU().a(w.a.xww, az);
            if (d.vAz >= i6) {
                boolean z;
                if (i == 1) {
                    x.i("MicroMsg.SubCoreAA", "mark recv or pay red dot");
                    c.Bq().p(262159, true);
                    z = true;
                } else {
                    z = false;
                }
                if (i2 == 1) {
                    x.i("MicroMsg.SubCoreAA", "mark group pay red dot");
                    c.Bq().b(w.a.xxe, true);
                    z = true;
                }
                if (i3 == 1) {
                    x.i("MicroMsg.SubCoreAA", "mark f2f recv red dot");
                    c.Bq().b(w.a.xxf, true);
                    z = true;
                }
                if (i4 == 1) {
                    x.i("MicroMsg.SubCoreAA", "mark f2f hb red dot");
                    c.Bq().b(w.a.xxg, true);
                    z = true;
                }
                if (i5 == 1) {
                    x.i("MicroMsg.SubCoreAA", "mark qr reward red dot");
                    c.Bq().b(w.a.xxh, true);
                    z = true;
                }
                if (z) {
                    g.Dj().CU().a(w.a.xxj, Boolean.valueOf(false));
                }
            }
            com.tencent.mm.plugin.report.service.g.pQN.h(14396, new Object[]{Integer.valueOf(1)});
        }
    }
}
