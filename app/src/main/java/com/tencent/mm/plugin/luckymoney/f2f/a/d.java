package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.au;
import com.tencent.mm.protocal.c.tz;
import com.tencent.mm.protocal.c.ua;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends k implements com.tencent.mm.network.k {
    private e gJT;
    private b hNJ;
    public String lOX;
    public String nZa;
    private tz nZn;
    private ua nZo;
    public String nZp;
    public String nZq;
    public int nZr;

    public d() {
        a aVar = new a();
        aVar.hmj = new tz();
        aVar.hmk = new ua();
        aVar.hmi = 1990;
        aVar.hml = 0;
        aVar.hmm = 0;
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffquerydowxhb";
        this.hNJ = aVar.JZ();
        this.nZn = (tz) this.hNJ.hmg.hmo;
        this.nZn.timestamp = System.currentTimeMillis() / 1000;
        au bLf = i.bLf();
        if (bLf != null) {
            this.nZn.latitude = bLf.latitude;
            this.nZn.longitude = bLf.longitude;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("NetSceneF2FLuckyMoneyQuery", "errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.nZo = (ua) ((b) qVar).hmh.hmo;
        this.nZa = this.nZo.nZa;
        this.lOX = this.nZo.lOX;
        this.nZr = this.nZo.wbZ;
        this.nZp = this.nZo.nZp;
        this.nZq = this.nZo.nZq;
        if (this.gJT != null) {
            this.gJT.a(i2, this.nZo.liH, this.nZo.liI, this);
        }
    }

    public final int getType() {
        return 1990;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }
}
