package com.google.android.gms.analytics;

import com.google.android.gms.analytics.AnalyticsService.1;
import com.google.android.gms.common.internal.f;

class AnalyticsService$1$1 implements Runnable {
    final /* synthetic */ 1 aEE;

    AnalyticsService$1$1(1 1) {
        this.aEE = 1;
    }

    public final void run() {
        if (!this.aEE.aED.stopSelfResult(this.aEE.aEA)) {
            return;
        }
        if (f.aNs) {
            this.aEE.aEC.au("Device AnalyticsService processed last dispatch request");
        } else {
            this.aEE.aEC.au("Local AnalyticsService processed last dispatch request");
        }
    }
}
