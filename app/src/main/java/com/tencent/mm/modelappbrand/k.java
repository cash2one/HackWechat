package com.tencent.mm.modelappbrand;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bmx;
import com.tencent.mm.protocal.c.ge;
import com.tencent.mm.protocal.c.gf;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class k extends com.tencent.mm.ae.k implements com.tencent.mm.network.k {
    private e gOB;
    private final b hjD;

    public k(LinkedList<bmx> linkedList) {
        a aVar = new a();
        aVar.hmj = new ge();
        aVar.hmk = new gf();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/batchswitchservicenotifyoption";
        aVar.hmi = 1176;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hjD = aVar.JZ();
        ((ge) this.hjD.hmg.hmo).vLA = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gOB != null) {
            this.gOB.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1176;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneBatchSwitchServiceNotifyOption", "doScene");
        this.gOB = eVar2;
        return a(eVar, this.hjD, this);
    }
}
