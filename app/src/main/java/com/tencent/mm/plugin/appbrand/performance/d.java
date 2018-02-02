package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.TargetApi;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

@TargetApi(16)
public final class d implements FrameCallback {
    boolean AW = true;
    boolean iqR = false;
    a jFS;
    Choreographer jGh = Choreographer.getInstance();
    long jGi = 0;
    int jGj = 0;
    long mInterval = 200;

    public interface a {
        void j(double d);
    }

    public final void doFrame(long j) {
        double d = 60.0d;
        if (this.AW && !this.iqR) {
            long j2 = j / 1000000;
            if (this.jGi > 0) {
                long j3 = j2 - this.jGi;
                this.jGj++;
                if (j3 > this.mInterval) {
                    double d2 = ((double) (this.jGj * 1000)) / ((double) j3);
                    if (d2 < 60.0d) {
                        d = d2;
                    }
                    this.jGi = j2;
                    this.jGj = 0;
                    if (this.jFS != null) {
                        this.jFS.j(d);
                    }
                }
            } else {
                this.jGi = j2;
            }
        }
        if (this.AW) {
            this.jGh.postFrameCallback(this);
        }
    }
}
