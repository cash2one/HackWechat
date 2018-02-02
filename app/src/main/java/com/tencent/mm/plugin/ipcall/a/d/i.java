package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.ayj;
import com.tencent.mm.protocal.c.ayk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.q;

public final class i extends k implements com.tencent.mm.network.k {
    private b gJQ = null;
    private e gJT = null;
    public ayj nFF = null;
    public ayk nFG = null;

    public i(String str, String str2, int i, int i2, int i3) {
        a aVar = new a();
        aVar.hmj = new ayj();
        aVar.hmk = new ayk();
        aVar.hmi = 991;
        aVar.uri = "/cgi-bin/micromsg-bin/pstninvite";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        long currentTimeMillis = System.currentTimeMillis();
        int aUN = c.aUN();
        ayj com_tencent_mm_protocal_c_ayj = (ayj) this.gJQ.hmg.hmo;
        com_tencent_mm_protocal_c_ayj.nkp = q.FS();
        com_tencent_mm_protocal_c_ayj.wFr = str2;
        com_tencent_mm_protocal_c_ayj.nko = str;
        com_tencent_mm_protocal_c_ayj.wFq = i;
        com_tencent_mm_protocal_c_ayj.vWK = aUN;
        com_tencent_mm_protocal_c_ayj.wFz = 1;
        com_tencent_mm_protocal_c_ayj.wFp = currentTimeMillis;
        com_tencent_mm_protocal_c_ayj.wFy = i2;
        com_tencent_mm_protocal_c_ayj.wFA = i3;
        this.nFF = com_tencent_mm_protocal_c_ayj;
        x.i("MicroMsg.NetSceneIPCallInvite", "toUsername: %s, phoneNumber: %s, invitedId: %s, netType: %d, dialScene: %d, countryType: %d", str, str2, Integer.valueOf(i), Integer.valueOf(aUN), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public final int getType() {
        return 991;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneIPCallInvite", "onGYNetEnd, errType: %d, errCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.nFG = (ayk) ((b) qVar).hmh.hmo;
        if (i2 == 0 || i3 == 0) {
            if (this.gJT != null) {
                this.gJT.a(i2, i3, str, this);
            }
        } else if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }
}
