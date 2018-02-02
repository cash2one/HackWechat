package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.sdk.platformtools.x;

class i$1 implements a {
    final /* synthetic */ i rWE;

    i$1(i iVar) {
        this.rWE = iVar;
    }

    public final boolean uF() {
        String a = i.a(this.rWE);
        if (a != null) {
            g Mk = h.Mk(a);
            if (Mk == null) {
                x.d("MicroMsg.VoiceRemindLogic", "startSend null record : " + a);
            } else if (Mk.field_status == 1) {
                Mk.field_status = 2;
                Mk.fDt = 64;
                h.a(Mk);
            }
        }
        d.bEc().run();
        x.d("MicroMsg.VoiceRemindRecorder", "Start Send fileName :" + i.a(this.rWE));
        return false;
    }
}
