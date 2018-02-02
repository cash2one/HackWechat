package com.tencent.smtt.sdk;

import android.webkit.WebStorage.QuotaUpdater;
import com.tencent.smtt.sdk.ad.a;

class SystemWebChromeClient$QuotaUpdaterImpl implements a {
    QuotaUpdater mQuotaUpdater;
    final /* synthetic */ SystemWebChromeClient this$0;

    SystemWebChromeClient$QuotaUpdaterImpl(SystemWebChromeClient systemWebChromeClient, QuotaUpdater quotaUpdater) {
        this.this$0 = systemWebChromeClient;
        this.mQuotaUpdater = quotaUpdater;
    }

    public void updateQuota(long j) {
        this.mQuotaUpdater.updateQuota(j);
    }
}
