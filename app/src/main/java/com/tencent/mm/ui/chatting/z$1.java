package com.tencent.mm.ui.chatting;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class z$1 extends af {
    final /* synthetic */ z yxf;

    z$1(z zVar, Looper looper) {
        this.yxf = zVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (this.yxf.kJF != null && ar.Hj()) {
            x.d("MicroMsg.EggMgr", "post start egg");
            this.yxf.a(this.yxf.yxe, this.yxf.kJF);
        }
    }
}
