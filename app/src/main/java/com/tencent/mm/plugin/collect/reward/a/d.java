package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.lm;
import com.tencent.mm.protocal.c.ln;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardPayCheck";
    private b gJQ;
    private e gJT;
    private ln ljv;

    public d(String str, String str2, String str3, int i, String str4, String str5) {
        a aVar = new a();
        aVar.hmj = new lm();
        aVar.hmk = new ln();
        aVar.hmi = 1960;
        aVar.uri = "/cgi-bin/mmpay-bin/rewardqrcodepaycheck";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        lm lmVar = (lm) this.gJQ.hmg.hmo;
        lmVar.fwY = str;
        lmVar.vUn = str2;
        lmVar.vHr = str3;
        lmVar.nZd = i;
        lmVar.vUl = str4;
        lmVar.vUk = str5;
        x.i("MicroMsg.NetSceneQrRewardPayCheck", "rewardid: %s, amt: %s", str2, Integer.valueOf(i));
    }

    public final int getType() {
        return 1960;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQrRewardPayCheck", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.ljv = (ln) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneQrRewardPayCheck", "retcode: %s, retmsg: %s", Integer.valueOf(this.ljv.liH), this.ljv.liI);
        if (!(this.ljp || this.ljv.liH == 0)) {
            this.ljq = true;
        }
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }
}
