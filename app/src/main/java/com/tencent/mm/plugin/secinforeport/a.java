package com.tencent.mm.plugin.secinforeport;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.secinforeport.a.b;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.protocal.c.og;
import com.tencent.mm.protocal.c.oh;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.charset.Charset;

public enum a implements b {
    ;

    private a(String str) {
    }

    public final void a(int i, String str, int i2, byte[] bArr) {
        if (str == null) {
            x.w("MicroMsg.ClipBordReportImpl", "operationInfo isNullOrNil");
            return;
        }
        og ogVar = new og();
        ogVar.vXg = i;
        ogVar.vXi = i2;
        ogVar.vXh = new bdn().bj(str.getBytes(Charset.forName("UTF-8")));
        if (!bh.bw(bArr)) {
            ogVar.vXj = new bdn().bj(bArr);
        }
        com.tencent.mm.bq.a ohVar = new oh();
        ohVar.vXl.add(ogVar);
        ohVar.vXk = ohVar.vXl.size();
        ((h) g.h(h.class)).EX().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(com.tencent.mm.plugin.appbrand.jsapi.share.h.CTRL_INDEX, ohVar));
    }
}
