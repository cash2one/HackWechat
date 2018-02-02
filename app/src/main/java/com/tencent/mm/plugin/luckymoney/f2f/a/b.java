package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.au;
import com.tencent.mm.protocal.c.bbg;
import com.tencent.mm.protocal.c.tx;
import com.tencent.mm.protocal.c.ty;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    public int fLD;
    public int fqv;
    private e gJT;
    private com.tencent.mm.ae.b hNJ;
    private tx nYY;
    private ty nYZ;
    public String nZa;
    public int nZb;
    public String nZc;
    public int nZd;
    public bbg nZe;
    public int nZf;
    public String nZg;
    public String nZh;
    public String nZi;
    public int nZj;

    public b(String str) {
        a aVar = new a();
        aVar.hmj = new tx();
        aVar.hmk = new ty();
        aVar.hmi = 1997;
        aVar.hml = 0;
        aVar.hmm = 0;
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffopenwxhb";
        this.hNJ = aVar.JZ();
        this.nYY = (tx) this.hNJ.hmg.hmo;
        this.nYY.lOX = str;
        au bLf = i.bLf();
        if (bLf != null) {
            this.nYY.fWq = bLf.fWq;
            this.nYY.fWp = bLf.fWp;
            this.nYY.wbT = bLf.vFP;
            this.nYY.wbU = bLf.vFQ;
            this.nYY.wbV = bLf.vFO;
            this.nYY.wbW = bLf.latitude;
            this.nYY.wbX = bLf.longitude;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.nYZ = (ty) ((com.tencent.mm.ae.b) qVar).hmh.hmo;
        x.i("NetSceneF2FLuckyMoneyOpen", "errType %d, retCode %d, retMsg %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.nYZ.liH), this.nYZ.liI});
        this.nZa = this.nYZ.nZa;
        this.fLD = this.nYZ.fLD;
        this.nZb = this.nYZ.fLE;
        this.fqv = this.nYZ.fqv;
        this.nZc = this.nYZ.ocj;
        this.nZd = this.nYZ.nZd;
        this.nZe = this.nYZ.wbY;
        this.nZf = this.nYZ.nZf;
        this.nZg = this.nYZ.nZg;
        this.nZh = this.nYZ.nZh;
        this.nZi = this.nYZ.nZi;
        this.nZj = this.nYZ.nZj;
        if (this.gJT != null) {
            this.gJT.a(i2, this.nYZ.liH, this.nYZ.liI, this);
        }
    }

    public final int getType() {
        return 1997;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hNJ, this);
    }
}
