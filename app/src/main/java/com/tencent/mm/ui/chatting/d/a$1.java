package com.tencent.mm.ui.chatting.d;

import com.tencent.mm.R;
import com.tencent.mm.modelsimple.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;
import com.tencent.mm.z.c;

class a$1 implements Runnable {
    final /* synthetic */ a yGZ;

    a$1(a aVar) {
        this.yGZ = aVar;
    }

    public final void run() {
        this.yGZ.fEJ.setType(10002);
        z.a(ac.getContext().getString(R.l.dSM), "", this.yGZ.fEJ, "");
        ar.Hg();
        c.Fa().a(this.yGZ.fEJ.field_msgId, this.yGZ.fEJ);
        x.i("MicroMsg.InvokeMessageNewXmlMsg", "checkExpired:%s", new Object[]{Long.valueOf(this.yGZ.fEJ.field_msgId)});
    }
}
