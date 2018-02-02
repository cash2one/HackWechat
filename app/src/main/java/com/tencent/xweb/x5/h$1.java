package com.tencent.xweb.x5;

import android.webkit.ValueCallback;
import org.xwalk.core.Log;

class h$1 implements ValueCallback<String> {
    final /* synthetic */ h ArU;

    h$1(h hVar) {
        this.ArU = hVar;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        Log.i("MicroMsg.X5V8JsRuntime", "on inject nativeBufferCompat Object finished.");
    }
}
