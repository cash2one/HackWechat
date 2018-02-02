package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import android.widget.Toast;
import com.tencent.mm.plugin.appbrand.q.j;

class JsApiAddNativeDownloadTask$3 implements Runnable {
    final /* synthetic */ JsApiAddNativeDownloadTask jcF;
    final /* synthetic */ Context val$context;

    JsApiAddNativeDownloadTask$3(JsApiAddNativeDownloadTask jsApiAddNativeDownloadTask, Context context) {
        this.jcF = jsApiAddNativeDownloadTask;
        this.val$context = context;
    }

    public final void run() {
        Toast.makeText(this.val$context, this.val$context.getString(j.emi), 0).show();
    }
}
