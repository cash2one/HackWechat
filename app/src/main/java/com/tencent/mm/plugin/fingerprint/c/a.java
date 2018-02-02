package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.plugin.soter.c.c;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.protocal.c.blf;
import com.tencent.mm.protocal.c.blg;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends d implements k {
    public final b gJQ;
    private e gJT;
    public String mzI = "";
    public boolean mzJ = false;

    public a() {
        com.tencent.mm.ae.b.a aVar = new com.tencent.mm.ae.b.a();
        aVar.hmj = new blf();
        aVar.hmk = new blg();
        aVar.uri = "/cgi-bin/mmpay-bin/sotergetchallenge";
        aVar.hmi = 1586;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        blf com_tencent_mm_protocal_c_blf = (blf) this.gJQ.hmg.hmo;
        c bCP = com.tencent.mm.plugin.soter.c.b.bCP();
        x.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: cpu_id: %s, uid: %s", new Object[]{bCP.rSm, bCP.rSn});
        com_tencent_mm_protocal_c_blf.rSm = r2;
        com_tencent_mm_protocal_c_blf.rSn = r1;
        com_tencent_mm_protocal_c_blf.scene = 0;
    }

    public final int getType() {
        return 1586;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void d(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneSoterGetPayChallenge", "hy: onGYNetEnd errType %d errCode%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i == 0 && i2 == 0) {
            boolean z;
            blg com_tencent_mm_protocal_c_blg = (blg) ((b) qVar).hmh.hmo;
            this.mzI = com_tencent_mm_protocal_c_blg.mzI;
            s.sPp.mzI = this.mzI;
            this.mzJ = 1 == com_tencent_mm_protocal_c_blg.wOx;
            String str2 = "MicroMsg.NetSceneSoterGetPayChallenge";
            String str3 = "get pay challenge needChangeAuthKey: %b";
            Object[] objArr = new Object[1];
            if (1 == com_tencent_mm_protocal_c_blg.wOx) {
                z = true;
            } else {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            x.d(str2, str3, objArr);
            s.sPp.mzJ = this.mzJ;
            x.i("MicroMsg.NetSceneSoterGetPayChallenge", "hy: challenge: %s, need auth key: %b", new Object[]{this.mzI, Boolean.valueOf(this.mzJ)});
        }
        this.gJT.a(i, i2, str, this);
    }

    public final void aKF() {
        x.e("MicroMsg.NetSceneSoterGetPayChallenge", "hy: auth key expired");
        if (this.gJT != null) {
            this.gJT.a(4, -1, "", this);
        }
    }

    public final void cy(int i, int i2) {
        if (this.gJT != null) {
            this.gJT.a(4, -1, "", this);
        }
    }
}
