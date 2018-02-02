package com.tencent.mm.pluginsdk.model.app;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.y.a;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;

class e$2 extends af {
    final /* synthetic */ e vee;

    e$2(e eVar, Looper looper) {
        this.vee = eVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        u uVar = (u) message.obj;
        r rVar = new r(uVar.appId, uVar.hNr);
        if (this.vee.vec.contains(rVar)) {
            this.vee.vec.remove(rVar);
            if (!a.bin().e(uVar.appId, uVar.data, uVar.hNr)) {
                x.e("MicroMsg.AppIconService", "handleMessage, saveIcon fail");
            }
        }
        while (this.vee.qkX.size() > 0) {
            r rVar2 = (r) this.vee.qkX.remove(0);
            if (this.vee.a(rVar2)) {
                this.vee.vec.add(rVar2);
                return;
            }
        }
    }
}
