package com.tencent.smtt.sdk;

import com.tencent.smtt.export.external.interfaces.QuotaUpdater;
import com.tencent.smtt.sdk.ad.a;

class i$a implements a {
    final /* synthetic */ i zWw;
    QuotaUpdater zWy;

    i$a(i iVar, QuotaUpdater quotaUpdater) {
        this.zWw = iVar;
        this.zWy = quotaUpdater;
    }

    public final void updateQuota(long j) {
        this.zWy.updateQuota(j);
    }
}
