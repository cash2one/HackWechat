package com.tencent.xweb.xwalk;

import android.webkit.ValueCallback;

class b$4 implements Runnable {
    final /* synthetic */ b AsS;
    final /* synthetic */ String AsT;
    final /* synthetic */ ValueCallback val$callback;

    b$4(b bVar, String str, ValueCallback valueCallback) {
        this.AsS = bVar;
        this.AsT = str;
        this.val$callback = valueCallback;
    }

    public final void run() {
        if (this.AsS.AsO != null) {
            XWAppBrandEngine xWAppBrandEngine = this.AsS.AsO;
            String evaluateJavascript = xWAppBrandEngine.evaluateJavascript(xWAppBrandEngine.mInstance, this.AsT);
            if (this.val$callback != null) {
                this.val$callback.onReceiveValue(evaluateJavascript);
            }
        }
    }
}
