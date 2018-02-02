package com.tencent.xweb.x5.sdk;

import android.content.Context;
import com.tencent.smtt.sdk.WebView;

public final class i implements c {
    public final int getTbsCoreVersion(Context context) {
        return WebView.getTbsCoreVersion(context);
    }

    public final int getTbsSDKVersion(Context context) {
        return WebView.getTbsSDKVersion(context);
    }

    public final String getCrashExtraMessage(Context context) {
        return WebView.getCrashExtraMessage(context);
    }

    public final boolean getCanReboot() {
        return WebView.getTbsNeedReboot();
    }
}
