package com.tencent.mm.plugin.fingerprint.c;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.b.d;
import com.tencent.mm.protocal.c.blh;
import com.tencent.mm.protocal.c.bli;
import com.tencent.mm.sdk.platformtools.x;
import com.tenpay.android.wechat.TenpayUtil;

public final class b extends d implements k {
    public final com.tencent.mm.ae.b gJQ;
    private e gJT;

    public b(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hmj = new blh();
        aVar.hmk = new bli();
        aVar.uri = "/cgi-bin/mmpay-bin/soteropenfppayment";
        aVar.hmi = 1638;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        blh com_tencent_mm_protocal_c_blh = (blh) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_blh.wCJ = str;
        com_tencent_mm_protocal_c_blh.signature = str2;
        com_tencent_mm_protocal_c_blh.wOy = str3;
        com_tencent_mm_protocal_c_blh.fyn = TenpayUtil.signWith3Des("passwd=" + com_tencent_mm_protocal_c_blh.wOy);
    }

    public final void d(int i, int i2, String str, q qVar) {
        x.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay success");
            com.tencent.mm.plugin.fingerprint.b.e.fj(true);
        } else {
            x.e("MicroMsg.NetSceneSoterOpenTouchPay", "open fingerprintpay failed");
        }
        this.gJT.a(i, i2, "", this);
    }

    public final void aKF() {
        x.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: authkey required");
        if (this.gJT != null) {
            this.gJT.a(4, -1, "", this);
        }
    }

    public final void cy(int i, int i2) {
        x.i("MicroMsg.NetSceneSoterOpenTouchPay", "hy: onError: errType: %d, errcode: %d", new Object[]{Integer.valueOf(3), Integer.valueOf(i2)});
        if (this.gJT != null) {
            this.gJT.a(4, -1, "", this);
        }
    }

    public final int getType() {
        return 1638;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
