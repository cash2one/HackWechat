package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.abw;
import com.tencent.mm.protocal.c.abx;
import com.tencent.mm.protocal.c.bdn;
import com.tencent.mm.sdk.platformtools.x;

public final class m extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT;
    public byte[] lyZ = null;
    private String lza;

    public m(String str, byte[] bArr) {
        a aVar = new a();
        aVar.hmj = new abw();
        aVar.hmk = new abx();
        aVar.uri = "/cgi-bin/micromsg-bin/mmgetemotiondonorlist";
        aVar.hmi = 299;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.lyZ = bArr;
        this.lza = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.emoji.NetSceneGetEmotionDonorList", "ErrType:" + i2 + "   errCode:" + i3);
        abx com_tencent_mm_protocal_c_abx = (abx) ((b) qVar).hmh.hmo;
        if (com_tencent_mm_protocal_c_abx.vHH != null) {
            this.lyZ = n.a(com_tencent_mm_protocal_c_abx.vHH);
        }
        this.gJT.a(i2, i3, str, this);
    }

    public final int getType() {
        return 299;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        abw com_tencent_mm_protocal_c_abw = (abw) this.gJQ.hmg.hmo;
        if (this.lyZ != null) {
            com_tencent_mm_protocal_c_abw.vHG = n.N(this.lyZ);
        } else {
            com_tencent_mm_protocal_c_abw.vHG = new bdn();
        }
        com_tencent_mm_protocal_c_abw.vIR = this.lza;
        return a(eVar, this.gJQ, this);
    }

    public final abx aBT() {
        return (abx) this.gJQ.hmh.hmo;
    }
}
