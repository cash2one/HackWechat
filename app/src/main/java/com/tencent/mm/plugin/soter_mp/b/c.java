package com.tencent.mm.plugin.soter_mp.b;

import com.tencent.d.b.e.e;
import com.tencent.d.b.e.e.a;
import com.tencent.mm.ae.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.c.bqx;
import com.tencent.mm.protocal.c.bqy;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends d implements e, k {
    private b gJQ;
    private com.tencent.mm.ae.e gJT;
    private com.tencent.d.b.e.b<e.b> mzK = null;

    public final /* synthetic */ void bq(Object obj) {
        a aVar = (a) obj;
        b.a aVar2 = new b.a();
        aVar2.hmj = new bqx();
        aVar2.hmk = new bqy();
        aVar2.uri = "/cgi-bin/mmbiz-bin/usrmsg/uploadsoterauthkey";
        aVar2.hmi = 1185;
        aVar2.hml = 0;
        aVar2.hmm = 0;
        this.gJQ = aVar2.JZ();
        bqx com_tencent_mm_protocal_c_bqx = (bqx) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bqx.wSp = aVar.AcQ;
        com_tencent_mm_protocal_c_bqx.wSq = aVar.AcR;
    }

    public final int getType() {
        return 1185;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void d(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.gJT != null) {
            this.gJT.a(i, i2, str, this);
        }
        if (this.mzK == null) {
            return;
        }
        if (i == 0 && i2 == 0) {
            this.mzK.cx(new e.b(true));
        } else {
            this.mzK.cx(new e.b(false));
        }
    }

    public final void aKF() {
        x.i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy:NetSceneSoterMPUpdateAuthKey authkey required");
        if (this.gJT != null) {
            this.gJT.a(4, -1, "", this);
        }
        if (this.mzK != null) {
            this.mzK.cx(new e.b(false));
        }
    }

    public final void cy(int i, int i2) {
        x.i("MicroMsg.NetSceneSoterMPUpdateAuthKey", "hy: NetSceneSoterMPUpdateAuthKey onError: errType: %d, errcode: %d", new Object[]{Integer.valueOf(3), Integer.valueOf(i2)});
        if (this.gJT != null) {
            this.gJT.a(4, -1, "", this);
        }
    }

    public final void execute() {
        g.CG().a(this, 0);
    }

    public final void a(com.tencent.d.b.e.b<e.b> bVar) {
        this.mzK = bVar;
    }
}
