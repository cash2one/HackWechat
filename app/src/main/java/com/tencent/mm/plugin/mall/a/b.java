package com.tencent.mm.plugin.mall.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aei;
import com.tencent.mm.protocal.c.aej;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    private e gJT;
    private com.tencent.mm.ae.b hNJ;
    private aei okR;
    public aej okS;

    public b() {
        a aVar = new a();
        aVar.hmj = new aei();
        aVar.hmk = new aej();
        aVar.hmi = 1754;
        aVar.uri = "/cgi-bin/mmpay-bin/tenpay/getpaymenu";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hNJ = aVar.JZ();
        this.okR = (aei) this.hNJ.hmg.hmo;
    }

    public final int getType() {
        return 1754;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneGetPayMenu", "doScene");
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetPayMenu", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            int size;
            this.okS = (aej) this.hNJ.hmh.hmo;
            String str2 = "MicroMsg.NetSceneGetPayMenu";
            String str3 = "onGYNetEnd, title: %s, sectors: %s, sectors.size: %s";
            Object[] objArr = new Object[3];
            objArr[0] = this.okS.title;
            objArr[1] = this.okS.wmF;
            if (this.okS.wmF != null) {
                size = this.okS.wmF.size();
            } else {
                size = 0;
            }
            objArr[2] = Integer.valueOf(size);
            x.i(str2, str3, objArr);
        }
        this.gJT.a(i2, i3, str, this);
    }
}
