package com.tencent.mm.plugin.aj;

import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.x;

class f$1 implements ValueCallback<String> {
    f$1() {
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        x.i("MicroMsg.WebViewUtil", "initIFrame back %s", new Object[]{(String) obj});
    }
}
