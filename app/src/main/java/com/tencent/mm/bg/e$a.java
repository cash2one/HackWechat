package com.tencent.mm.bg;

import com.tencent.mm.compatible.d.q;
import com.tencent.mm.e.b.c;
import com.tencent.mm.e.c.d;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class e$a implements Runnable {
    final /* synthetic */ e hYx;

    public e$a(e eVar) {
        this.hYx = eVar;
    }

    public final void run() {
        synchronized (this.hYx) {
            x.i("MicroMsg.SceneVoiceAddr", "initDeviceInLock");
            try {
                new File(e.d(this.hYx)).delete();
            } catch (Exception e) {
                x.e("MicroMsg.SceneVoiceAddr", "delete file failed, " + e.d(this.hYx), new Object[]{e});
            }
            this.hYx.fkb = new c(e.c(this.hYx) ? 8000 : 16000, 1, 3);
            this.hYx.fkb.fkz = -19;
            this.hYx.fkb.aO(false);
            if (!e.c(this.hYx)) {
                this.hYx.hYu = new d();
                if (!this.hYx.hYu.cL(e.d(this.hYx))) {
                    x.e("MicroMsg.SceneVoiceAddr", "init speex writer failed");
                    this.hYx.hYu.vE();
                    this.hYx.hYu = null;
                }
            }
            if (e.c(this.hYx) || q.gGe.gEQ <= 0) {
                this.hYx.fkb.n(5, false);
            } else {
                this.hYx.fkb.n(q.gGe.gEQ, true);
            }
            this.hYx.fkb.aP(false);
            this.hYx.hYv = new com.tencent.qqpinyin.voicerecoapi.c(e.f(this.hYx));
            int start = this.hYx.hYv.start();
            if (start != 0) {
                x.e("MicroMsg.SceneVoiceAddr", "init VoiceDetectAPI failed :" + start);
                e.g(this.hYx);
            } else {
                this.hYx.fkb.fkK = e.h(this.hYx);
                if (!this.hYx.fkb.vr()) {
                    x.e("MicroMsg.SceneVoiceAddr", "start record failed");
                    e.g(this.hYx);
                }
            }
        }
    }
}
