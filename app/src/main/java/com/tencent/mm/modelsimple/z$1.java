package com.tencent.mm.modelsimple;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class z$1 implements Runnable {
    final /* synthetic */ z hOc;
    final /* synthetic */ au heZ;

    z$1(z zVar, au auVar) {
        this.hOc = zVar;
        this.heZ = auVar;
    }

    public final void run() {
        x.i("MicroMsg.NetSceneRevokeMsg", "delete invoke message! msg:%s", new Object[]{Long.valueOf(this.heZ.field_msgId)});
        this.heZ.setType(10002);
        z.a(z.a(this.hOc), "", this.heZ, "");
        ar.Hg();
        c.Fa().a(this.heZ.field_msgId, this.heZ);
    }
}
