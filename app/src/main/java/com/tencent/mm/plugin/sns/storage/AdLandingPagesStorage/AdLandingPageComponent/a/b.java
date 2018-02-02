package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;

import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.va;
import com.tencent.mm.protocal.c.vb;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends k implements com.tencent.mm.network.k {
    private com.tencent.mm.ae.b gJQ;
    private e gJT;
    public String rnt = "";

    public b(String str) {
        this.rnt = str;
        a aVar = new a();
        aVar.hmj = new va();
        aVar.hmk = new vb();
        aVar.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_favofficialitem";
        aVar.hmi = 2874;
        this.gJQ = aVar.JZ();
        ((va) this.gJQ.hmg.hmo).weN = str;
        x.i("MicroMsg.NetSceneFavOfficialItem", "Req: item_buff[%s]", str);
    }

    public final int getType() {
        return 2874;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneFavOfficialItem", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.gJT.a(i2, i3, str, this);
    }
}
