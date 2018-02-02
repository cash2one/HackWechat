package com.tencent.mm.plugin.mmsight.segment;

import com.tencent.mm.sdk.platformtools.x;

class g$1 implements Runnable {
    final /* synthetic */ g oxV;

    g$1(g gVar) {
        this.oxV = gVar;
    }

    public final void run() {
        try {
            if (this.oxV.oxJ != null) {
                x.i("MicroMsg.MediaCodecAACTranscoder", "delay to stop decoder");
                this.oxV.oxJ.stop();
                this.oxV.oxJ.release();
                this.oxV.oxJ = null;
            }
        } catch (Exception e) {
            x.e("MicroMsg.MediaCodecAACTranscoder", "delayStopDecoder error: %s", new Object[]{e.getMessage()});
        }
    }
}
