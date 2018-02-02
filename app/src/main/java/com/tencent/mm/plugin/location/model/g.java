package com.tencent.mm.plugin.location.model;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.adl;
import com.tencent.mm.protocal.c.adm;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends k implements com.tencent.mm.network.k {
    public final b gJQ;
    private e gJT;
    private byte[] nQK;
    String nQL;

    public g(float f, float f2, int i, int i2, int i3, String str, String str2) {
        a aVar = new a();
        aVar.hmj = new adl();
        aVar.hmk = new adm();
        aVar.uri = "/cgi-bin/micromsg-bin/getlocimg";
        aVar.hmi = 648;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        adl com_tencent_mm_protocal_c_adl = (adl) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_adl.lOo = str2;
        if (bh.PT()) {
            com_tencent_mm_protocal_c_adl.wmc = 1;
        } else {
            com_tencent_mm_protocal_c_adl.wmc = 0;
        }
        com_tencent_mm_protocal_c_adl.vQu = f;
        com_tencent_mm_protocal_c_adl.vQt = f2;
        com_tencent_mm_protocal_c_adl.wmd = i;
        x.i("MicroMsg.NetSceneGetLocImg", "src w %d h %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        while (i2 * i3 > 270000) {
            i2 = (int) (((double) i2) / 1.2d);
            i3 = (int) (((double) i3) / 1.2d);
        }
        x.i("MicroMsg.NetSceneGetLocImg", "NetSceneGetLocImg %f %f %d w = %d h = %d lan=%s", new Object[]{Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), com_tencent_mm_protocal_c_adl.lOo});
        com_tencent_mm_protocal_c_adl.Height = i3;
        com_tencent_mm_protocal_c_adl.Width = i2;
        this.nQL = str;
    }

    public final int getType() {
        return 648;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetLocImg", "onGYNetEnd errType %d errCode%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        try {
            this.nQK = ((adm) ((b) qVar).hmh.hmo).vHb.wJD.oz;
            com.tencent.mm.a.e.b(this.nQL, this.nQK, this.nQK.length);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneGetLocImg", e, "", new Object[0]);
        }
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
