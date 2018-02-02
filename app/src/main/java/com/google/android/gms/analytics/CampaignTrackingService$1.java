package com.google.android.gms.analytics;

import android.os.Handler;
import com.google.android.gms.analytics.internal.f;

class CampaignTrackingService$1 implements Runnable {
    final /* synthetic */ int aEA;
    final /* synthetic */ f aEC;
    final /* synthetic */ Handler aEF;
    final /* synthetic */ CampaignTrackingService aEG;

    CampaignTrackingService$1(CampaignTrackingService campaignTrackingService, f fVar, Handler handler, int i) {
        this.aEG = campaignTrackingService;
        this.aEC = fVar;
        this.aEF = handler;
        this.aEA = i;
    }

    public final void run() {
        this.aEG.a(this.aEC, this.aEF, this.aEA);
    }
}
