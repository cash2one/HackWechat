package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.au;
import com.tencent.mm.protocal.c.ub;
import com.tencent.mm.protocal.c.uc;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    public String fuH;
    private e gJT;
    private b hNJ;
    public String nZa;
    private ub nZk;
    private uc nZl;
    public String nZm;

    public c(int i, int i2, int i3, int i4) {
        a aVar = new a();
        aVar.hmj = new ub();
        aVar.hmk = new uc();
        aVar.hmi = 1970;
        aVar.hml = 0;
        aVar.hmm = 0;
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffrequestwxhb";
        this.hNJ = aVar.JZ();
        this.nZk = (ub) this.hNJ.hmg.hmo;
        this.nZk.liB = i;
        this.nZk.pgd = i2;
        this.nZk.obK = i3;
        this.nZk.wca = i4;
        au bLf = i.bLf();
        if (bLf != null) {
            this.nZk.latitude = bLf.latitude;
            this.nZk.longitude = bLf.longitude;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("NetSceneF2FLuckyMoneyPrepare", "errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.nZl = (uc) ((b) qVar).hmh.hmo;
        this.fuH = this.nZl.ods;
        this.nZa = this.nZl.nZa;
        this.nZm = this.nZl.odz;
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1970;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }
}
