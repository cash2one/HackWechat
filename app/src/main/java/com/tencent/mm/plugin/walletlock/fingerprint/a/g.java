package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.d.b.e.e;
import com.tencent.d.b.e.e.a;
import com.tencent.mm.ae.b;
import com.tencent.mm.g.a.hv;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.c.bob;
import com.tencent.mm.protocal.c.boc;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends d implements e, k {
    public b gJQ;
    private com.tencent.mm.ae.e gJT;
    private com.tencent.d.b.e.b<e.b> mzK = null;
    private String mzL = null;

    public final /* synthetic */ void bq(Object obj) {
        a aVar = (a) obj;
        b.a aVar2 = new b.a();
        aVar2.hmj = new bob();
        aVar2.hmk = new boc();
        aVar2.uri = "/cgi-bin/mmpay-bin/touchlockupdateauthkey";
        aVar2.hmi = 1244;
        aVar2.hml = 0;
        aVar2.hmm = 0;
        this.gJQ = aVar2.JZ();
        bob com_tencent_mm_protocal_c_bob = (bob) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bob.wOz = aVar.AcQ;
        com_tencent_mm_protocal_c_bob.wOA = aVar.AcR;
        com_tencent_mm_protocal_c_bob.wOy = this.mzL;
        com.tencent.mm.sdk.b.b hvVar = new hv();
        hvVar.fyk.fym = this.mzL;
        com.tencent.mm.sdk.b.a.xef.m(hvVar);
        com_tencent_mm_protocal_c_bob.fyn = hvVar.fyl.fyn;
        x.v("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo wcpaysign: %s", new Object[]{com_tencent_mm_protocal_c_bob.fyn});
    }

    public g(String str) {
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
        x.d("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo onGYNetEnd errType: %d , errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
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
        x.i("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "hy: authkey required");
        if (this.gJT != null) {
            this.gJT.a(4, -1, "", this);
        }
        if (this.mzK != null) {
            x.e("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "alvinluo pay auth key expired when upload pay auth key");
            this.mzK.cx(new e.b(false));
        }
    }

    public final void cy(int i, int i2) {
        x.i("MicroMsg.NetSceneUploadWalletLockSoterAuthKey", "hy: onError: errType: %d, errcode: %d", new Object[]{Integer.valueOf(3), Integer.valueOf(i2)});
        if (this.gJT != null) {
            this.gJT.a(4, -1, "", this);
        }
    }

    public final void execute() {
        com.tencent.mm.kernel.g.CG().a(this, 0);
    }

    public final void a(com.tencent.d.b.e.b<e.b> bVar) {
        this.mzK = bVar;
    }
}
