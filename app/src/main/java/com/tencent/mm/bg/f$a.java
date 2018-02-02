package com.tencent.mm.bg;

import com.tencent.mm.compatible.d.q;
import com.tencent.mm.e.b.c;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class f$a implements Runnable {
    final /* synthetic */ f hYD;

    private f$a(f fVar) {
        this.hYD = fVar;
    }

    public final void run() {
        synchronized (this.hYD) {
            x.i("MicroMsg.SceneVoiceInputAddr", "initDeviceInLock time %s", new Object[]{Long.valueOf(System.currentTimeMillis())});
            long nanoTime = System.nanoTime() & 4294967295L;
            if (nanoTime < 0) {
                nanoTime = Math.abs(nanoTime);
            }
            String valueOf = String.valueOf(nanoTime);
            try {
                File file = new File(f.bz());
                if (!file.exists()) {
                    file.mkdir();
                }
                file = new File(f.UU());
                if (!file.exists()) {
                    file.createNewFile();
                }
                file.delete();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e, "delete file failed", new Object[0]);
            }
            f.a(this.hYD, new c(16000, 1, 3));
            f.a(this.hYD).fkz = -19;
            f.a(this.hYD).aO(false);
            f.a(this.hYD, new com.tencent.mm.e.c.c(16000, 23900));
            if (f.b(this.hYD).cL(f.UU())) {
                if (q.gGe.gEQ > 0) {
                    f.a(this.hYD).n(q.gGe.gEQ, true);
                } else {
                    f.a(this.hYD).n(5, false);
                }
                f.a(this.hYD).et(50);
                f.a(this.hYD).aP(false);
                try {
                    f.a(this.hYD, new com.tencent.mm.bg.a.c());
                    f.d(this.hYD).hZf = f.c(this.hYD);
                    com.tencent.mm.storage.c fn = com.tencent.mm.z.c.c.IF().fn("100235");
                    f.a(this.hYD, new b(f.UU(), valueOf, String.valueOf(fn.isValid() ? bh.getInt((String) fn.chI().get("MMVoipVadOn"), 0) : 0)));
                    f.a(this.hYD).fkK = f.e(this.hYD);
                    if (!f.a(this.hYD).vr()) {
                        x.e("MicroMsg.SceneVoiceInputAddr", "start record failed");
                        this.hYD.bq(8, -1);
                    }
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.SceneVoiceInputAddr", e2, "init VoiceDetectAPI failed", new Object[0]);
                    this.hYD.bq(7, -1);
                }
            } else {
                x.e("MicroMsg.SceneVoiceInputAddr", "init speex writer failed");
                f.b(this.hYD).vE();
                f.a(this.hYD, null);
                this.hYD.bq(5, -1);
            }
        }
    }
}
