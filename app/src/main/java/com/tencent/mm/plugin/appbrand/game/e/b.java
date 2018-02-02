package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.mm.sdk.platformtools.x;

public final class b {
    private static final long jam = 100000000;
    private static final long jan = 16666666;
    public long jao = 16666666;
    private long jap = -1;
    private boolean jaq = false;

    public static long km(int i) {
        return 1000000000 / ((long) i);
    }

    public final void aeT() {
        if (this.jap == -1) {
            this.jap = System.nanoTime();
        }
    }

    public final void cE(boolean z) {
        if (this.jao > jan || !z || this.jaq) {
            this.jaq = true;
            if (this.jap != -1) {
                long nanoTime = System.nanoTime() - this.jap;
                if (nanoTime < this.jao) {
                    nanoTime = this.jao - nanoTime;
                    try {
                        Thread.sleep(nanoTime / 1000000, (int) (nanoTime % 1000000));
                    } catch (InterruptedException e) {
                        x.e("MicroMsg.WAGameFrameRateController", "Sleep unsuccessfully.");
                    }
                }
            }
            this.jap = System.nanoTime();
        }
    }
}
