package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.d.b.e.e;
import com.tencent.d.b.e.e.a;
import com.tencent.mm.ae.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.c.blj;
import com.tencent.mm.protocal.c.blk;
import com.tencent.mm.sdk.platformtools.x;
import com.tenpay.android.wechat.TenpayUtil;
import org.json.JSONObject;

public final class c extends d implements e, k {
    public b gJQ;
    private com.tencent.mm.ae.e gJT;
    private com.tencent.d.b.e.b<e.b> mzK = null;
    private String mzL = null;

    public final /* synthetic */ void bq(Object obj) {
        a aVar = (a) obj;
        b.a aVar2 = new b.a();
        aVar2.hmj = new blj();
        aVar2.hmk = new blk();
        aVar2.uri = "/cgi-bin/mmpay-bin/soterupdateauthkey";
        aVar2.hmi = 1665;
        aVar2.hml = 0;
        aVar2.hmm = 0;
        this.gJQ = aVar2.JZ();
        blj com_tencent_mm_protocal_c_blj = (blj) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_blj.wOy = this.mzL;
        com_tencent_mm_protocal_c_blj.wOz = aVar.AcQ;
        com_tencent_mm_protocal_c_blj.wOA = aVar.AcR;
        com_tencent_mm_protocal_c_blj.fyn = TenpayUtil.signWith3Des("passwd=" + com_tencent_mm_protocal_c_blj.wOy);
        try {
            JSONObject jSONObject = new JSONObject(aVar.AcQ);
            com.tencent.mm.plugin.soter.c.b.eq(jSONObject.getString("cpu_id"), jSONObject.getString("uid"));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", e, "save device info exception", new Object[0]);
        }
    }

    public c(String str) {
        this.mzL = str;
    }

    public final int getType() {
        return 1665;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void d(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
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
        x.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: authkey required");
        if (this.gJT != null) {
            this.gJT.a(4, -1, "", this);
        }
        if (this.mzK != null) {
            x.e("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "alvinluo pay auth key expired when upload pay auth key");
            this.mzK.cx(new e.b(false));
        }
    }

    public final void cy(int i, int i2) {
        x.i("MicroMsg.NetSceneSoterPayUploadAuthKeyManually", "hy: onError: errType: %d, errcode: %d", new Object[]{Integer.valueOf(3), Integer.valueOf(i2)});
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
