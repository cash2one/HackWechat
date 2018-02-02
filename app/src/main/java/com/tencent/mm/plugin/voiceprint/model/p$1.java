package com.tencent.mm.plugin.voiceprint.model;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class p$1 extends af {
    final /* synthetic */ p shm;

    public p$1(p pVar) {
        this.shm = pVar;
    }

    public final void handleMessage(Message message) {
        x.d("MicroMsg.VoicePrintRecoder", " Recorder handleMessage");
        if (!p.a(this.shm)) {
            ar.Hh().b(this.shm);
            ar.Hh().xJ();
            this.shm.er(200);
        }
    }
}
