package com.tencent.mm.modelvideo;

import com.tencent.mm.plugin.a.b;
import com.tencent.mm.plugin.a.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class a {
    public static void a(r rVar, int i) {
        if (rVar == null) {
            x.w("MicroMsg.AtomStatUtil", "report moov location, but video info is null.");
            return;
        }
        int i2;
        long Wq = bh.Wq();
        o.TU();
        String nt = s.nt(rVar.getFileName());
        long j = 0;
        long j2 = 0;
        if (c.oy(nt)) {
            i2 = 1;
            b bVar = new b();
            j = bVar.ox(nt);
            j2 = bVar.ieF != null ? bVar.ieF.ieB : 0;
        } else {
            x.i("MicroMsg.AtomStatUtil", "download video finish, but it is not mp4 file.");
            i2 = 0;
        }
        long j3 = rVar.fFo;
        nt = r.nq(rVar.Ug());
        long j4 = (long) rVar.hlp;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j3).append(";").append(nt).append(";");
        stringBuilder.append(j4).append(";");
        stringBuilder.append(i2).append(";").append(j).append(";");
        stringBuilder.append(j2).append(";").append(i);
        x.d("MicroMsg.AtomStatUtil", "report moov content : " + stringBuilder.toString() + " cost time: " + bh.bA(Wq));
        g.pQN.h(11098, Integer.valueOf(8000), r0);
    }
}
