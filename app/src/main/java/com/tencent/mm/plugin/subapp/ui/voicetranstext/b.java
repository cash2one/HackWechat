package com.tencent.mm.plugin.subapp.ui.voicetranstext;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ahq;
import com.tencent.mm.protocal.c.ahr;
import com.tencent.mm.protocal.c.btc;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class b extends k implements com.tencent.mm.network.k {
    private final String TAG = "MicroMsg.NetSceneGetVoiceTransRes";
    private com.tencent.mm.ae.b hmb;
    private e oPD;
    private String rYS;
    public btc rZb;
    public int rZf = -1;

    public b(String str) {
        Assert.assertTrue(!bh.ov(str));
        this.rYS = str;
        a aVar = new a();
        aVar.hmj = new ahq();
        aVar.hmk = new ahr();
        aVar.uri = "/cgi-bin/micromsg-bin/getvoicetransres";
        aVar.hmi = 548;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hmb = aVar.JZ();
    }

    public final int getType() {
        return 548;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.oPD = eVar2;
        ((ahq) this.hmb.hmg.hmo).vWC = this.rYS;
        return a(eVar, this.hmb, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            ahr com_tencent_mm_protocal_c_ahr = (ahr) this.hmb.hmh.hmo;
            if (com_tencent_mm_protocal_c_ahr.vWG != null) {
                this.rZf = com_tencent_mm_protocal_c_ahr.vWG.wHb;
            }
            this.rZb = com_tencent_mm_protocal_c_ahr.vWE;
        } else {
            x.i("MicroMsg.NetSceneGetVoiceTransRes", "error get: errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        this.oPD.a(i2, i3, str, this);
    }

    public final boolean isComplete() {
        return this.rZb != null && this.rZb.vLj == 1;
    }

    public final boolean bEk() {
        return (this.rZb == null || bh.ov(this.rZb.wUh)) ? false : true;
    }
}
