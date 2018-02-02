package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class aj$1 implements e {
    final /* synthetic */ aj yOg;

    aj$1(aj ajVar) {
        this.yOg = ajVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.ChattingItemVoiceRemindRemind", "errType " + i + " errCode " + i2 + "  scene " + kVar.getType());
        ar.CG().b(221, aj.a(this.yOg));
        aj.b(this.yOg);
    }
}
