package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.gn;
import com.tencent.mm.protocal.c.go;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    private b gJQ;
    private e gJT;
    public go sZv;

    public c(String str, String str2, String str3, String str4, int i) {
        a aVar = new a();
        aVar.hmj = new gn();
        aVar.hmk = new go();
        aVar.hmi = 1986;
        aVar.uri = "/cgi-bin/mmpay-bin/bindecard";
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        gn gnVar = (gn) this.gJQ.hmg.hmo;
        gnVar.vLI = str;
        gnVar.vLJ = str2;
        gnVar.sPk = str3;
        gnVar.vLK = str4;
        gnVar.fCy = i;
        x.i("MicroMsg.NetSceneBindECard", "cardType: %s, reqSerial: %s, openScene: %s, verifyCode: %s, bindToken: %s", new Object[]{str, str2, Integer.valueOf(i), str3, str4});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBindECard", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.sZv = (go) ((b) qVar).hmh.hmo;
        x.i("MicroMsg.NetSceneBindECard", "ret_code: %d, ret_msg: %s", new Object[]{Integer.valueOf(this.sZv.kLO), this.sZv.kLP});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1986;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }
}
