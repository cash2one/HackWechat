package com.tencent.mm.plugin.appbrand.g;

import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.x;

class i$3 implements ValueCallback<String> {
    final /* synthetic */ i jvU;

    i$3(i iVar) {
        this.jvU = iVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        x.d("MicroMsg.AppBrandMessBasedJsEngine", "invoke callFromJsThread ret %s", (String) obj);
    }
}
