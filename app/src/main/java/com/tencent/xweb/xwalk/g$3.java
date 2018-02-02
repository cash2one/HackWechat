package com.tencent.xweb.xwalk;

import android.webkit.ValueCallback;

class g$3 implements Runnable {
    final /* synthetic */ String AsT;
    final /* synthetic */ g Atf;
    final /* synthetic */ ValueCallback val$callback;

    g$3(g gVar, String str, ValueCallback valueCallback) {
        this.Atf = gVar;
        this.AsT = str;
        this.val$callback = valueCallback;
    }

    public final void run() {
        if (this.Atf.Atd != null) {
            this.Atf.Atd.evaluateJavascript(this.AsT, this.val$callback);
        }
    }
}
