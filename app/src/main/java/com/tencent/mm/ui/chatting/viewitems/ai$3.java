package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.pluginsdk.model.app.ab;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class ai$3 implements e {
    final /* synthetic */ ai yOa;
    final /* synthetic */ b yOb;

    ai$3(ai aiVar, b bVar) {
        this.yOa = aiVar;
        this.yOb = bVar;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i + " errCode " + i2 + "  scene " + kVar.getType());
        if (((ab) kVar).getMediaId().equals(this.yOb.field_mediaSvrId)) {
            ar.CG().b(221, ai.b(this.yOa));
            ai.a(this.yOa, null);
        }
    }
}
