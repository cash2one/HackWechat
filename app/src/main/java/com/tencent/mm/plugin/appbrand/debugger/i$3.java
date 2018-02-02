package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.ae.b;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.c.afm;
import com.tencent.mm.sdk.platformtools.x;

class i$3 implements a {
    final /* synthetic */ i iQE;

    i$3(i iVar) {
        this.iQE = iVar;
    }

    public final void a(int i, int i2, String str, b bVar) {
        if (i == 0 && i2 == 0 && bVar.hmh.hmo != null) {
            this.iQE.iQx.rd(((afm) bVar.hmh.hmo).wnw);
            x.i("MicroMsg.RemoteDebugJsEngine", "loginTicket %s", r0.wnw);
            if (this.iQE.iQA.isOpen()) {
                i.a(this.iQE);
                return;
            }
            return;
        }
        String str2 = "MicroMsg.RemoteDebugJsEngine";
        String str3 = "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %b";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = str;
        objArr[3] = Boolean.valueOf(bVar.hmh.hmo == null);
        x.e(str2, str3, objArr);
    }
}
