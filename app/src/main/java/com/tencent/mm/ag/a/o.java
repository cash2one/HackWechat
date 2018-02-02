package com.tencent.mm.ag.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.zf;
import com.tencent.mm.protocal.c.zg;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private e gJT;
    boolean hru = false;

    public o(String str, String str2) {
        a aVar = new a();
        aVar.hmj = new zf();
        aVar.hmk = new zg();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatinfo";
        aVar.hmi = 1352;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        zf zfVar = (zf) this.gJQ.hmg.hmo;
        zfVar.vNk = str;
        zfVar.vNq = str2;
        this.hru = true;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneGetBizChatInfo", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1352;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.brandservice.NetSceneGetBizChatInfo", "do scene");
        return a(eVar, this.gJQ, this);
    }
}
