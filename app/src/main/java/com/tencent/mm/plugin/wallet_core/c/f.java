package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aek;
import com.tencent.mm.protocal.c.ael;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    public String sIk = "";
    public boolean sIl = false;

    public f() {
        a aVar = new a();
        aVar.hmj = new aek();
        aVar.hmk = new ael();
        aVar.uri = "/cgi-bin/mmpay-bin/getpayuserduty";
        aVar.hmi = 2541;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
    }

    public final int getType() {
        return 2541;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MircoMsg.NetSceneGetPayUserDuty", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            ael com_tencent_mm_protocal_c_ael = (ael) ((b) qVar).hmh.hmo;
            this.sIk = com_tencent_mm_protocal_c_ael.sIk;
            this.sIl = com_tencent_mm_protocal_c_ael.sIl;
            x.i("MircoMsg.NetSceneGetPayUserDuty", "duty_info %s need_agree_duty %s", new Object[]{this.sIk, Boolean.valueOf(this.sIl)});
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
