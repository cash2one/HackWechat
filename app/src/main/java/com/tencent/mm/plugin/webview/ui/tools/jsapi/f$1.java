package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.x;

class f$1 implements ValueCallback<String> {
    final /* synthetic */ f tHo;

    f$1(f fVar) {
        this.tHo = fVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        x.i("MicroMsg.JsLoader", "loadJavaScript, evaluateJavascript cb, ret = %s", (String) obj);
    }
}
