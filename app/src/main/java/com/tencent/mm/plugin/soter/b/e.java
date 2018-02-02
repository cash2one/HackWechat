package com.tencent.mm.plugin.soter.b;

import com.tencent.d.b.e.e.a;
import com.tencent.mm.ae.b;
import com.tencent.mm.ae.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bpq;
import com.tencent.mm.protocal.c.bpr;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.d.b.e.e, com.tencent.mm.network.k {
    private b gJQ;
    private com.tencent.mm.ae.e gJT;
    private com.tencent.d.b.e.b<com.tencent.d.b.e.e.b> mzK = null;

    public final /* synthetic */ void bq(Object obj) {
        a aVar = (a) obj;
        b.a aVar2 = new b.a();
        aVar2.hmj = new bpq();
        aVar2.hmk = new bpr();
        aVar2.uri = "/cgi-bin/micromsg-bin/updatesoterask";
        aVar2.hmi = 619;
        aVar2.hml = 0;
        aVar2.hmm = 0;
        this.gJQ = aVar2.JZ();
        bpq com_tencent_mm_protocal_c_bpq = (bpq) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bpq.rYW = 619;
        com_tencent_mm_protocal_c_bpq.wRx = aVar.AcR;
        com_tencent_mm_protocal_c_bpq.wRy = aVar.AcQ;
        x.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo keyJson: %s, signature: %s", aVar.AcQ, aVar.AcR);
        x.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo hashCode: %s", Integer.valueOf(hashCode()));
    }

    public final int getType() {
        return 619;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadSoterASK", "MicroMsg.NetSceneUploadSoterASK errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask successfully");
            if (this.mzK != null) {
                this.mzK.cx(new com.tencent.d.b.e.e.b(true));
                return;
            }
            return;
        }
        x.e("MicroMsg.NetSceneUploadSoterASK", "netscene upload soter ask failed");
        if (this.mzK != null) {
            this.mzK.cx(new com.tencent.d.b.e.e.b(false));
        }
    }

    public final void a(com.tencent.d.b.e.b<com.tencent.d.b.e.e.b> bVar) {
        this.mzK = bVar;
    }

    public final void execute() {
        x.v("MicroMsg.NetSceneUploadSoterASK", "alvinluo NetSceneUploadSoterASK execute doScene");
        g.CG().a((k) this, 0);
    }
}
