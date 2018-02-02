package com.tencent.mm.plugin.freewifi.e;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.freewifi.d.a;
import com.tencent.mm.plugin.freewifi.e.g.4;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.platformtools.x;

class g$3 implements e {
    final /* synthetic */ g mFi;

    g$3(g gVar) {
        this.mFi = gVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.i("MicroMsg.FreeWifi.ProtocolOne", "errType : %d, errCode : %d, errMsg : %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            a aVar = (a) kVar;
            x.i("MicroMsg.FreeWifi.ProtocolOne", "authUrl : %s", new Object[]{aVar.aLW()});
            ei aMc = aVar.aMc();
            if (aMc != null) {
                x.i("MicroMsg.FreeWifi.ProtocolOne", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", new Object[]{aMc.nkv, aMc.kub, aMc.ksU, Integer.valueOf(aMc.vJH), aMc.vJI, aMc.hvw});
                j.aLR().aLz().post(new 4(this.mFi, r0, aMc));
                return;
            }
            g.c(this.mFi);
            return;
        }
        g.c(this.mFi);
    }
}
