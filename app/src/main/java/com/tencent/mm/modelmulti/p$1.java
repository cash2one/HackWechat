package com.tencent.mm.modelmulti;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.report.service.d;
import com.tencent.mm.sdk.platformtools.x;

class p$1 implements e {
    final /* synthetic */ p hGP;

    p$1(p pVar) {
        this.hGP = pVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        String str2 = "MicroMsg.SubCoreBaseMonitor";
        String str3 = "summerhv onIDKeyCallback onSceneEnd[%d][%d, %d, %s]";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(kVar == null ? -1 : kVar.getType());
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = str;
        x.i(str2, str3, objArr);
        if (i == 0 && i2 == 0) {
            d.boj();
        }
    }
}
