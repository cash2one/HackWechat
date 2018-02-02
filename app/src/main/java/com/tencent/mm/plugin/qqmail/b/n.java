package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bmv;
import com.tencent.mm.protocal.c.bmw;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class n extends k implements com.tencent.mm.network.k {
    public final boolean fJL;
    private b gJQ;
    private e gJT;
    private String poX = "";

    public n(boolean z, String str) {
        this.fJL = z;
        this.poX = bh.ou(str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        a aVar = new a();
        aVar.hmj = new bmv();
        aVar.hmk = new bmw();
        aVar.uri = "/cgi-bin/micromsg-bin/switchpushmail";
        aVar.hmi = 129;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bmv com_tencent_mm_protocal_c_bmv = (bmv) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bmv.wgM = this.fJL ? 1 : 2;
        com_tencent_mm_protocal_c_bmv.wPW = this.poX;
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final boolean Kd() {
        return true;
    }

    public final int getType() {
        return 24;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            bmw com_tencent_mm_protocal_c_bmw = (bmw) this.gJQ.hmh.hmo;
            ar.Hg();
            c.CU().set(17, Integer.valueOf(com_tencent_mm_protocal_c_bmw.wgM));
        }
        this.gJT.a(i2, i3, str, this);
    }
}
