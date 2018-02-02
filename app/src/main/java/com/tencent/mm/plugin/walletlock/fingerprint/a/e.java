package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bnz;
import com.tencent.mm.protocal.c.boa;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private com.tencent.mm.ae.e gJT;
    String mzI;
    boolean tfA = false;

    public e(String str, String str2) {
        a aVar = new a();
        aVar.hmj = new bnz();
        aVar.hmk = new boa();
        aVar.uri = "/cgi-bin/mmpay-bin/touchlockgetchallenge";
        aVar.hmi = 1548;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        bnz com_tencent_mm_protocal_c_bnz = (bnz) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_bnz.scene = 1548;
        com_tencent_mm_protocal_c_bnz.rSm = str;
        com_tencent_mm_protocal_c_bnz.rSn = str2;
    }

    public final int getType() {
        return 1548;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ae.e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch wallet lock challenge errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        boa com_tencent_mm_protocal_c_boa = (boa) ((b) qVar).hmh.hmo;
        this.mzI = com_tencent_mm_protocal_c_boa.mzI;
        x.d("MicroMsg.NetSceneGetTouchWalletLockChallenge", "alvinluo get touch lock challenge: %s", new Object[]{this.mzI});
        if (com_tencent_mm_protocal_c_boa.wOx == 1) {
            this.tfA = true;
        } else {
            this.tfA = false;
        }
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
