package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.smtt.utils.b;

class WebView$2 extends Thread {
    final /* synthetic */ WebView this$0;
    final /* synthetic */ Context val$context;

    WebView$2(WebView webView, Context context) {
        this.this$0 = webView;
        this.val$context = context;
    }

    public void run() {
        try {
            QbSdk.zVR = b.hL(this.val$context) == 3;
            QbSdk.zVS = System.currentTimeMillis();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.val$context.getApplicationContext().registerReceiver(WebView.cFd(), intentFilter);
        } catch (Throwable th) {
        }
    }
}
