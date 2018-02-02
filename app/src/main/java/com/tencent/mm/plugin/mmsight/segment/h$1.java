package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;

class h$1 implements Runnable {
    final /* synthetic */ h oyk;

    h$1(h hVar) {
        this.oyk = hVar;
    }

    public final void run() {
        h hVar = this.oyk;
        x.i("MicroMsg.MediaCodecFFMpegTranscoder", "waitEncoderFinish: %s %s", new Object[]{hVar.oyc, hVar.owW});
        if (hVar.oyc != null && hVar.owW != null) {
            hVar.oyc.owX = true;
            try {
                hVar.owW.join();
                e.remove(hVar.oyc);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MediaCodecFFMpegTranscoder", e, "waitEncoderFinish, join error: %s", new Object[]{e.getMessage()});
            }
        }
    }
}
