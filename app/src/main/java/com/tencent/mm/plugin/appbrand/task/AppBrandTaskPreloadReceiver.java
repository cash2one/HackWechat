package com.tencent.mm.plugin.appbrand.task;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.app.b;
import com.tencent.mm.sdk.f.e;

public class AppBrandTaskPreloadReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getBooleanExtra("extra_skip_webview_preload_boolean", false)) {
            b.YZ();
            e.post(new 1(this), "WxaCommLibReaderPreload");
        }
    }
}
