package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.ls;
import com.tencent.mm.protocal.c.lt;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardSetPhotoWord";
    private b gJQ;
    private e gJT;
    public String kHm;
    public lt ljz;

    public h(String str) {
        a aVar = new a();
        aVar.hmj = new ls();
        aVar.hmk = new lt();
        aVar.hmi = 1649;
        aVar.uri = "/cgi-bin/mmpay-bin/setrewardqrcodephotoword";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((ls) this.gJQ.hmg.hmo).kHm = str;
        this.kHm = str;
        if (str.length() > 0 && str.length() <= 3) {
            g.pQN.a(724, 0, 1, false);
        } else if (str.length() > 3) {
            g.pQN.a(724, 1, 1, false);
        }
    }

    public final int getType() {
        return 1649;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQrRewardSetPhotoWord", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.ljz = (lt) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneQrRewardSetPhotoWord", "retcode: %s, retmsg: %s", Integer.valueOf(this.ljz.liH), this.ljz.liI);
        if (!(this.ljp || this.ljz.liH == 0)) {
            this.ljq = true;
        }
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }
}
