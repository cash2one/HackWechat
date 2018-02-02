package com.tencent.mm.modelappbrand;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cbq;
import com.tencent.mm.protocal.c.cbr;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends k implements com.tencent.mm.network.k {
    private e gOB;
    private final b hjD;

    public o(String str) {
        a aVar = new a();
        aVar.hmj = new cbq();
        aVar.hmk = new cbr();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/wxatmplcomplaint";
        this.hjD = aVar.JZ();
        ((cbq) this.hjD.hmg.hmo).xaK = str;
    }

    public final cbr Jf() {
        if (this.hjD != null) {
            return (cbr) this.hjD.hmh.hmo;
        }
        return null;
    }

    public final int getType() {
        return 1198;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gOB != null) {
            this.gOB.a(i2, i3, str, this);
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
        this.gOB = eVar2;
        return a(eVar, this.hjD, this);
    }
}
