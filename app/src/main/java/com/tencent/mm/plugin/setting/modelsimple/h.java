package com.tencent.mm.plugin.setting.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bfh;
import com.tencent.mm.protocal.c.bfi;

public final class h extends k implements com.tencent.mm.network.k {
    private String fod;
    private e gJT;
    public byte[] qga;
    public bfi qgd;

    public h(String str) {
        this.fod = str;
    }

    public h(byte[] bArr) {
        this.qga = bArr;
    }

    public final int getType() {
        return 1169;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        a aVar = new a();
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_bfh = new bfh();
        com_tencent_mm_protocal_c_bfh.fod = this.fod;
        if (this.qga != null) {
            com_tencent_mm_protocal_c_bfh.wor = n.N(this.qga).wJD;
        }
        aVar.hmj = com_tencent_mm_protocal_c_bfh;
        aVar.hmk = new bfi();
        aVar.hmi = 1169;
        aVar.uri = "/cgi-bin/mmbiz-bin/searchuserauth";
        aVar.hml = 0;
        aVar.hmm = 0;
        return a(eVar, aVar.JZ(), this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.qgd = (bfi) ((b) qVar).hmh.hmo;
        this.gJT.a(i2, this.qgd.vYS.fts, this.qgd.vYS.ftt, this);
    }
}
