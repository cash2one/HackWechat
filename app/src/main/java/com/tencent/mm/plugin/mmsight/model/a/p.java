package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.sdk.platformtools.x;

public class p implements f {
    volatile int frameCount = 0;
    long kEb = 0;
    int mvv;
    int nUr;
    long otQ = 0;
    boolean oth;
    int ovV = -1;
    int ovW = -1;
    int ovX = -1;
    int ovY = -1;
    int ovZ = -1;

    public p(boolean z, int i, int i2, int i3) {
        this.oth = z;
        this.ovW = i;
        this.nUr = i2;
        this.mvv = i3;
        x.i("MicroMsg.MMSightX264YUVRecorder", "create MMSightX264YUVRecorder, needRotateEachFrame: %s, initRotate: %s, targetWidth: %s, targetHeight: %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.ovW), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final int sQ(int i) {
        if (i < 0) {
            x.e("MicroMsg.MMSightX264YUVRecorder", "init error, yuv buffer id error");
            return -1;
        }
        this.ovV = i;
        synchronized (p.class) {
            this.frameCount = 0;
        }
        this.kEb = 0;
        return 0;
    }

    public final void stop() {
        synchronized (p.class) {
            this.frameCount = 0;
        }
        this.kEb = 0;
    }

    public final long baQ() {
        if (0 != this.kEb) {
            return System.currentTimeMillis() - this.kEb;
        }
        x.w("MicroMsg.MMSightX264YUVRecorder", "do not start record");
        return 0;
    }
}
