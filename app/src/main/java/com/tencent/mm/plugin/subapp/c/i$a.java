package com.tencent.mm.plugin.subapp.c;

import android.os.Message;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

final class i$a implements Runnable {
    af handler;
    final /* synthetic */ i rWE;

    public i$a(final i iVar) {
        this.rWE = iVar;
        this.handler = new af(this) {
            final /* synthetic */ i$a rWG;

            public final void handleMessage(Message message) {
                if (i.c(this.rWG.rWE) > 0) {
                    x.d("MicroMsg.VoiceRemindRecorder", "On Part :" + (this.rWG.rWE.rWx == null));
                    i.d(this.rWG.rWE);
                    if (this.rWG.rWE.rWx != null) {
                        this.rWG.rWE.rWx.Ka();
                    }
                }
            }
        };
    }

    public final void run() {
        if (i.e(this.rWE) == null) {
            x.e("MicroMsg.VoiceRemindRecorder", "Stop Record Failed recorder == null");
            return;
        }
        synchronized (this.rWE) {
            if (!i.e(this.rWE).cI(h.aJ(i.a(this.rWE), true))) {
                i.Mm(i.a(this.rWE));
                i.f(this.rWE);
                x.d("MicroMsg.VoiceRemindRecorder", "Thread Start Record  Error fileName[" + i.a(this.rWE) + "]");
                i.g(this.rWE);
            }
            i.a(this.rWE, bh.Wq());
            x.d("MicroMsg.VoiceRemindRecorder", "Thread Started Record fileName[" + i.a(this.rWE) + "] time:" + bh.bA(i.h(this.rWE)));
        }
        this.handler.sendEmptyMessageDelayed(0, 1);
    }
}
