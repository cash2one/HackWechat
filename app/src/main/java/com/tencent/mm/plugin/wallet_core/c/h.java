package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yk;
import com.tencent.mm.sdk.platformtools.x;

public final class h extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    private yj sIp;
    public yk sIq;
    public long sIr;

    public h(String str, long j) {
        a aVar = new a();
        aVar.hmj = new yj();
        aVar.hmk = new yk();
        aVar.uri = "/cgi-bin/mmpay-bin/mktgetaward";
        aVar.hmi = 2948;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        this.sIp = (yj) this.hNJ.hmg.hmo;
        this.sIp.wiD = str;
        this.sIr = j;
        x.i("MicroMsg.NetSceneMktGetAward", "NetSceneMktGetAward, get_award_params: %s, activityId: %s", new Object[]{str, Long.valueOf(j)});
    }

    public final int getType() {
        return 2948;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMktGetAward", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.sIq = (yk) ((b) qVar).hmh.hmo;
        if (i2 == 0 || i3 == 0) {
            x.i("MicroMsg.NetSceneMktGetAward", "ret_code: %s, ret_msg: %s, result_code: %s, alert_wording: %s, btn_wording: %s", new Object[]{Integer.valueOf(this.sIq.kLO), this.sIq.kLP, Integer.valueOf(this.sIq.wiE), this.sIq.wiF, this.sIq.wiG});
        }
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
