package com.tencent.mm.plugin.collect.reward.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.lo;
import com.tencent.mm.protocal.c.lp;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends a {
    private final String TAG = "MicroMsg.NetSceneQrRewardPlaceOrder";
    private b gJQ;
    private com.tencent.mm.ae.e gJT;
    public lp ljw;

    public e(int i, int i2, String str, String str2, String str3, int i3, String str4, String str5, String str6, String str7, String str8) {
        a aVar = new a();
        aVar.hmj = new lo();
        aVar.hmk = new lp();
        aVar.hmi = 1336;
        aVar.uri = "/cgi-bin/mmpay-bin/rewardqrcodeplaceorder";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        lo loVar = (lo) this.gJQ.hmg.hmo;
        loVar.nZd = i;
        loVar.vUq = i2;
        loVar.vUo = str;
        loVar.vUp = str2;
        loVar.pLh = str3;
        loVar.fCR = i3;
        loVar.vUr = str4;
        loVar.vUl = str5;
        loVar.vUs = str6;
        loVar.vUt = str7;
        loVar.vUu = str8;
    }

    public final int getType() {
        return 1336;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void b(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneQrRewardPlaceOrder", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        this.ljw = (lp) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneQrRewardPlaceOrder", "retcode: %s, retmsg: %s", Integer.valueOf(this.ljw.liH), this.ljw.liI);
        if (!(this.ljp || this.ljw.liH == 0)) {
            this.ljq = true;
        }
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }
}
