package com.tencent.mm.plugin.webview.ui.tools;

import android.support.v4.view.z;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

final class LogoWebViewWrapper$c implements Runnable {
    private final long duration;
    private long startTime = -1;
    final /* synthetic */ LogoWebViewWrapper twr;
    private final Interpolator tws;
    private final int twt;
    private final int twu;
    boolean twv = true;
    private int tww = -1;

    public LogoWebViewWrapper$c(LogoWebViewWrapper logoWebViewWrapper, int i, int i2, long j) {
        this.twr = logoWebViewWrapper;
        this.twu = i;
        this.twt = i2;
        this.tws = LogoWebViewWrapper.b(logoWebViewWrapper) ? new AccelerateInterpolator() : new DecelerateInterpolator();
        this.duration = j;
    }

    public final void run() {
        if (this.startTime == -1) {
            this.startTime = System.currentTimeMillis();
        } else {
            long j = 500;
            if (this.duration > 0) {
                j = Math.max(Math.min(((System.currentTimeMillis() - this.startTime) * 1000) / this.duration, 1000), 0);
            }
            this.tww = this.twu - Math.round(this.tws.getInterpolation(((float) j) / 1000.0f) * ((float) (this.twu - this.twt)));
            this.twr.AA(this.tww);
            if (LogoWebViewWrapper.c(this.twr) != null) {
                LogoWebViewWrapper.c(this.twr).S(this.tww, false);
            }
        }
        if (this.twv && this.twt != this.tww) {
            z.a(this.twr, this);
        }
    }
}
