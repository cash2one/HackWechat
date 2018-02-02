package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.sdk.platformtools.x;

class h$4 implements Runnable {
    final /* synthetic */ h ouI;

    h$4(h hVar) {
        this.ouI = hVar;
    }

    public final void run() {
        try {
            if (this.ouI.oul != null) {
                x.i("MicroMsg.MMSightAACMediaCodecRecorder", "delay to stop encoder");
                this.ouI.oul.stop();
                this.ouI.oul.release();
                this.ouI.oul = null;
            }
            if (this.ouI.fkb != null && !this.ouI.ouw) {
                this.ouI.fkb.vi();
                this.ouI.fkb = null;
            }
        } catch (Exception e) {
            x.e("MicroMsg.MMSightAACMediaCodecRecorder", "delay to stop encoder error: %s", new Object[]{e.getMessage()});
        }
    }
}
