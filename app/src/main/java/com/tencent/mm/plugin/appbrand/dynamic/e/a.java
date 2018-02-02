package com.tencent.mm.plugin.appbrand.dynamic.e;

import android.os.Looper;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.u.b.d;
import com.tencent.xweb.g;
import java.util.concurrent.CountDownLatch;

public final class a implements d {
    g iTM;
    private volatile boolean iTN;
    private volatile boolean iTO = false;
    private volatile CountDownLatch iTP;
    private af mHandler;

    public final boolean Ca() {
        return this.iTM.isValid();
    }

    public a(Object obj, String str, g gVar) {
        this.iTM = gVar;
        this.iTN = false;
        this.iTM.addJavascriptInterface(obj, str);
        this.mHandler = new af(Looper.getMainLooper());
        this.iTM.addJavascriptInterface(this, "WeixinJsThreadCaller");
    }

    @JavascriptInterface
    public final int callFromJsThread() {
        x.d("MicroMsg.AppBrandX5BasedJsEngine", "enter callFromJsThread, pendingPause %b", new Object[]{Boolean.valueOf(this.iTO)});
        if (this.iTO) {
            x.i("MicroMsg.AppBrandX5BasedJsEngine", "pause await threadId %d", new Object[]{Long.valueOf(Thread.currentThread().getId())});
            this.iTO = false;
            this.iTP = new CountDownLatch(1);
            try {
                this.iTP.await();
            } catch (InterruptedException e) {
                x.e("MicroMsg.AppBrandX5BasedJsEngine", "pause await e = %s", new Object[]{e});
            }
        }
        return 1;
    }

    public final void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!this.iTN) {
            Runnable 1 = new 1(this, str, valueCallback);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                1.run();
            } else {
                this.mHandler.post(1);
            }
        }
    }

    public final void cleanup() {
        if (!this.iTN) {
            this.iTM.cleanup();
        }
        this.iTN = true;
    }

    public final void pause() {
        if (this.iTM.BZ()) {
            this.iTM.pause();
            return;
        }
        this.iTO = true;
        evaluateJavascript("var ret = WeixinJsThreadCaller.callFromJsThread();", new 2(this));
    }

    public final void resume() {
        if (this.iTM.BZ()) {
            this.iTM.resume();
            return;
        }
        this.iTO = false;
        if (this.iTP != null) {
            this.iTP.countDown();
            this.iTP = null;
        }
    }

    public final boolean BZ() {
        return true;
    }
}
