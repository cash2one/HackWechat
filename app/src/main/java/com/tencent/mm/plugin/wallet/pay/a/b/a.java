package com.tencent.mm.plugin.wallet.pay.a.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.jv;
import com.tencent.mm.protocal.c.jw;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.l;

public class a extends l {
    private b gJQ;
    private e gJT;

    public a(String str, int i, int i2) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        com.tencent.mm.bq.a jvVar = new jv();
        jvVar.vIT = str;
        jvVar.vQL = i;
        jvVar.vQM = i2;
        aVar.hmj = jvVar;
        aVar.hmk = new jw();
        aVar.uri = getUri();
        aVar.hmi = Hr();
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        x.i("MicroMsg.NetSceneCancelPay", "request uri: %s, reqKey: %s, payScene: %d, payChannel:%d", new Object[]{getUri(), str, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneCancelPay", "response uri: %s, errType: %d, errCode: %d, errMsg: %s", new Object[]{getUri(), Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            try {
                jw jwVar = (jw) ((b) qVar).hmh.hmo;
                x.i("MicroMsg.NetSceneCancelPay", "NetSceneCancelPay BaseResponse.Ret is %d, BaseResponse.ErrMsg is %s", new Object[]{Integer.valueOf(jwVar.wJr.vJU), jwVar.wJr.vLc});
            } catch (Exception e) {
                x.i("MicroMsg.NetSceneCancelPay", e.getMessage());
            }
        }
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
    }

    public final int getType() {
        return Hr();
    }

    public int Hr() {
        return 2823;
    }

    public String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/ts_cancelpay";
    }
}
