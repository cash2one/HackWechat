package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ak.a;
import com.tencent.mm.z.ar;

class ak$1 implements e {
    final /* synthetic */ String uS;
    final /* synthetic */ au yOi;
    final /* synthetic */ int yOj;
    final /* synthetic */ ak yOk;

    ak$1(ak akVar, au auVar, String str, int i) {
        this.yOk = akVar;
        this.yOi = auVar;
        this.uS = str;
        this.yOj = i;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.ChattingItemVoiceRemindSys", "errType " + i + " errCode " + i2 + "  scene " + kVar.getType());
        boolean z = false;
        if (a.hfO != null) {
            z = a.hfO.aJ(this.yOi.field_msgId);
        }
        if (!z && i == 0 && i2 == 0 && ((ab) kVar).getMediaId().equals(this.uS)) {
            ak.a(this.yOk).ysf.ysR.a(this.yOj, this.yOi);
        }
        ar.CG().b(221, ak.b(this.yOk));
        ak.c(this.yOk);
    }
}
