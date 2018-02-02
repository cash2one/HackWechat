package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class g extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardSetCode";
    private b gJQ;
    private e gJT;
    public lv ljy;

    public g(LinkedList<Integer> linkedList, String str, boolean z, boolean z2) {
        a aVar = new a();
        aVar.hmj = new lu();
        aVar.hmk = new lv();
        aVar.hmi = 1562;
        aVar.uri = "/cgi-bin/mmpay-bin/setrewardqrcode";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        lu luVar = (lu) this.gJQ.hmg.hmo;
        luVar.vTY = linkedList;
        luVar.desc = str;
        luVar.vUx = z;
        luVar.vUy = z2;
        x.i("MicroMsg.NetSceneQrRewardSetCode", "desc: %s, flag: %s, default: %s", new Object[]{str, Boolean.valueOf(z), Boolean.valueOf(z2)});
    }

    public final int getType() {
        return 1562;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQrRewardSetCode", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.ljy = (lv) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneQrRewardSetCode", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.ljy.liH), this.ljy.liI});
        if (!(this.ljp || this.ljy.liH == 0)) {
            this.ljq = true;
        }
        if (!this.ljp && !this.ljq) {
            com.tencent.mm.kernel.g.Dj().CU().a(w.a.xwP, Integer.valueOf(this.ljy.vUb));
            com.tencent.mm.kernel.g.Dj().CU().a(w.a.xwQ, Integer.valueOf(this.ljy.vTX));
            com.tencent.mm.kernel.g.Dj().CU().a(w.a.xwS, this.ljy.desc);
            com.tencent.mm.kernel.g.Dj().CU().a(w.a.xwY, this.ljy.pKb);
            List arrayList = new ArrayList();
            Iterator it = this.ljy.vTY.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(((Integer) it.next()).intValue()));
            }
            com.tencent.mm.kernel.g.Dj().CU().a(w.a.xwV, bh.d(arrayList, ","));
            com.tencent.mm.plugin.report.service.g.pQN.a(724, 5, 1, false);
        } else if (this.ljp) {
            com.tencent.mm.plugin.report.service.g.pQN.a(724, 7, 1, false);
        } else {
            com.tencent.mm.plugin.report.service.g.pQN.a(724, 6, 1, false);
        }
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }
}
