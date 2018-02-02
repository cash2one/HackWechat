package com.tencent.mm.plugin.voiceprint.model;

import android.os.Message;
import com.tencent.mm.plugin.voiceprint.model.p.b;
import com.tencent.mm.sdk.platformtools.af;

class p$b$1 extends af {
    final /* synthetic */ p shn;
    final /* synthetic */ b sho;

    p$b$1(b bVar, p pVar) {
        this.sho = bVar;
        this.shn = pVar;
    }

    public final void handleMessage(Message message) {
        if (p.b(this.sho.shm) > 0) {
            p.c(this.sho.shm);
        }
    }
}
