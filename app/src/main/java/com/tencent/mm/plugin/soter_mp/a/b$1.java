package com.tencent.mm.plugin.soter_mp.a;

import com.tencent.d.b.a.b;
import com.tencent.d.b.a.c;
import com.tencent.d.b.a.e;
import com.tencent.mm.plugin.soter.c.a;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements b<c> {
    final /* synthetic */ b rTf;

    b$1(b bVar) {
        this.rTf = bVar;
    }

    public final /* synthetic */ void a(e eVar) {
        c cVar = (c) eVar;
        x.i("MicroMsg.SoterControllerFingerprint", "hy: update mp auth key result: errcode: %d, errmsg: %s", new Object[]{Integer.valueOf(cVar.errCode), cVar.fnL});
        b.bCX();
        if (cVar.isSuccess()) {
            b.a(this.rTf, false);
        } else {
            a.dM(2, cVar.errCode);
        }
        if (cVar.errCode == 12) {
            x.e("MicroMsg.SoterControllerFingerprint", "hy: model is null");
            this.rTf.rTk.errCode = 90007;
            this.rTf.rTk.fnL = "auth key can not be retrieved";
            this.rTf.bDa();
        } else if (cVar.errCode == 5) {
            x.v("MicroMsg.SoterControllerFingerprint", "alvinluo: gen auth key failed, remove auth key");
            com.tencent.d.b.a.Ia(2);
            this.rTf.rTk.errCode = 90007;
            this.rTf.rTk.fnL = "auth key generate failed";
            this.rTf.bDa();
        } else if (cVar.errCode == 10) {
            x.i("MicroMsg.SoterControllerFingerprint", "hy: update auth key failed. remove auth key");
            com.tencent.d.b.a.Ia(2);
            this.rTf.rTk.errCode = 90007;
            this.rTf.rTk.fnL = "auth key update error";
            this.rTf.bDa();
        }
    }
}
