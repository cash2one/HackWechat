package com.tencent.mm.plugin.voiceprint.model;

import com.tencent.mm.ae.e;
import com.tencent.mm.ae.k;
import com.tencent.mm.plugin.voiceprint.model.e.1;
import com.tencent.mm.sdk.platformtools.x;

class e$1$1 implements e {
    final /* synthetic */ 1 sgF;

    e$1$1(1 1) {
        this.sgF = 1;
    }

    public final void a(int i, int i2, String str, k kVar) {
        x.d("MicroMsg.NetSceneGetVoiceprintTicketRsa", "summerauth dkcert getcert type:%d ret [%d,%d]", Integer.valueOf(kVar.getType()), Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && i2 == 0) {
            this.sgF.sgE.a(this.sgF.sgE.hmA, this.sgF.sgE.gJT);
        } else {
            this.sgF.sgE.gJT.a(i, i2, "", this.sgF.sgE);
        }
    }
}
