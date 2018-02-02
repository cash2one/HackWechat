package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.ae.b;
import com.tencent.mm.ae.b.a;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ajg;
import com.tencent.mm.protocal.c.ajh;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

public final class j extends k implements com.tencent.mm.network.k {
    private final b gJQ;
    private e gJT = null;

    public final int getType() {
        return 339;
    }

    public j(String str) {
        a aVar = new a();
        aVar.hmj = new ajg();
        aVar.hmk = new ajh();
        aVar.uri = "/cgi-bin/micromsg-bin/grantbigchatroom";
        aVar.hmi = 339;
        aVar.hml = 0;
        aVar.hmm = 0;
        this.gJQ = aVar.JZ();
        ((ajg) this.gJQ.hmg.hmo).nko = str;
        x.d("MicroMsg.NetSceneGrantBigChatRoom", "grant to userName :" + str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gJT = eVar2;
        return a(eVar, this.gJQ, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGrantBigChatRoom", "onGYNetEnd " + i2 + " " + i3 + "  " + str);
        if (i2 == 0 && i3 == 0) {
            ar.Hg();
            int intValue = ((Integer) c.CU().get(135176, Integer.valueOf(0))).intValue();
            if (intValue - 1 >= 0) {
                ar.Hg();
                c.CU().set(135176, Integer.valueOf(intValue - 1));
            }
            this.gJT.a(i2, i3, str, this);
            return;
        }
        this.gJT.a(i2, i3, str, this);
    }
}
