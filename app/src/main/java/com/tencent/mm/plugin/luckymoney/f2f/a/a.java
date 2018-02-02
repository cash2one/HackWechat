package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.tv;
import com.tencent.mm.protocal.c.tw;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    private tv nYW;
    private tw nYX;

    public a(String str) {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new tv();
        aVar.hmk = new tw();
        aVar.hmi = 1987;
        aVar.hml = 0;
        aVar.hmm = 0;
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffclearwxhb";
        this.hNJ = aVar.JZ();
        this.nYW = (tv) this.hNJ.hmg.hmo;
        this.nYW.nZa = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.nYX = (tw) ((b) qVar).hmh.hmo;
        x.i("NetSceneF2FLuckyMoneyClear", "errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.nYX.liH), this.nYX.liI});
        if (this.gJT != null) {
            this.gJT.a(i2, this.nYX.liH, this.nYX.liI, this);
        }
    }

    public final int getType() {
        return 1987;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }
}
