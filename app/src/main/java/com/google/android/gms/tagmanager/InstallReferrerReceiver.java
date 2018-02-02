package com.google.android.gms.tagmanager;

import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class InstallReferrerReceiver extends CampaignTrackingReceiver {
    protected final void am(String str) {
        l.be(str);
    }

    protected final Class<? extends CampaignTrackingService> md() {
        return InstallReferrerService.class;
    }
}
