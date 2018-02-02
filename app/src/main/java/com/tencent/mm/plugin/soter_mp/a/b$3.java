package com.tencent.mm.plugin.soter_mp.a;

import com.tencent.d.b.a.a;
import com.tencent.d.b.a.b;
import com.tencent.d.b.a.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements b<a> {
    final /* synthetic */ b rTf;

    b$3(b bVar) {
        this.rTf = bVar;
    }

    public final /* synthetic */ void a(e eVar) {
        a aVar = (a) eVar;
        x.i("MicroMsg.SoterControllerFingerprint", "alvinluo request authentication result errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(aVar.errCode), aVar.fnL});
        this.rTf.rSW = false;
        if (aVar.isSuccess()) {
            ag.h(new 1(this, aVar), 500);
            return;
        }
        com.tencent.mm.plugin.soter.c.a.dM(3, aVar.errCode);
        if (aVar.errCode == 13 || aVar.errCode == 20) {
            x.i("MicroMsg.SoterControllerFingerprint", "hy: start authen error, maybe key invalid. remove former key and give suggestion");
            com.tencent.d.b.a.Ia(2);
            this.rTf.rTk.errCode = 90007;
            this.rTf.rTk.fnL = "start fingerprint authen failed";
        } else if (aVar.errCode == 25) {
            this.rTf.rTk.errCode = 90010;
            this.rTf.rTk.fnL = "authenticate freeze. please try again later";
        } else {
            this.rTf.rTk.errCode = 90007;
            this.rTf.rTk.fnL = "authenticate error: " + aVar.fnL;
        }
        this.rTf.bDa();
    }
}
