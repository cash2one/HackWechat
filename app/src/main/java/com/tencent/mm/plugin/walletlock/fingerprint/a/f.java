package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.auv;
import com.tencent.mm.protocal.c.auw;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;

    public final int getType() {
        return 1967;
    }

    public f(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hmj = new auv();
        aVar.hmk = new auw();
        aVar.uri = "/cgi-bin/mmpay-bin/opensotertouchlock";
        aVar.hmi = 1967;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        auv com_tencent_mm_protocal_c_auv = (auv) this.gJQ.hmg.hmo;
        x.d("MicroMsg.NetSceneOpenSoterFingerprintLock", "alvinluo json: %s, signature: %s, token: %s", new Object[]{str, str2, str3});
        com_tencent_mm_protocal_c_auv.wCJ = str;
        com_tencent_mm_protocal_c_auv.signature = str2;
        com_tencent_mm_protocal_c_auv.sIP = str3;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneOpenSoterFingerprintLock", "alvinluo open soter fingerprint lock errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
