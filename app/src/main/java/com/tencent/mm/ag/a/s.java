package com.tencent.mm.ag.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ace;
import com.tencent.mm.protocal.c.acf;
import com.tencent.mm.sdk.platformtools.x;

public final class s extends k implements com.tencent.mm.network.k {
    public b gJQ;
    private e gJT;

    public s(String str) {
        a aVar = new a();
        aVar.hmj = new ace();
        aVar.hmk = new acf();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getfavbizchatlist";
        aVar.hmi = 1367;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((ace) this.gJQ.hmg.hmo).vNq = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneGetFavBizChatList", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gJT != null) {
            this.gJT.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1367;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        x.i("MicroMsg.brandservice.NetSceneGetFavBizChatList", "do scene");
        return a(eVar, this.gJQ, this);
    }
}
