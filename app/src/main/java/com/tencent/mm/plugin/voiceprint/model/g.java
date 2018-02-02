package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.ae.k.b;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.av;
import com.tencent.mm.z.av.a;

public final class g extends k implements com.tencent.mm.network.k {
    e gJT;
    private final q hnp = new a();
    String sgB = "";
    int sgC = 0;
    private String sgD = "";

    public g(String str) {
        a aVar = (a) this.hnp.Kb();
        x.i("MicroMsg.NetSceneRsaGetVoicePrintResource", "sceneType %d %s", new Object[]{Integer.valueOf(73), str});
        aVar.hgm.woZ = 73;
        aVar.hgm.wpa = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.hnp, this);
    }

    public final int getType() {
        return 616;
    }

    protected final int Bh() {
        return 3;
    }

    protected final int a(q qVar) {
        return b.hmP;
    }

    protected final void a(k.a aVar) {
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        av.b bVar = (av.b) qVar.Hp();
        if (i2 == 4 && i3 == -102) {
            x.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "summerauth auth MM_ERR_CERT_EXPIRED  getcert now  old ver:%d", new Object[]{Integer.valueOf(qVar.Kb().vBn.ver)});
            ar.Dm().F(new 1(this, r0));
        } else if (i2 == 0 || i3 == 0) {
            if (bVar.hgn.wpb != null) {
                this.sgB = new String(bVar.hgn.wpb.wJi.wJD.oz);
                this.sgC = bVar.hgn.wpb.wIj;
                x.d("MicroMsg.NetSceneRsaGetVoicePrintResource", "resid %d mVertifyKey %s mtext %s", new Object[]{Integer.valueOf(this.sgC), this.sgD, this.sgB});
            } else {
                x.e("MicroMsg.NetSceneRsaGetVoicePrintResource", "resp ResourceData null ");
            }
            this.gJT.a(i2, i3, str, this);
        } else {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
