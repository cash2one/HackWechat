package com.tencent.mm.plugin.setting.modelsimple;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.agz;
import com.tencent.mm.protocal.c.aha;

public final class e extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ae.e gJT;
    public aha qfZ;
    public byte[] qga;

    public e(byte[] bArr) {
        this.qga = bArr;
    }

    public final int getType() {
        return 1146;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        a aVar = new a();
        com.tencent.mm.bq.a com_tencent_mm_protocal_c_agz = new agz();
        if (this.qga != null) {
            com_tencent_mm_protocal_c_agz.wor = n.N(this.qga).wJD;
        }
        aVar.hmj = com_tencent_mm_protocal_c_agz;
        this.qfZ = new aha();
        aVar.hmk = this.qfZ;
        aVar.uri = "/cgi-bin/mmbiz-bin/getuserauthlist";
        aVar.hmi = 1146;
        aVar.hml = 0;
        aVar.hmm = 0;
        return a(eVar, aVar.JZ(), this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.qfZ = (aha) ((b) qVar).hmh.hmo;
        this.gJT.a(i2, this.qfZ.vYS.fts, this.qfZ.vYS.ftt, this);
    }
}
