package com.tencent.mm.plugin.welab;

import com.tencent.mm.modelsns.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.x;

public final class e {
    public static void a(a aVar) {
        int i;
        d dVar = new d();
        dVar.q("expid", aVar.tPA + ",");
        dVar.q("appid", aVar.fFm + ",");
        dVar.q("action", aVar.action + ",");
        dVar.q("timestamp", aVar.hOG + ",");
        String str = "hasRedPoint";
        StringBuilder stringBuilder = new StringBuilder();
        if (aVar.tPB) {
            i = 1;
        } else {
            i = 0;
        }
        dVar.q(str, stringBuilder.append(i).append(",").toString());
        x.i("WelabReporter", "report " + dVar.Sz());
        g.pQN.h(14206, new Object[]{dVar});
    }

    public static void o(String str, int i, boolean z) {
        a aVar = new a();
        aVar.fFm = str;
        aVar.action = i;
        aVar.hOG = System.currentTimeMillis();
        aVar.tPA = b.bVu().Qw(str).field_expId;
        aVar.tPB = z;
        a(aVar);
    }
}
