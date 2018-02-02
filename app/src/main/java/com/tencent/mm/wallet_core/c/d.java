package com.tencent.mm.wallet_core.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiBatchGetContact;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.jz;
import com.tencent.mm.protocal.c.ka;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends l {
    private b gJQ;
    private e gJT;

    public d(String str, String str2) {
        a aVar = new a();
        aVar.hmj = new jz();
        aVar.hmk = new ka();
        aVar.uri = "/cgi-bin/mmpay-bin/cancelqrpay";
        aVar.hmi = JsApiBatchGetContact.CTRL_INDEX;
        aVar.hml = bc.CTRL_INDEX;
        aVar.hmm = 1000000198;
        this.gJQ = aVar.JZ();
        jz jzVar = (jz) this.gJQ.hmg.hmo;
        jzVar.vQR = str;
        jzVar.vIT = str2;
        jzVar.vQS = i.bLf();
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneCancelQRPay", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.gJT.a(i, i2, str, this);
    }

    public final int getType() {
        return JsApiBatchGetContact.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
