package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.sdk.platformtools.x;

class g$2 implements Runnable {
    final /* synthetic */ g oxV;

    g$2(g gVar) {
        this.oxV = gVar;
    }

    public final void run() {
        try {
            if (this.oxV.oxK != null) {
                x.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop encoder");
                this.oxV.oxK.stop();
                this.oxV.oxK.release();
                this.oxV.oxK = null;
            }
        } catch (Exception e) {
            x.e("MicroMsg.MediaCodecAACTranscoder", "delayStopEncoder error: %s", new Object[]{e.getMessage()});
        }
    }
}
