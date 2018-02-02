package com.tencent.mm.plugin.subapp.c;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.z.ar;

class i$3 extends af {
    final /* synthetic */ i rWE;

    i$3(i iVar) {
        this.rWE = iVar;
    }

    public final void handleMessage(Message message) {
        x.d("MicroMsg.VoiceRemindRecorder", " Recorder handleMessage");
        if (!i.b(this.rWE)) {
            ar.Hh().b(this.rWE);
            ar.Hh().xJ();
            this.rWE.er(200);
        }
    }
}
