package com.tencent.mm.ag.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.protocal.c.zh;
import com.tencent.mm.protocal.c.zi;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends k implements com.tencent.mm.network.k {
    Object data;
    public b gJQ;
    private e gJT;

    public q(String str, Object obj) {
        a aVar = new a();
        aVar.hmj = new zh();
        aVar.hmk = new zi();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatmyuserinfo";
        aVar.hmi = 1354;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((zh) this.gJQ.hmg.hmo).vNq = str;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1354;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.brandservice.NetSceneGetBizChatMyUserInfo", "do scene");
        return a(eVar, this.gJQ, this);
    }
}
