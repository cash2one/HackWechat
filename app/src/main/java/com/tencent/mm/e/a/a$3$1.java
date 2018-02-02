package com.tencent.mm.e.a;

import android.content.Context;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.compatible.d.q;
import com.tencent.mm.e.a.a.3;
import com.tencent.mm.plugin.e.a.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ar.b;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

class a$3$1 implements Runnable {
    final /* synthetic */ 3 fjJ;

    a$3$1(3 3) {
        this.fjJ = 3;
    }

    public final void run() {
        try {
            if (q.gFV.gCP == 1) {
                Thread.sleep(300);
            }
            x.i("MicroMsg.SceneVoicePlayer", "onCompletion, intOnCompletion: %s, shouldPlayComplete: %s", new Object[]{a.e(this.fjJ.fjH), Boolean.valueOf(a.f(this.fjJ.fjH))});
            ag.y(new Runnable(this) {
                final /* synthetic */ a$3$1 fjK;

                {
                    this.fjK = r1;
                }

                public final void run() {
                    f.xG().h(a.g(this.fjK.fjJ.fjH), false);
                    if (a.f(this.fjK.fjJ.fjH)) {
                        b bVar;
                        Context h = a.h(this.fjK.fjJ.fjH);
                        int i = a.kib;
                        boolean g = a.g(this.fjK.fjJ.fjH);
                        ar.a 1 = new 1(this);
                        if (g) {
                            bVar = b.xhm;
                        } else {
                            bVar = b.xhn;
                        }
                        ar.a(h, i, bVar, false, 1);
                    } else {
                        x.i("MicroMsg.SceneVoicePlayer", "play sound end onCompletion");
                        if (!this.fjK.fjJ.fjH.isPlaying()) {
                            f.xG().b(this.fjK.fjJ.fjH);
                            x.i("MicroMsg.SceneVoicePlayer", "onCompletion() continuousPlay:%s", new Object[]{Boolean.valueOf(a.i(this.fjK.fjJ.fjH))});
                            if (!a.i(this.fjK.fjJ.fjH)) {
                                f.xG().xJ();
                            }
                            a.j(this.fjK.fjJ.fjH);
                            a.c(this.fjK.fjJ.fjH);
                            f.xG().setMode(0);
                            x.i("MicroMsg.SceneVoicePlayer", "onCompletion() resetSpeaker");
                        }
                    }
                    if (a.e(this.fjK.fjJ.fjH) != null) {
                        x.i("MicroMsg.SceneVoicePlayer", "intOnCompletion onCompletion()");
                        a.e(this.fjK.fjJ.fjH).vh();
                        return;
                    }
                    x.e("MicroMsg.SceneVoicePlayer", "intOnCompletion is null!!!");
                }
            });
        } catch (Throwable e) {
            x.e("MicroMsg.SceneVoicePlayer", "exception:%s", new Object[]{bh.i(e)});
        }
    }
}
