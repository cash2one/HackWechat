package com.tencent.mm.ag.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ho;
import com.tencent.mm.protocal.c.hp;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends k implements com.tencent.mm.network.k {
    private Object data;
    public b gJQ;
    private e gJT;

    public l(String str, String str2, int i) {
        a aVar = new a();
        aVar.hmj = new ho();
        aVar.hmk = new hp();
        aVar.uri = "/cgi-bin/mmocbiz-bin/bizchatsearchcontact";
        this.gJQ = aVar.JZ();
        ho hoVar = (ho) this.gJQ.hmg.hmo;
        hoVar.vNq = str;
        hoVar.fod = str2;
        hoVar.offset = i;
        this.data = null;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneBizChatSearchContact", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1364;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.NetSceneBizChatSearchContact", "do scene");
        return a(eVar, this.gJQ, this);
    }
}
