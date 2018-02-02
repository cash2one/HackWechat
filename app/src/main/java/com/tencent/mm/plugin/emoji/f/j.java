package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abq;
import com.tencent.mm.protocal.c.abr;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends k implements com.tencent.mm.network.k {
    public final b gJQ;
    private e gOB;
    public String lyU;
    private String lyV;

    public j(String str, String str2) {
        a aVar = new a();
        aVar.hmj = new abq();
        aVar.hmk = new abr();
        aVar.uri = "/cgi-bin/micromsg-bin/getemotionactivity";
        aVar.hmi = 368;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        this.lyU = str;
        this.lyV = str2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gOB = eVar2;
        abq com_tencent_mm_protocal_c_abq = (abq) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_abq.wky = this.lyU;
        com_tencent_mm_protocal_c_abq.vZL = this.lyV;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.emoji.NetSceneGetEmotionActivity", "onGYNetEnd ErrType:%d, errCode:%d, errMsg", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gOB.a(i2, i3, str, this);
    }

    public final int getType() {
        return 368;
    }
}
