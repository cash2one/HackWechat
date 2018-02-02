package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.lq;
import com.tencent.mm.protocal.c.lr;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardScanCode";
    private b gJQ;
    private e gJT;
    public lr ljx;

    public f(String str, int i, String str2) {
        a aVar = new a();
        aVar.hmj = new lq();
        aVar.hmk = new lr();
        aVar.hmi = 1516;
        aVar.uri = "/cgi-bin/mmpay-bin/scanrewardqrcode";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        lq lqVar = (lq) this.gJQ.hmg.hmo;
        lqVar.liJ = str;
        lqVar.fCR = i;
        lqVar.vUs = str2;
    }

    public final int getType() {
        return 1516;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQrRewardScanCode", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        this.ljx = (lr) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneQrRewardScanCode", "retcode: %s, retmsg: %s", new Object[]{Integer.valueOf(this.ljx.liH), this.ljx.liI});
        if (!(this.ljp || this.ljx.liH == 0)) {
            this.ljq = true;
        }
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }

    protected final boolean ayR() {
        return false;
    }
}
