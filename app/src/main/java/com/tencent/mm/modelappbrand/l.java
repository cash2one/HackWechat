package com.tencent.mm.modelappbrand;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.afr;
import com.tencent.mm.protocal.c.afs;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends k implements com.tencent.mm.network.k {
    private e gOB;
    public final b hjD;

    public l(int i) {
        a aVar = new a();
        aVar.hmj = new afr();
        aVar.hmk = new afs();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getservicenotifyoptions";
        aVar.hmi = 1145;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.hjD = aVar.JZ();
        ((afr) this.hjD.hmg.hmo).wnA = i;
    }

    public final afs Jb() {
        return (afs) this.hjD.hmh.hmo;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetServiceNotifyOptions", "onGYNetEnd, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gOB != null) {
            this.gOB.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1145;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.NetSceneGetServiceNotifyOptions", "doScene");
        this.gOB = eVar2;
        return a(eVar, this.hjD, this);
    }
}
