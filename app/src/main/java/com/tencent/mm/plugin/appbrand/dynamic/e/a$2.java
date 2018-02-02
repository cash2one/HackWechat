package com.tencent.mm.plugin.appbrand.dynamic.e;

import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.x;

class a$2 implements ValueCallback<String> {
    final /* synthetic */ a iTS;

    a$2(a aVar) {
        this.iTS = aVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        x.d("MicroMsg.AppBrandX5BasedJsEngine", "invoke callFromJsThread ret %s", new Object[]{(String) obj});
    }
}
