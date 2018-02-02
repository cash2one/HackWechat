package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.protocal.c.yq;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private com.tencent.mm.ae.e gJT;
    public yq sIj;

    public e(String str) {
        a aVar = new a();
        aVar.hmj = new yp();
        aVar.hmk = new yq();
        aVar.uri = "/cgi-bin/mmpay-bin/tenpay/getbanpaymobileinfo";
        aVar.hmi = 1667;
        this.gJQ = aVar.JZ();
        yp ypVar = (yp) this.gJQ.hmg.hmo;
        x.d("MicroMsg.NetSceneGetBanpayMobileInfo", "req_key: %s", new Object[]{str});
        ypVar.fwY = str;
    }

    public final int getType() {
        return 1667;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetBanpayMobileInfo", "NetSceneGetBanpayMobileInfo, netId: %s, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        this.sIj = (yq) this.gJQ.hmh.hmo;
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
