package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.azq;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends com.tencent.mm.ae.k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    public String rVK;
    private azq sIw;
    public azr sIx;

    public k(String str, String str2) {
        a aVar = new a();
        aVar.hmj = new azq();
        aVar.hmk = new azr();
        aVar.hmi = 2710;
        aVar.uri = "/cgi-bin/mmpay-bin/mktqueryawardstatus";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        this.sIw = (azq) this.hNJ.hmg.hmo;
        this.sIw.sUx = str;
        this.rVK = str2;
        x.i("MicroMsg.NetSceneMtkQueryAwardStatus", "NetSceneMtkQueryAwardStatus, query_award_status_params: %s, activityId: %s", new Object[]{str, str2});
    }

    public final int getType() {
        return 2710;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMtkQueryAwardStatus", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.sIx = (azr) ((b) qVar).hmh.hmo;
        if (i2 == 0 || i3 == 0) {
            x.i("MicroMsg.NetSceneMtkQueryAwardStatus", "ret_code: %s, ret_msg: %s", new Object[]{Integer.valueOf(this.sIx.kLO), this.sIx.kLP});
        }
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
