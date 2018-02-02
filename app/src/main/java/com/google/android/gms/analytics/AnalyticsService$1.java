package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.ah;
import com.google.android.gms.analytics.internal.f;
import com.google.android.gms.analytics.internal.q;

class AnalyticsService$1 implements ah {
    final /* synthetic */ int aEA;
    final /* synthetic */ q aEB;
    final /* synthetic */ f aEC;
    final /* synthetic */ AnalyticsService aED;

    AnalyticsService$1(AnalyticsService analyticsService, int i, q qVar, f fVar) {
        this.aED = analyticsService;
        this.aEA = i;
        this.aEB = qVar;
        this.aEC = fVar;
    }

    public final void mc() {
        AnalyticsService.a(this.aED).post(new 1(this));
    }
}
