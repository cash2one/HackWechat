package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.acx;
import com.tencent.mm.protocal.c.acy;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends k implements com.tencent.mm.network.k {
    public final b hRB;
    private e pns;

    public c() {
        a aVar = new a();
        aVar.hmj = new acx();
        aVar.hmk = new acy();
        aVar.uri = "/cgi-bin/micromsg-bin/getimunreadmsgcount";
        this.hRB = aVar.JZ();
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetImUnreadMsgCount", "end get im unread msg count, errType: %d, errCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        this.pns.a(i2, i3, str, this);
    }

    public final int getType() {
        return 630;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneGetImUnreadMsgCount", "get im unread msg count");
        this.pns = eVar2;
        return a(eVar, this.hRB, this);
    }
}
