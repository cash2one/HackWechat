package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ld;
import com.tencent.mm.protocal.c.le;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardGetCode";
    private com.tencent.mm.ae.b gJQ;
    private e gJT;
    public le ljs;
    public boolean ljt;

    public b(boolean z) {
        a aVar = new a();
        aVar.hmj = new ld();
        aVar.hmk = new le();
        aVar.hmi = 1323;
        aVar.uri = "/cgi-bin/mmpay-bin/getrewardqrcode";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((ld) this.gJQ.hmg.hmo).vTU = z;
        this.ljt = z;
    }

    public final int getType() {
        return 1323;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    protected final boolean ayR() {
        return false;
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQrRewardGetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.ljs = (le) ((com.tencent.mm.ae.b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneQrRewardGetCode", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.ljs.liH), this.ljs.liI});
        if (!(this.ljp || this.ljs.liH == 0)) {
            this.ljq = true;
        }
        if (!this.ljp && !this.ljq) {
            g.Dj().CU().a(w.a.xwP, Integer.valueOf(this.ljs.vUb));
            g.Dj().CU().a(w.a.xwQ, Integer.valueOf(this.ljs.vTX));
            g.Dj().CU().a(w.a.xwS, this.ljs.desc);
            g.Dj().CU().a(w.a.xwR, this.ljs.kHm);
            g.Dj().CU().a(w.a.xwU, Integer.valueOf(this.ljs.vUa));
            g.Dj().CU().a(w.a.xwW, this.ljs.kLA);
            g.Dj().CU().a(w.a.xwX, this.ljs.vTZ);
            g.Dj().CU().a(w.a.xwY, this.ljs.pKb);
            List arrayList = new ArrayList();
            Iterator it = this.ljs.vTY.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(((Integer) it.next()).intValue()));
            }
            g.Dj().CU().a(w.a.xwV, bh.d(arrayList, ","));
            com.tencent.mm.plugin.report.service.g.pQN.a(724, 2, 1, false);
        } else if (this.ljp) {
            com.tencent.mm.plugin.report.service.g.pQN.a(724, 4, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.a(724, 3, 1, false);
        }
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }
}
