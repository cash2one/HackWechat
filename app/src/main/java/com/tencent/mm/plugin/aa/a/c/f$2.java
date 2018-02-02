package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.s;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;

class f$2 implements a<Void, com.tencent.mm.ae.a.a<s>> {
    final /* synthetic */ f ihD;
    final /* synthetic */ b ihn;

    f$2(f fVar, b bVar) {
        this.ihD = fVar;
        this.ihn = bVar;
    }

    public final /* synthetic */ Object call(Object obj) {
        com.tencent.mm.ae.a.a aVar = (com.tencent.mm.ae.a.a) obj;
        x.i("MicroMsg.PaylistAAInteractor", "on urgeAAPay finish, errType: %s, errCode: %s", new Object[]{Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode)});
        if (aVar.errType == 0 && aVar.errCode == 0) {
            s sVar = (s) aVar.fJJ;
            x.i("MicroMsg.PaylistAAInteractor", "on urgeAAPay finish, retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(sVar.liH), sVar.liI});
            if (sVar.liH == 0) {
                x.i("MicroMsg.PaylistAAInteractor", "on urgeAAPay success");
                com.tencent.mm.plugin.aa.a.ift.um();
                this.ihn.t(new Object[]{Boolean.valueOf(true)});
                g.pQN.a(407, 24, 1, false);
            } else {
                if (sVar.liH <= 0 || bh.ov(sVar.liI)) {
                    this.ihn.cl(Boolean.valueOf(false));
                } else {
                    this.ihn.cl(sVar.liI);
                }
                g.pQN.a(407, 26, 1, false);
            }
        } else {
            this.ihn.cl(Boolean.valueOf(false));
            g.pQN.a(407, 25, 1, false);
        }
        return zBS;
    }
}
